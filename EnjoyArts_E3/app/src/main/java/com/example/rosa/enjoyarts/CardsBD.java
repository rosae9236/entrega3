package com.example.rosa.enjoyarts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class CardsBD extends SQLiteOpenHelper{

    private static final String NOMBRE_BD="cards.db";
    private static final int VERSION_BD=1;    // para diferenciar cambio por si se decide modificar estructura de bd
    private static final  String TABLA_CARDS="CREATE TABLE CARDS (AUTHOR TEXT PRIMARY KEY, TITLE TEXT, YEAR INTEGER, LOCATION TEXT)";
    public CardsBD(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    //se crea método onCreate que se ejecutará automáticamente y creará las tablas que conforman la bd.
    //método execSQL para ejectur las sentencias sql que se requieran en la tabla
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_CARDS);
    }


    /*método onUpgrade que se lanza automáticamente sólo cuando sea necesaria una actualización en la estructura de la bd
    o se de una conversión de datos. Como sólo tenemos una tabla hacemos que se elimana la versión anterior de la tabla
    y luego la volvemos a crear con una nueva versión*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(String.format("%sDROP TABLE IF EXISTS", TABLA_CARDS));
        db.execSQL(TABLA_CARDS);
    }

    //método para agregar los registros dentro de la tabla.
    //se crea objeto de la clase SQLiteDataBase
    // y luego se llama al método que nos permite trabajar con la bd en modo lectura y escritura
    public void addCards(String author, String title, String year, String location){
        SQLiteDatabase db = getWritableDatabase();
        if (db != null){                    //para comprobar si se abre correctamente la db
            db.execSQL("INSERT INTO CARDS VALUES('"+author+"', '"+title+"', '"+year+"','"+location+"')");
            db.close();
        }

    }

}
