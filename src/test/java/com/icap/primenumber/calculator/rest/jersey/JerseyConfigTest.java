package com.icap.primenumber.calculator.rest.jersey;

import org.glassfish.jersey.server.spring.SpringLifecycleListener;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by shakshis on 19/04/2016.
 */
public class JerseyConfigTest {

    private JerseyConfig jerseyConfig;

    @Before
    public void setUp() throws Exception {
        jerseyConfig = new JerseyConfig();
    }

    @Test
    public void testJC() {
        assertTrue(jerseyConfig.isRegistered(RequestContextFilter.class));
        assertTrue(jerseyConfig.isRegistered(SpringLifecycleListener.class));
    }
}