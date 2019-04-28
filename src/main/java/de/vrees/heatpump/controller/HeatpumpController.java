package de.vrees.heatpump.controller;


import de.vrees.heatpump.mapper.ProcessdataMapper;
import de.vrees.heatpump.master.HeatpumpMaster;
import de.vrees.heatpump.model.ProcessdataResource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@Slf4j
public class HeatpumpController {

    private final HeatpumpMaster master;

    private final ProcessdataMapper mapper;

    @GetMapping("/processdata")
    public ProcessdataResource getProcessdata() {

        ProcessdataResource resource = mapper.map(master.getEl1008(), master.getEl3122());
        return resource;
    }
}
