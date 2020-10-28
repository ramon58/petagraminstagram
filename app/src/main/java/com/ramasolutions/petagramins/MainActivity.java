package com.ramasolutions.petagramins;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.ramasolutions.petagramins.activities.BiosActivity;
import com.ramasolutions.petagramins.activities.ConfigurarCuentaActivity;
import com.ramasolutions.petagramins.activities.ContactoActivity;
import com.ramasolutions.petagramins.activities.MisFavoritos;
import com.ramasolutions.petagramins.main.SectionsPagerAdapter;
import com.ramasolutions.petagramins.pojo.ProfileItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public static ArrayList<ProfileItem> profileItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "¡Tomar fotografía!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                Object value = getIntent().getExtras().get(key);
                Log.d(TAG, "Key: " + key + " Value: " + value);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {

            case R.id.action_contact:
                Intent goToContact = new Intent(MainActivity.this, ContactoActivity.class);
                startActivity(goToContact);
                break;

            case R.id.action_about:
                Intent goToBios = new Intent(MainActivity.this, BiosActivity.class);
                startActivity(goToBios);
                break;

            case R.id.action_favorites:
                Intent goToFavorites = new Intent(MainActivity.this, MisFavoritos.class);
                startActivity(goToFavorites);
                break;

            case R.id.action_configurar:
                Intent goToConfigurar = new Intent(MainActivity.this, ConfigurarCuentaActivity.class);
                startActivity(goToConfigurar);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}