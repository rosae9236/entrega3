package com.example.rosa.enjoyarts.provider;

import android.net.Uri;
import android.provider.BaseColumns;

public class Contract {

    public static final String AUTHORITY = "com.example.rosa.enjoyarts.provider.ContentProviderArt";

    public static final class Card implements BaseColumns {     //recurso, tabla dentro del proveedor de contenido

        public static final Uri CONTENT_URI = Uri
                .parse("content://"+AUTHORITY+"/Card");

        //Table columns
        public static final String ARTIST = "artist";
        public static final String TITLE = "title";
        public static final String YEAR = "year";
        public static final String LOCATION = "location";
    }

}
