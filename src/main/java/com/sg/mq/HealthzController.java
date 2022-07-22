package com.sg.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class HealthzController {

    @GetMapping
    private String getHealthz(){
        log.info("#########################################[ok]");
        return "ok!!!";
    }
}
