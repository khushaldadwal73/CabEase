package com.example.Cabeasebackend.Controller;

import com.example.Cabeasebackend.Entity.Book_Now;
import com.example.Cabeasebackend.Service.Book_NowService;
import com.example.Cabeasebackend.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.time.LocalDate;

@Controller
public class Book_NowController {

    @Autowired
    private Book_NowService bookNowService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/book")
    public String getIndex1(Model model){
        model.addAttribute("booking",new Book_Now());
        return "booking";
    }

    @PostMapping("/book")
    public String booking(@ModelAttribute("booking") Book_Now bookNow){

        bookNowService.PostBooking(bookNow);

        try {
            Context context = new Context();
            context.setVariable("booking", bookNow);

            emailService.sendEmail("akhil.sharma0612@gmail.com", "New Booking" + LocalDate.now(),"email-template", context);
        } catch (MessagingException e) {
            e.printStackTrace(); // Handle exception appropriately
        }

        return "redirect:/book";
    }

}
