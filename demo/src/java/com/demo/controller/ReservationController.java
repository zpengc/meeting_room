package com.demo.controller;

import com.demo.model.RoomInfo;
import com.demo.model.RoomReservation;
import com.demo.model.RoomSearchRequest;
import com.demo.model.UserInfo;
import com.demo.repo.RoomReservationRepository;
import com.demo.service.ReservationService;
import com.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class ReservationController {


    @Autowired
    private ReservationService service;

    @GetMapping(value = "/reservation/list")
    public ModelAndView listUser() {
        List<RoomReservation> reservations = service.list();
        ModelAndView mav = new ModelAndView("listreservation");
        mav.addObject("data", reservations);
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value ="/reservation/add")
    public String RegisterForm(Map<String, Object> model) {
        RoomReservation reservation = new RoomReservation();
        model.put("reservation", reservation);
        return "addreservation";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/reservation/add")
    public String Register(@ModelAttribute("reservation") RoomReservation reservation) {
        service.save(reservation);
        return "redirect:/reservation/list";
    }

    @GetMapping(value = "/reservation/search")
    public ModelAndView search(@RequestParam String username) {
        List<RoomReservation> reservations = service.search(username);
        ModelAndView mav = new ModelAndView("searchreservation");
        mav.addObject("data", reservations);
        return mav;
    }

    @GetMapping(value = "/reservation/edit")
    public ModelAndView search(@RequestParam int id) {
        RoomReservation reservation = service.get(id);
        ModelAndView mav = new ModelAndView("editreservation");
        mav.addObject("reservation", reservation);
        return mav;
    }
}
