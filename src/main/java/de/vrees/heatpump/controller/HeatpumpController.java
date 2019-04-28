package de.vrees.heatpump.controller;


import java.util.concurrent.atomic.AtomicLong;

import de.vrees.heatpump.model.ProcessdataResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeatpumpController {

    @GetMapping("/processdata")
    public ProcessdataResource getProcessdata() {
        return new ProcessdataResource();
    }
}
