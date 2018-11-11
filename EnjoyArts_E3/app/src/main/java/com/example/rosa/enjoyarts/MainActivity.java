package com.example.rosa.enjoyarts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText editTextName;
    private Button buttonStart;


   // instancia de la clase RecyclerView y del Adaptador
      private RecyclerView recyclerViewPainter;
      private RecyclerViewAdapter adapterPainter;



   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



      /* //RECYCLERVIEW Y CARDVIEW
       //se vincula instancia RecyclerView con el RecyclerView del layout
       recyclerViewPainter = (RecyclerView) findViewById(R.id.RecyclerViewTabColor);
       //para definir la forma de la lista: vertical
       recyclerViewPainter.setLayoutManager(new LinearLayoutManager(this));

        //función tipolista basada en la clase PainterModel que contiene los datos con los que trabajaremos.
        public List<PainterModel> getPainters(){
            List<PainterModel> painter = new ArrayList <>();
            painter.add(new PainterModel());
        }


       //asignar la información en el RecyclerView del layout
       adapterPainter = new RecyclerViewAdapter(obtenerPainters());
       recyclerViewPainter.setAdapter(adapterPainter);
    */

     /* GRID
        GridView gridView = (GridView) findViewById(R.id.grid_view);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new GridLayoutActivity(this));
    */



    }
    //RESPUESTA CORREO TIBURCIO
    public void ejecutarButtonStart (View view){
        EditText editTextName = (EditText) findViewById(R.id.editTextName);
        String name = editTextName.getText().toString();
        // TIBURCIO: Aquí empieza la validación
        editTextName.setError(null);
        if (TextUtils.isEmpty(name)) {
            editTextName.setError("Está vacío");
            editTextName.setFocusable(true);
            return;
        }
        // TIBURCIO: Si llega aquí es que he pasado la validación y por tanto se va a la siguiente actividad
        Intent intentStart = new Intent(this, ArtisticExpression.class);
        intentStart.putExtra("name", name); // TIBURCIO: Esta línea es para pasar "name" a la actividad ArtisticExpression
        startActivity(intentStart);
    }

    /*
    //función tipo lista basanda en la clase PainterModel que contiene los datos con los que se trabajará
    public List<PainterModel> obtenerPainters(){
        List<PainterModel> painter = new ArrayList <>();
        painter.add(new PainterModel("Mark Rothko", "Untitled",R.mipmap.ic_rothko1_foreground));
        painter.add(new PainterModel("Van Gogh", "Retrato de Père Tanguy",R.mipmap.ic_vangoght));
        painter.add(new PainterModel("Seurat", "La tour Eiffel",R.mipmap.ic_seuratt));
        painter.add(new PainterModel("Munch", "El grito",R.mipmap.ic_munchg_foreground));
        return painter;    //pasa la información de la lista al adaptador
    }
*/
        /*
            //ROSA (va boton con atributo OnClick)  (presentado en tarea1)
            public void ejecutarButtonStart(View view) {
                Intent intentStart = new Intent(this, ArtisticExpression.class);
                startActivity(intentStart);
            }
        */

}

/*
        //ROSA v1  -funciona ir a siguiente activity >  pero el cód. de la otra activity no resuelve "get"
        editTextName = (EditText)findViewById(R.id.editTextName);
        buttonStart = (Button) findViewById(R.id.buttonStart);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStart = new Intent(MainActivity.this,ArtisticExpression.class);
                intentStart.putExtra("name", editTextName.getText() + "");
                startActivity(intentStart);
            }

       });
*/

//-------------------------------

//  OCULTAR TECLADO resuelvo con atributo android:imeOptions="actionDone"
               /*
                Ocultar teclado vitual
                InputMethodManager tecladoOculto = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                tecladoOculto.hideSoftInputFromWindow(editText_name.getWindowToken(),0);
                */



//en Oncreate
     /*
        //cod. video TIBURCIO  con este código haciendo click en botón se pasa de una actividad a otra (a mi no me va)
        Button buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStart = new Intent(getApplicationContext(),ArtisticExpression.class);
                startActivity(intentStart);
         }
*/
     /*
        //cód. video TIBURCIO  paso con parámetro.

        Button buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            EditText editTextName = (EditText) findViewById(R.id.editTextName);
            String name = editTextName.getText().toString();                                // para coger el texto que ha escrito el usuario  a recoger en la otra actividad.

                Intent intentStart = new Intent(getApplicationContext(),ArtisticExpression.class);
                startActivity(intentStart);
         }
*/


