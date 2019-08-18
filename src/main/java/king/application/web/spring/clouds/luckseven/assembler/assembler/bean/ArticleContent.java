/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.bean;

/**
 *
 * @author king
 */
public class ArticleContent {
    
    private String id = null;
    
    private String content = null;
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }    
    
    public void setContent(String content ){
        this.content = content;
    }
    
    public String getContent(){
        return this.content;
    }
    
}
