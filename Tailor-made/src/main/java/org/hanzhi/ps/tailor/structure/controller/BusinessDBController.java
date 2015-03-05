package org.hanzhi.ps.tailor.structure.controller;

import org.hanzhi.ps.tailor.structure.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class BusinessDBController {

    @Resource(name = "userService")
    private UserService service;

    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public ModelAndView hello2() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "HelloMVC");
        mv.setViewName("user/users");
        return mv;
    }


    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ModelAndView count() {

        int c = service.userCount();

        ModelAndView mv = new ModelAndView();
        mv.addObject("message", c);
        mv.setViewName("user/users");
        return mv;
    }
}


