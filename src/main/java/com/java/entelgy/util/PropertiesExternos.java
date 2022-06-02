package com.java.entelgy.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component

public class PropertiesExternos {
    Environment environment;

    @Value("${spring.api1}")
    public String api1;

    @Value("${spring.api2}")
    public String api2;

    @Value("${spring.json}")
    public String json;

    @Value("${spring.log.status}")
    public String logStatus;

    @Value("${spring.log.headers}")
    public String logHeaders;

    @Value("${spring.log.body}")
    public String logBody;

    @Value("${spring.error}")
    public String error;

    @Value("%{spring.finally}")
    public String finalizar;
}
