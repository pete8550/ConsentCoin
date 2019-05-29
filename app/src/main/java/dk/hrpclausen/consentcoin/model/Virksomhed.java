package dk.hrpclausen.consentcoin.model;

public class Virksomhed extends Bruger {
    public String getCVR() {
        return CVR;
    }

    public void setCVR(String CVR) {
        this.CVR = CVR;
    }

    String CVR;

}
