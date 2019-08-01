/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.service;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
@Service
public class UrlService {
   
    private final String MINITORS_URL_SUPPORT = "http://localhost:8084/minitors/model/";
    
    @Autowired
    private UrlService self;
    
    public String http(String url){
        return new StringBuilder().append(MINITORS_URL_SUPPORT).append(url).toString();
    }
    
    public String http(String url , String name , String value){
        
        return new StringBuilder().append(this.self.http(url))
                .append("?")
                .append(name).append("=").append(value)
                .toString();
    }
    
        
}
