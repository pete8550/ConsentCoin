package dk.hrpclausen.consentcoin;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Database {

    private DatabaseReference databaseReference;


    public void pushToDatabaseConsent(String text) {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Consents");
        databaseReference.push().setValue(text);
    }

    public void pushToDatabaseAnmodning(String text) {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Anmodninger");
        databaseReference.push().setValue(text);
    }
}