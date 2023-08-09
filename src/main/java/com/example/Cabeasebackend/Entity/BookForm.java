package com.example.Cabeasebackend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BookForm {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String Contact_no;

    private String Email;

    private String Tour_Iternary;

    private int How_many;

    private String Arrivals;

    private String Leaving;

}
