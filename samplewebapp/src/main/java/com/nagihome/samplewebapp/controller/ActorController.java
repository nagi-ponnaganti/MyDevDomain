package com.nagihome.samplewebapp.controller;

import com.nagihome.samplewebapp.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActorController {

    @Autowired
    private IActorService actorService;

    @RequestMapping("/allactors")
    private String getAllActors(Model model) {
        model.addAttribute("actors", actorService.getAllActors());
        return "actorspage";
    }
}
