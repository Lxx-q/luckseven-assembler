/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.bean;

import java.util.Date;

/**
 *
 * @author king
 */
public class Article {
        //这本期刊的书 id
    private String id = null;
    
    private String describe = null;
    
    //这本杂志的封面主题
    private String name = null;
    
    //这本杂志的更新日期
    private Date date = null;
    
    //本期的杂志封面
    private String image = null;
    
    private String belongto = null;
    
    public void setId( String id ){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    
    public Date getDate(){
        return this.date;
    }
    
    
    public void setImage(String href){
        this.image= href;
    }
    
    public String getImage(){
        return this.image;
    }
    
    
    public void setDescribe(String describe){
        this.describe = describe;
    }
    
    public String getDescribe(){
        return this.describe;
    }
    
    public void setBelongto(String belongto){
        this.belongto = belongto;
    }
    
    public String getBelongto(){
        return this.belongto;
    }
    
}
