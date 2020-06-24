package com.springboot.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("msg", "이름을 적어서 전송해주세요.");
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView send(@RequestParam("text1") String str, ModelAndView mav){
        mav.addObject("msg", "안녕하세여" + str);
        mav.addObject("value", str);
        mav.setViewName("index");
        return mav;
    }
    /*@RequestMapping("/{num}")
    public String index(@PathVariable int num, Model model) {
        int res = 0;
        for(int i = 0; i <= num; i++){
            res += i;
        }
        model.addAttribute("msg", "total : " + res);
        return "index";
    }*/

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
