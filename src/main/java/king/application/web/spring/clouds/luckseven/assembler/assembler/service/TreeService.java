/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.service;

import king.application.web.spring.clouds.luckseven.assembler.assembler.service.tag.TagService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import king.application.web.spring.clouds.luckseven.assembler.assembler.bean.Article;
import king.application.web.spring.clouds.luckseven.assembler.assembler.bean.User;
import king.application.web.spring.clouds.luckseven.assembler.assembler.tag.Tag;
import king.application.web.spring.clouds.luckseven.assembler.assembler.tag.strategy.TagStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 倘若 需要 一次性的 全部输出 相对应的 信息 我们便在这里 进行 相对应的 规定 ， 这里只生产 相对应的 一次性产生工具
 *
 * @author king
 */
@Service
public class TreeService {

    @Autowired
    private FeignService feign;

    @Autowired
    private TreeService tree;

    @Autowired
    private LeafService leaf;

    @Autowired
    private TagService tag;
    
    @Autowired
    private StrategyService strategy;
    
    @Autowired
    private UrlService url;
    
    //之后 再为该方法 进行 相对应的 工作 ， 应为 内部 不知道 
    //暂时 不必
    public Tag strategy(){
        TagStrategy _strategy = this.strategy.get(null);
        return _strategy.build();
    }

    /**
     * 下面 这个 是 相对应的 所有网页头部的 信息
     *
     * 可能 我们需要分成 好几部 来完成 相对应的 工作 ， 但是 没事 ， 我认为 ， 在 相对应的 时间内
     *
     * 另一个参数 ，User 可以 进行 相对应的 调整 ,
     *
     */
    // 但是 还是 有 相对应的 问题 ， 便是  效率 上的 问题 ， 估计 之后 需要 相对应的 调整
    /**
     * <div class="firstbar">
     * <div class="container">
     * <div class="row">
     * <div class="col-md-3 col-sm-12">
     * <div class="brand">
     * <a href="index.html">
     * <img src="images/logo.png" alt="Magz Logo">
     * </a>
     * </div>
     * </div>
     * <div class="col-md-6 col-sm-12">
     * <form class="search" autocomplete="off">
     * <div class="form-group">
     * <div class="input-group">
     * <input type="text" name="string" class="form-control" placeholder="Type something here">
     * <div class="input-group-btn">
     * <button class="btn btn-primary"><i class="ion-search"></i></button>
     * </div>
     * </div>
     * </div>
     * <div class="help-block">
     * <div>Popular:</div>
     * <ul>
     * <li><a href="#">HTML5</a></li>
     * <li><a href="#">CSS3</a></li>
     * <li><a href="#">Bootstrap 3</a></li>
     * <li><a href="#">jQuery</a></li>
     * <li><a href="#">AnguarJS</a></li>
     * </ul>
     * </div>
     * </form>
     * </div>
     * <div class="col-md-3 col-sm-12 text-right">
     * <ul class="nav-icons">
     * <li><a href="register.html"><i class="ion-person-add"></i><div>Register</div></a></li>
     * <li><a href="login.html"><i class="ion-person"></i><div>Login</div></a></li>
     * </ul>
     * </div>
     * </div>
     * </div>
     * </div>
     *
     * @param recommend_map
     * @param user
     * @return
     */
    public Tag headerFirstbar(Map<String, String> recommend_map, User user) {
        //似乎 有 两部分 组成 ， 我们 首先 观察 上面 那部分

        //这里 , 我们 需要 设置 更多的 信息 ,比如 搜索 下面的 推荐信息
        Tag firstbar = this.tag.build("div").attr("class", "firstbar");
        Tag firstbar_container = this.tag.build("div").attr("class", "container");
        Tag firstbar_container_row = this.tag.build("div").attr("class", "row");
        Tag firstbar_container_row_col1 = this.tag.build("div").attr("class", "col-md-3 col-sm-12");
        
        //这里 是 应该是 相对应的 标志 文件 路径 
        // 设置 相对应的
        Tag firstbar_container_row_col1_brand = this.leaf.brand("images/logo.png", "/minitors/model/");

        this.tag.append(firstbar_container_row_col1, firstbar_container_row_col1_brand)
                .append(firstbar_container_row, firstbar_container_row_col1);
        //但这里 为止 之前 ，  已经 结束了 一部分 ，  但是 县低音的 col1 还是 没有 完成

        Tag firstbar_container_row_col2 = this.tag.build("div").attr("class", "col-md-6 col-sm-12");

        //可以在这里设置 相对应的 action 的 属性 ， 来确定 相对应导向的 位置
        Tag firstbar_container_row_col2_form = this.tag.build("form").attr("class", "search").attr("autocomplete", "off")
                .attr("action",this.url.http("category"));

        Tag firstbar_container_row_col2_form_group = this.tag.build("div").attr("class", "form-group");
        Tag firstbar_container_row_col2_form_group_group = this.tag.build("div").attr("class", "input-group");

        /*  有相对应  带输入 的 值 ， 目前 设置 为 相对应的 string*/
        //这里输入 相对应的 input ， 以及 相对应的 parameter
        Tag firstbar_container_row_col2_form_group_group_input = this.tag.build("input").attr("type", "text")
                .attr("name", "string").attr("class", "form-control").attr("placeholder", "Type something here");

        Tag firstbar_container_row_col2_form_group_group_btn = this.tag.build("div").attr("class", "input-group-btn");

        Tag firstbar_container_row_col2_form_group_group_btn_button = this.tag.build("button").attr("class", "btn btn-primary");
        Tag firstbar_container_row_col2_form_group_group_btn_button_i = this.tag.build("i").attr("class", "ion-search");

        this.tag.append(firstbar_container_row_col2_form_group_group_btn_button, firstbar_container_row_col2_form_group_group_btn_button_i)
                .append(firstbar_container_row_col2_form_group_group_btn, firstbar_container_row_col2_form_group_group_btn_button)
                .append(firstbar_container_row_col2_form_group_group, firstbar_container_row_col2_form_group_group_input)
                .append(firstbar_container_row_col2_form_group_group, firstbar_container_row_col2_form_group_group_btn)
                .append(firstbar_container_row_col2_form_group, firstbar_container_row_col2_form_group_group)
                .append(firstbar_container_row_col2_form, firstbar_container_row_col2_form_group);

        //其实 添加 到 这里 就结束了
        Tag firstbar_container_row_col2_form_help = this.tag.build("div").attr("class", "help-block");

        //应该 是 头部 标签 文字
        Tag firstbar_container_row_col2_form_help_popular = this.tag.build("div").text("Popular:");

        //这里 开始 相对应的 开始 有 一定的 标签 ， 因此  ， 我认为 这里 也应该 可以 使用 相对应的 
        Tag firstbar_container_row_col2_form_help_ul = this.tag.build("ul");

        /* 这里 有 相对应的 数据  ， 可以 使用 相对应的 数据  ， 但是 这里的 结果 ， 
            个人 认为 这里的 这个 数据 ， 最好 能使用 相对应 系统内 点击量最多的 数据 
            key 为 相对应的 推荐 内容 ， value 为 链接
         */
        //这里仅仅是测试 数据 中心
        /**
         * 下面 ， 我们 开始 设置
         */
        Map<String, String> firstbar_container_row_col2_form_help_ul_li_recommands_map = recommend_map;

        for (String key : firstbar_container_row_col2_form_help_ul_li_recommands_map.keySet()) {

            //注意 ， 相对应的 key 为 text ， name 为 推荐 内容
            //相对应的 li 数据
            String value = firstbar_container_row_col2_form_help_ul_li_recommands_map.get(key);
            
            //获取 相对应的 路径
            String url = this.url.http("category","string" , value);

            Tag first_container_row_col2_form_help_ul_li = this.tag.build("li");

            //设置 相对应的 信息
            Tag first_container_row_col2_form_help_ul_li_a = this.tag.build("a").attr("href", url).text(key);

            this.tag.append(first_container_row_col2_form_help_ul_li, first_container_row_col2_form_help_ul_li_a)
                    .append(firstbar_container_row_col2_form_help_ul, first_container_row_col2_form_help_ul_li);
        }

        this.tag.append(firstbar_container_row_col2_form_help, firstbar_container_row_col2_form_help_popular)
                .append(firstbar_container_row_col2_form_help, firstbar_container_row_col2_form_help_ul)
                .append(firstbar_container_row_col2_form, firstbar_container_row_col2_form_help)
                .append(firstbar_container_row_col2, firstbar_container_row_col2_form)
                .append(firstbar_container_row, firstbar_container_row_col2);

        /* 这里 使用的 默认 参数  */
        //这里 是 用户信息的 地址 ， 个人认为 最好把 这个 单独 撰写 一个 函数 ， 
        Tag firstbar_container_row_col3 = user != null ? this.leaf.headerFirstbarUserDiv(user) : this.leaf.headerFirstbarDeafultUser();

        this.tag.append(firstbar_container_row, firstbar_container_row_col3)
                .append(firstbar_container, firstbar_container_row)
                .append(firstbar, firstbar_container);

        return firstbar;

        // 相对应
    }

    /**
     *
     * 大致 分析 了 一下 ， 相对应的 错误 应该 是 需要 设置 一个 List ， 然后 元素 最简单 的 可以 是一个 相对应的 Tag ，
     * 这是 最简单的 方法， 但是 这样的 操作 ， 无法 进行 很 好的 管理 ， 以及 自动化
     *
     * @return
     */
    public Tag headerMenu() {

        Tag menu = this.tag.build("nav").attr("class", "menu");

        Tag menu_container = this.tag.build("div").attr("class", "container");

        //使用 相对应的 方法 进行 获取
        //这里暂时 不需要 添加 什么的 
        Tag menu_container_brand = this.leaf.brand("images/logo.png", "/minitor/model/");

        this.tag.append(menu_container, menu_container_brand);

        //可能 需要 相对应的 连接 地址 ， 但也可一 不需要 ， 因为 这个 只是 相对应的 调增 位置的 连接
        Tag menu_container_mobile_menu = this.leaf.headerMobileToggle("menu", "#menu-list", "ion-navicon-round");

        Tag menu_container_mobile_sidebar = this.leaf.headerMobileToggle("sidebar", "#sidebar", "ion-ios-arrow-left");

        this.tag.append(menu_container, menu_container_mobile_menu)
                .append(menu_container, menu_container_mobile_sidebar);

        Tag menu_container_menu = this.tag.build("div").attr("id", "menu-list");

        Tag menu_container_menu_nav = this.tree.headerMeauNavList();

        this.tag.append(menu_container_menu, menu_container_menu_nav)
                .append(menu_container, menu_container_menu)
                .append(menu, menu_container);

        return menu;
    }

    /**
     * 之所以 ， 这里还没有 进行 动手操作 ， 的 主要 原因 便是
     * 这里需要大量的 操作策略模型的设计
     * 需要等到 相对应的 模型理论建立 之后 ， 才可以 进行 相对应的操作
     * 
     * @return 
     */
    public Tag headerMeauNavList() {
        Tag navlist = this.tag.build("div").attr("id", "menu-list");

        Tag navlist_ul = this.tag.build("ul").attr("class", "nav-list").text("<li class=\"for-tablet nav-title\"><a>Menu</a></li>\n"
                + "                            <li class=\"for-tablet\"><a href=\"login.html\">Login</a></li>\n"
                + "                            <li class=\"for-tablet\"><a href=\"register.html\">Register</a></li>\n"
                + "                            <li><a href=\"category.html\">Standard</a></li>\n"
                + "                            <li class=\"dropdown magz-dropdown\">\n"
                + "                                <a href=\"category.html\">Pages <i class=\"ion-ios-arrow-right\"></i></a>\n"
                + "                                <ul class=\"dropdown-menu\">\n"
                + "                                    <li><a href=\"index.html\">Home</a></li>\n"
                + "                                    <li class=\"dropdown magz-dropdown\">\n"
                + "                                        <a href=\"#\">Authentication <i class=\"ion-ios-arrow-right\"></i></a>\n"
                + "                                        <ul class=\"dropdown-menu\">\n"
                + "                                            <li><a href=\"login.html\">Login</a></li>\n"
                + "                                            <li><a href=\"register.html\">Register</a></li>\n"
                + "                                            <li><a href=\"forgot.html\">Forgot Password</a></li>\n"
                + "                                            <li><a href=\"reset.html\">Reset Password</a></li>\n"
                + "                                        </ul>\n"
                + "                                    </li>\n"
                + "                                    <li><a href=\"category.html\">Category</a></li>\n"
                + "                                    <li><a href=\"single.html\">Single</a></li>\n"
                + "                                    <li><a href=\"page.html\">Page</a></li>\n"
                + "                                    <li><a href=\"search.html\">Search</a></li>\n"
                + "                                    <li><a href=\"contact.html\">Contact</a></li>\n"
                + "                                    <li class=\"dropdown magz-dropdown\">\n"
                + "                                        <a href=\"#\">Error <i class=\"ion-ios-arrow-right\"></i></a>\n"
                + "                                        <ul class=\"dropdown-menu\">\n"
                + "                                            <li><a href=\"403.html\">403</a></li>\n"
                + "                                            <li><a href=\"404.html\">404</a></li>\n"
                + "                                            <li><a href=\"500.html\">500</a></li>\n"
                + "                                            <li><a href=\"503.html\">503</a></li>\n"
                + "                                        </ul>\n"
                + "                                    </li>\n"
                + "                                </ul>\n"
                + "                            </li>\n"
                + "                            <li class=\"dropdown magz-dropdown\"><a href=\"#\">Dropdown <i class=\"ion-ios-arrow-right\"></i></a>\n"
                + "                                <ul class=\"dropdown-menu\">\n"
                + "                                    <li><a href=\"category.html\">Internet</a></li>\n"
                + "                                    <li class=\"dropdown magz-dropdown\"><a href=\"category.html\">Troubleshoot <i class=\"ion-ios-arrow-right\"></i></a>\n"
                + "                                        <ul class=\"dropdown-menu\">\n"
                + "                                            <li><a href=\"category.html\">Software</a></li>\n"
                + "                                            <li class=\"dropdown magz-dropdown\"><a href=\"category.html\">Hardware <i class=\"ion-ios-arrow-right\"></i></a>\n"
                + "                                                <ul class=\"dropdown-menu\">\n"
                + "                                                    <li><a href=\"category.html\">Main Board</a></li>\n"
                + "                                                    <li><a href=\"category.html\">RAM</a></li>\n"
                + "                                                    <li><a href=\"category.html\">Power Supply</a></li>\n"
                + "                                                </ul>\n"
                + "                                            </li>\n"
                + "                                            <li><a href=\"category.html\">Brainware</a>\n"
                + "                                        </ul>\n"
                + "                                    </li>\n"
                + "                                    <li><a href=\"category.html\">Office</a></li>\n"
                + "                                    <li class=\"dropdown magz-dropdown\"><a href=\"#\">Programming <i class=\"ion-ios-arrow-right\"></i></a>\n"
                + "                                        <ul class=\"dropdown-menu\">\n"
                + "                                            <li><a href=\"category.html\">Web</a></li>\n"
                + "                                            <li class=\"dropdown magz-dropdown\"><a href=\"category.html\">Mobile <i class=\"ion-ios-arrow-right\"></i></a>\n"
                + "                                                <ul class=\"dropdown-menu\">\n"
                + "                                                    <li class=\"dropdown magz-dropdown\"><a href=\"category.html\">Hybrid <i class=\"ion-ios-arrow-right\"></i></a>\n"
                + "                                                        <ul class=\"dropdown-menu\">\n"
                + "                                                            <li><a href=\"#\">Ionic Framework 1</a></li>\n"
                + "                                                            <li><a href=\"#\">Ionic Framework 2</a></li>\n"
                + "                                                            <li><a href=\"#\">Ionic Framework 3</a></li>\n"
                + "                                                            <li><a href=\"#\">Framework 7</a></li>\n"
                + "                                                        </ul>\n"
                + "                                                    </li>\n"
                + "                                                    <li><a href=\"category.html\">Native</a></li>\n"
                + "                                                </ul>\n"
                + "                                            </li>\n"
                + "                                            <li><a href=\"category.html\">Desktop</a></li>\n"
                + "                                        </ul>\n"
                + "                                    </li>\n"
                + "                                </ul>\n"
                + "                            </li>\n"
                + "                            <li class=\"dropdown magz-dropdown magz-dropdown-megamenu\"><a href=\"#\">Mega Menu <i class=\"ion-ios-arrow-right\"></i> <div class=\"badge\">Hot</div></a>\n"
                + "                                <div class=\"dropdown-menu megamenu\">\n"
                + "                                    <div class=\"megamenu-inner\">\n"
                + "                                        <div class=\"row\">\n"
                + "                                            <div class=\"col-md-3\">\n"
                + "                                                <div class=\"row\">\n"
                + "                                                    <div class=\"col-md-12\">\n"
                + "                                                        <h2 class=\"megamenu-title\">Trending</h2>\n"
                + "                                                    </div>\n"
                + "                                                </div>\n"
                + "                                                <ul class=\"vertical-menu\">\n"
                + "                                                    <li><a href=\"#\"><i class=\"ion-ios-circle-outline\"></i> Mega menu is a new feature</a></li>\n"
                + "                                                    <li><a href=\"#\"><i class=\"ion-ios-circle-outline\"></i> This is an example</a></li>\n"
                + "                                                    <li><a href=\"#\"><i class=\"ion-ios-circle-outline\"></i> For a submenu item</a></li>\n"
                + "                                                    <li><a href=\"#\"><i class=\"ion-ios-circle-outline\"></i> You can add</a></li>\n"
                + "                                                    <li><a href=\"#\"><i class=\"ion-ios-circle-outline\"></i> Your own items</a></li>\n"
                + "                                                </ul>\n"
                + "                                            </div>\n"
                + "                                            <div class=\"col-md-9\">\n"
                + "                                                <div class=\"row\">\n"
                + "                                                    <div class=\"col-md-12\">\n"
                + "                                                        <h2 class=\"megamenu-title\">Featured Posts</h2>\n"
                + "                                                    </div>\n"
                + "                                                </div>\n"
                + "                                                <div class=\"row\">\n"
                + "                                                    <article class=\"article col-md-4 mini\">\n"
                + "                                                        <div class=\"inner\">\n"
                + "                                                            <figure>\n"
                + "                                                                <a href=\"single.html\">\n"
                + "                                                                    <img src=\"images/news/img10.jpg\" alt=\"Sample Article\">\n"
                + "                                                                </a>\n"
                + "                                                            </figure>\n"
                + "                                                            <div class=\"padding\">\n"
                + "                                                                <div class=\"detail\">\n"
                + "                                                                    <div class=\"time\">December 10, 2016</div>\n"
                + "                                                                    <div class=\"category\"><a href=\"category.html\">Healthy</a></div>\n"
                + "                                                                </div>\n"
                + "                                                                <h2><a href=\"single.html\">Duis aute irure dolor in reprehenderit in voluptate</a></h2>\n"
                + "                                                            </div>\n"
                + "                                                        </div>\n"
                + "                                                    </article>\n"
                + "                                                    <article class=\"article col-md-4 mini\">\n"
                + "                                                        <div class=\"inner\">\n"
                + "                                                            <figure>\n"
                + "                                                                <a href=\"single.html\">\n"
                + "                                                                    <img src=\"images/news/img11.jpg\" alt=\"Sample Article\">\n"
                + "                                                                </a>\n"
                + "                                                            </figure>\n"
                + "                                                            <div class=\"padding\">\n"
                + "                                                                <div class=\"detail\">\n"
                + "                                                                    <div class=\"time\">December 13, 2016</div>\n"
                + "                                                                    <div class=\"category\"><a href=\"category.html\">Lifestyle</a></div>\n"
                + "                                                                </div>\n"
                + "                                                                <h2><a href=\"single.html\">Duis aute irure dolor in reprehenderit in voluptate</a></h2>\n"
                + "                                                            </div>\n"
                + "                                                        </div>\n"
                + "                                                    </article>\n"
                + "                                                    <article class=\"article col-md-4 mini\">\n"
                + "                                                        <div class=\"inner\">\n"
                + "                                                            <figure>\n"
                + "                                                                <a href=\"single.html\">\n"
                + "                                                                    <img src=\"images/news/img14.jpg\" alt=\"Sample Article\">\n"
                + "                                                                </a>\n"
                + "                                                            </figure>\n"
                + "                                                            <div class=\"padding\">\n"
                + "                                                                <div class=\"detail\">\n"
                + "                                                                    <div class=\"time\">December 14, 2016</div>\n"
                + "                                                                    <div class=\"category\"><a href=\"category.html\">Travel</a></div>\n"
                + "                                                                </div>\n"
                + "                                                                <h2><a href=\"single.html\">Duis aute irure dolor in reprehenderit in voluptate</a></h2>\n"
                + "                                                            </div>\n"
                + "                                                        </div>\n"
                + "                                                    </article>\n"
                + "                                                </div>\n"
                + "                                            </div>\n"
                + "                                        </div>								\n"
                + "                                    </div>\n"
                + "                                </div>\n"
                + "                            </li>\n"
                + "                            <li class=\"dropdown magz-dropdown magz-dropdown-megamenu\"><a href=\"#\">Column <i class=\"ion-ios-arrow-right\"></i></a>\n"
                + "                                <div class=\"dropdown-menu megamenu\">\n"
                + "                                    <div class=\"megamenu-inner\">\n"
                + "                                        <div class=\"row\">\n"
                + "                                            <div class=\"col-md-3\">\n"
                + "                                                <h2 class=\"megamenu-title\">Column 1</h2>\n"
                + "                                                <ul class=\"vertical-menu\">\n"
                + "                                                    <li><a href=\"#\">Example 1</a></li>\n"
                + "                                                    <li><a href=\"#\">Example 2</a></li>\n"
                + "                                                    <li><a href=\"#\">Example 3</a></li>\n"
                + "                                                    <li><a href=\"#\">Example 4</a></li>\n"
                + "                                                    <li><a href=\"#\">Example 5</a></li>\n"
                + "                                                </ul>\n"
                + "                                            </div>\n"
                + "                                            <div class=\"col-md-3\">\n"
                + "                                                <h2 class=\"megamenu-title\">Column 2</h2>\n"
                + "                                                <ul class=\"vertical-menu\">\n"
                + "                                                    <li><a href=\"#\">Example 6</a></li>\n"
                + "                                                    <li><a href=\"#\">Example 7</a></li>\n"
                + "                                                    <li><a href=\"#\">Example 8</a></li>\n"
                + "                                                    <li><a href=\"#\">Example 9</a></li>\n"
                + "                                                    <li><a href=\"#\">Example 10</a></li>\n"
                + "                                                </ul>\n"
                + "                                            </div>\n"
                + "                                            <div class=\"col-md-3\">\n"
                + "                                                <h2 class=\"megamenu-title\">Column 3</h2>\n"
                + "                                                <ul class=\"vertical-menu\">\n"
                + "                                                    <li><a href=\"#\">Example 11</a></li>\n"
                + "                                                    <li><a href=\"#\">Example 12</a></li>\n"
                + "                                                    <li><a href=\"#\">Example 13</a></li>\n"
                + "                                                    <li><a href=\"#\">Example 14</a></li>\n"
                + "                                                    <li><a href=\"#\">Example 15</a></li>\n"
                + "                                                </ul>\n"
                + "                                            </div>\n"
                + "                                            <div class=\"col-md-3\">\n"
                + "                                                <h2 class=\"megamenu-title\">Column 4</h2>\n"
                + "                                                <ul class=\"vertical-menu\">\n"
                + "                                                    <li><a href=\"#\">Example 16</a></li>\n"
                + "                                                    <li><a href=\"#\">Example 17</a></li>\n"
                + "                                                    <li><a href=\"#\">Example 18</a></li>\n"
                + "                                                    <li><a href=\"#\">Example 19</a></li>\n"
                + "                                                    <li><a href=\"#\">Example 20</a></li>\n"
                + "                                                </ul>\n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "                                    </div>\n"
                + "                                </div>\n"
                + "                            </li>\n"
                + "                            <li class=\"dropdown magz-dropdown\"><a href=\"#\">Dropdown Icons <i class=\"ion-ios-arrow-right\"></i></a>\n"
                + "                                <ul class=\"dropdown-menu\">\n"
                + "                                    <li><a href=\"#\"><i class=\"icon ion-person\"></i> My Account</a></li>\n"
                + "                                    <li><a href=\"#\"><i class=\"icon ion-heart\"></i> Favorite</a></li>\n"
                + "                                    <li><a href=\"#\"><i class=\"icon ion-chatbox\"></i> Comments</a></li>\n"
                + "                                    <li><a href=\"#\"><i class=\"icon ion-key\"></i> Change Password</a></li>\n"
                + "                                    <li><a href=\"#\"><i class=\"icon ion-settings\"></i> Settings</a></li>\n"
                + "                                    <li class=\"divider\"></li>\n"
                + "                                    <li><a href=\"#\"><i class=\"icon ion-log-out\"></i> Logout</a></li>\n"
                + "                                </ul>\n"
                + "                            </li>");

        this.tag.append(navlist, navlist_ul);

        return navlist;

    }

    //需要 两个值 ， 一个为 用户 ， 一个为
    public Tag footer() {

        Tag container = this.tag.build("div").attr("class", "container");
        //最上层的 信息

        Tag container_row = this.tag.build("div").attr("class", "row");

        //这里 是 创建 最左边的 那个 小表格
        //创建 开始
        Tag container_row_div_1 = this.tag.build("div").attr("class", "col-md-3 col-sm-6 col-xs-12");

        Tag container_row_div_block = this.tag.build("div").attr("class", "block");
        
        Tag container_row_div_block_title = this.tag.build("h1").attr("class", "block-title");

        Tag container_row_div_block_body = this.tag.build("h1").attr("class", "block-body");
        
        Tag container_row_div_block_body_figure = this.tag.build("figure").attr("class","foot-logo");
        
        
        //输入 相对应的 src 地址
        String container_row_div_block_body_figure_img_string = "images/logo-light.png";
        
        
        Tag container_row_div_block_body_figure_img = this.tag.build("img").attr("class", "img-responsive")
                .attr("alt", "Logo").attr("src", container_row_div_block_body_figure_img_string);
        
        //填充 相对应的 信息
        this.tag.append(container_row_div_block_body_figure,container_row_div_block_body_figure_img);

        //相对应的 公司介绍 文本信息
        String container_row_div_block_body_describe_string 
                = "Magz is a HTML5 &amp; CSS3 magazine template based on Bootstrap 3.";
        //相对应的公司介绍
        Tag container_row_div_block_body_describe = this.tag.build("p").attr("class", "brand-description")
                .text(container_row_div_block_body_describe_string);
        
        //下面 两个元素分别代表着 不同的 信息
        String container_row_div_block_body_a_href = "/minitors/model/" ;
        String container_row_div_block_body_a_text = "About us";
        
        Tag container_row_div_block_body_a = this.tag.build("a")
                .attr("href",container_row_div_block_body_a_href).attr("class", "btn btn-magz white")
                .text(container_row_div_block_body_a_text);
        //对应的 图标信息
        Tag container_row_div_block_body_a_i = this.leaf.icon("ion-ios-arrow-thin-right");
        
        //将 图标值 icon ， 带入 a中
        this.tag.append(container_row_div_block_body_a,container_row_div_block_body_a_i)
                //这里 开始 输入 相对应的 信息
                .append(container_row_div_block_body, container_row_div_block_body_figure)
                .append(container_row_div_block_body, container_row_div_block_body_describe)
                .append(container_row_div_block_body, container_row_div_block_body_a)
                //block_body 中的 值 已经输入完成 ， 现在 ， 我们 输入 相对应的 上层信息
                
                .append(container_row_div_block, container_row_div_block_title)
                .append(container_row_div_block, container_row_div_block_body)
                
                .append(container_row_div_1,container_row_div_block);
        
        
        Tag container_row_div_2 = this.tag.build("div").attr("div", "col-md-3 col-sm-6 col-xs-12");
        
        //中间位 我们 开始 创建 相对应的 信息
        
        
        //这里 是 相对应的 List<PeridocialBrief> 的 信息 , 如何 获取该信息 ， 我们 不去 追究 ， 
        //我们 直接 在这里进行输出
        
        //设置 上列的 信息
        
        List<Article> container_row_div_2_block_peridocials = new ArrayList<Article>();
        //获取相对应的 信息的长度
        List<Tag> container_row_div_2_block_tag_list = new ArrayList<>();
        
        for(Article peridocial_brief : container_row_div_2_block_peridocials){
            Tag container_row_div_2_block_article = this.leaf.articleMini(peridocial_brief);
            //将 相对应的 信息 输入 到 相对应的地方
            container_row_div_2_block_tag_list.add(container_row_div_2_block_article);
        }
        
        Tag container_row_div_2_block_icon = this.leaf
                    .button("#" , "btn btn-magz white btn-block" 
                            ,  new StringBuilder().append("See all")
                                    .append(this.tag.http(this.leaf.icon("ion-ios-arrow-thin-right")))
                                    .toString());
        
        container_row_div_2_block_tag_list.add(container_row_div_2_block_icon);
        
        Tag container_row_div_2_block = this.leaf.block("LastNew", container_row_div_2_block_tag_list);
        
        this.tag.append(container_row_div_2, container_row_div_2_block);
        
        
        //第三段的 信息
        Tag container_row_div_3  = this.tag.build("div").attr("class", "col-md-4 col-sm-6 col-xs-12");
        
        //我们输出 相对应的 一定量的 信息 
        List<Article> containers_row_div_3_block_peridocials = new ArrayList<Article>();
        
        List<Tag> container_row_div_3_block_tag_list = new ArrayList<>();
        //相对应的信息
        for(Article peridocial_brief : containers_row_div_3_block_peridocials){
        
            Tag container_row_div_3_block_article = this.leaf
                    .articleMini(peridocial_brief);
            
            //输入 相对应的信息
            container_row_div_3_block_tag_list.add(container_row_div_3_block_article);
        }
        
        Tag container_row_div_3_block = this.leaf.block
        ("Se all", container_row_div_3_block_tag_list);
        
        this.tag.append(container_row_div_3, container_row_div_3_block);
        
        //最后 底部的 标签语句
        
        Tag container_row_tail = this.tag.build("div").attr("class", "row");
        
        Tag container_row_tail_div = this.tag.build("div").attr("class", "col-md-12");
        
        Tag container_row_tail_div_copyright = this.tag.build("div").attr("class", "copyright")
                .text("COPYRIGHT &copy; MAGZ 2017. ALL RIGHT RESERVED.");
        
        Tag container_row_tail_div_copyright_div = this.tag.build("div")
                .text(new StringBuilder().append("Made with")
                        //添加 相对应的 id
                        .append(this.tag.http(this.leaf.icon("ion-heart")))
                        .append(" by king").toString());
        
        
        
        
        
        //最后 进行 相对应的 添加
        this.tag.append(container_row_tail_div_copyright, container_row_tail_div_copyright_div)
                .append(container_row_tail_div, container_row_tail_div_copyright)
                .append(container_row_tail,container_row_tail_div)
                //下面 这里是 最后每一行数据 进行的 添加
                .append(container_row, container_row_div_1)
                .append(container_row, container_row_div_2)
                .append(container_row, container_row_div_3)
                .append(container, container_row)
                //底部数据的添加
                .append(container, container_row_tail);
        

        return container;

    }

}
