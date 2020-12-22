package com.coursera.pets.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coursera.pets.R;
import com.coursera.pets.pojo.Favorite;

import java.util.ArrayList;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>{

    public FavoritesAdapter(ArrayList<Favorite> favorites, Activity activity) {
        this.favorites = favorites;
        this.activity = activity;
    }

    ArrayList<Favorite> favorites;
    Activity activity;


    @NonNull
    @Override
    public FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_favorites_pets, parent, false);
        return new FavoritesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesViewHolder holder, int position) {
        Favorite favorite = favorites.get(position);
        holder.ivPetFavorite.setImageResource(favorite.getIvPetFavorites());
        holder.tvNameFavorite.setText(favorite.getTvNameFavorite());
        holder.tvRatingFavorite.setText(String.valueOf(favorite.getTvRatingFavorite()));
    }

    @Override
    public int getItemCount() {
        return favorites.size();
    }

    public static class FavoritesViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPetFavorite;
        private TextView tvNameFavorite, tvRatingFavorite;

        public FavoritesViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPetFavorite       = (ImageView) itemView.findViewById(R.id.ivPetFavorite);
            tvNameFavorite      = (TextView) itemView.findViewById(R.id.tvNameFavorite);
            tvRatingFavorite    = (TextView) itemView.findViewById(R.id.tvRatingFavorite);
        }
    }

}
