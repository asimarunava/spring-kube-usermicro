package com.vortexmind.usermicro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ConfigurableController {
    @Autowired
    private MyConfig config;
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurableController.class);

    @GetMapping("/")
    public String getValue()
    {
        return config.getMessage();
    }
}