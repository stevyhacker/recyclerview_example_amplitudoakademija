package me.amplitudo.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class PlanetsAdapter extends RecyclerView.Adapter<PlanetsAdapter.PlanetViewHolder> {

    private Context context;
    private ArrayList<Planet> planets;

    public PlanetsAdapter(Context context, ArrayList<Planet> planets) {
        this.context = context;
        this.planets = planets;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.planet_item, parent, false);
        return new PlanetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        final Planet planet = planets.get(position);

        holder.planetNameTxtView.setText(planet.getName());

        Glide.with(context)
                .load(planet.getImage())
                .into(holder.planetImgView);

        holder.planetNameTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, planet.getImage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    static class PlanetViewHolder extends ViewHolder {

        TextView planetNameTxtView;
        ImageView planetImgView;

        PlanetViewHolder(@NonNull View itemView) {
            super(itemView);
            planetNameTxtView = itemView.findViewById(R.id.planet_name);
            planetImgView = itemView.findViewById(R.id.planet_img);
        }
    }

}
