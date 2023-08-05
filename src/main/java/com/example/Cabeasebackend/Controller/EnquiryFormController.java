package com.example.Cabeasebackend.Controller;

import com.example.Cabeasebackend.Entity.EnquiryForm;
import com.example.Cabeasebackend.Service.EnquiryFormService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnquiryFormController {

    private EnquiryFormService enquiryFormService;

//    @RequestMapping(value = "/enquiry",method = RequestMethod.POST)
//    @PostMapping("/enquiry")
//    String newEnquiry(@ModelAttribute("user") @RequestBody EnquiryForm enquiryForm)
//    {
//         enquiryFormService.postEnquiry(enquiryForm);
//         return "index";
//    }

    @GetMapping("/enquiry")
    public String getIndex(Model model ){
        model.addAttribute("enquiry",enquiryFormService.getEnquiry());
        return "index";
    }

}
