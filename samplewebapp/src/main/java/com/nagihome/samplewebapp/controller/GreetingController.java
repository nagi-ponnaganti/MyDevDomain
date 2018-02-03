package com.nagihome.samplewebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {

        User user = new User();
        user.setName(name);
        user.setFirstName("Nagi");
        user.setLastName("Ponnaganti");
        user.setNationality("Indian");

        Order order = new Order();
        order.setId(45432L);

        model.addAttribute("user", user);
        model.addAttribute("order", order);
        return "greeting";
    }

    class Order {
        private long id;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }

    class User {
        private String name;
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        private String nationality;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}