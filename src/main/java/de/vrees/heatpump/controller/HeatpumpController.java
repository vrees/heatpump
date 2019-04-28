package de.vrees.heatpump.controller;


import de.vrees.heatpump.mapper.ProcessdataMapper;
import de.vrees.heatpump.master.HeatpumpMaster;
import de.vrees.heatpump.model.ProcessdataResource;
import de.vrees.heatpump.slaves.beckhoff.EL1008;
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
        EL1008 el1008 = master.getEl1008();

        ProcessdataResource resource = mapper.map(el1008);
        return resource;
    }
}
