package dk.hrpclausen.consentcoin.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


// en FirebaseDAO klasse der implementerer interfacet DatabaseDAO
public class FirebaseDAO implements DatabaseDAO {

    // ny Databasereference objekt kaldet databaseReference
    private DatabaseReference databaseReference;


    // en void metode der tager imod parametrene String Text, og sender til firebase database "Consents"
    public void pushToDatabaseConsent(String text) {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Consents");
        databaseReference.push().setValue(text);
    }
    // en void metode der tager imod parametrene String Text, og sender til firebase database "Anmodninger"
    public void pushToDatabaseAnmodning(String text) {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Anmodninger");
        databaseReference.push().setValue(text);
    }

}