package com.example.Cabeasebackend.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
 public class EnquiryForm {
    @Id
    private Long Customer_Id;

    private String name;

    private String Email;

    private int how_many;

    private String Subject;

    private String Message;
}
