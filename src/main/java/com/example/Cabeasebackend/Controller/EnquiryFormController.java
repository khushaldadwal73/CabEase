package com.example.Cabeasebackend.Controller;

import com.example.Cabeasebackend.Entity.EnquiryForm;
import com.example.Cabeasebackend.Service.EnquiryFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class EnquiryFormController {

    @Autowired
    private EnquiryFormService enquiryFormService;

    @GetMapping("/")
    public String home() {
        return "Backend Running Successfully";
    }

    @PostMapping("/enquiry")
    public ResponseEntity<String> newEnquiry(@RequestBody EnquiryForm enquiryForm) {
        enquiryFormService.postEnquiry(enquiryForm);
        return ResponseEntity.ok("Enquiry submitted successfully");
    }

}
