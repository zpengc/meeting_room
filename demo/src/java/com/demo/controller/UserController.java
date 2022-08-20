package com.demo.controller;

import com.demo.model.RoomInfo;
import com.demo.model.RoomReservation;
import com.demo.model.UserInfo;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    // 查询用户
    @RequestMapping(method = RequestMethod.GET, value = "/userInfo/list")
    public ModelAndView listUser() {
        List<UserInfo> userInfos = userService.list();
        ModelAndView mav = new ModelAndView("listuser");
        mav.addObject("data", userInfos);
        return mav;
    }

    // 添加用户
    @RequestMapping(method = RequestMethod.GET, value ="/userInfo/add")
    public String RegisterForm(Map<String, Object> model) {
        UserInfo userInfo = new UserInfo();
        model.put("user", userInfo);
        return "adduser";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/userInfo/add")
    public String Register(@ModelAttribute("user") UserInfo userInfo) {
        userService.save(userInfo);
        return "redirect:/userInfo/list";
    }

    @RequestMapping(method = RequestMethod.GET, value ="/userInfo/search")
    public ModelAndView search(@RequestParam String username) {
        List<UserInfo> result = userService.search(username);
        ModelAndView mav = new ModelAndView("searchuser");
        mav.addObject("data", result);
        return mav;
    }

    @GetMapping(value = "/userInfo/edit")
    public ModelAndView editPokemonForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edituser");
        UserInfo userInfo = userService.get(id);
        mav.addObject("user", userInfo);
        return mav;
    }

}
