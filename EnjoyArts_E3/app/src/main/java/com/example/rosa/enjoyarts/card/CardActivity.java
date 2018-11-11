package com.example.rosa.enjoyarts.card;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.rosa.enjoyarts.card.MainCRUD;
import com.example.rosa.enjoyarts.R;


//para cargar el CartelaListFrament en el layout frament_cartela:list (id fragment_cartela)

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabedit);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Acceso a CRUD", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent intentCrud = new Intent(CardActivity.this, MainCRUD.class);
                startActivity(intentCrud);
            }
        });


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        //Se carga fragmento dentro de la actividad

        CardListFragment cardListFragment = new CardListFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_card, cardListFragment);  //fragmento a cargar en activity_card: cardListFrament
        transaction.commit();
    }


}
