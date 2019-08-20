/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import king.application.web.spring.clouds.luckseven.assembler.assembler.bean.Article;
import king.application.web.spring.clouds.luckseven.assembler.assembler.bean.Article;
import king.application.web.spring.clouds.luckseven.assembler.assembler.feign.CalculatorFeignClient;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.FeignService;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.LeafService;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.MostService;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.SectionService;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.tag.TagService;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.TreeService;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.UrlService;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.common.BeanService;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.common.function.TransferFunction;
import king.application.web.spring.clouds.luckseven.assembler.assembler.tag.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author king
 */
@RestController
@RequestMapping("leaf")
public class LeafController {

    @Autowired
    private CalculatorFeignClient calculator;

    @Autowired
    private TagService tag;

    @Autowired
    private UrlService url;

    @Autowired
    private LeafService leaf;

    @Autowired
    private TreeService tree;

    @Autowired
    private FeignService feign;

    @Autowired
    private MostService most;

    @Autowired
    private SectionService section;

    @Autowired
    private BeanService bean;

    @RequestMapping("article/inner")
    public String article_inner(String string, Integer page_index, Integer page_size) {
        //根据 传输 进来的 string 进行获取 相对应的 peridocials
        List<Article> peridocials = this.calculator.searchArticleBrief(string, page_index, page_size);

        List<String> list_id = this.bean.transfer(peridocials, new TransferFunction<Article, String>() {
            @Override
            public String transfer(Article target) {
                return target.getId();
            }
        });

        List<Map<String, Object>> list_map = this.calculator.searchArticleFavorites(list_id);
        
        Map<String,Map<String, Object>> id_map = this.bean.toMap(list_map, new TransferFunction<Map<String, Object> , String>() {
            @Override
            public String transfer(Map<String, Object> target) {
                return target.get("id").toString();
            }
        });

        if (peridocials == null || peridocials.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        
        for (int index = 0 ; index < peridocials.size() ; index ++ ) {
            //进行 输入 相对应的 信息
        
            Article peridocial = peridocials.get(index);
            
            String id = peridocial.getId();
            
            //根据 相对应的 id  来 获取 相对应的 信息
            Map<String,Object> map = id_map.get(id);
            
            Integer favorites_count = 10;
            //如果 不为空 ， 那么 我们就开始 获取 相对应的 值
            if( map != null ){
                favorites_count = Integer.parseInt(map.get("favorites_count").toString());
            }
            
            Tag article = this.leaf.articleInner(peridocial,favorites_count);

            if (article != null) {
                //倘若 相对应的 信息 进行 输入 
                builder.append(this.tag.http(article));
            }
        }

        //得到 相对应的 builder
        //输出 相对应的 string
        return builder.toString();
    }

    //用来 制作 相对应的 一个 比较 简单的 吧 ...
    @RequestMapping("article/fw")
    public String article_fw(String string, Integer page_index, Integer page_size) {

        //相对应的 元数据
        List<Article> peridocials = this.calculator.searchArticleBrief(string, page_index, page_size);

        StringBuilder builder = new StringBuilder();
        for (Article peridocial_brief : peridocials) {
            Tag article_fw = this.leaf.articleFw(peridocial_brief);
            //倘若 相对应的 atricle_fw  不等于 为 空 ， 则 添加 ， 否则 不添加 ， 添加 空字符串  
            builder.append(article_fw != null ? this.tag.http(article_fw) : "");
        }

        return builder.toString();
    }

    @RequestMapping("pagination")
    public String pagination(int peridocial_page, int button_number, int active) {

        Tag pagination = this.leaf.pagination(peridocial_page, button_number, active);

        return this.tag.http(pagination);
    }

    @RequestMapping("aside/title")
    public String aside_title(String string) {
        return this.tag.http(this.leaf.asideTitle(string));
    }

    @RequestMapping("aside/line")
    public String aside_line() {
        return this.tag.http(this.leaf.asideLine());
    }

    //获取 下方的 走位 信息
    @RequestMapping("aside/mini/{id}")
    public String article_mini(@PathVariable("id") String id) {

        Article peridocial_brief = this.calculator.showArticle(id);
        //获取 到 相对应的 Peridocial
        //进行 相对应的 渲染 以及 工作
        Tag article_mini = this.leaf.articleMini(peridocial_brief);

        return this.tag.http(article_mini);
    }

    @RequestMapping("aside")
    public String aside(String url, HttpServletRequest request) {
        // 根据 内部的 相对应的 内部的 信息 来获取 信息

        String aside_string = this.feign.template(url, request, String.class);

        Tag aside = this.leaf.aside(aside_string);
        return this.tag.http(aside);
    }

    //这里 输出 相对应的 xinxi
    @RequestMapping("test")
    public String test(HttpServletRequest request) {
        return this.feign.template("http://assembler/assembler/leaf/aside/line", request, String.class);
    }

    //暂时 先用这个 相对应的 方法
    @RequestMapping("article/mini/most")
    public String article_mini_most() {
        return this.most.getAsideMini();
    }

    @RequestMapping("article/fw/most")
    public String article_fw_most() {
        return this.most.getAsideFw();
    }

    @RequestMapping("header")
    public String header() {
        //进行设置 相对应的 信息
        HashMap<String, String> map = new HashMap<>();
        map.put("HTML5", "HTML5");
        map.put("996", "a12");
        map.put("what ha", "a1");

        //上面 只是 暂时的 设置 相对应的 信息 ， 后续我们 会进行 调整
        Tag firstbar = this.tree.headerFirstbar(map, null);
        Tag menu = this.tree.headerMenu();

        return this.tag.and(firstbar, menu);
    }

    @RequestMapping("footer")
    public String footer() {
        return this.tag.http(this.leaf.footer());
    }

    @RequestMapping("register/section")
    public String register_section() {

        String title = "Register";

        List<Tag> list_tag = this.section.register();

        Tag _section = this.leaf.inputSection(title, list_tag);

        return this.tag.http(_section);
    }

    @RequestMapping("login/section")
    public String login_section() {
        List<Tag> list_tag = this.section.login();
        Tag _section = this.leaf.inputSection("Login", list_tag);

        return this.tag.http(_section);
    }

}
