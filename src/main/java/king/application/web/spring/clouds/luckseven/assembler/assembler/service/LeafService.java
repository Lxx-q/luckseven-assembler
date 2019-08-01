/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.service;

import java.util.List;
import king.application.web.spring.clouds.luckseven.assembler.assembler.bean.PeridocialBrief;
import king.application.web.spring.clouds.luckseven.assembler.assembler.bean.User;
import king.application.web.spring.clouds.luckseven.assembler.assembler.tag.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
@Service
public class LeafService {

    @Autowired
    private TagService tag;

    @Autowired
    private UrlService url;

    /**
     *
     * 相对应的 文本 信息
     *
     * <article class="col-md-12 article-list">
     * <div class="inner">
     * <figure>
     * <a href="single.html">
     * <img src="images/news/img11.jpg">
     * </a>
     * </figure>
     * <div class="details">
     * <div class="detail">
     * <div class="category">
     * <a href="category.html">Film</a>
     * </div>
     * <div class="time">December 26, 2016</div>
     * </div>
     * <h1><a href="single.html">Lorem Ipsum Dolor Sit Consectetur Adipisicing
     * Elit</a></h1>
     * <p>
     * Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
     * tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim
     * veniam, quis nostrud exercitat...
     * </p>
     * <footer>
     * <a href="#" class="love"><i class="ion-android-favorite-outline"></i>
     * <div>78</div></a>
     * <a class="btn btn-primary more" href="single.html">
     * <div>More</div>
     * <div><i class="ion-ios-arrow-thin-right"></i></div>
     * </a>
     * </footer>
     * </div>
     * </div>
     * </article>
     *
     * @param peridocial
     * @param favorites_count
     * @param peridocials
     * @return
     */
    public Tag articleInner(PeridocialBrief peridocial , Integer favorites_count) {

        String href_peridocial = this.url.http("single/page/" + peridocial.getId());

        Tag article = this.tag.build("article").attr("class", "col-md-12 article-list");
        //获取 相对应的 article_inner 标签 ， 这里 是大部分数据的 集合地 ， 所以 
        Tag article_inner = this.tag.build("div").attr("class", "inner");

        Tag article_inner_figure = this.tag.build("figure");

        //相对应的 链接地址
        Tag article_inner_figure_a = this.tag.build("a").attr("href", href_peridocial);

        Tag article_inner_figure_a_image = this.tag.build("img").attr("src", peridocial.getImage());
        //将 上面的 关系 一次性全部进行拼接 ， 虽然 ， 代码的 观赏性 可能不强 ， 但是 ， 就是 比较爽 能一次性解决 就是 了
        //tag.append( father , children ) 的 返回值 为 自身 ， 之所以 怎么做 目前只是为了能减少适当的工作量
        this.tag.append(article, article_inner)
                .append(article_inner, article_inner_figure)
                .append(article_inner_figure, article_inner_figure_a)
                .append(article_inner_figure_a, article_inner_figure_a_image);

        Tag article_inner_details = this.tag.build("div").attr("class", "details");

        Tag article_inner_details_detail = this.tag.build("div").attr("class", "detail");

        Tag article_inner_details_detail_category = this.tag.build("div").attr("class", "category");

        //这里用相对应的 href
        Tag article_inner_details_detail_category_a = this.tag.build("a").attr("href", href_peridocial).text("Happy");

        Tag article_inner_details_detail_time = this.tag.build("div").attr("class", "time").text(peridocial.getDate().toLocaleString());
        //进行联系 关系
        //这里的 关系 叙述从下而上
        this.tag.append(article_inner_details_detail_category, article_inner_details_detail_category_a)
                .append(article_inner_details_detail, article_inner_details_detail_category)
                .append(article_inner_details_detail, article_inner_details_detail_time)
                .append(article_inner_details, article_inner_details_detail);

        Tag article_inner_details_h1 = this.tag.build("h1");

        //这里拥有相对应的 href 的 信息
        Tag article_inner_details_h1_a = this.tag.build("a").attr("href", href_peridocial).text(peridocial.getName());
        //这里输出 相对应的 信息
        Tag article_inner_details_p = this.tag.build("p").text(peridocial.getDescribe());
        this.tag.append(article_inner_details_h1, article_inner_details_h1_a)
                .append(article_inner_details, article_inner_details_h1)
                .append(article_inner_details, article_inner_details_p);

        Tag article_inner_details_footer = this.tag.build("footer");

        //这里的 href ， 为 相对应的点赞 的 按钮连接
        Tag article_inner_details_footer_love = this.tag.build("a").attr("href", "#").attr("class", "love");

        Tag article_inner_details_footer_love_i = this.tag.build("i").attr("class", "ion-android-favorite-outline");

        //这里为 相对应的 点赞数
        Tag article_inner_details_footer_love_div = this.tag.build("div").text(favorites_count.toString());

        this.tag.append(article_inner_details_footer_love, article_inner_details_footer_love_i)
                .append(article_inner_details_footer_love, article_inner_details_footer_love_div)
                .append(article_inner_details_footer, article_inner_details_footer_love);

        //相对用的 More 额 信息 板 ，便是 那个查看信息的 版
        Tag article_inner_details_footer_more = this.tag.build("a").attr("class", "btn btn-primary more")
                .attr("href", href_peridocial);

        Tag article_inner_details_footer_more_div = this.tag.build("div").text("More");

        this.tag.append(article_inner_details_footer_more, article_inner_details_footer_more_div);

        //对应的 图标
        Tag article_inner_details_footer_more_arrow = this.tag.build("div");

        Tag article_inner_details_footer_more_arrow_i = this.tag.build("i").attr("class", "ion-ios-arrow-thin-right");

        this.tag.append(article_inner_details_footer_more_arrow, article_inner_details_footer_more_arrow_i)
                .append(article_inner_details_footer_more, article_inner_details_footer_more_arrow)
                .append(article_inner_details_footer, article_inner_details_footer_more)
                //这里 开始 将 footer  等相关的 信息  输入
                .append(article_inner_details, article_inner_details_footer)
                .append(article_inner, article_inner_details);

        //进行 填充 相对应的 信息
        return article;
    }

    /**
     *
     * 显示 相对应的 信息
     *
     * @param peridocial_page
     * @param max_button
     * @param active
     * @return
     */
    // 进行 相对应的 获取 相对应的
    public Tag pagination(int peridocial_page, int max_button, int active) {
        Tag pagination = this.tag.build("div").attr("class", "col-md-12 text-center");

        Tag pagination_ul = this.tag.build("ul").attr("class", "pagination");

        //相对应的 前行 按钮
        Tag pagination_ul_prev = this.tag.build("li").attr("class", "prev");

        Tag pagination_ul_prev_a = this.tag.build("a").attr("href", "#");

        Tag pagination_ul_prev_a_i = this.tag.build("i").attr("class", "ion-ios-arrow-left");

        this.tag.append(pagination_ul_prev_a, pagination_ul_prev_a_i)
                .append(pagination_ul_prev, pagination_ul_prev_a)
                .append(pagination_ul, pagination_ul_prev);

        //设置 相对应的 peridocial _ page
        boolean is = peridocial_page > max_button;

        int size = is ? max_button : peridocial_page;

        int _active = active > size ? size : active;

        for (int index = 0; index < size; index++) {

            // 进行 相对应的 工作 进行 配置
            Tag pagination_ul_li = this.tag.build("li");

            if (index == _active) {
                // 倘若 相对应的 为 句首 ， 那么 他就为 成为 active
                pagination_ul_li.attr("class", "active");
            }

            String pagination_ul_li_a_text = Integer.toString(index + 1);

            if (is && index == size - 2) {

                //倘若 数量 正正好 ， 并且 
                pagination_ul_li_a_text = "...";
            } else if (is && index == size - 1) {
                pagination_ul_li_a_text = Integer.toString(peridocial_page);
            }

            // 倘若相对应的 
            //这里 有 相对应的 here 这里 有 相对应的 信息
            Tag pagination_ul_li_a = this.tag.build("a").attr("href", pagination_ul_li_a_text);

            this.tag.append(pagination_ul_li, pagination_ul_li_a)
                    .append(pagination_ul, pagination_ul_li);
        }

        //相对应的 前行 按钮
        Tag pagination_ul_next = this.tag.build("li").attr("class", "next");

        Tag pagination_ul_next_a = this.tag.build("a").attr("href", "#");

        Tag pagination_ul_next_a_i = this.tag.build("i").attr("class", "ion-ios-arrow-right");

        // 进行 输入 相对应的 信息
        this.tag.append(pagination_ul_next_a, pagination_ul_next_a_i)
                .append(pagination_ul_next, pagination_ul_next_a)
                .append(pagination_ul, pagination_ul_next)
                .append(pagination, pagination_ul);

        return pagination;
    }

    public Tag asideTitle(String string) {
        Tag aside_title = this.tag.build("h1").attr("class", "aside-title").text(string);
        return aside_title;
    }

    public Tag asideLine() {
        return this.tag.build("a").attr("class", "line");
    }

    /**
     * <article class="article-mini">
     * <div class="inner">
     * <figure>
     * <a href="single.html">
     * <img src="images/news/img05.jpg">
     * </a>
     * </figure>
     * <div class="padding">
     * <h1><a href="single.html">Duis aute irure dolor in reprehenderit in
     * voluptate velit</a></h1>
     * <div class="detail">
     * <div class="category"><a href="category.html">Lifestyle</a></div>
     * <div class="time">December 22, 2016</div>
     * </div>
     * </div>
     * </div>
     * </article>
     *
     * 例子
     *
     * @param peridocial
     * @return
     */
    public Tag articleMini(PeridocialBrief peridocial) {
        Tag article = this.tag.build("article").attr("class", "article-mini");

        String peridocial_href = this.url.http("/single/page/" + peridocial.getId());

        Tag article_inner = this.tag.build("div").attr("class", "inner");

        Tag article_inner_figure = this.tag.build("figure");

        Tag article_inner_figure_a = this.tag.build("a").attr("href", peridocial_href);

        Tag article_inner_figure_a_img = this.tag.build("img").attr("src", peridocial.getImage());

        //获取 到 相对应的  figure a  aimg  的 所有 内容
        this.tag.append(article_inner_figure_a, article_inner_figure_a_img)
                .append(article_inner_figure, article_inner_figure_a)
                .append(article_inner, article_inner_figure);

        Tag article_inner_padding = this.tag.build("div").attr("class", "padding");

        Tag article_inner_padding_h1 = this.tag.build("h1");

        //输入 的 相对应的 peridocial de  name
        Tag article_inner_padding_h1_a = this.tag.build("a").attr("href", peridocial_href).text(peridocial.getName());
        //完成 到 padding  内的 下面 那部分 内容
        this.tag.append(article_inner_padding_h1, article_inner_padding_h1_a)
                .append(article_inner_padding, article_inner_padding_h1);

        Tag article_inner_padding_detail = this.tag.build("div").attr("class", "detail");

        Tag article_inner_padding_detail_category = this.tag.build("div").attr("class", "category");

        //这里 有一个 相对应的 标志 ， 所以 我们 要记住
        Tag article_inner_padding_detail_category_a = this.tag.build("a").attr("href", peridocial_href).text("Happy");

        this.tag.append(article_inner_padding_detail_category, article_inner_padding_detail_category_a)
                .append(article_inner_padding_detail, article_inner_padding_detail_category);

        Tag article_inner_padding_detail_time = this.tag.build("div").attr("class", "time").text(peridocial.getDate().toLocaleString());

        this.tag.append(article_inner_padding_detail, article_inner_padding_detail_time)
                .append(article_inner_padding, article_inner_padding_detail)
                .append(article_inner, article_inner_padding)
                .append(article, article_inner);

        return article;
    }

    public Tag aside(String text) {
        Tag aside = this.tag.build("aside").text(text);
        return aside;
    }

    //相对应的 信息
    public Tag asideBody(String text) {

        //相对应的 信息 
        Tag aside_body = this.tag.build("div").attr("class", "details").text(text);
        //然后 返回 相对应的 东西
        return aside_body;

    }

    /**
     * <article class="article-fw">
     * <div class="inner">
     * <figure>
     * <a href="single.html">
     * <img src="images/news/img12.jpg">
     * </a>
     * </figure>
     * <div class="details">
     * <h1><a href="single.html">Lorem Ipsum Dolor Sit Amet Consectetur
     * Adipisicing Elit</a></h1>
     * <p>
     * Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
     * tempor incididunt ut labore et dolore magna aliqua.
     * </p>
     * <div class="detail">
     * <div class="time">December 26, 2016</div>
     * <div class="category"><a href="category.html">Lifestyle</a></div>
     * </div>
     * </div>
     * </div>
     * </article>
     *
     * @param peridocial
     * @return
     */
    public Tag articleFw(PeridocialBrief peridocial) {
        if (peridocial == null) {
            return null;
        }

        String href = null;

        Tag article_fw = this.tag.build("article").attr("class", "article-fw");

        Tag article_fw_inner = this.tag.build("div").attr("class", "inner");

        Tag article_fw_figure = this.tag.build("figure");

        Tag article_fw_figure_a = this.tag.build("a").attr("href", href);

        Tag article_fw_figure_a_img = this.tag.build("img").attr("src", peridocial.getImage());
        //获取 相对应的 href
        article_fw_figure_a.append(article_fw_figure_a_img);
        //补充正常的 _a 
        article_fw_figure.append(article_fw_figure_a);
        article_fw_inner.append(article_fw_figure);

        //上面 那部分 已经搞定
        Tag article_fw_inner_details = this.tag.build("div").attr("class", "details");

        Tag article_fw_inner_details_h1 = this.tag.build("h1");
        Tag article_fw_inner_details_h1_a = this.tag.build("a").attr("href", href).text(peridocial.getName());

        article_fw_inner_details_h1.append(article_fw_inner_details_h1_a);
        article_fw_inner_details.append(article_fw_inner_details_h1);

        /**
         * <p>
         * Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
         * eiusmod tempor incididunt ut labore et dolore magna aliqua.
         * </p>
         */
        Tag article_fw_inner_details_p = this.tag.build("p").text(peridocial.getDescribe());

        article_fw_inner_details.append(article_fw_inner_details_p);

        Tag article_fw_inner_details_detail = this.tag.build("div").attr("class", "detail");

        Tag article_fw_inner_details_detail_time = this.tag.build("time").attr("class", "time").text(peridocial.getDate().toGMTString());
        Tag article_fw_inner_details_detail_category = this.tag.build("div").attr("class", "category");

        Tag article_fw_inner_details_detail_category_a = this.tag.build("a").attr("href", href).text("happy");

        article_fw_inner_details_detail_category.append(article_fw_inner_details_detail_category_a);

        article_fw_inner_details_detail.append(article_fw_inner_details_detail_time);
        article_fw_inner_details_detail.append(article_fw_inner_details_detail_category);

        article_fw_inner_details.append(article_fw_inner_details_detail);

        article_fw_inner.append(article_fw_inner_details);

        article_fw.append(article_fw_inner);

        return article_fw;
    }

    //相对应部分 内容 已经 转移到 tree 中
    /**
     * 设置 相对应的 信息 ， 前卫 前为图片 ， 后为 相对应的 href
     *
     * @param image
     * @param href
     * @return
     */
    public Tag brand(String image, String href) {
        Tag brand = this.tag.build("div").attr("class", "brand");

        /* 这里 拥有 很重要的 */
        // 这里 是 相对应的 链接 路径的  ， 现在 默认 值 为 "mode/"
        Tag brand_a = this.tag.build("a").attr("href", href);

        /* 这里 有 相对应的 文件 路径 地址 , 现在 我们 默认 为 images/logo.png */
        Tag brand_a_img = this.tag.build("img").attr("src", image).attr("alt", "Magz Logo");
        this.tag.append(brand_a, brand_a_img)
                .append(brand, brand_a);

        return brand;
    }

    /**
     * <div class="col-md-3 col-sm-12 text-right">
     * <ul class="nav-icons">
     * <li><a href="register.html"><i class="ion-person-add"></i><div>Register</div></a></li>
     * <li><a href="login.html"><i class="ion-person"></i><div>Login</div></a></li>
     * </ul>
     * </div>
     *
     * @return
     */
    public Tag headerFirstbarDeafultUser() {
        Tag div = this.tag.build("div").attr("class", "col-md-3 col-sm-12 text-right").text("<ul class=\"nav-icons\">\n"
                + "                                <li><a href=\"register.html\"><i class=\"ion-person-add\"></i><div>Register</div></a></li>\n"
                + "                                <li><a href=\"login.html\"><i class=\"ion-person\"></i><div>Login</div></a></li>\n"
                + "                            </ul>");

        //下面 相对应的 信息
        /**
         * Tag div_ul = this.tag.build("ul").attr("class", "nav-icons");
         *
         * Tag div_ul_li_register = this.tag.build("li");
         *
         * Tag div_ul_li_register_a = this.tag.build("a").attr("href",
         * "register.html");
         *
         * Tag div_ul_li_register_i = this.tag.build("i").attr("class",
         * "ion-person-add");
         *
         * Tag div_ul_li_register_div = this.tag.build("div").text("Register");
         *
         *
         *
         * this.tag.append(div, div_ul);
        *
         */
        return div;
    }

    //用来 设置 相对应的 user
    public Tag headerFirstbarUserDiv(User user) {
        //目前 暂时 使用 相对应的 信息 ， 来完成 相对应的 信息
        return this.headerFirstbarDeafultUser();
    }


    

    /*相对应的 在 header 中的 mobile toggle*/
    public Tag headerMobileToggle(String data_toggle, String data_target, String i_class) {
        Tag mobile_toggle = this.tag.build("div").attr("class", "mobile-toggle");
        Tag mobile_toggle_a = this.tag.build("a").attr("href", "#").attr("data-togle", data_toggle)
                .attr("data-target", data_target);

        Tag mobile_toggle_a_i = this.tag.build("i").attr("class", i_class);

        this.tag.append(mobile_toggle_a, mobile_toggle_a_i)
                .append(mobile_toggle, mobile_toggle_a);

        return mobile_toggle;

    }

    

    //开始 制作 尾部 tag 
    /**
     * <div class="row">
     * <div class="col-md-3 col-sm-6 col-xs-12">
     * <div class="block">
     * <h1 class="block-title">Company Info</h1>
     * <div class="block-body">
     * <figure class="foot-logo">
     * <img src="images/logo-light.png" class="img-responsive" alt="Logo">
     * </figure>
     * <p class="brand-description">
     * Magz is a HTML5 &amp; CSS3 magazine template based on Bootstrap 3.
     * </p>
     * <a href="page.html" class="btn btn-magz white">About Us
     * <i class="ion-ios-arrow-thin-right"></i></a>
     * </div>
     * </div>
     * </div>
     * <div class="col-md-3 col-sm-6 col-xs-12">
     * <div class="block">
     * <h1 class="block-title">Popular Tags <div class="right"><a href="#">See
     * All <i class="ion-ios-arrow-thin-right"></i></a></div></h1>
     * <div class="block-body">
     * <ul class="tags">
     * <li><a href="#">HTML5</a></li>
     * <li><a href="#">CSS3</a></li>
     * <li><a href="#">Bootstrap 3</a></li>
     * <li><a href="#">Web Design</a></li>
     * <li><a href="#">Creative Mind</a></li>
     * <li><a href="#">Standing On The Train</a></li>
     * <li><a href="#">at 6.00PM</a></li>
     * </ul>
     * </div>
     * </div>
     * <div class="line"></div>
     * <div class="block">
     * <h1 class="block-title">Newsletter</h1>
     * <div class="block-body">
     * <p>
     * By subscribing you will receive new articles in your email.</p>
     * <form class="newsletter">
     * <div class="input-group">
     * <div class="input-group-addon">
     * <i class="ion-ios-email-outline"></i>
     * </div>
     * <input type="email" class="form-control email" placeholder="Your mail">
     * </div>
     * <button class="btn btn-primary btn-block white">Subscribe</button>
     * </form>
     * </div>
     * </div>
     * </div>
     * <div class="col-md-3 col-sm-6 col-xs-12">
     * <div class="block">
     * <h1 class="block-title">Latest News</h1>
     * <div class="block-body">
     * <article class="article-mini">
     * <div class="inner">
     * <figure>
     * <a href="single.html">
     * <img src="images/news/img12.jpg" alt="Sample Article">
     * </a>
     * </figure>
     * <div class="padding">
     * <h1><a href="single.html">Donec consequat lorem quis augue
     * pharetra</a></h1>
     * </div>
     * </div>
     * </article>
     * <article class="article-mini">
     * <div class="inner">
     * <figure>
     * <a href="single.html">
     * <img src="images/news/img14.jpg" alt="Sample Article">
     * </a>
     * </figure>
     * <div class="padding">
     * <h1><a href="single.html">eu dapibus risus aliquam etiam ut
     * venenatis</a></h1>
     * </div>
     * </div>
     * </article>
     * <article class="article-mini">
     * <div class="inner">
     * <figure>
     * <a href="single.html">
     * <img src="images/news/img15.jpg" alt="Sample Article">
     * </a>
     * </figure>
     * <div class="padding">
     * <h1><a href="single.html">Nulla facilisis odio quis gravida vestibulum
     * </a></h1>
     * </div>
     * </div>
     * </article>
     * <article class="article-mini">
     * <div class="inner">
     * <figure>
     * <a href="single.html">
     * <img src="images/news/img16.jpg" alt="Sample Article">
     * </a>
     * </figure>
     * <div class="padding">
     * <h1><a href="single.html">Proin venenatis pellentesque arcu vitae
     * </a></h1>
     * </div>
     * </div>
     * </article>
     * <a href="#" class="btn btn-magz white btn-block">See All
     * <i class="ion-ios-arrow-thin-right"></i></a>
     * </div>
     * </div>
     * </div>
     * <div class="col-md-3 col-xs-12 col-sm-6">
     * <div class="block">
     * <h1 class="block-title">Follow Us</h1>
     * <div class="block-body">
     * <p>
     * Follow us and stay in touch to get the latest news</p>
     * <ul class="social trp">
     * <li>
     * <a href="#" class="facebook">
     * <svg><rect width="0" height="0"/></svg>
     * <i class="ion-social-facebook"></i>
     * </a>
     * </li>
     * <li>
     * <a href="#" class="twitter">
     * <svg><rect width="0" height="0"/></svg>
     * <i class="ion-social-twitter-outline"></i>
     * </a>
     * </li>
     * <li>
     * <a href="#" class="youtube">
     * <svg><rect width="0" height="0"/></svg>
     * <i class="ion-social-youtube-outline"></i>
     * </a>
     * </li>
     * <li>
     * <a href="#" class="googleplus">
     * <svg><rect width="0" height="0"/></svg>
     * <i class="ion-social-googleplus"></i>
     * </a>
     * </li>
     * <li>
     * <a href="#" class="instagram">
     * <svg><rect width="0" height="0"/></svg>
     * <i class="ion-social-instagram-outline"></i>
     * </a>
     * </li>
     * <li>
     * <a href="#" class="tumblr">
     * <svg><rect width="0" height="0"/></svg>
     * <i class="ion-social-tumblr"></i>
     * </a>
     * </li>
     * <li>
     * <a href="#" class="dribbble">
     * <svg><rect width="0" height="0"/></svg>
     * <i class="ion-social-dribbble"></i>
     * </a>
     * </li>
     * <li>
     * <a href="#" class="linkedin">
     * <svg><rect width="0" height="0"/></svg>
     * <i class="ion-social-linkedin"></i>
     * </a>
     * </li>
     * <li>
     * <a href="#" class="skype">
     * <svg><rect width="0" height="0"/></svg>
     * <i class="ion-social-skype"></i>
     * </a>
     * </li>
     * <li>
     * <a href="#" class="rss">
     * <svg><rect width="0" height="0"/></svg>
     * <i class="ion-social-rss"></i>
     * </a>
     * </li>
     * </ul>
     * </div>
     * </div>
     * <div class="line"></div>
     * <div class="block">
     * <div class="block-body no-margin">
     * <ul class="footer-nav-horizontal">
     * <li><a href="index.html">Home</a></li>
     * <li><a href="#">Partner</a></li>
     * <li><a href="contact.html">Contact</a></li>
     * <li><a href="page.html">About</a></li>
     * </ul>
     * </div>
     * </div>
     * </div>
     * </div>
     * <div class="row">
     * <div class="col-md-12">
     * <div class="copyright">
     * COPYRIGHT &copy; MAGZ 2017. ALL RIGHT RESERVED.
     * <div>
     * Made with <i class="ion-heart"></i> by jq22
     * </div>
     * </div>
     * </div>
     * </div>
     *
     * @return
     */
    
    public Tag footer() {
        Tag container = this.tag.build("div").attr("class", "container").text("<div class=\"row\">\n"
                + "                    <div class=\"col-md-3 col-sm-6 col-xs-12\">\n"
                + "                        <div class=\"block\">\n"
                + "                            <h1 class=\"block-title\">Company Info</h1>\n"
                + "                            <div class=\"block-body\">\n"
                + "                                <figure class=\"foot-logo\">\n"
                + "                                    <img src=\"images/logo-light.png\" class=\"img-responsive\" alt=\"Logo\">\n"
                + "                                </figure>\n"
                + "                                <p class=\"brand-description\">\n"
                + "                                    Magz is a HTML5 &amp; CSS3 magazine template based on Bootstrap 3.\n"
                + "                                </p>\n"
                + "                                <a href=\"page.html\" class=\"btn btn-magz white\">About Us <i class=\"ion-ios-arrow-thin-right\"></i></a>\n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                    <div class=\"col-md-3 col-sm-6 col-xs-12\">\n"
                + "                        <div class=\"block\">\n"
                + "                            <h1 class=\"block-title\">Popular Tags <div class=\"right\"><a href=\"#\">See All <i class=\"ion-ios-arrow-thin-right\"></i></a></div></h1>\n"
                + "                            <div class=\"block-body\">\n"
                + "                                <ul class=\"tags\">\n"
                + "                                    <li><a href=\"#\">HTML5</a></li>\n"
                + "                                    <li><a href=\"#\">CSS3</a></li>\n"
                + "                                    <li><a href=\"#\">Bootstrap 3</a></li>\n"
                + "                                    <li><a href=\"#\">Web Design</a></li>\n"
                + "                                    <li><a href=\"#\">Creative Mind</a></li>\n"
                + "                                    <li><a href=\"#\">Standing On The Train</a></li>\n"
                + "                                    <li><a href=\"#\">at 6.00PM</a></li>\n"
                + "                                </ul>\n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                        <div class=\"line\"></div>\n"
                + "                        <div class=\"block\">\n"
                + "                            <h1 class=\"block-title\">Newsletter</h1>\n"
                + "                            <div class=\"block-body\">\n"
                + "                                <p>By subscribing you will receive new articles in your email.</p>\n"
                + "                                <form class=\"newsletter\">\n"
                + "                                    <div class=\"input-group\">\n"
                + "                                        <div class=\"input-group-addon\">\n"
                + "                                            <i class=\"ion-ios-email-outline\"></i>\n"
                + "                                        </div>\n"
                + "                                        <input type=\"email\" class=\"form-control email\" placeholder=\"Your mail\">\n"
                + "                                    </div>\n"
                + "                                    <button class=\"btn btn-primary btn-block white\">Subscribe</button>\n"
                + "                                </form>\n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                    <div class=\"col-md-3 col-sm-6 col-xs-12\">\n"
                + "                        <div class=\"block\">\n"
                + "                            <h1 class=\"block-title\">Latest News</h1>\n"
                + "                            <div class=\"block-body\">\n"
                + "                                <article class=\"article-mini\">\n"
                + "                                    <div class=\"inner\">\n"
                + "                                        <figure>\n"
                + "                                            <a href=\"single.html\">\n"
                + "                                                <img src=\"images/news/img12.jpg\" alt=\"Sample Article\">\n"
                + "                                            </a>\n"
                + "                                        </figure>\n"
                + "                                        <div class=\"padding\">\n"
                + "                                            <h1><a href=\"single.html\">Donec consequat lorem quis augue pharetra</a></h1>\n"
                + "                                        </div>\n"
                + "                                    </div>\n"
                + "                                </article>\n"
                + "                                <article class=\"article-mini\">\n"
                + "                                    <div class=\"inner\">\n"
                + "                                        <figure>\n"
                + "                                            <a href=\"single.html\">\n"
                + "                                                <img src=\"images/news/img14.jpg\" alt=\"Sample Article\">\n"
                + "                                            </a>\n"
                + "                                        </figure>\n"
                + "                                        <div class=\"padding\">\n"
                + "                                            <h1><a href=\"single.html\">eu dapibus risus aliquam etiam ut venenatis</a></h1>\n"
                + "                                        </div>\n"
                + "                                    </div>\n"
                + "                                </article>\n"
                + "                                <article class=\"article-mini\">\n"
                + "                                    <div class=\"inner\">\n"
                + "                                        <figure>\n"
                + "                                            <a href=\"single.html\">\n"
                + "                                                <img src=\"images/news/img15.jpg\" alt=\"Sample Article\">\n"
                + "                                            </a>\n"
                + "                                        </figure>\n"
                + "                                        <div class=\"padding\">\n"
                + "                                            <h1><a href=\"single.html\">Nulla facilisis odio quis gravida vestibulum </a></h1>\n"
                + "                                        </div>\n"
                + "                                    </div>\n"
                + "                                </article>\n"
                + "                                <article class=\"article-mini\">\n"
                + "                                    <div class=\"inner\">\n"
                + "                                        <figure>\n"
                + "                                            <a href=\"single.html\">\n"
                + "                                                <img src=\"images/news/img16.jpg\" alt=\"Sample Article\">\n"
                + "                                            </a>\n"
                + "                                        </figure>\n"
                + "                                        <div class=\"padding\">\n"
                + "                                            <h1><a href=\"single.html\">Proin venenatis pellentesque arcu vitae </a></h1>\n"
                + "                                        </div>\n"
                + "                                    </div>\n"
                + "                                </article>\n"
                + "                                <a href=\"#\" class=\"btn btn-magz white btn-block\">See All <i class=\"ion-ios-arrow-thin-right\"></i></a>\n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                    <div class=\"col-md-3 col-xs-12 col-sm-6\">\n"
                + "                        <div class=\"block\">\n"
                + "                            <h1 class=\"block-title\">Follow Us</h1>\n"
                + "                            <div class=\"block-body\">\n"
                + "                                <p>Follow us and stay in touch to get the latest news</p>\n"
                + "                                <ul class=\"social trp\">\n"
                + "                                    <li>\n"
                + "                                        <a href=\"#\" class=\"facebook\">\n"
                + "                                            <svg><rect width=\"0\" height=\"0\"/></svg>\n"
                + "                                            <i class=\"ion-social-facebook\"></i>\n"
                + "                                        </a>\n"
                + "                                    </li>\n"
                + "                                    <li>\n"
                + "                                        <a href=\"#\" class=\"twitter\">\n"
                + "                                            <svg><rect width=\"0\" height=\"0\"/></svg>\n"
                + "                                            <i class=\"ion-social-twitter-outline\"></i>\n"
                + "                                        </a>\n"
                + "                                    </li>\n"
                + "                                    <li>\n"
                + "                                        <a href=\"#\" class=\"youtube\">\n"
                + "                                            <svg><rect width=\"0\" height=\"0\"/></svg>\n"
                + "                                            <i class=\"ion-social-youtube-outline\"></i>\n"
                + "                                        </a>\n"
                + "                                    </li>\n"
                + "                                    <li>\n"
                + "                                        <a href=\"#\" class=\"googleplus\">\n"
                + "                                            <svg><rect width=\"0\" height=\"0\"/></svg>\n"
                + "                                            <i class=\"ion-social-googleplus\"></i>\n"
                + "                                        </a>\n"
                + "                                    </li>\n"
                + "                                    <li>\n"
                + "                                        <a href=\"#\" class=\"instagram\">\n"
                + "                                            <svg><rect width=\"0\" height=\"0\"/></svg>\n"
                + "                                            <i class=\"ion-social-instagram-outline\"></i>\n"
                + "                                        </a>\n"
                + "                                    </li>\n"
                + "                                    <li>\n"
                + "                                        <a href=\"#\" class=\"tumblr\">\n"
                + "                                            <svg><rect width=\"0\" height=\"0\"/></svg>\n"
                + "                                            <i class=\"ion-social-tumblr\"></i>\n"
                + "                                        </a>\n"
                + "                                    </li>\n"
                + "                                    <li>\n"
                + "                                        <a href=\"#\" class=\"dribbble\">\n"
                + "                                            <svg><rect width=\"0\" height=\"0\"/></svg>\n"
                + "                                            <i class=\"ion-social-dribbble\"></i>\n"
                + "                                        </a>\n"
                + "                                    </li>\n"
                + "                                    <li>\n"
                + "                                        <a href=\"#\" class=\"linkedin\">\n"
                + "                                            <svg><rect width=\"0\" height=\"0\"/></svg>\n"
                + "                                            <i class=\"ion-social-linkedin\"></i>\n"
                + "                                        </a>\n"
                + "                                    </li>\n"
                + "                                    <li>\n"
                + "                                        <a href=\"#\" class=\"skype\">\n"
                + "                                            <svg><rect width=\"0\" height=\"0\"/></svg>\n"
                + "                                            <i class=\"ion-social-skype\"></i>\n"
                + "                                        </a>\n"
                + "                                    </li>\n"
                + "                                    <li>\n"
                + "                                        <a href=\"#\" class=\"rss\">\n"
                + "                                            <svg><rect width=\"0\" height=\"0\"/></svg>\n"
                + "                                            <i class=\"ion-social-rss\"></i>\n"
                + "                                        </a>\n"
                + "                                    </li>\n"
                + "                                </ul>\n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                        <div class=\"line\"></div>\n"
                + "                        <div class=\"block\">\n"
                + "                            <div class=\"block-body no-margin\">\n"
                + "                                <ul class=\"footer-nav-horizontal\">\n"
                + "                                    <li><a href=\"index.html\">Home</a></li>\n"
                + "                                    <li><a href=\"#\">Partner</a></li>\n"
                + "                                    <li><a href=\"contact.html\">Contact</a></li>\n"
                + "                                    <li><a href=\"page.html\">About</a></li>\n"
                + "                                </ul>\n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "                <div class=\"row\">\n"
                + "                    <div class=\"col-md-12\">\n"
                + "                        <div class=\"copyright\">\n"
                + "                            COPYRIGHT &copy; MAGZ 2017. ALL RIGHT RESERVED.\n"
                + "                            <div>\n"
                + "                                Made with <i class=\"ion-heart\"></i> by jq22\n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                </div>");
        /*Tag container_row = this.tag.build("div").attr("class","row");
        
        //这里 是 第一行的 数据 
        Tag container_row_col1 = this.tag.build("div").attr("class", "col-md-3 col-sm-6 col-xs-12");
        Tag container_row_col1_block = this.tag.build("div").attr("class", "block");
         */

        return container;
    }

    /**
     *
     * 相对应的 输入 信息 的 section
     *
     * @param title
     * @param input_groups
     * @return
     */
    public Tag inputSection(String title, List<Tag> input_groups) {
        Tag section = this.tag.build("section").attr("class", "login first grey");
        Tag section_container = this.tag.build("div").attr("class", "container");
        Tag section_container_box = this.tag.build("div").attr("class", "box box-border");
        Tag section_container_box_body = this.tag.build("div").attr("class", "box-body");
        Tag section_container_box_body_h4 = this.tag.build("h4").text(title);

        Tag section_container_box_body_form = this.tag.build("form");

        //下面 我们 就可以 设计 相对应的 信息
        //在下面的 信息 , 我们 可以 相对应的 输入 信息
        this.tag.append(section_container_box_body, section_container_box_body_h4)
                .append(section_container_box, section_container_box_body)
                .append(section_container, section_container_box)
                .append(section, section_container);

        //将 相对应的 信息 进行是输入
        for (Tag input_group : input_groups) {
            this.tag.append(section_container_box_body_form, input_group);
        }

        return section;
    }

    /**
     * <div class="form-group">
     * <label class="fw">Password</label>
     * <input type="password" name="password" class="form-control">
     * </div>
     *
     * @param class_name
     * @param label
     * @param input
     * @return
     */
    // 相对应的 label  name , 
    public Tag sectionInputGroup(String class_name, String label, Tag input) {
        Tag group = this.tag.build("div").attr("class", "form-group");
        Tag group_label = this.tag.build("label").text(label);

        this.tag.append(group, group_label)
                .append(group, input);

        return group;
    }

    /**
     * <div class="form-group text-right">
     * <button class="btn btn-primary btn-block">Register</button>
     * </div> * @param button_name
     *
     * @param button_name
     * @return
     */
    public Tag sectionBtn(String button_name) {
        Tag div = this.tag.build("div").attr("class", "form-group text-right");

        Tag div_button = this.tag.build("button").attr("class", "btn btn-primary btn-block").text(button_name);

        this.tag.append(div, div_button);

        return div;
    }

    /**
     *
     * <div class="form-group text-center">
     * <span class="text-muted">Already have an account?</span>
     * <a href="login.html">Login</a>
     * </div>
     *
     * @param string
     * @param tag
     * @return
     */
    public Tag sectionMuted(String string, Tag tag) {

        Tag group = this.tag.build("div").attr("class", "form-group text-center");

        Tag group_span = this.tag.build("span").attr("class", "text-muted").text(string);

        this.tag.append(group_span, tag)
                .append(group, group_span);
        return group;
    }
    
    public Tag icon(String class_name){
        return this.tag.build("i").attr("class", class_name);
    }
    
    public Tag block(String block_title_string ,  List<Tag> tags){
        //相对应的 block 的 信息 本体、
        Tag block = this.tag.build("div").attr("class", "block");
        
        Tag block_title = this.tag.build("h1").attr("class", "block-title")
                .text(block_title_string);
        
        Tag block_body = this.tag.build("div").attr("class", "block-body");
        
        for(Tag tag : tags){
            //将目标的 tag 按照 相对应的 序列关系 进行 插入
            this.tag.append(block_body, tag);
        }
        //已经输入 相对应的 消息
        
        this.tag.append(block, block_title)
                .append(block, block_body);
        
        
        return block;
    }
    
    //输出 相对应的 信息
    public Tag button(String href , String class_string , String text){
        //输出 相对应的 信息    
        return this.tag.build("a").attr("href", href).attr("class", class_string)
                .text(text);
    }
}
