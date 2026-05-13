package com.example.Cabeasebackend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class PageController {

        @GetMapping("/")
        public String index() {
            return "enquiry";
        }

        @GetMapping("/review")
        public String review() {
            return "review";
        }
    }


