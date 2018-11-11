package com.example.rosa.enjoyarts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.rosa.enjoyarts.card.CardActivity;

public class MainActivityCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_card);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


         Button button = (Button) findViewById(R.id.buttonGotoCards);
         button.setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View v) {
                Intent intentcartela = new Intent(MainActivityCard.this, CardActivity.class);
                startActivity(intentcartela);
            }
       });
       }
}
