package com.example.rosa.enjoyarts.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;

public class ContentProviderArt extends ContentProvider {

    private static final int CARD_ONE_REG = 1;  //Uri >  CARD_ONE_REG = //content://com.example.rosa.conteproviderarts.provider.ContentProviderArt/CardActivity/#
    private static final int CARD_ALL_REGS = 2;  //Uri > CARD_ALL_REGS = //content://com.example.rosa.conteproviderarts.provider.ContentProviderArt/CardActivity

    private SQLiteDatabase sqlDB;
    public DatabaseHelper dbHelper;
    private static final String DATABASE_NAME = "Cards.db";
    private static final int DATABASE_VERSION = 3;

    private static final String CARD_TABLE_NAME = "Card";


    // Indicates an invalid content URI
    public static final int INVALID_URI = -1;

    // Defines a helper object that matches content URIs to table-specific parameters
    private static final UriMatcher sUriMatcher;

    // Stores the MIME types served by this provider
    private static final SparseArray<String> sMimeTypes;

    /*
     * Initializes meta-data used by the content provider:
     * - UriMatcher that maps content URIs to codes
     * - MimeType array that returns the custom MIME type of a table
     */
    static {

        // Creates an object that associates content URIs with numeric codes
        sUriMatcher = new UriMatcher(0);

        /*
         * Sets up an array that maps content URIs to MIME types, via a mapping between the
         * URIs and an integer code. These are custom MIME types that apply to tables and rows
         * in this particular provider.
         */
        sMimeTypes = new SparseArray<String>();

        // Adds a URI "match" entry that maps picture URL content URIs to a numeric code

        sUriMatcher.addURI(
                Contract.AUTHORITY,
                CARD_TABLE_NAME,
                CARD_ALL_REGS);
        sUriMatcher.addURI(
                Contract.AUTHORITY,
                CARD_TABLE_NAME + "/#",
                CARD_ONE_REG);

        // Specifies a custom MIME type for the picture URL table  text/html
        sMimeTypes.put(
                CARD_ALL_REGS,
                "vnd.android.cursor.dir/vnd." +
                        Contract.AUTHORITY + "." + CARD_TABLE_NAME);
        sMimeTypes.put(
                CARD_ONE_REG,
                "vnd.android.cursor.item/vnd."+
                        Contract.AUTHORITY + "." + CARD_TABLE_NAME);
    }


    public static class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onOpen(SQLiteDatabase db) {
            super.onOpen(db);

            //if (!db.isReadOnly()){
            //Habilitamos la integridad referencial  > ej."clave extranjera relacionada con clave principal"
            db.execSQL("PRAGMA foreign_keys=ON;");
            //}
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // create table to store

            db.execSQL("Create table "
                    + CARD_TABLE_NAME
                    + "( _id INTEGER PRIMARY KEY ON CONFLICT ROLLBACK AUTOINCREMENT, "
                    + Contract.Card.ARTIST + " TEXT , "
                    + Contract.Card.TITLE + " TEXT , "
                    + Contract.Card.YEAR + " INTEGER , "
                    + Contract.Card.LOCATION + " TEXT ); "
            );

            inicializarDatos(db);

        }

        void inicializarDatos(SQLiteDatabase db){

            db.execSQL("INSERT INTO " + CARD_TABLE_NAME + " (" + Contract.Card.ARTIST + "," + Contract.Card.TITLE + "," + Contract.Card.YEAR + "," + Contract.Card.LOCATION + ") " +
                    "VALUES ('Rothko','Untitle 12',0,'Colección privada')");

            db.execSQL("INSERT INTO " + CARD_TABLE_NAME + " (" +  Contract.Card.ARTIST + "," + Contract.Card.TITLE + "," + Contract.Card.YEAR + "," + Contract.Card.LOCATION + ") " +
                    "VALUES ('VanGogh','Retrato de Père Tanguy',1887,'Museo Rodin, París')");

            db.execSQL("INSERT INTO " + CARD_TABLE_NAME + " (" +  Contract.Card.ARTIST + "," + Contract.Card.TITLE + "," + Contract.Card.YEAR + "," + Contract.Card.LOCATION + ") " +
                    "VALUES ('Seurat','La tour Eiffel',1889,'Fine Arts Museums of San Francisco, CA, USA')");

            db.execSQL("INSERT INTO " + CARD_TABLE_NAME + " (" +  Contract.Card.ARTIST + ","+ Contract.Card.TITLE + "," + Contract.Card.YEAR + "," + Contract.Card.LOCATION + ") " +
                    "VALUES ('Munch','El grito',1893,'Galería Nacional de Oslo, Noruega')");

            db.execSQL("INSERT INTO " + CARD_TABLE_NAME + " (" +  Contract.Card.ARTIST + ","+ Contract.Card.TITLE + "," + Contract.Card.YEAR + "," + Contract.Card.LOCATION + ") " +
                    "VALUES ('Sorolla','Niños en la playa',1916,'Colección privada')");
        }

        //cuando se modifica versión se borra tabla
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + CARD_TABLE_NAME);

            onCreate(db);
        }

    }

    public ContentProviderArt() {
    }


    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }


    @Override
    public boolean onCreate() {
        dbHelper = new DatabaseHelper(getContext());
        return (dbHelper == null) ? false : true;
    }

    public void resetDatabase() {
        dbHelper.close();
        dbHelper = new DatabaseHelper(getContext());
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        sqlDB = dbHelper.getWritableDatabase();

        String table = "";
        switch (sUriMatcher.match(uri)) {
            case CARD_ALL_REGS:
                table = CARD_TABLE_NAME;
                break;
        }

        long rowId = sqlDB.insert(table, "", values);  //se ejecuta la inserción de los valores pasados por parámetro

        if (rowId > 0) {
            Uri rowUri = ContentUris.appendId(
                    uri.buildUpon(), rowId).build();
            getContext().getContentResolver().notifyChange(rowUri, null);
            return rowUri;
        }
        throw new SQLException("Failed to insert row into " + uri);
    }


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        sqlDB = dbHelper.getWritableDatabase();
        // insert record in user table and get the row number of recently inserted record

        String table = "";
        switch (sUriMatcher.match(uri)) {
            case CARD_ONE_REG:
                if (null == selection) selection = "";
                selection += Contract.Card._ID + " = "
                        + uri.getLastPathSegment();
                table = CARD_TABLE_NAME;
                break;
            case CARD_ALL_REGS:
                table = CARD_TABLE_NAME;
                break;
        }
        int rows = sqlDB.delete(table, selection, selectionArgs);
        if (rows > 0) {
            getContext().getContentResolver().notifyChange(uri, null); //notifica a los de esa uri
            return rows;
        }
        throw new SQLException("Failed to delete row into " + uri);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String query = null;

        switch (sUriMatcher.match(uri)) {
            case CARD_ONE_REG:
                if (null == selection) selection = "";
                selection += Contract.Card._ID + " = "
                        + uri.getLastPathSegment();
                qb.setTables(CARD_TABLE_NAME);
                break;
            case CARD_ALL_REGS:
                if (TextUtils.isEmpty(sortOrder)) sortOrder =
                        Contract.Card._ID + " ASC";
                qb.setTables(CARD_TABLE_NAME);
                break;
        }

        Cursor c;
        c = qb.query(db, projection, selection, selectionArgs, null, null,
                sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);  //aquí se notifica/avisa a todos los suscritos a esa URI

        return c;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {

        //SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        //SQLiteDatabase db = dbHelper.getWritableDatabase();

        sqlDB = dbHelper.getWritableDatabase();
        // insert record in user table and get the row number of recently inserted record


        String query = null;
        String table = "";
        switch (sUriMatcher.match(uri)) {
            case CARD_ONE_REG:
                if (null == selection) selection = "";
                selection += Contract.Card._ID + " = "
                        + uri.getLastPathSegment();
                table = CARD_TABLE_NAME;
                break;
            case CARD_ALL_REGS:
                table = CARD_TABLE_NAME;
                break;
        }

        int rows = sqlDB.update(table, values, selection, selectionArgs);
        if (rows > 0) {
            getContext().getContentResolver().notifyChange(uri, null); //notifica a los de esa uri

            return rows;
        }
        throw new SQLException("Failed to update row into " + uri);
    }

}
