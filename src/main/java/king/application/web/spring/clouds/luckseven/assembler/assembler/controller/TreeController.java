/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.controller;

import java.util.ArrayList;
import king.application.web.spring.clouds.luckseven.assembler.assembler.feign.CalculatorFeignClient;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.TagService;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("tree")
public class TreeController {
    
    @Autowired
    private TagService tag;
    
    @Autowired
    private TreeService tree;
    
    @Autowired
    private CalculatorFeignClient calculator;
    
    @RequestMapping("footer")
    public Object footer(){
        return this.tag.http(this.tree.footer());
    }
    
    
    @RequestMapping("list")
    public Object list(){
        ArrayList<String> list = new ArrayList<>();
        list.add("dw");
        
        list.add("dqwd");
        
        return this.calculator.list();
        
    }
    
}
