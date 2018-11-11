package com.example.rosa.enjoyarts;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Tab_paintColor extends Fragment {


    // instancia de la clase RecyclerView y del Adaptador
    private RecyclerView recyclerViewPainter;
    private RecyclerViewAdapter adapterPainter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_paint_color, container, false);


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

    }
}
