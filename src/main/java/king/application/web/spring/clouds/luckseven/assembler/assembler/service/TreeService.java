/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author king
 */

/**
 * 倘若 需要 一次性的 全部输出 相对应的 信息
 * 目前 可能 暂时的 不需要
 * @author king
 */
@Service
public class TreeService {
    
    @Autowired
    private FeignService feign ;
    
    @Autowired
    private LeafService leaf;
    
    
    
}
