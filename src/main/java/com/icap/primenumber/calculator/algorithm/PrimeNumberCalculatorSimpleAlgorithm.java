package com.icap.primenumber.calculator.algorithm;

import com.icap.primenumber.calculator.PrimeNumberCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shakshis on 18/04/2016.
 */
public class PrimeNumberCalculatorSimpleAlgorithm implements PrimeNumberCalculator {

    private static final Logger LOG = LoggerFactory.getLogger(PrimeNumberCalculatorSimpleAlgorithm.class);

    @Override
    public List<Integer> calculatePrimeNumbers(Integer endingNumber) {
        LOG.debug("Ending range received : " + endingNumber);
        List<Integer> primeNumberList = new ArrayList();
        for (int startNumber = 2; startNumber <= endingNumber; startNumber++) {
            if (startNumber % 2 == 0 && startNumber != 2)
                continue;
            boolean isStartNumberPrime = true;
            for (int index = 3; index <= startNumber / 2; index += 2) {
                if (startNumber % index == 0)
                    isStartNumberPrime = false;
            }
            if (isStartNumberPrime)
                primeNumberList.add(startNumber);
        }
        LOG.debug("Prime numbers : " + primeNumberList);
        return primeNumberList;
    }
}
