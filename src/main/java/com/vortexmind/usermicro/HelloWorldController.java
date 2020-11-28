package com.vortexmind.usermicro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping
    public String hello() throws IOException {

        StringBuilder result = new StringBuilder();
        URL url = new URL("http://mymdbmicro-service:8080/movies");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }
    @GetMapping("/new")
    public String hellonew() throws IOException {

        StringBuilder result = new StringBuilder();
        URL url = new URL("http://mymdbmicro-service.default.svc.cluster.local:8080/movies");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString()+"from new url";
    }

}