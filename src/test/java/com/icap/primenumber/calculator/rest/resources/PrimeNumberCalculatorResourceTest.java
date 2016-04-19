package com.icap.primenumber.calculator.rest.resources;

import com.icap.primenumber.calculator.service.PrimeNumberCalculatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by shakshis on 19/04/2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class PrimeNumberCalculatorResourceTest {

    final Integer PRIME_NUMBER_END_RANGE = 23;
    final List<Integer> PRIME_NUMBER_LIST = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
    final String CALCULATE_PRIME_NUMBER_RESOURCE_RESPONSE_JSON = "{\"Prime Numbers\":[2,3,5,7,11,13,17,19]}";
    final Integer PRIME_NUMBER = 17;
    final Integer NON_PRIME_NUMBER = 15;
    final String IS_PRIME_RESOURCE_RESOURCE_POSITIVE_RESPONSE_JSON = "{\"result\":true}";
    final String IS_PRIME_RESOURCE_RESOURCE_NEGATIVE_RESPONSE_JSON = "{\"result\":false}";

    @Mock
    private PrimeNumberCalculatorService primeNumberCalculatorService;

    @InjectMocks
    private PrimeNumberCalculatorResource primeNumberCalculatorResource;

    @Test
    public void testCalculatePrimeNumber() throws Exception {
        when(primeNumberCalculatorService.calculatePrimeNumber(PRIME_NUMBER_END_RANGE)).thenReturn(PRIME_NUMBER_LIST);
        Response response = primeNumberCalculatorResource.calculatePrimeNumber(PRIME_NUMBER_END_RANGE);
        assertEquals(200, response.getStatus());
        assertEquals(CALCULATE_PRIME_NUMBER_RESOURCE_RESPONSE_JSON, response.getEntity().toString());
    }

    @Test
    public void testIsPrimePositive() throws Exception {
        Response response = primeNumberCalculatorResource.isPrime(PRIME_NUMBER);
        assertEquals(200, response.getStatus());
        assertEquals(IS_PRIME_RESOURCE_RESOURCE_POSITIVE_RESPONSE_JSON, response.getEntity().toString());
    }

    @Test
    public void testIsPrimeNegative() throws Exception {
        Response response = primeNumberCalculatorResource.isPrime(NON_PRIME_NUMBER);
        assertEquals(200, response.getStatus());
        assertEquals(IS_PRIME_RESOURCE_RESOURCE_NEGATIVE_RESPONSE_JSON, response.getEntity().toString());
    }
}