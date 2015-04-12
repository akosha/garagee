package com.psimic.controllers;

import com.google.common.collect.Lists;
import com.psimic.model.GarageDTO;
import com.psimic.model.UserDTO;
import com.psimic.model.UserType;
import com.psimic.service.SettingService;
import com.psimic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by psimic on 31.03.15.
 */
@Controller
@RequestMapping("/")
public class SettingsController {

    @Autowired private SettingService settingService;
    @Autowired private UserService userService;

    @RequestMapping(value = "/garage", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView garage() {
        return new ModelAndView("garage", "command", new GarageDTO(0l, 0l));
    }

    @RequestMapping(value = "/userPage", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView userPage() {
        List<UserType> types = Lists.newArrayList();
        for (UserType userType : UserType.values()) {
            types.add(userType);
        }
        return new ModelAndView("userPage", "command", new UserDTO(" ", " "));
    }

    @RequestMapping(value = "/addCustomer", method = {RequestMethod.POST, RequestMethod.HEAD})
    public ModelAndView addCustomer(@ModelAttribute("SpringWeb")UserDTO userDTO,  ModelMap model) {
        model.addAttribute("plates", userDTO.getPlates()!=null?userDTO.getPlates():"");
        model.addAttribute("type", userDTO.getType()!=null?userDTO.getType():"");
        userService.insertUser(userDTO);
        return new ModelAndView("userPage", "command", new UserDTO(" ", " "));
    }

    @RequestMapping(value = "/removeCustomer", method = {RequestMethod.POST, RequestMethod.HEAD})
    public ModelAndView removeCustomer(@ModelAttribute("SpringWeb")UserDTO userDTO,  ModelMap model) {
        model.addAttribute("plates", userDTO.getPlates());
        userService.removeUser(userDTO.getPlates());
        return new ModelAndView("userPage", "command", new UserDTO(" ", " "));
    }

    @RequestMapping(value = "/addCapacity", method = {RequestMethod.POST, RequestMethod.HEAD})
    public String setCapacity(@ModelAttribute("SpringWeb")GarageDTO garageDTO,
                              ModelMap model) {
        model.addAttribute("flors", garageDTO.getFlors()!=null?garageDTO.getFlors():0l);
        model.addAttribute("parkingSlotsPerFlor", garageDTO.getParkingSlotsPerFlor()!=null?garageDTO.getParkingSlotsPerFlor():0l);
        settingService.setCapacity(garageDTO);
        return "homePage";
    }

}
