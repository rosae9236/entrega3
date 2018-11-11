package com.example.rosa.enjoyarts;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ArtisticExpression extends Activity {


    TextView textViewHello;
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textViewSelected;
    Button buttonApply;

   // TextView textViewObjective;
   // Typeface brush;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artistic_expression);


      showWelcome();

   //   String fontText = getString(R.string.AmtumsBrush);
  //    this.brush = Typeface.createFromAsset(getAssets(),fontText);

  //    textViewObjective = (TextView)findViewById(R.id.textViewObjective);
   //   textViewObjective.setTypeface(brush);

/*
        radioGroup = findViewById(R.id.radioGroupAExpression);
        textViewSelected = findViewById(R.id.textViewSelected);

        Button buttonApply = findViewById(R.id.buttonApply);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);

                textViewSelected.setText("Tu elección es: " + radioButton.getText());

                radioButton = findViewById(radioId);

            }
        });

*/
    }



/*
    //video
    private void showWelcome() {
        String name = getIntent().getExtras().getString("name");
        TextView textViewHello = (TextView) findViewById(R.id.editTextName);
        textViewHello.setText("¡" + "Hola" + name + "!");
    }
*/
/*
//   ROSA v2
    private void showWelcome() {

        textViewHello = (TextView) findViewById(R.id.editTextName);
        String name = getIntent().getStringExtra("name");
        textViewHello.setText("¡" + "Hola" + name + "!");
    }
*/


    //TIBURCIO correo + modifico
    private void showWelcome() {
        // TIBURCIO: Aquí recojo el parámetro pasado desde MainActivity y lo muestro por pantalla a modo de ejemplo

        String name = getIntent().getExtras().getString("name");
        TextView textView = findViewById(R.id.textViewHello);
        textView.setText("¡" + "Hola" + " " + name + "!");

        //Toast.makeText(this, "El mensaje pasado es: " + name, Toast.LENGTH_LONG).show();
    }

/*
        Toast.makeText(this,"¡" + "Hola" + " " + name + "!" ,Toast.LENGTH_LONG).show();*/
       /*
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        View view=toast.getView();
        TextView view1=(TextView)view.findViewById(android.R.id.message);
        view1.setTextColor(Color.CYAN);
        view.setBackgroundResource(R.color.colorPrimary);
*/


    public void ejecutarButtonContinue (View view){
        Intent intentContinue = new Intent(this, NavigationDrawerActivity.class);
        startActivity(intentContinue);
    }

}

/*

              /*
               TextView textViewSelected = (TextView) findViewById(R.id.textViewSelected);
                String name = textViewSelected.getText().toString();

                textViewSelected.setError(null);
                if(TextUtils.isEmpty("name")){
                    textViewSelected.setError("Selecciona, por favor");
                    textViewSelected.setFocusable(true);
                    return;
                }

*/

    /*
    Toast toast=Toast.makeText(getApplicationContext(),"This is advanced toast",Toast.LENGTH_LONG);
    toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT,0,0);
    View view=toast.getView(); T
    extView view1=(TextView)view.findViewById(android.R.id.message);
    view1.setTextColor(Color.YELLOW);
    view.setBackgroundResource(R.color.colorPrimary);
    toast.show();
     */