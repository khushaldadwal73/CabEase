package com.example.Cabeasebackend.Service;

import com.example.Cabeasebackend.Entity.Book_Now;
import com.example.Cabeasebackend.Repository.Book_NowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class Book_NowService {

    @Autowired

    private Book_NowRepository bookNowRepository;

    public Book_Now PostBooking(Book_Now bookNow){
        return bookNowRepository.save(bookNow);
    }

}
