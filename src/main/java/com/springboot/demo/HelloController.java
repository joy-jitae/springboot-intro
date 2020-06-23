package com.springboot.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

   /* @RequestMapping("/{num}")
    public String index(@PathVariable int num) {
        int res = 0;
        for(int i = 1; i<= num; i++){
            res += i;
        }
        return "total:" + res;
//        return "Hello Spring-Boot World!";
    }*/

}
