package com.demo.controller;

import com.demo.model.RoomInfo;
import com.demo.model.UserInfo;
import com.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class RoomController {

    @Autowired
    private RoomService service;

    @GetMapping(value = "/room/list")
    public ModelAndView listUser() {
        List<RoomInfo> roomInfos = service.list();
        ModelAndView mav = new ModelAndView("listroom");
        mav.addObject("data", roomInfos);
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value ="/room/add")
    public String RegisterForm(Map<String, Object> model) {
        RoomInfo roomInfo = new RoomInfo();
        model.put("room", roomInfo);
        return "addroom";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/room/add")
    public String Register(@ModelAttribute("room") RoomInfo roomInfo) {
        service.add(roomInfo);
        return "redirect:/room/list";
    }

    @GetMapping(value ="/room/search")
    public ModelAndView search(@RequestParam(required = false) String name, @RequestParam(required = false) String desc,
                               @RequestParam(required = false) int capacity, @RequestParam(required = false) int has_projector,
                               @RequestParam(required = false) int has_laptop) {
        RoomInfo room = new RoomInfo();
        List<RoomInfo> result = service.search(room);
        ModelAndView mav = new ModelAndView("searchroom");
        mav.addObject("data", result);
        return mav;
    }

    @GetMapping(value = "/room/edit")
    public ModelAndView editPokemonForm(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("editroom");
        RoomInfo roomInfo = service.get(id);
        mav.addObject("room", roomInfo);
        return mav;
    }
}
