package me.amplitudo.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class SinglePlanetDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_planet_details);

        Planet p = getIntent().getParcelableExtra("planet_item");

        ImageView planetImgView = findViewById(R.id.planet_img);
        TextView planetNameTxtView = findViewById(R.id.planet_name);

        planetNameTxtView.setText(p.getName());

        Glide.with(this).load(p.getImage()).into(planetImgView);

    }
}
