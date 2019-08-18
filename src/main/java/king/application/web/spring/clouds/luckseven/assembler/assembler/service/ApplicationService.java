/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.service;

import java.util.List;
import king.application.web.spring.clouds.luckseven.assembler.assembler.bean.Article;
import king.application.web.spring.clouds.luckseven.assembler.assembler.bean.Article;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
@Service
public class ApplicationService {

    //我们 在 这里的 策略 是 每隔一定的 时间 ， 我们 再更新 相对应的 数据
    private List<Article> most = null;

    public List<Article> most() {
        return this.most;
    }

    public void setMost(List<Article> most) {
        this.most = most;
    }

}
