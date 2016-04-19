package com.icap.primenumber.calculator.rest.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.SpringLifecycleListener;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * Created by shakshis on 18/04/2016.
 */
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(SpringLifecycleListener.class);
        register(RequestContextFilter.class);
        packages("com.icap.primenumber.calculator.rest", "com.icap.primenumber.calculator.service");
    }
}
