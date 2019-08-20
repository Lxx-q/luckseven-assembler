/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.service;

import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
@Service
public class TimeService {
    
    public String getDateString(Date date){
        //输出 相对应的 信息
        return date.toString();
    }
    
}
