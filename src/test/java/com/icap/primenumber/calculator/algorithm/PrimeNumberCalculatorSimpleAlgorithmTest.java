package com.icap.primenumber.calculator.algorithm;

import com.icap.primenumber.calculator.PrimeNumberCalculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

/**
 * Created by shakshis on 19/04/2016.
 */
@RunWith(Parameterized.class)
public class PrimeNumberCalculatorSimpleAlgorithmTest {

    @Parameter(0)
    public Integer numberRange;
    @Parameter(1)
    public List<Integer> expectedPrimeNumberList;
    PrimeNumberCalculator primeNumberCalculator;

    @Parameters
    public static Collection primeNumberList() {
        return Arrays.asList(new Object[][]{
                {7, Arrays.asList(2, 3, 5, 7)},
                {23, Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23)},
                {42, Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41)},
                {60, Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59)},
                {100, Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)}

        });
    }

    @Before
    public void setup() {
        primeNumberCalculator = new PrimeNumberCalculatorSimpleAlgorithm();
    }

    @Test
    public void testCalculatePrimeNumbers() throws Exception {
        assertArrayEquals(expectedPrimeNumberList.toArray(), primeNumberCalculator.calculatePrimeNumbers(numberRange).toArray());
    }
}