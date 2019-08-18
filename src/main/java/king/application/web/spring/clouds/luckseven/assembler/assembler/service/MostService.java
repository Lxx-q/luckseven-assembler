/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.service;

import king.application.web.spring.clouds.luckseven.assembler.assembler.service.tag.TagService;
import java.util.List;
import king.application.web.spring.clouds.luckseven.assembler.assembler.bean.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
//我们 需要 想一个 方法 ， 来 保存 相对应的 进一步的 信息
@Service
public class MostService {

    @Autowired
    private LeafService leaf;

    @Autowired
    private TagService tag;

    private String aside_mini = null;
    
    private String aside_fw = null ;

    public void configuration(List<Article> list) {
        
        //相对应的 aisde  的 数据 建造者
        StringBuilder aside_mini_builder = new StringBuilder();
        StringBuilder aside_fw_builder = new StringBuilder();
        
        for (Article peridocial_brief : list) {

            //下面 刚开始 看的 时候 可能 你会有 相对应 可以 进行 简短 代码的 冲动 ， 其实 也是
            //但是 ， 之所以 没有 使用 最简单的 做法 便是 因为 想把见过 稍微 简单 一点
            
            //进行 输入 相对应的 信息
            String aisde_mini_string = this.tag.http(this.leaf.articleMini(peridocial_brief));
            String aside_fw_string = this.tag.http(this.leaf.articleFw(peridocial_brief));
            
            //将上面的 填充物 进行 相对应的 输出 以及 放入 
            aside_mini_builder.append(aisde_mini_string);
            aside_fw_builder.append(aside_fw_string);
        }

        this.aside_mini = aside_mini_builder.toString();
        this.aside_fw = aside_fw_builder.toString();
    }

    public String getAsideMini() {
        return this.aside_mini;
    }
    
    public String getAsideFw(){
        return this.aside_fw;
    }

}
