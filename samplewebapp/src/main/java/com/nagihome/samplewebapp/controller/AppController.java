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

    @RequestMapping("/allcity")
    private String getAllCities(Model model) {
        model.addAttribute("cities", appService.getAllCities());
        return "citiespage";
    }

    @RequestMapping("/allcountry")
    private String getAllCountries(Model model) {
        model.addAttribute("countries", appService.getAllCountries());
        return "countriespage";
    }

    @RequestMapping("/allcustomer")
    private String getAllCustomers(Model model) {
        model.addAttribute("customers", appService.getAllCustomers());
        return "customerspage";
    }

    @RequestMapping("/allfilm")
    private String getAllFilms(Model model) {
        model.addAttribute("films", appService.getAllFilms());
        return "filmspage";
    }

    @RequestMapping("/allfilmactor")
    private String getAllFilmActors(Model model) {
        model.addAttribute("filmactors", appService.getAllFilmActors());
        return "filmsactorspage";
    }

    @RequestMapping("/allfilmcategory")
    private String getAllFilmCategories(Model model) {
        model.addAttribute("filmcategories", appService.getAllFilmCategories());
        return "filmcategoriespage";
    }

    @RequestMapping("/allfilmtext")
    private String getAllFilmTexts(Model model) {
        model.addAttribute("filmtexts", appService.getAllFilmTexts());
        return "filmtextspage";
    }

    @RequestMapping("/allinventory")
    private String getAllInventories(Model model) {
        model.addAttribute("inventories", appService.getAllInventories());
        return "inventoriespage";
    }

}
