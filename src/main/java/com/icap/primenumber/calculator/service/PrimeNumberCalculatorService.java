package com.icap.primenumber.calculator.service;

import com.icap.primenumber.calculator.PrimeNumberCalculator;
import com.icap.primenumber.calculator.exception.PrimeNumberCalculatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shakshis on 18/04/2016.
 */
@Service
public class PrimeNumberCalculatorService {

    @Autowired
    PrimeNumberCalculator primeNumberCalculator;

    public List<Integer> calculatePrimeNumber(Integer number) {
        if (number < 1) throw new PrimeNumberCalculatorException("Prime number end range should be greater than 2");
        return primeNumberCalculator.calculatePrimeNumbers(number);
    }
}
