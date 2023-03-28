package com.example.demo.model.repository;

import com.example.demo.model.Currency;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends MongoRepository<Currency, Long> {

}
