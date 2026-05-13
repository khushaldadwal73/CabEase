package com.example.Cabeasebackend.Service;

import com.example.Cabeasebackend.Entity.Book_Now;
import com.example.Cabeasebackend.Repository.Book_NowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Book_NowService {

    @Autowired
    private Book_NowRepository bookNowRepository;

    public Book_Now PostBooking(Book_Now bookNow) {

        // Get last booking
        Book_Now lastBooking =
                bookNowRepository.findTopByOrderByIdDesc();

        int nextNumber = 1;

        if (lastBooking != null && lastBooking.getId() != null) {

            // Example: BK-001
            String lastId = lastBooking.getId();

            // Extract numeric part
            String numberPart = lastId.substring(3);

            nextNumber = Integer.parseInt(numberPart) + 1;
        }

        // Generate new booking ID
        String newId = String.format("BK-%03d", nextNumber);

        bookNow.setId(newId);

        return bookNowRepository.save(bookNow);
    }

    public List<Book_Now> getAllBookings() {
        return bookNowRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
