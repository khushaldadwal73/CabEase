package com.example.Cabeasebackend.Controller.Admin;

import com.example.Cabeasebackend.Entity.Book_Now;
import com.example.Cabeasebackend.Entity.EnquiryForm;
import com.example.Cabeasebackend.Service.Book_NowService;
import com.example.Cabeasebackend.Service.EnquiryFormService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin")
public class AdminListingController {

    private final Book_NowService bookNowService;
    private final EnquiryFormService enquiryFormService;

    public AdminListingController(Book_NowService bookNowService,
                                  EnquiryFormService enquiryFormService) {
        this.bookNowService = bookNowService;
        this.enquiryFormService = enquiryFormService;
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<Book_Now>> getBookings() {
        return ResponseEntity.ok(bookNowService.getAllBookings());
    }

    @GetMapping("/enquiries")
    public ResponseEntity<List<EnquiryForm>> getEnquiries() {
        return ResponseEntity.ok(enquiryFormService.getAllEnquiries());
    }
}
