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
public class Favorites {

    private String id = null;

    private String userId = null;

    private String articleId = null;

    private Date time = null;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticle() {
        return this.articleId;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return this.time;
    }
}
