package com.example.Cabeasebackend.Service;

import com.example.Cabeasebackend.Entity.EnquiryForm;
import com.example.Cabeasebackend.Repository.EnquiryFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnquiryFormService {

    @Autowired
    private EnquiryFormRepository enquiryFormRepository;

    public EnquiryForm postEnquiry(EnquiryForm enquiryForm)
    {
      return enquiryFormRepository.save(enquiryForm);
    }

    public List<EnquiryForm> getEnquiry()
    {
        return enquiryFormRepository.findAll();
    }

}
