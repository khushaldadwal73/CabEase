package com.example.Cabeasebackend.Controller;

import com.example.Cabeasebackend.Entity.BookForm;
import com.example.Cabeasebackend.Entity.EnquiryForm;
import com.example.Cabeasebackend.Service.BookFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class BookFormController {

    @Autowired
    private BookFormService bookFormService;


    @GetMapping("/book")
    public String getIndex(Model model ){
        model.addAttribute("book",new EnquiryForm());
        return "index";
    }

    @GetMapping("/book/new")
    public String createEnquiry(Model model){
        BookForm book= new BookForm();
        model.addAttribute("book", book);
        return "new_book";
    }

    @PostMapping("/book")
    public String newBooking(@ModelAttribute("book") EnquiryForm enquiryForm)
    {
        BookFormService.getBooking(enquiryForm);
        return "redirect:/book";
    }
}
