package com.example.demo.Web.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {

    @GetMapping("/AboutUs")
        public String getAboutUsPage () {
        
            return "AboutUS";
        }
}
