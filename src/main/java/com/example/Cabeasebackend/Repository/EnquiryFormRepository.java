package com.example.Cabeasebackend.Repository;

import com.example.Cabeasebackend.Entity.EnquiryForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EnquiryFormRepository extends JpaRepository<EnquiryForm,Long> {
}
