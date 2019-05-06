package de.vrees.heatpump.websocket;


import de.vrees.heatpump.model.ProcessdataResource;

public interface ProcessdataListener {

    void publishData(ProcessdataResource event);

    void error(Throwable e);
}
