package com.example.Cabeasebackend.Controller;

import com.example.Cabeasebackend.Entity.EnquiryForm;
import com.example.Cabeasebackend.Service.EnquiryFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Timer;
import java.util.TimerTask;


@Controller
public class EnquiryFormController {

    @Autowired
    private EnquiryFormService enquiryFormService;

    private Timer timer = new Timer();



    @GetMapping("")
    public String getIndex(Model model ){
        model.addAttribute("enquiry",new EnquiryForm());
        return "index";
    }

    @GetMapping("/enquiry/new")
    public String createEnquiry(Model model){
        EnquiryForm enquiry= new EnquiryForm();
        model.addAttribute("enquiry", enquiry);
        return "index";
    }


    @PostMapping("/enquiry")
    public String newEnquiry(@ModelAttribute("enquiry") EnquiryForm enquiryForm, HttpSession session)
    {
        enquiryFormService.postEnquiry(enquiryForm);
        session.setAttribute("message", "The enquiry has sent!");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                session.removeAttribute("message");
            }
        }, 5000);
        return "redirect:/";
    }

}
