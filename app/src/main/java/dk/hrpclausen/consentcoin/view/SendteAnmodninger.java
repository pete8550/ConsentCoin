package dk.hrpclausen.consentcoin.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import dk.hrpclausen.consentcoin.R;

public class SendteAnmodninger extends AppCompatActivity

    // her implementeres androids inbyggede navigationview
        implements NavigationView.OnNavigationItemSelectedListener {

    // her startes activitien, og metoden "onCreate" kører den kode som ligger inde i metoden, når activitien startes
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // her findes layoutet og det bliver kaldt.
            // (meotden fra parent klassen "AppCompatActivity" kræver parametre som sættes)
            setContentView(R.layout.activity_sendte_anmodninger);

            // her kaldes toolbaren
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            // her sættes titlen, og stilen på denne titel
            toolbar.setTitleTextAppearance(this, R.style.TitleTextApperance);
            getSupportActionBar().setTitle("Consentcoin");

            // her sættes parametre for vores navigation drawer og layoutet kaldes
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            NavigationView navigationView = findViewById(R.id.nav_view);
            // her forbindes en listener til knappen på vores activity som tager brugeren til vores navigation drawer
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
            navigationView.setNavigationItemSelectedListener(this);

            // her kaldes vores firebase database og mere specifik vores path "Andmodninger"
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Anmodninger");


        // her instansieres vores childEventListener
        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            // denne metode sætter texten i vores textview som findes i sendteAnmodninger.
            // metoden benytter sig af en listener "onChildAdded" som tager dataen fra vores firebase database og laver det til en string
            // derefter tilføjes text til sendteAnmodninger via "textView.append" og linjen skiftes
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String text = dataSnapshot.getValue().toString();
                TextView textView = findViewById(R.id.sendteAnmodninger);
                textView.append(text + "\n");
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        myRef.addChildEventListener(childEventListener);
    }


    // denne metode sender brugeren tilbage til navigation draweren hvis "back" knappen trykkes på
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflater vores menu; denne metoden kan også tilføje ting til vores menu
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    // standard metoder når man opretter acitivity med Navigationdrawer
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

            return true;
        }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    // Her er metoden som navigerer os rundt i vores app via vores navigation drawer
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // denne variation sender os skærmen "giv_tilladelse"
        if (id == R.id.nav_giv_tilladelse) {

            Intent intent = new Intent(this, GivTilladelse.class);
            startActivity(intent);

            // denne variation sender os skærmen "anmod_om_tilladelse"
        } else if (id == R.id.nav_anmod_om_tilladelse) {

            Intent intent = new Intent(this, Anmodning.class);
            startActivity(intent);

            // denne variation sender os skærmen "mine_tilladelser"
        } else if (id == R.id.nav_mine_tilladelser) {

            Intent intent = new Intent(this, MineTilladelser.class);
            startActivity(intent);

            // denne variation sender os skærmen "sendteanmodninger"
        } else if (id == R.id.nav_sendteanmodninger) {
            Intent intent = new Intent(this, SendteAnmodninger.class);
            startActivity(intent);

        } else if (id == R.id.nav_indstillinger) {

        }

        // her sættes vores layout til draweren
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
