/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.service;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import king.application.web.spring.clouds.luckseven.assembler.assembler.feign.CalculatorFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author king
 */
@Service
public class FeignService {
    
    @Autowired
    private RestTemplate template;
    
    @Autowired
    private CalculatorFeignClient calculator;
    
    public <T> T template(String url ,HttpServletRequest request , Class<T> targetClass){
        return this.template.postForObject(url,request.getParameterMap(), targetClass);
    }
    
}
