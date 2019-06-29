/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
@Service
public class UrlService {
   
    private final String MINITORS_URL_SUPPORT = "http://localhost:8084/minitors/model/";
    
    public String url(String url){
        return new StringBuilder().append(MINITORS_URL_SUPPORT).append(url).toString();
    }
    
}
