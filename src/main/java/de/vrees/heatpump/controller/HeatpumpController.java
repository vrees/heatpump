package de.vrees.heatpump.controller;


import de.vrees.heatpump.model.ProcessdataResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HeatpumpController {

    @GetMapping("/processdata")
    public ProcessdataResource getProcessdata() {
        return new ProcessdataResource();
    }
}
