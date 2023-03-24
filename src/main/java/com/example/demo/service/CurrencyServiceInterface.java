package com.example.demo.service;


import com.example.demo.model.Currency;
import java.util.List;
import java.util.Optional;

public interface CurrencyServiceInterface {

    Currency saveCurrency(Currency currency);

    List<Currency> getAll();

    Optional<Currency> getById(Long id);

    boolean deleteBySymbol(String symbol);
}
