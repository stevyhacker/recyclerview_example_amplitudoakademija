package me.amplitudo.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner planetsSpinner = (Spinner) findViewById(R.id.spinner);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, R.layout.custom_spinner_item);

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.custom_spinner_item);

// Apply the adapter to the spinner
        planetsSpinner.setAdapter(adapter);

        RecyclerView planetsRecyclerView = findViewById(R.id.planetsRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        planetsRecyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<Planet> planets = new ArrayList<>();

        planets.add(new Planet("Namek", "https://vignette.wikia.nocookie.net/animecross2roblox/images/e/eb/Base_Goku.png"));
        planets.add(new Planet("Zemlja", "https://vignette.wikia.nocookie.net/animecross2roblox/images/e/eb/Base_Goku.png"));
        planets.add(new Planet("Vegeta", "https://vignette.wikia.nocookie.net/animecross2roblox/images/e/eb/Base_Goku.png"));

        PlanetsAdapter planetsAdapter = new PlanetsAdapter(this, planets);
        planetsRecyclerView.setAdapter(planetsAdapter);

        planets.add(new Planet("Test", "test.png"));
        adapter.notifyDataSetChanged();


    }

}
