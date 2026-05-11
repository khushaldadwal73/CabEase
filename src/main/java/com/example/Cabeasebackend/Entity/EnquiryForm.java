package com.example.Cabeasebackend.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Document(collection = "enquiry")
@Data
public class EnquiryForm {

    @Id
    private String id;

    @NotBlank(message = "Name is required")
    @Size(
            min = 2,
            max = 50,
            message = "Name must be between 2 and 50 characters"
    )
    private String name;

    @NotBlank(message = "Phone number is required")
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must be exactly 10 digits"
    )
    private String phone;

    @NotBlank(message = "Enquiry message is required")
    @Size(
            min = 5,
            max = 500,
            message = "Enquiry must be between 5 and 500 characters"
    )
    private String enquiry;
}