/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.configuration;

import king.application.web.spring.clouds.luckseven.assembler.assembler.service.LeafService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author king
 */
@Configuration
public class SectionConfiguration {
    
    @Autowired
    private LeafService leaf;
    
}
