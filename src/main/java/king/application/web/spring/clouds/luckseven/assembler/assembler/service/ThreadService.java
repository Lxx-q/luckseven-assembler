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
public class ThreadService {
    
    public Thread thread(Runnable runnable){
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }
    
}
