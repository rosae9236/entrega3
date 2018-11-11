package com.example.rosa.enjoyarts.card;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toolbar;
import com.example.rosa.enjoyarts.R;
import com.example.rosa.enjoyarts.constants.constant;
import com.example.rosa.enjoyarts.pojos.Card;
import com.example.rosa.enjoyarts.provider.CardProvider;

import java.util.regex.Pattern;

public class MainCRUD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_crud);


        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_crud);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

/*
           editTextArtist.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editTextArtist.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
             });
            editTextTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editTextTitle.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
             });
            editTextYear.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editTextYear.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
               });
            editTextLocation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editTextLocation.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
            });
*/

    }

/*
    private boolean validateArtist(String artist ) {
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        if (!patron.matcher(artist).matches() || artist.length() > 30) {
            editTextArtist.setError("Nombre no válido");
            return false;
        } else {
            editTextArtist.setError(null);
        }
        return true;
    }

    private boolean validateTitle (String title ) {
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        if (!patron.matcher(title).matches() || title.length() > 30) {
            editTextTitle.setError("Nombre no válido");
            return false;
        } else {
            editTextTitle.setError(null);
        }
        return true;
    }

    private boolean validateLocation (String location ) {
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        if (!patron.matcher(location).matches() ||location.length() > 30) {
            editTextLocation.setError("Nombre no válido");
            return false;
        } else {
            editTextLocation.setError(null);
        }
        return true;


}
*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.add(Menu.NONE, constant.SAVE, Menu.NONE, "Save");
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menuItem.setIcon(R.drawable.ic_save_black_24dp);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case constant.SAVE:
                attemptSave();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void attemptSave() {

        EditText editTextArtits = (EditText) findViewById(R.id.editTextArtist);
        EditText editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        EditText editTextYear = (EditText) findViewById(R.id.editTextYear);
        EditText editTextLocation = (EditText) findViewById(R.id.editTextLocation);

        editTextArtits.setError(null);
        editTextTitle.setError(null);
        editTextYear.setError(null);
        editTextLocation.setError(null);

        String artist = String.valueOf(editTextArtits.getText());
        String title = String.valueOf(editTextTitle.getText());
        String year = String.valueOf(editTextYear.getText());
        String location = String.valueOf(editTextLocation.getText());


        if (TextUtils.isEmpty(artist)) {
            editTextArtits.setError(getString(R.string.error_campo_obligatorio));
            editTextArtits.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(title)) {
            editTextTitle.setError(getString(R.string.error_campo_obligatorio));
            editTextTitle.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(year)) {
            editTextYear.setError(getString(R.string.error_campo_obligatorio));
            editTextYear.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(location)) {
            editTextLocation.setError(getString(R.string.error_campo_obligatorio));
            editTextLocation.requestFocus();
            return;
        }

        Card card = new Card(constant.SIN_VALOR_INT, artist, title, year, location);
        CardProvider.insert(getContentResolver(), card);
        finish();

    }

}