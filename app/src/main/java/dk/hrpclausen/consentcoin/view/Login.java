package dk.hrpclausen.consentcoin.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import dk.hrpclausen.consentcoin.R;
import dk.hrpclausen.consentcoin.model.DatabaseDAO;
import dk.hrpclausen.consentcoin.model.FirebaseDAO;

//Login-klasse som er den første activity brugeren ser når appen åbnes
public class Login extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    //override metode der minder meget om PSVM i Java
    //Uden denne metode ville activitiet ikke kunne åbnes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //hvilket XML-layout der anvendes til denne activity

        //Her vises det at der anvendes en toolbar samt hvilken text og text-style der er anvendt
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextAppearance(this, R.style.TitleTextApperance);
        getSupportActionBar().setTitle("Consentcoin");

        // Edittext oprettet
        final EditText brugernavn = (EditText) findViewById(R.id.brugernavn);

        // floating actionbutton, der sender besked fra edittext - til firebase i child Brugere
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Bruger oprettet", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                // Skriver en besked til vores firebaseDAO

                DatabaseDAO firebaseDAO = new FirebaseDAO();
                firebaseDAO.pushToDatabaseBruger(brugernavn.getText().toString());

                startActivity(new Intent(Login.this,GivTilladelse.class));
            }

        });

        //Her vises det at der er en drawer-menu for denne activity
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
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

    //Denne metode viser de enkelte items i draweren
    //Samtidigt er der intents der åbner en pågældende activity
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

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
