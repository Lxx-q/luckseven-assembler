/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.service;

import java.util.ArrayList;
import java.util.List;
import king.application.web.spring.clouds.luckseven.assembler.assembler.tag.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author king
 */
@Service
public class SectionService {
    
    @Autowired
    private LeafService leaf;
    
    public List<Tag> register(){
        ArrayList<Tag> list_tag = new ArrayList<>();
        return list_tag;
    }
    
    public List<Tag> login(){
        ArrayList<Tag> list_tag = new ArrayList<>();
        return list_tag;
    }
}
