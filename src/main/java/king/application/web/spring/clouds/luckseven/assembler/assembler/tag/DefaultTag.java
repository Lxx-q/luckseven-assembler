/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author king
 */
public class DefaultTag implements Tag{
    
    private String name = null;
    
    private final List<Tag> children = new ArrayList<>();
    
    private final HashMap<String,String> attributes = new HashMap<>();
    
    private String text = null;

    @Override
    public int size() {
        return this.children.size();
    }

    @Override
    public void previdous(Tag tag) {
        this.children.add(0, tag);
    }

    @Override
    public void append(Tag tag) {
        this.children.add(tag);
    }

    @Override
    public Tag getChildren(int size) {
        return this.children.get(size);
    }

    @Override
    public Tag removeChildren(int size) {
        return this.children.remove(size);
    }

    @Override
    public Tag attr(String key, String value) {
        this.attributes.put(key, value);
        return this;
    }

    @Override
    public String attr(String key) {
        return this.attributes.get(key);
    }

    @Override
    public Tag text(String text) {
        this.text = text;
        return this;
    }

    @Override
    public String text() {
        return this.text != null ? this.text : "";
    }

    @Override
    public Map<String, String> attributes() {
        return this.attributes;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
    
    
}
