package com.example.rosa.enjoyarts.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;

import com.example.rosa.enjoyarts.pojos.Card;

public class CardProvider {

    public static void insert(ContentResolver resolver, Card card){

        Uri uri = Contract.Card.CONTENT_URI;

        ContentValues values = new ContentValues();
        values.put(Contract.Card.ARTIST, card.getArtist());
        values.put(Contract.Card.TITLE, card.getTitle());
        values.put(Contract.Card.YEAR, card.getYear());
        values.put(Contract.Card.LOCATION, card.getLocation());

        resolver.insert(uri,values);
    }

}
