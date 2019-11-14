package me.amplitudo.myapplication;

import android.content.Context;
import android.content.Intent;
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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class PlanetsAdapter extends RecyclerView.Adapter<ViewHolder> {

    private Context context;
    private ArrayList<Planet> planets;

    public PlanetsAdapter(Context context, ArrayList<Planet> planets) {
        this.context = context;
        this.planets = planets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.planet_item, parent, false);
            return new PlanetViewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.star_item, parent, false);
            return new StarViewHolder(v);
        }
    }

    @Override
    public int getItemViewType(int position) {
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
        return planets.get(position).getViewType();
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Planet planet = planets.get(position);

        if (holder.getItemViewType() == 1) {
            PlanetViewHolder planetViewHolder = (PlanetViewHolder) holder;

            planetViewHolder.planetNameTxtView.setText(planet.getName());

            Picasso.get().load(planet.getImage()).placeholder(R.drawable.ic_launcher_background).into(planetViewHolder.planetImgView);

            planetViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Ovo je Planet view", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, SinglePlanetDetailsActivity.class);
                    intent.putExtra("planet_item", planet);
                    context.startActivity(intent);
                }
            });

        } else {
            StarViewHolder starViewHolder = (StarViewHolder) holder;

            Glide.with(context)
                    .load(planet.getImage())
                    .into(starViewHolder.starImgView);

            starViewHolder.starNameTxtView.setText(planet.getName());

            starViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Ovo je Star view", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, SinglePlanetDetailsActivity.class);
                    intent.putExtra("planet_item", planet);
                    context.startActivity(intent);
                }
            });
        }

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

    static class StarViewHolder extends ViewHolder {

        TextView starNameTxtView;
        ImageView starImgView;

        StarViewHolder(@NonNull View itemView) {
            super(itemView);
            starNameTxtView = itemView.findViewById(R.id.star_name);
            starImgView = itemView.findViewById(R.id.star_img);
        }
    }

}
