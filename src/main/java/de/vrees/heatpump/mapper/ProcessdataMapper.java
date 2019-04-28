package de.vrees.heatpump.mapper;

import de.vrees.heatpump.model.ProcessdataResource;
import de.vrees.heatpump.slaves.beckhoff.EL1008;
import org.mapstruct.Mapper;

//@Component
@Mapper(componentModel = "spring")
public interface ProcessdataMapper {

    ProcessdataResource map(EL1008 source);
}
