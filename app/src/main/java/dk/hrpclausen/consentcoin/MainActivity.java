package dk.hrpclausen.consentcoin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextAppearance(this, R.style.TitleTextApperance);
        getSupportActionBar().setTitle("Consentcoin");
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_giv_lov) {

        } else if (id == R.id.nav_bed_om_lov) {

        } else if (id == R.id.nav_mine_tilladelser) {

        } else if (id == R.id.nav_inviter) {

        } else if (id == R.id.nav_brugere_og_virksomheder) {

        } else if (id == R.id.nav_indstillinger) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}

//Disse ting skal designes
//TODO 1: Slet/usynliggør tekst Cosentcoin
//TODO 2: Lav en textview i toolbar (xml), og design og placer nyt Consentcoin logo
//TODO 5: Design næste activity
//TODO 6: Design menuen ved klik på hamburger ikonet

//Disse ting skal programmeres
//TODO 3: Ændr teksten i edittext (skriv et brugernavn), så den forsvinder ved skrivning
//TODO 4: Gør teksten funktionel, opret nyt activity og log ind med funktionaliteten

//Andet der kan laves
//TODO 7: Kommentér både kode og xml. Intet er dokumenteret endnu
//TODO 8: Skab mere orden i koden. Både i res og i klasser. Eventuelt lav flere styles, så koden minimeres
