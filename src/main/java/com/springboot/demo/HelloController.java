package com.springboot.demo;

import com.springboot.demo.repositories.MyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @Autowired
    MyDataRepository repository;

    public void init() {
        MyData d1 = new MyData();
        d1.setName("YU");
        d1.setAge(28);
        d1.setMail("wlxosmsla");
        d1.setMemo("This is my data!!");
        repository.saveAndFlush(d1);
        MyData d2 = new MyData();
        d2.setName("JI");
        d2.setAge(28);
        d2.setMail("wlxosmsla");
        d2.setMemo("This is my data!!");
        repository.saveAndFlush(d2);
    }

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

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute MyData myData, @PathVariable int id, ModelAndView mav){
        mav.setViewName("edit");
        mav.addObject("title", "edit mydata.");
        MyData data = repository.findById((long)id);
        mav.addObject("formModel2", data);

        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView update(@ModelAttribute MyData myData, ModelAndView mav) {
        repository.saveAndFlush(myData);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, ModelAndView mav) {
        mav.setViewName("delete");
        mav.addObject("title", "delete mydata");
        MyData data = repository.findById((long) id);
        mav.addObject("formModel", data);

        return mav;
    }
 
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView remove(@RequestParam long id, ModelAndView mav){
        repository.deleteById(id);
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
