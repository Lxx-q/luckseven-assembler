/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.service.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.common.function.TransferFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */

// 创建 相对应的 Bean 类 工具 ， 主要是为了 解决 一些 重复性的 问题
@Service
public class BeanService {
    
    //self
    @Autowired
    private BeanService self;
    
    //获取 相对应的 id
    public <T,M> M transfer(T target , TransferFunction<T,M> function){
        return function.transfer(target);
    }
    
    //编写 相对应的 list
    public <T,M> List<M> transfer( List<T> list_target , TransferFunction<T,M> function){
        
        List<M> list_m = new ArrayList<>();
        
        for(T target : list_target){
            
            //相对应的 输出 相对应的 值
            M model = this.self.transfer(target, function);
            
            list_m.add(model);
        }
        
        return list_m;
        
    }
    
    public <T,M> List<Map<String,Object>> toMap(List<T> list_target , TransferFunction<T,M> function){
        
        List<Map<String,Object>> result = new ArrayList<>();
        
        for(T target : list_target){
            
            //相对应的 输出 相对应的 信息
            
            M id = this.self.transfer(target, function);
            
            Map<String,Object> map = new HashMap<>();
            
            //输出 相对应的 信息
            map.put("id", id);
            map.put("context", target);
            
            result.add(map);
        }
        
        return result;
        
    }
    
}
