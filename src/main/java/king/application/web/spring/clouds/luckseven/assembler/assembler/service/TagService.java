/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import king.application.web.spring.clouds.luckseven.assembler.assembler.tag.DefaultTag;
import king.application.web.spring.clouds.luckseven.assembler.assembler.tag.ListTag;
import king.application.web.spring.clouds.luckseven.assembler.assembler.tag.Tag;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
@Service
public class TagService {
    
    public String http(Tag tag){
        
        StringBuilder builder  = new StringBuilder();
        //获取 头部 开始的部分
        builder.append("<").append(tag.getName());
        Map<String,String> attributes = tag.attributes();
        
        for(Entry<String,String> entry :attributes.entrySet()){
            builder.append(" ").append(entry.getKey()).append("='").append(entry.getValue()).append("' ");
        }
        
        builder.append(">");
        
        //部署 子元素 的 部分
        for(int index = 0  ; index < tag.size() ; index ++){
            builder.append(this.http(tag.getChildren(index)));
        }
        
        builder.append(tag.text());
        //部署 尾部 信息
        builder.append("</").append(tag.getName()).append(">");
        
        return builder.toString();
        
    }
    
    public Tag build(String name){
        DefaultTag tag = new DefaultTag();
        tag.setName(name);
        return tag;
    }
    
    public TagService append(Tag father , Tag children){
        father.append(children);
        return this;
    }
    
    //相对应的 tag
    public String and(Tag... tags){

        StringBuilder builder = new StringBuilder();
        
        for(Tag tag : tags){
            String text = this.http(tag);
            
            builder.append(text);
        }
        
        return builder.toString();
        
    }
    
}
