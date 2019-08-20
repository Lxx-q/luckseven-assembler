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

public class ArticleSummary {
    
    private String id = null;
    
    private String name = null;
    
    private String articleId = null;
    
    private String createTime = null;
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setName( String name ){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setArticleId( String articleId ){
        this.articleId = articleId;
    }
    
    public String getArticleId(){
        return this.articleId;
    }
    
    public void setCreateTime( String createTime ){
        this.createTime = createTime;
    }
    
    public String getCreateTime(){
        return this.createTime;
    }
    
}
