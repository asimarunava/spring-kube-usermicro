package com.vortexmind.usermicro;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
@Configuration
@ConfigurationProperties(prefix = "bean")
public class MyConfig {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String m) {
        this.message = m;
    }

}