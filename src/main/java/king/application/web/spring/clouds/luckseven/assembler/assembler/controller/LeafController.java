/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import king.application.web.spring.clouds.luckseven.assembler.assembler.bean.Peridocial;
import king.application.web.spring.clouds.luckseven.assembler.assembler.bean.PeridocialBrief;
import king.application.web.spring.clouds.luckseven.assembler.assembler.feign.CalculatorFeignClient;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.FeignService;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.LeafService;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.MostService;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.SectionService;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.TagService;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.UrlService;
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
    private FeignService feign;
    
    @Autowired
    private MostService most;
    
    @Autowired
    private SectionService section;

    
    @RequestMapping("article/inner")
    public String article_inner(String string, Integer page_index, Integer page_size) {
        //根据 传输 进来的 string 进行获取 相对应的 peridocials
        List<PeridocialBrief> peridocials = this.calculator.searchPeridocialBrief(string, page_index, page_size);

        if (peridocials == null || peridocials.isEmpty()) {
            return "";
        }
        
        StringBuilder builder = new StringBuilder();
        for(PeridocialBrief peridocial : peridocials){
            //进行 输入 相对应的 信息
            Tag article = this.leaf.articleInner(peridocial);
            
            if(article != null){
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
    public String article_fw(String string , Integer page_index , Integer page_size) {

        //相对应的 元数据
        List<PeridocialBrief> peridocials = this.calculator.searchPeridocialBrief(string, page_index, page_size);
        
        StringBuilder builder = new StringBuilder();
        for(PeridocialBrief peridocial_brief : peridocials){
            Tag article_fw = this.leaf.articleFw(peridocial_brief);
            //倘若 相对应的 atricle_fw  不等于 为 空 ， 则 添加 ， 否则 不添加 ， 添加 空字符串  
            builder.append(article_fw != null ? this.tag.http(article_fw) : "");
        }
        
        return builder.toString();
    }

    @RequestMapping("pagination")
    public String pagination(int peridocial_page, int button_number , int active) {

        Tag pagination = this.leaf.pagination(peridocial_page, button_number , active);
        
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
    public String article_mini(@PathVariable("id") String id){
        
        PeridocialBrief peridocial_brief = this.calculator.showPeridocialBrief(id);
        //获取 到 相对应的 Peridocial
        //进行 相对应的 渲染 以及 工作
        Tag article_mini = this.leaf.articleMini(peridocial_brief);
        return this.tag.http(article_mini);
    }
    
    @RequestMapping("aside")
    public String aside(String url ,HttpServletRequest request){
        // 根据 内部的 相对应的 内部的 信息 来获取 信息
        
        String aside_string = this.feign.template(url, request, String.class);
        
        Tag aside = this.leaf.aside(aside_string);
        return this.tag.http(aside);
    }
    
    //这里 输出 相对应的 xinxi
    
    @RequestMapping("test")
    public String test(HttpServletRequest request){
        return this.feign.template("http://assembler/assembler/leaf/aside/line", request, String.class);
    }
    
    //暂时 先用这个 相对应的 方法
    @RequestMapping("article/mini/most")
    public String article_mini_most(){
        return this.most.getAsideMini();
    }
    
    @RequestMapping("article/fw/most")
    public String articlw_fw_most(){
        return this.most.getAsideFw();
    }
    
    
    //我们这里设定 第二级的  http 文本的 设定
    /**
     * 
     *  这里是 第二级 http 的设定
     *  是将 上层 的 http 信息 在这里 进行 一次 整合
     *  通过这样来尽量 减少的 相对应的 http 请求的 方式 
     *  但是 也不一定 一定是 如此 ， 我们只能说
     *  这样做的 方法 只是一种获取 信息的 方式
     * 
     * @param string
     * @param page_index
     * @param page_size
     * @return 
     */
    
    @RequestMapping("header/firstbar")
    public String header_firstbar(){
        Tag tag = this.leaf.firstbar();
        return this.tag.http(tag);
    }
    
    //相对应的 头部 信息 
    @RequestMapping("header/brand")
    public String header_brand(){
        Tag brand = this.leaf.brand();
        
        return this.tag.http(brand);
    }
    
    @RequestMapping("header/menu")
    public String header_menu(){
        
        Tag header_menu = this.leaf.menu();
        //相对应的 输出 相对应的额 信息 
        return this.tag.http(header_menu);
    }
    
    @RequestMapping("header/nav")
    public String header_nav(){
        Tag nav = this.leaf.headerNavList();
        return this.tag.http(nav);
    }
    
    @RequestMapping("header")
    public String header(){
        Tag firstbar = this.leaf.firstbar();
        Tag menu = this.leaf.menu();
        
        return this.tag.and(firstbar, menu);
    }
    
    @RequestMapping("footer")
    public String footer(){
        return this.tag.http(this.leaf.footer());
    }
    
    @RequestMapping("register/section")
    public String register_section(){
        
        String title = "Register";
        
        List<Tag> list_tag = this.section.register();
        
        Tag _section = this.leaf.inputSection(title, list_tag);
        
        return this.tag.http(_section);
    }
    
    @RequestMapping("login/section")
    public String login_section(){
        List<Tag> list_tag = this.section.login();
        
        Tag _section = this.leaf.inputSection("Login", list_tag);
        
        return this.tag.http(_section);
    }
    
}
