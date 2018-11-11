package com.example.rosa.enjoyarts;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true); //para que salga flechita home  > providing up navigation PREGUNTAR

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabedit);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Contacta conmigo y hablamos de Arte", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent ffintent = new Intent(NavigationDrawerActivity.this, FFActivity.class);
                startActivity(ffintent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

       //FragmentManager fragmentManager = getSupportFragmentManager();
       //fragmentManager.beginTransaction().replace(R.id.containerFragments, new PaintingFragment()).commit();


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();
        switch (item.getItemId()){
            case R.id.info:
                Intent intentHelp = new Intent(this , SectionsAppBarActivity.class);
                startActivity(intentHelp);
                break;
            case R.id.home:
                Intent intentHome = new Intent(this , MainActivity.class);
                startActivity(intentHome);
                break;
            case R.id.crud:
                Intent intentCrud = new Intent(this , MainActivityCard.class);
                startActivity(intentCrud);
                break;
            default:
                break;
        }
        return true;
        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
         //   return true;
        }

        //return super.onOptionsItemSelected(item);



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Vinculamos opciones con sus respectivos fragmentos
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.nav_import) {
            fragmentManager.beginTransaction().replace(R.id.containerFragments, new ImportFragment()).commit();
          } else if (id == R.id.nav_gallery) {
            fragmentManager.beginTransaction().replace(R.id.containerFragments, new GalleryFragment()).commit();
          } else if (id == R.id.nav_slideshow) {
            fragmentManager.beginTransaction().replace(R.id.containerFragments, new SlideshowFragment()).commit();
          } else if (id == R.id.nav_painting) {
            fragmentManager.beginTransaction().replace(R.id.containerFragments, new PaintingFragment()).commit();
          } else if (id == R.id.nav_sculpture) {
            fragmentManager.beginTransaction().replace(R.id.containerFragments, new SculptureFragment()).commit();
          } else if (id == R.id.nav_manage) {
            fragmentManager.beginTransaction().replace(R.id.containerFragments, new ToolsFragment()).commit();
          } else if (id == R.id.nav_share) {
            Intent intent = new Intent(this, OtraCosaActivity.class);
            startActivity(intent);
          } else if (id == R.id.nav_send) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
