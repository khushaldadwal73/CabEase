package com.example.Cabeasebackend.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="book_now")
@Data
public class Book_Now {
    private String name;

    private String Contact_no;

    private String Email;

    private String tour_iternary;

    private int How_many;

    private String Arrivals;

    private String Leaving;

}
