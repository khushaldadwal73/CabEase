package com.example.Cabeasebackend.Entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
 public class EnquiryForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Customer_Id;

    private String name;

    private String Email;

    private double phoneNumber;

    private int how_many;

    private String Subject;

    private String Message;
}
