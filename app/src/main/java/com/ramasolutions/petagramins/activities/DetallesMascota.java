package com.ramasolutions.petagramins.activities;

import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ramasolutions.petagramins.R;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class DetallesMascota extends AppCompatActivity {

    public static final String KEY_EXTRA_URL = "url";
    public static final String KEY_EXTRA_LIKES = "likes";
    private ImageView ivPetDetailPic;
    private TextView tvDetailLikes;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_photo);

        Toolbar toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle extras = getIntent().getExtras();
        String url = extras.getString(KEY_EXTRA_URL);
        int likes = extras.getInt(KEY_EXTRA_LIKES);

        ivPetDetailPic = findViewById(R.id.ivDetailPetPic);

        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.perro_cuatro)
                .into(ivPetDetailPic);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slide = new Slide(Gravity.TOP);
            slide.setDuration(500);


            getWindow().setEnterTransition(slide);

            getWindow().setReturnTransition(new Fade());
        } else {

        }

        tvDetailLikes = findViewById(R.id.tvDetailLikes);

        tvDetailLikes.setText(String.valueOf(likes));
    }
}
