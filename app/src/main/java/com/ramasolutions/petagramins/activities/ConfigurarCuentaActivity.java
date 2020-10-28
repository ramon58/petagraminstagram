package com.ramasolutions.petagramins.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ramasolutions.petagramins.MainActivity;
import com.ramasolutions.petagramins.R;

import java.util.Objects;


public class ConfigurarCuentaActivity extends AppCompatActivity {
    private EditText inNombreUsuario;
    private Button btnGuardar;
    String NombreCTA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);

        Toolbar toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        inNombreUsuario = (EditText) findViewById(R.id.inNombreUsuario);

        guardarDatos();

    }

    public void guardarDatos(){

        btnGuardar = (Button) findViewById(R.id.buttonGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        NombreCTA = inNombreUsuario.getText().toString();
        Toast.makeText(ConfigurarCuentaActivity.this, NombreCTA+" Se a guardado", Toast.LENGTH_SHORT).show();

              }
           }
        );
    }

    public String getNombreCuenta(){

        if (NombreCTA == null){
            NombreCTA="ramon583";
        }
        return NombreCTA;

    }
    //Codigo para en caso que el usuario presione el boton back, reconstruir el activity main
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(ConfigurarCuentaActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
