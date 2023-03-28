package com.example.demo.service;

import com.example.demo.model.Currency;
import com.example.demo.model.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService implements CurrencyServiceInterface
{
    @Autowired
    private CurrencyRepository currencyRepository;
    @Override
    public Currency saveCurrency(Currency currency) {
        currencyRepository.save(currency);

        return currency;
    }

    @Override
    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }


    @Override
    public Optional<Currency> getById(Long id) {
        return currencyRepository.findById(id);
    }

    // Simple version without search criteria
    // Not the best practice
    @Override
    public boolean deleteBySymbol(String symbol) {
        List<Currency> currencies = this.getAll();

        for (Currency currency: currencies){
            if (currency.getSymbol().equals(symbol)){
                currencyRepository.delete(currency);
            }
        }

        return true;
    }
}
