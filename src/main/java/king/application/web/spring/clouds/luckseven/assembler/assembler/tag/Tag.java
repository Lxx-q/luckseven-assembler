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
public interface Tag {
    
    public void setName(String name);
    
    public String getName();
    
    public int size();
    
    public void previdous(Tag tag);
    
    public void append(Tag tag);
    
    public Tag getChildren(int size);
    
    public Tag removeChildren(int size);
    
    public Tag attr(String key , String value);
    
    public String attr(String key);
    
    public Map<String,String> attributes();
    
    public Tag text(String text);
    
    public String text();
    
}
