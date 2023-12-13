package com.example.demo.Web.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage (@RequestParam(name="name" , required = false, defaultValue = "Test ")String name, Model model) {

        model.addAttribute("name", name);


        return "Home";
    }




}
