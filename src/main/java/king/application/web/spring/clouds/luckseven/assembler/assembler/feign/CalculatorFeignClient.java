/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.feign;

import java.util.List;
import king.application.web.spring.clouds.luckseven.assembler.assembler.bean.Peridocial;
import king.application.web.spring.clouds.luckseven.assembler.assembler.bean.PeridocialBrief;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author king
 */
@FeignClient(name = "calculator")
public interface CalculatorFeignClient {
    
    @RequestMapping("/calculator/test/hello")
    public String test_hello();
    
    @RequestMapping("/calculator/show/peridocial")
    public Peridocial showPeridocial(@RequestParam String id);
    
    @RequestMapping("/calculator/show/peridocial")
    public PeridocialBrief showPeridocialBrief(@RequestParam("id") String id);
    
    @RequestMapping("/calculator/search/peridocial/brief")
    public List<PeridocialBrief> searchPeridocialBrief(@RequestParam("string") String string ,@RequestParam("page_index") Integer page_index ,
            @RequestParam("page_size") Integer page_size);
    
    @RequestMapping("calculator/application/most")
    public List<PeridocialBrief> applicationMost();
    
}
