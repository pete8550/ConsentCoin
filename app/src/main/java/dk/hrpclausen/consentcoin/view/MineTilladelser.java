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

//MineTilladelser-klasse der kan åbnes via draweren
public class MineTilladelser extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //onCreate metode der skaber klassen mine-tilladelser med rette layout, toolbar og style
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_tilladelser);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextAppearance(this, R.style.TitleTextApperance);
        getSupportActionBar().setTitle("Consentcoin");

        //Vises her at metoden også har en drawer-menu
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Consents");


        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String text = dataSnapshot.getValue().toString();
                TextView textView = findViewById(R.id.Samtykker);
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

    //Denne metode viser hvad der sker, når tilbagepilen klikkes på
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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    //Denne metode viser de enkelte items i draweren
    //Samtidigt er der intents der åbner en pågældende activity
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_giv_tilladelse) {

            Intent intent = new Intent(this, GivTilladelse.class);
            startActivity(intent);

        } else if (id == R.id.nav_anmod_om_tilladelse) {

            Intent intent = new Intent(this, Anmodning.class);
            startActivity(intent);

        } else if (id == R.id.nav_mine_tilladelser) {

            Intent intent = new Intent(this, MineTilladelser.class);
            startActivity(intent);

        } else if (id == R.id.nav_sendteanmodninger) {
            Intent intent = new Intent(this, SendteAnmodninger.class);
            startActivity(intent);

        } else if (id == R.id.nav_indstillinger) {
            //Ved klik på indstillinger i draweren åbnes intet da intet intent er sat til at åbne en activity (endnu)
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
