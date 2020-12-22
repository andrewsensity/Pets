package com.coursera.pets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.coursera.pets.adapters.FavoritesAdapter;
import com.coursera.pets.pojo.Favorite;
import com.coursera.pets.pojo.Pet;

import java.util.ArrayList;

public class FavoritesPets extends AppCompatActivity {

    RecyclerView rvFavorites;
    ArrayList<Favorite> favorites;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites_pets);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        favorites = new ArrayList<>();
        favorites.add(new Favorite(R.drawable.dolphin, "Jon Snow", 10));
        favorites.add(new Favorite(R.drawable.grampus, "Khal Drogo", 3));
        favorites.add(new Favorite(R.drawable.eagle, "Sansa Stark", 6));
        favorites.add(new Favorite(R.drawable.horse, "Arya Stark", 2));
        favorites.add(new Favorite(R.drawable.bear, "Hodor", 1));

        rvFavorites = (RecyclerView) findViewById(R.id.rvFavorites);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        FavoritesAdapter adapter = new FavoritesAdapter(favorites, this);

        rvFavorites.setLayoutManager(llm);
        rvFavorites.setAdapter(adapter);
    }
}