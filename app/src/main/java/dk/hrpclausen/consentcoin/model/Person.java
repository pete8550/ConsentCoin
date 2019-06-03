package dk.hrpclausen.consentcoin.model;

//Javaklasse kaldet Person der nedarver fra Bruger, har 1 variabel String cpr, og getters og setters på den.
public class Person extends Bruger {

    String cpr;

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

}

