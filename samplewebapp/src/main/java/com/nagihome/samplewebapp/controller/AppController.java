package com.nagihome.samplewebapp.controller;

import com.nagihome.samplewebapp.service.IAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @Autowired
    private IAppService appService;

    @RequestMapping("/allactors")
    private String getAllActors(Model model) {
        model.addAttribute("actors", appService.getAllActors());
        return "actorspage";
    }

    @RequestMapping("/alladdress")
    private String getAllAddresses(Model model) {
        model.addAttribute("addresses", appService.getAllAddresses());
        return "addressespage";
    }

    @RequestMapping("/allcategory")
    private String getAllCategories(Model model) {
        model.addAttribute("categories", appService.getAllCategories());
        return "categoriespage";
    }

}
