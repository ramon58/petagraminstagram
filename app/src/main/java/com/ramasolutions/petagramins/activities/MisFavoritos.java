package com.ramasolutions.petagramins.activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ramasolutions.petagramins.R;
import com.ramasolutions.petagramins.adapter.FavAdapter;

import com.ramasolutions.petagramins.pojo.FavItem;
import com.ramasolutions.petagramins.db.Database;

import java.util.ArrayList;
import java.util.List;

public class MisFavoritos extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Database database;
    private List<FavItem> favItemList = new ArrayList<>();
    public FavAdapter favAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        Toolbar toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        database = new Database(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        loadData();

    }

    private void loadData() {
        if (favItemList != null) {
            favItemList.clear();
        }
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = database.select_all_favorite_list();
        try {
            while (cursor.moveToNext()) {
                String petName = cursor.getString(cursor.getColumnIndex(Database.PET_NAME));
                String id = cursor.getString(cursor.getColumnIndex(Database.KEY_ID));
                int petPic = Integer.parseInt(cursor.getString(cursor.getColumnIndex(Database.PET_PIC)));
                FavItem favItem = new FavItem(petPic, petName, id);
                favItemList.add(favItem);
            }
        } finally {

            if (cursor != null && cursor.isClosed()) {
                cursor.close();
            db.close();
            }

            favAdapter = new FavAdapter(this, favItemList);

            recyclerView.setAdapter(favAdapter);
        }
    }
}