package com.example.Cabeasebackend.Controller;

import com.example.Cabeasebackend.Entity.EnquiryForm;
import com.example.Cabeasebackend.Service.EnquiryFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Timer;
import java.util.TimerTask;


@Controller
public class EnquiryFormController {

    @Autowired
    private EnquiryFormService enquiryFormService;

//    private Timer timer = new Timer();

    @GetMapping("")
    public String getIndex(Model model ){
        model.addAttribute("enquiry",new EnquiryForm());

        return "index";
    }

    @PostMapping("/enquiry")
    public String newEnquiry(@ModelAttribute("enquiry") EnquiryForm enquiryForm)
    {
        enquiryFormService.postEnquiry(enquiryForm);
//        session.setAttribute("message", "The enquiry has sent!");
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                session.removeAttribute("message");
//            }
//        }, 5000);
        return "redirect:/";
    }

}
