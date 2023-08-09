package com.example.Cabeasebackend.Service;

import com.example.Cabeasebackend.Entity.EnquiryForm;
import com.example.Cabeasebackend.Repository.EnquiryFormRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookFormService {

    @Autowired
    public static EnquiryFormRepository enquiryFormRepository;

    public static EnquiryForm getBooking(EnquiryForm enquiryForm){
       return enquiryFormRepository.save(enquiryForm);
    }
}
