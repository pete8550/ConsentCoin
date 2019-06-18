package dk.hrpclausen.consentcoin.view;

// importerede biblioteker
import android.content.Intent;
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
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import dk.hrpclausen.consentcoin.R;
import dk.hrpclausen.consentcoin.model.DatabaseDAO;
import dk.hrpclausen.consentcoin.model.FirebaseDAO;

// en public klasse Anmodning der er nedarvet fra AppCompatActivity og implementere NavigationView.OnNavigationItemSelectedListener
public class Anmodning extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // en Overrided void metode fra parentklassen, med Bundle objekt savedInstanceState som parameter.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // setContentView metode kald, der tager et layout fra ressources som parameter.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anmodning);
        // nyt toolbar objekt fra ressource id toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        //metode kald fra parentclass hvor der indsættes ovenstående toolbar som parameter.
        setSupportActionBar(toolbar);

        // Spinner objekter oprettes der hver især tager imod forskellige arrays
        final Spinner spinner2 = (Spinner)
                findViewById(R.id.virksomhed_spinner);
// Laver en ArrayAdapter der bruger string arrayet, og vores custom spinner layout.
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.virksomhed_array, R.layout.simple_spinner_item);
// Specificere layoutet der skal bruges når der vises de forskellige valgmuligheder
        adapter2.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
// Sætter adapteren på Spinneren
        spinner2.setAdapter(adapter2);

        final Spinner spinner5 = (Spinner)
                findViewById(R.id.personer_spinner);
// Laver en ArrayAdapter der bruger string arrayet, og vores custom spinner layout.
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this,
                R.array.personer_array, R.layout.simple_spinner_item);
// Specificere layoutet der skal bruges når der vises de forskellige valgmuligheder
        adapter5.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
// Sætter adapteren på Spinneren
        spinner5.setAdapter(adapter5);

        final Spinner spinner6 = (Spinner)
                findViewById(R.id.formaal_spinner);
// Laver en ArrayAdapter der bruger string arrayet, og vores custom spinner layout.
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this,
                R.array.formaal_array, R.layout.simple_spinner_item);
// Specificere layoutet der skal bruges når der vises de forskellige valgmuligheder
        adapter6.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
// Sætter adapteren på Spinneren
        spinner6.setAdapter(adapter6);

        final Spinner spinner7 = (Spinner)
                findViewById(R.id.varighed_spinner);
// Laver en ArrayAdapter der bruger string arrayet, og vores custom spinner layout.
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this,
                R.array.varighed_array, R.layout.simple_spinner_item);
// Specificere layoutet der skal bruges når der vises de forskellige valgmuligheder
        adapter7.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
// Sætter adapteren på Spinneren
        spinner7.setAdapter(adapter7);


        // et nyt FloatingActionButton kaldet fab, der får viewet fra ressources.id.fab
        FloatingActionButton fab = findViewById(R.id.fab);
        // en onClickListener metode, der laver en snackbar med følgende besked
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Anmodning sendt", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                // Write a message to the firebaseDAO
                // nyt DatabaseDAO objekt fra FirebaseDAO klassen oprettet.
                DatabaseDAO firebaseDAO = new FirebaseDAO();
                // kalder metoden pushToDataBaseAnmodning fra FirebaseDAO, som tager text fra hver valgt element i spinnerne, + noget String text.
                firebaseDAO.pushToDatabaseAnmodning(spinner2.getSelectedItem().toString() + " har sendt en anmodning til " +
                        spinner5.getSelectedItem().toString() + " om at bruge billeder til " +
                        spinner6.getSelectedItem().toString() + " i " +
                        spinner7.getSelectedItem().toString() + "\n");
            }

        });
        // Nyt DrawerLayout objekt
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        toolbar.setTitleTextAppearance(this, R.style.TitleTextApperance);
        getSupportActionBar().setTitle("Consentcoin");

    }
// standard metoder når man opretter acitivity med Navigationdrawer
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
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    // sætter viewet alt efter hvilket element der bliver klikket på i draweren.
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

            Intent intent = new Intent(this, Indstillinger.class);
            startActivity(intent);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
