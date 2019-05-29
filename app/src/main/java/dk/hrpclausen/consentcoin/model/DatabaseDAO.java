package dk.hrpclausen.consentcoin.model;

public interface DatabaseDAO {
    void pushToDatabaseConsent(String text);
    void pushToDatabaseAnmodning(String text);

    }
