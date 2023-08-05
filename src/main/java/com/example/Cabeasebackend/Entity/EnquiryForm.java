package com.example.Cabeasebackend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
 public class EnquiryForm {
    @Id
    @GeneratedValue
    private Long Customer_Id;

    private String name;

    private String Email;

    private int how_many;

    private String Subject;

    private String Message;
}
