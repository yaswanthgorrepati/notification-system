package com.yaswanthgorrepati.ns.controller;

import com.yaswanthgorrepati.ns.json.PingResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class HealthController {

    @GetMapping("/ping")
    public PingResponse ping(){
        return new PingResponse("200", "Success");
    }
}
