package com.icap.primenumber.calculator.algorithm;

import com.icap.primenumber.calculator.PrimeNumberCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by shakshis on 18/04/2016.
 */

/**
 * Algorithm
 *
 * Input: an integer n > 1

 Let A be an array of Boolean values, indexed by integers 2 to n,
 initially all set to true.

 for i = 2, 3, 4, ..., not exceeding √n:
 if A[i] is true:
 for j = i2, i2+i, i2+2i, i2+3i, ..., not exceeding n :
 A[j] := false

 Output: all i such that A[i] is true.
 *
 *
 */
public class PrimeNumberCalculatorAtkinAlgorithm implements PrimeNumberCalculator {

    private static final Logger LOG = LoggerFactory.getLogger(PrimeNumberCalculatorAtkinAlgorithm.class);

    @Override
    public List<Integer> calculatePrimeNumbers(Integer endingNumber) {
        LOG.debug("Ending range received : " + endingNumber);
        List<Integer> primeNumberList = new ArrayList();

        int[] primeNumberIndexList = new int[endingNumber+1];
        IntStream.rangeClosed(2,endingNumber).forEach(index -> primeNumberIndexList[index] = 1);

        for (int index = 2; index <= Math.sqrt(endingNumber); index++) {
            if (primeNumberIndexList[index] == 1) {
                for (int indexZ = index * index, indexY = 1; indexZ <= endingNumber; indexZ = (index * index) + (index * indexY) , indexY++) {
                    primeNumberIndexList[indexZ] =0;
                }
            }
        }
        primeNumberList = IntStream.rangeClosed(2,endingNumber).filter(index -> primeNumberIndexList[index] ==1).boxed().collect(Collectors.toList());
        LOG.debug("Prime numbers : " + primeNumberList);
        return  primeNumberList;
    }
}