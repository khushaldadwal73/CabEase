package com.example.Cabeasebackend.Entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Document(collection = "book_now")
@Data
public class Book_Now {

    @Id
    private String id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50,
            message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Phone number is required")
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must be exactly 10 digits"
    )
    private String phone;

    @NotBlank(message = "Pickup location is required")
    @Size(min = 2, max = 100,
            message = "Pickup location is invalid")
    private String from;

    @NotBlank(message = "Destination is required")
    @Size(min = 2, max = 100,
            message = "Destination is invalid")
    private String to;

    @NotBlank(message = "Date is required")
    private String date;

    @NotBlank(message = "Vehicle selection is required")
    private String vehicle;

    @Size(max = 500,
            message = "Note cannot exceed 500 characters")
    private String note;
}