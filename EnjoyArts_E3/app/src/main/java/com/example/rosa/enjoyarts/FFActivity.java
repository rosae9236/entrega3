package com.example.rosa.enjoyarts;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class FFActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ff);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Referencias editText
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);

        /*comprobación en tiempo real del texto que contiene un EditText,
         entonces asigna una escucha TextWatcher con el método addTextChangedListener().
         Para que los errores se limpien al momento de escribir una caracter en el campo del nombre,
         se usa setError(null) en el controlador onTextChanged().*/

            editTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editTextName.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

         /*Si quieres comprobar el campo del correo cada vez que se escriba, entonces llama al método de validación en onTextChanged().*/

         editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateEmail(String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Button buttonValidate = (Button) findViewById(R.id.buttonValidate);
        buttonValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });
    }

    private boolean validateName(String name) {
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        if (!patron.matcher(name).matches() || name.length() > 30) {
            editTextName.setError("Nombre no válido");
            return false;
        } else {
            editTextName.setError(null);
        }
        return true;
    }

    private boolean validateEmail(String email) {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Correo electrónico no válido");
            return false;
        } else {
            editTextEmail.setError(null);
        }
        return true;
    }


    private void validateData() {
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();

        if  (TextUtils.isEmpty(name)){
            editTextName.setError(getString(R.string.error_campo_obligatorio));
            editTextName.requestFocus();
            return;}

        boolean n = validateName(name);
        boolean em = validateEmail(email);

        if (n && em) {
            // OK, se pasa a la siguiente acción
            Toast.makeText(this, "Se guarda el registro", Toast.LENGTH_LONG).show();

        }

    }
}