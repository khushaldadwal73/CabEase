package com.example.Cabeasebackend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

    @Controller
    public class PageController {

        @GetMapping("/index")
        public String index() {
            return "index";
        }

        @GetMapping("/review")
        public String review() {
            return "review";
        }
    }


