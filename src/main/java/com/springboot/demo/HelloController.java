package com.springboot.demo;

import com.springboot.demo.repositories.MyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @Autowired
    MyDataRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(@ModelAttribute("formModel") MyData myData, ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("msg", "this is sample content.");
        Iterable<MyData> list = repository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView form(@ModelAttribute("formModel") MyData myData, ModelAndView mav) {
        repository.saveAndFlush(myData);
        return new ModelAndView("redirect:/");
    }

    /*@RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView send(@RequestParam("text1") String str, ModelAndView mav){
        mav.addObject("msg", "안녕하세여" + str);
        mav.addObject("value", str);
        mav.setViewName("index");
        return mav;
    }*/
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
