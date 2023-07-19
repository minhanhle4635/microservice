package com.example.grafana.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grafana")
public class GrafanaController {
    @GetMapping
    public ResponseEntity<String> grafana(){
        return ResponseEntity.ok("All OK");
    }
}
