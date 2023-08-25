package com.example.Cabeasebackend.Repository;

import com.example.Cabeasebackend.Entity.EnquiryForm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EnquiryFormRepository extends MongoRepository<EnquiryForm,Long> {
}
