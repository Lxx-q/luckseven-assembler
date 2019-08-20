/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.service.tag;

import java.util.Map;
import java.util.Map.Entry;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.tag.builder.HttpBuilderService;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.tag.builder.TagBuilder;
import king.application.web.spring.clouds.luckseven.assembler.assembler.tag.DefaultTag;
import king.application.web.spring.clouds.luckseven.assembler.assembler.tag.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
@Service
public class TagService {
    
    @Autowired
    private HttpBuilderService http_builder;
    
    @Autowired
    private TagService self;
    
    public String http(Tag tag) {
        return this.http_builder.string(tag);
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
    
    /**
     * 
     * 下面的 信息的 方式 ， 是通过 相对应的 name ， 的 配置 来直接 赋值 相对应的 信息
     * 
     * @param father
     * @param children_name
     * @return 
     */
    
    public Tag bind(Tag father , String children_name ){
        
        Tag children = this.self.build(children_name);
        //将相对应的 信息 赋值进去
        this.self.append(father, children);
        
        return children;
        
    }

    
    
}
