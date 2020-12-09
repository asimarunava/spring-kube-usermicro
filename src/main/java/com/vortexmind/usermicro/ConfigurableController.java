package com.vortexmind.usermicro;

import com.vortexmind.kafka.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConfigurableController {
    @Autowired
    private MyConfig config;
    @Autowired
    private ProducerService prd;
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurableController.class);

    @GetMapping("/")
    public String getValue()
    {
        return config.getMessage();
    }

    @PostMapping("/kafka")
    @ResponseBody
    public String addFoo(@RequestParam String topic, @RequestParam String msg) {
        prd.send();
        return "OK";
    }
}