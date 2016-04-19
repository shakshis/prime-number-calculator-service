package com.icap.primenumber.calculator;

import com.icap.primenumber.calculator.exception.PrimeNumberCalculatorException;

import java.util.List;

/**
 * Created by shakshis on 18/04/2016.
 */

@FunctionalInterface
public interface PrimeNumberCalculator {

    static Boolean isPrime(Integer number) {
        if (number <= 2) {
            return true;
        }
        try {
            int index = 2;
            double squareRoot = Math.sqrt(number);
            while (index <= squareRoot) {
                if (number % index == 0) {
                    return false;
                }
                index++;
            }
            return true;
        } catch (Exception e) {
            throw new PrimeNumberCalculatorException(e.getMessage());
        }
    }

    List<Integer> calculatePrimeNumbers(Integer endingNumber);
}
