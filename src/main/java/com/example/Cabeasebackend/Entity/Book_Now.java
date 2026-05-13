package com.example.Cabeasebackend.Entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Document(collection = "book_now")
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
