package com.sakilaweb.controller;

import com.sakilaweb.service.AppService;
import com.sakilaweb.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static com.sakilaweb.util.Constants.ACTORS_PAGE;
import static com.sakilaweb.util.Constants.APP_NAME;

@Controller
@RequestMapping(APP_NAME)
public class AppController {

    @Autowired
    private AppService appService;

    @RequestMapping(Constants.HOME_URL)
    public String home() {
        return Constants.INDEX_PAGE;
    }

    @RequestMapping(Constants.ACTORS_LIST_URL)
    public ModelAndView actorList() {
        ModelAndView modelAndView = new ModelAndView(ACTORS_PAGE);
        modelAndView.addObject("actorList", appService.getAllActors());
        return modelAndView;
    }
}
