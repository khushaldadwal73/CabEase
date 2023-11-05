package com.example.Cabeasebackend.Controller;

import com.example.Cabeasebackend.Entity.Book_Now;
import com.example.Cabeasebackend.Entity.EnquiryForm;
import com.example.Cabeasebackend.Service.Book_NowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Book_NowController {

    @Autowired
    private Book_NowService bookNowService;

    @GetMapping("/getbooking")
    public String getIndex(Model model ){
        model.addAttribute("booking",new Book_Now());
        return "index";
    }

    @PostMapping("/postbooking")
    public String NewBooking(@ModelAttribute("booking") Book_Now bookNow){

        bookNowService.PostBooking(bookNow);
        return "redirect:/";
    }

}
