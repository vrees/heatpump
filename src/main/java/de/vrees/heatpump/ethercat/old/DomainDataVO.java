package de.vrees.heatpump.ethercat.old;

import java.io.Serializable;
import java.time.Instant;

public class DomainDataVO implements DomainData, Serializable {

    private static final long serialVersionUID = 6680406242565144074L;

    private Instant zeitstempel;

    /**
     * Hochdruck Kältekreis in bar
     */
    private float hochdruck;

    /**
     * Niederdruck Kältekreis in bar
     */
    private float niederdruck;

    /**
     * Verdampfungstemperatur in °C
     */
    private float verdampfungsTempIn;

    /**
     * Verdampfungstemperatur out in °C
     */
    private float verdampfungsTempOut;

    /**
     * Druckdifferenz Verdampfer in mbar
     */
    private float druckdifferenzVerdampfer;

    /**
     * VorlaufTemperatur in °C
     */
    private float vorlaufTemperatur;

    /**
     * Rücklauf-Temperatur in °C
     */
    private float ruecklaufTemperatur;

    /**
     * Ein-/Aus-SchaltFühler misst die Temperatur in °C
     */
    private float schaltFuehlerTemperatur;

    /**
     * Kühlmittel-Temperatur am Ausgang des Verdsampfers
     */
    private float ueberhitzung;

    /**
     * Kühlmittel-Temperatur am Ausgang des Verdsampfers vor dem Eingang des Verdichters
     * Wird zusammen mit dem Druck im Verdampfer zur Bestimmung der Überhitzung benötigt
     */
    private float saugTemperatur;

    /**
     * Wärme Anforderung
     */
    private boolean waermeAnforderung;

    /**
     * EinAusQuittierung
     */
    private boolean einAusQuittierung;

    /**
     * Stoerung Durchfluss
     */
    private boolean stoerungDurchfluss;

    /**
     * Stoerung Verdichter / Motorschutzshalter
     */
    private boolean stoerungVerdichter;

    /**
     * Stoerung Niederdruck: Ranco-Thermostat meldet zu niedrigen Niederdruck
     */
    private boolean stoerungNiederdruck;

    /**
     * Stoerung Hochdruck Ranco-Thermostat meldet zu hohen Hochdruck
     */
    private boolean stoerungHochdruck;

    /**
     * Status Heizungspume: Ein/Aus
     */
    private boolean statusHeizungspume;

    /**
     * Status Verdichter: Ein/Aus
     */
    private boolean statusVerdichter;

    /**
     * Warung Niederdruck (Soft-Wert falls gemessener Niederdruck unter konfigurierte Grenze fällt)
     */
    private boolean warnungNiederdruck;

    /**
     * Warnung Hochdruck (Soft-Wert falls gemessener Hochdruck über konfigurierte Grenze steigt)
     */
    private boolean warnungHochdruck;

    /**
     * Wird angezeigt um im GUI weitere Information zum Status auszugeben
     */
    private String zusatzInfo;

    /**
     * String representation of Heatpump.State
     */
    private String status;


    /**
     * integer representation of Heatpump.State
     */
    private int betriebszustand;

    /**
     * Button-Beschriftung
     */
    private String buttonMainText;

    /**
     * True, wenn der Bnutzer den Ein/Aus-Button geklickt hat
     */
    private boolean buttonMainClicked = false;

    public float getHochdruck() {
        return hochdruck;
    }

    public void setHochdruck(float hochdruck) {
        this.hochdruck = hochdruck;
    }

    public float getNiederdruck() {
        return niederdruck;
    }

    public void setNiederdruck(float niederdruck) {
        this.niederdruck = niederdruck;
    }

    public float getVerdampfungsTempIn() {
        return verdampfungsTempIn;
    }

    public void setVerdampfungsTempIn(float verdampfungsTempIn) {
        this.verdampfungsTempIn = verdampfungsTempIn;
    }

    public float getVerdampfungsTempOut() {
        return verdampfungsTempOut;
    }

    public void setVerdampfungsTempOut(float verdampfungsTempOut) {
        this.verdampfungsTempOut = verdampfungsTempOut;
    }

    public float getDruckdifferenzVerdampfer() {
        return druckdifferenzVerdampfer;
    }

    public void setDruckdifferenzVerdampfer(float druckdifferenzVerdampfer) {
        this.druckdifferenzVerdampfer = druckdifferenzVerdampfer;
    }

    public boolean isWaermeAnforderung() {
        return waermeAnforderung;
    }

    public void setWaermeAnforderung(boolean waermeAnforderung) {
        this.waermeAnforderung = waermeAnforderung;
    }

    public boolean isEinAusQuittierung() {
        return einAusQuittierung;
    }

    public void setEinAusQuittierung(boolean einAusQuittierung) {
        this.einAusQuittierung = einAusQuittierung;
    }

    public float getVorlaufTemperatur() {
        return vorlaufTemperatur;
    }

    public void setVorlaufTemperatur(float vorlaufTemperatur) {
        this.vorlaufTemperatur = vorlaufTemperatur;
    }

    public float getRuecklaufTemperatur() {
        return ruecklaufTemperatur;
    }

    public void setRuecklaufTemperatur(float ruecklaufTemperatur) {
        this.ruecklaufTemperatur = ruecklaufTemperatur;
    }

    public boolean isStoerungDurchfluss() {
        return stoerungDurchfluss;
    }

    public void setStoerungDurchfluss(boolean stoerungDurchfluss) {
        this.stoerungDurchfluss = stoerungDurchfluss;
    }

    public boolean isStoerungVerdichter() {
        return stoerungVerdichter;
    }

    public void setStoerungVerdichter(boolean stoerungVerdichter) {
        this.stoerungVerdichter = stoerungVerdichter;
    }

    public boolean isStoerungNiederdruck() {
        return stoerungNiederdruck;
    }

    public void setStoerungNiederdruck(boolean stoerungNiederdruck) {
        this.stoerungNiederdruck = stoerungNiederdruck;
    }

    public boolean isStoerungHochdruck() {
        return stoerungHochdruck;
    }

    public void setStoerungHochdruck(boolean stoerungHochdruck) {
        this.stoerungHochdruck = stoerungHochdruck;
    }

    public boolean isStatusHeizungspume() {
        return statusHeizungspume;
    }

    public void setStatusHeizungspume(boolean statusHeizungspume) {
        this.statusHeizungspume = statusHeizungspume;
    }

    public boolean getStatusVerdichter() {
        return statusVerdichter;
    }

    public void setStatusVerdichter(Boolean statusVerdichter) {
        this.statusVerdichter = statusVerdichter;
    }

    @Override
    public String toString() {
        return "DomainData [zeitstempel=" + zeitstempel + ", hochdruck=" + hochdruck + ", niederdruck=" + niederdruck
                + ", verdampfungsTempIn=" + verdampfungsTempIn + ", verdampfungsTempOut=" + verdampfungsTempOut
                + ", druckdifferenzVerdampfer=" + druckdifferenzVerdampfer + ", vorlaufTemperatur=" + vorlaufTemperatur
                + ", ruecklaufTemperatur=" + ruecklaufTemperatur + ", statusVerdichter=" + statusVerdichter
                + ", statusHeizungspume=" + statusHeizungspume + ", waermeAnforderung=" + waermeAnforderung
                + ", einAusQuittierung=" + einAusQuittierung + ", stoerungDurchfluss=" + stoerungDurchfluss
                + ", stoerungVerdichter=" + stoerungVerdichter + ", stoerungNiederdruck=" + stoerungNiederdruck
                + ", stoerungHochdruck=" + stoerungHochdruck + "]";
    }

    public Instant getZeitstempel() {
        return zeitstempel;
    }

    public void setZeitstempel(Instant zeitstempel) {
        this.zeitstempel = zeitstempel;
    }

    public boolean isWarnungNiederdruck() {
        return warnungNiederdruck;
    }

    public void setWarnungNiederdruck(boolean warnungNiederdruck) {
        this.warnungNiederdruck = warnungNiederdruck;
    }

    public boolean isWarnungHochdruck() {
        return warnungHochdruck;
    }

    public void setWarnungHochdruck(boolean warnungHochdruck) {
        this.warnungHochdruck = warnungHochdruck;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int getBetriebszustand() {
        return betriebszustand;
    }

    @Override
    public void setBetriebszustand(int betriebszustand) {
        this.betriebszustand = betriebszustand;
    }

    public String getZusatzInfo() {
        return zusatzInfo;
    }

    public void setZusatzInfo(String zusatzInfo) {
        this.zusatzInfo = zusatzInfo;
    }

    public String getButtonMainText() {
        return buttonMainText;
    }

    public void setButtonMainText(String buttonMainText) {
        this.buttonMainText = buttonMainText;
    }

    public boolean isButtonMainClicked() {
        return buttonMainClicked;
    }

    public void setButtonMainClicked(boolean buttonMainClicked) {
        this.buttonMainClicked = buttonMainClicked;
    }

    public float getSchaltFuehlerTemperatur() {
        return schaltFuehlerTemperatur;
    }

    public void setSchaltFuehlerTemperatur(float schaltFuehlerTemperatur) {
        this.schaltFuehlerTemperatur = schaltFuehlerTemperatur;
    }

    @Override
    public float getSaugTemperatur() {
        return saugTemperatur;
    }

    public void setSaugTemperatur(float saugTemperatur) {
        this.saugTemperatur = saugTemperatur;
    }

    @Override
    public float getUeberhitzung() {
        return ueberhitzung;
    }

    public void setUeberhitzung(float ueberhitzung) {
        this.ueberhitzung = ueberhitzung;
    }
}
