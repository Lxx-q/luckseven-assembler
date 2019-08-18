/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.feign;

import java.util.List;
import java.util.Map;
import king.application.web.spring.clouds.luckseven.assembler.assembler.bean.Article;
import king.application.web.spring.clouds.luckseven.assembler.assembler.bean.ArticleContent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author king
 */
@FeignClient(name = "calculator")
public interface CalculatorFeignClient {
    
    @RequestMapping("/calculator/test/hello")
    public String test_hello();
    
    @RequestMapping("/calculator/show/article")
    public Article showArticle(@RequestParam String id);
    
    @RequestMapping("/calculator/show/article/content")
    public ArticleContent showArticleContent( @RequestParam("id") String id );
    
    @RequestMapping("/calculator/search/article/content")
    public List<ArticleContent> search_article_content_like( @RequestParam("text") String text );

    @RequestMapping("/calculator/search/article/brief")
    public List<Article> searchArticleBrief(@RequestParam("string") String string ,@RequestParam("page_index") Integer page_index ,
            @RequestParam("page_size") Integer page_size);
    
    @RequestMapping("calculator/application/most")
    public List<Article> applicationMost();
    
    
    //根据 相对应的 article _id  , 便可以 获取 相对应的 article 的 favorites 数目
    /**
     *  输出 相对应的 信息 
     * 相对应的 架构为 { id : xx , favorites_count : xx }
     * @param id
     * @return 
     */
    @RequestMapping( "/calculator/search/article/favorites")
    public List<Map<String,Object>> searchArticleFavorites(@RequestBody List<String> id );
 
    @RequestMapping("/calculator/search/list")
    public List list();
}
