/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.assembler.assembler.configuration;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import king.application.web.spring.clouds.luckseven.assembler.assembler.bean.PeridocialBrief;
import king.application.web.spring.clouds.luckseven.assembler.assembler.feign.CalculatorFeignClient;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.ApplicationService;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.LeafService;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.MostService;
import king.application.web.spring.clouds.luckseven.assembler.assembler.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author king
 */
@Configuration
public class ThreadConfiguration {

    @Autowired
    private TagService tag;

    @Autowired
    private LeafService leaf;

    //我们 在 这里 来获取 相对应的 信息 
    @Autowired
    public void most_set(CalculatorFeignClient calculator, ApplicationService application, MostService most) {
        //List<PeridocialBrief> list_most  = calculator.applicationMost();

        /**
         * 现在 ， 我们 先开始 测试
         *
         * 是否程序 后台 会 每隔 一秒 打印 相对应 start
         */
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                //进行输出 相对应的 信息
                int index = 0;

                while (true) {

                    //相对应的 信息
                    //System.out.println("this is a heart jump is :\t" + (++index));
                    //获取相对应的 信息
                    try {
                        List<PeridocialBrief> list_most = calculator.applicationMost();
                        application.setMost(list_most);

                        most.configuration(list_most);

                    } catch (Exception ex) {
                        Logger.getLogger(ThreadConfiguration.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ThreadConfiguration.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        
        thread.setDaemon(true);
        thread.start();
    }

}
