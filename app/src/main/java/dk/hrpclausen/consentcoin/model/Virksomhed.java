package dk.hrpclausen.consentcoin.model;

//Javaklasse kaldet Virksomhed der nedarver fra Bruger, har 1 variabel String cvr, og getters og setters på den.
public class Virksomhed extends Bruger {

    private String CVR;

    public String getCVR() {
        return CVR;
    }

    public void setCVR(String CVR) {
        this.CVR = CVR;
    }


}
