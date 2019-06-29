/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.tag;

import java.util.List;
import java.util.Map;

/**
 *
 * @author king
 */

//注意 ，这个 应该 不能使用 里面的 关系 并不是 相对应的 上下级 关系 ， 而是 平等的 关系 
public class ListTag extends BridgeTag {
    
    private List<Tag> list = null;
    
    public ListTag setList(List<Tag> list){
        this.list = list;
        return this;
    }
    
    public List<Tag> getList(){
        return this.list;
    }

    @Override
    public String text() {
        StringBuilder builder = new StringBuilder();
        //当前的 tag 并不算 ， 因为 没有 成功的 执行
        for(Tag tag : this.getList()){
            builder.append(tag.text());
        }
        return builder.toString();
    }
    
    public void commit(){
        //将 相对应的 本地 之前 初始化的 值 提交到 自己的 队列之中 
        Tag tag = this.getCurrentTag();
        
        if(tag == null){
            return ;
        }
        
        List<Tag> _list = this.getList();
        
        //默认 当 tag 为 空的 时候 不执行函数
        
        _list.add(tag);
        //并且 初始化 相对应的 本地 null
        this.setCurrentTag(null);
        
    }
    
    public ListTag add(Tag tag){
        
        this.list.add(tag);
        
        return this;
    }
    
    
}
