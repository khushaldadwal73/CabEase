package com.example.Cabeasebackend.Controller;

import com.example.Cabeasebackend.Entity.Book_Now;
import com.example.Cabeasebackend.Entity.EnquiryForm;
import com.example.Cabeasebackend.Service.Book_NowService;
import com.example.Cabeasebackend.Service.EmailService;
import com.example.Cabeasebackend.Service.EnquiryFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Timer;
import java.util.TimerTask;


@Controller
public class EnquiryFormController {

    @Autowired
    private EnquiryFormService enquiryFormService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/enquiry")
    public String getIndex(Model model){
        model.addAttribute("enquiry",new EnquiryForm());
        return "enquiry";
    }

    @PostMapping("/enquiry")
    public String newEnquiry(@ModelAttribute("enquiry") EnquiryForm enquiryForm)
    {
        enquiryFormService.postEnquiry(enquiryForm);

        try {
            Context context = new Context();
            context.setVariable("enquiry", enquiryForm);

            emailService.sendEmail("akhil.sharma0612@gmail.com", "New Enquiry " + LocalDate.now(), "email-template", context);
        } catch (MessagingException e) {
            e.printStackTrace(); // Handle exception appropriately
        }
        return "redirect:/enquiry";
    }

}
