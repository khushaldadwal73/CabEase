package com.example.Cabeasebackend.Repository;

import com.example.Cabeasebackend.Entity.Book_Now;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  Book_NowRepository extends MongoRepository<Book_Now,Long> {
}
