package dk.hrpclausen.consentcoin.model;

// en javaklasse Bruger, der fungere som superklasse for Virksomhed og Person
public class Bruger {

    // 3 variabler
   private int nummer;
   private String navn;
   private String email;

   // getters og setters på variablerne

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
