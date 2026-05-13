package com.example.Cabeasebackend.Service;

import com.example.Cabeasebackend.Entity.EnquiryForm;
import com.example.Cabeasebackend.Repository.EnquiryFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnquiryFormService {

    @Autowired
    private EnquiryFormRepository enquiryFormRepository;

    public EnquiryForm postEnquiry(EnquiryForm enquiryForm) {

        // Get last enquiry from database
        EnquiryForm lastEnquiry = enquiryFormRepository.findTopByOrderByIdDesc();

        int nextNumber = 1;

        if (lastEnquiry != null && lastEnquiry.getId() != null) {

            // Example: EQ-001
            String lastId = lastEnquiry.getId();

            // Extract number part
            String numberPart = lastId.substring(3);

            nextNumber = Integer.parseInt(numberPart) + 1;
        }

        // Generate new ID
        String newId = String.format("EQ-%03d", nextNumber);

        enquiryForm.setId(newId);

        return enquiryFormRepository.save(enquiryForm);
    }

    public List<EnquiryForm> getAllEnquiries() {
        return enquiryFormRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
