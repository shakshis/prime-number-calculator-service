package com.icap.primenumber.calculator.service;

import com.icap.primenumber.calculator.PrimeNumberCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.when;

/**
 * Created by shakshis on 19/04/2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class PrimeNumberCalculatorServiceTest {

    final Integer PRIME_NUMBER_END_RANGE = 23;
    final List<Integer> PRIME_NUMBER_LIST = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);

    @Mock
    private PrimeNumberCalculator primeNumberCalculator;

    @InjectMocks
    private PrimeNumberCalculatorService primeNumberCalculatorService;

    @Test
    public void testCalculatePrimeNumber() throws Exception {
        when(primeNumberCalculator.calculatePrimeNumbers(PRIME_NUMBER_END_RANGE)).thenReturn(PRIME_NUMBER_LIST);
        List<Integer> actualPrimeNumbers = primeNumberCalculatorService.calculatePrimeNumber(PRIME_NUMBER_END_RANGE);
        assertArrayEquals(actualPrimeNumbers.toArray(), PRIME_NUMBER_LIST.toArray());
    }
}