package org.example.tmdeh_ci_cd.controller;

import lombok.RequiredArgsConstructor;
import org.example.tmdeh_ci_cd.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;
    @GetMapping("/test")
    public String getString() {
        return testService.getString();
    }
}
