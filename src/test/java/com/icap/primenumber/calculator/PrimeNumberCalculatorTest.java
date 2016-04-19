package com.icap.primenumber.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

/**
 * Created by shakshis on 19/04/2016.
 */
@RunWith(Parameterized.class)
public class PrimeNumberCalculatorTest {


    @Parameter(0)
    public Integer number;

    @Parameter(1)
    public Boolean isPrime;

    @Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {11, true},
                {18, false},
                {7, true},
                {44, false},
                {19, true}
        });
    }

    @Test
    public void testIsPrime() throws Exception {
        assertEquals(isPrime, PrimeNumberCalculator.isPrime(number));
    }
}