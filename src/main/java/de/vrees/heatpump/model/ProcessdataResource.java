package de.vrees.heatpump.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProcessdataResource {

    private Instant timestamp;

    /**
     * Hochdruck Kältekreis in bar
     */
    private float highPressure;

    /**
     * Niederdruck Kältekreis in bar
     */
    private float lowPressure;

    /**
     * Verdampfungstemperatur in °C
     */
    private float evaporatingTemperatureIn;

    /**
     * Verdampfungstemperatur out in °C
     */
    private float evaporatingTemperatureOut;

    /**
     * Druckdifferenz Verdampfer in mbar
     */
    private float pressureDiffenceEvaporator;

    /**
     * VorlaufTemperatur in °C
     */
    private float flowTemperature;

    /**
     * Rücklauf-Temperatur in °C
     */
    private float returnTemperature;

    /**
     * schaltFuehlerTemperatur: Ein-/Aus-SchaltFühler misst die Temperatur in °C
     */
    private float switchOnSensorTemperature;

    /**
     * Überhitzung: Kühlmittel-Temperatur am Ausgang des Verdampfers (berechnet ?)
     */
    private float overheatTemperature;

    /**
     * SaugTemperatur:
     * Kühlmittel-Temperatur am Ausgang des Verdampfers vor dem Eingang des Verdichters
     * Wird zusammen mit dem Druck im Verdampfer zur Bestimmung der Überhitzung benötigt
     */
    private float evaporatorOutTemperature;

    /**
     * Wärme Anforderung
     */
    private boolean heatRequest;

    /**
     * EinAusQuittierung
     */
    private boolean actionConfirmation;

    /**
     * Stoerung Durchfluss
     */
    private boolean incidentFlow;

    /**
     * Stoerung Verdichter / Motorschutzshalter
     */
    private boolean incidentCompressor;

    /**
     * Stoerung Niederdruck: Ranco-Thermostat meldet zu niedrigen Niederdruck
     */
    private boolean incidentLowPressure;

    /**
     * Stoerung Hochdruck Ranco-Thermostat meldet zu hohen Hochdruck
     */
    private boolean incidentHighPressure;

    /**
     * Status Heizungspume: Ein/Aus
     */
    private boolean operatingStateWaterPump;

    /**
     * Status Verdichter: Ein/Aus
     */
    private boolean operatingStateCompressor;

    /**
     * Warung Niederdruck (Soft-Wert falls gemessener Niederdruck unter konfigurierte Grenze fällt)
     */
    private boolean warningLowPressure;

    /**
     * Warnung Hochdruck (Soft-Wert falls gemessener Hochdruck über konfigurierte Grenze steigt)
     */
    private boolean warningHighPressure;


}
