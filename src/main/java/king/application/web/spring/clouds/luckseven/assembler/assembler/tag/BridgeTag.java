/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.tag;

import java.util.Map;

/**
 *
 * @author king
 */
public class BridgeTag implements Tag{
    
    //所有 原本参数的 操作 都是 在这个 类上 进行 
    private Tag currentTag = null;
    
    public void setCurrentTag(Tag currentTag){
        this.currentTag = currentTag;
    }
    
    public Tag getCurrentTag(){
        return this.currentTag;
    }

    @Override
    public void setName(String name) {
        this.currentTag.setName(name);
    }

    @Override
    public String getName() {
        return  this.currentTag.getName();
    }

    @Override
    public int size() {
        return this.currentTag.size();
    }

    @Override
    public void previdous(Tag tag) {
        this.currentTag.previdous(tag);
    }

    @Override
    public void append(Tag tag) {
        this.currentTag.append(tag);
    }

    @Override
    public Tag getChildren(int size) {
        return this.currentTag.getChildren(size);
    }

    @Override
    public Tag removeChildren(int size) {
        return this.currentTag.removeChildren(size);
    }

    @Override
    public Tag attr(String key, String value) {
        return this.currentTag.attr(key, value);
    }

    @Override
    public String attr(String key) {
        return this.currentTag.attr(key);
    }

    @Override
    public Map<String, String> attributes() {
        return this.currentTag.attributes();
    }

    @Override
    public Tag text(String text) {
        return this.currentTag.text(text);
    }

    @Override
    public String text() {
        return this.currentTag.text();
    }
    
}
