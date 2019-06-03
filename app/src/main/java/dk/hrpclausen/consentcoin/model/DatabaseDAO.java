package dk.hrpclausen.consentcoin.model;

//DatabaseDAO interface, der skal indeholde alle metoder fra databaseklasserne (kun FirebaseDAO er brugt)
public interface DatabaseDAO {
    void pushToDatabaseConsent(String text);
    void pushToDatabaseAnmodning(String text);

    }
