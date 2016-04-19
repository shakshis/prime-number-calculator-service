package com.icap.primenumber.calculator.rest.resources;

import com.icap.primenumber.calculator.PrimeNumberCalculator;
import com.icap.primenumber.calculator.service.PrimeNumberCalculatorService;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by shakshis on 18/04/2016.
 */

@Path("/primeNumber")
@Component
@Produces(MediaType.APPLICATION_JSON)
public class PrimeNumberCalculatorResource {

    private static final Logger LOG = LoggerFactory.getLogger(PrimeNumberCalculatorResource.class);

    @Autowired
    private PrimeNumberCalculatorService primeNumberCalculatorService;

    @GET
    @Path("/calculate/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculatePrimeNumber(@PathParam("number") Integer endRange) throws JSONException {
        LOG.debug("Got range: {}", endRange);
        JSONObject jsonObject = new JSONObject();
        List<Integer> primeNumbers = primeNumberCalculatorService.calculatePrimeNumber(endRange);

        jsonObject.put("Prime Numbers", primeNumbers);
        return Response.status(200).entity(jsonObject).build();
    }

    @GET
    @Path("/verify/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response isPrime(@PathParam("number") Integer number) throws JSONException {
        LOG.debug("Got number to verify: {}", number);
        JSONObject jsonObject = new JSONObject();
        boolean result = PrimeNumberCalculator.isPrime(number);
        jsonObject.put("result", result);
        return Response.status(200).entity(jsonObject).build();
    }
}
