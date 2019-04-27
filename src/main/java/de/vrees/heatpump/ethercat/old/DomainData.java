package de.vrees.heatpump.ethercat.old;

import java.time.Instant;

public interface DomainData {

    float getHochdruck();

    float getNiederdruck();

    float getVerdampfungsTempIn();

    float getVerdampfungsTempOut();

    float getDruckdifferenzVerdampfer();

    boolean isWaermeAnforderung();

    boolean isEinAusQuittierung();

    float getVorlaufTemperatur();

    float getRuecklaufTemperatur();

    boolean isStoerungDurchfluss();

    boolean isStoerungVerdichter();

    boolean isStoerungNiederdruck();

    boolean isStoerungHochdruck();

    boolean isStatusHeizungspume();

    boolean getStatusVerdichter();

    void setStatusVerdichter(Boolean status);

    Instant getZeitstempel();

    void setZeitstempel(Instant zeitstempel);

    boolean isWarnungNiederdruck();

    void setWarnungNiederdruck(boolean warnungNiederdruck);

    boolean isWarnungHochdruck();

    void setWarnungHochdruck(boolean warnungHochdruck);

    String getStatus();

    void setStatus(String status);

    int getBetriebszustand();

    void setBetriebszustand(int betriebszustand);

    String getZusatzInfo();

    void setZusatzInfo(String zusatzInfo);

    String getButtonMainText();

    void setButtonMainText(String buttonMainText);

    float getSchaltFuehlerTemperatur();

    float getSaugTemperatur();

    float getUeberhitzung();
}
