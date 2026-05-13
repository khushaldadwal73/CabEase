package com.example.Cabeasebackend.Controller;

import com.example.Cabeasebackend.Entity.Book_Now;
import com.example.Cabeasebackend.Entity.EnquiryForm;
import com.example.Cabeasebackend.Service.Book_NowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class Book_NowController {

    @Autowired
    private Book_NowService bookNowService;

    @GetMapping("/book")
    public String getIndex1(Model model){
        model.addAttribute("booking",new Book_Now());
        return "booking";
    }

    @PostMapping("/book")
    public ResponseEntity<String> booking(@RequestBody Book_Now bookNow){
        bookNowService.PostBooking(bookNow);
        return ResponseEntity.ok("Booking Created successfully");
    }

}
