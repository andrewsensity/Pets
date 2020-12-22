package com.coursera.pets.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coursera.pets.R;
import com.coursera.pets.dataBase.ConstructorPets;
import com.coursera.pets.pojo.Pet;

import java.util.ArrayList;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder>{

    public PetAdapter(ArrayList<Pet> pets, Activity activity) {
        this.pets = pets;
        this.activity = activity;
    }

    ArrayList<Pet> pets;
    Activity activity;

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet, parent, false);
        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewHolder holder, int position) {
        Pet pet = pets.get(position);
        holder.ivPet.setImageResource(pet.getIvPet());
        holder.tvName.setText(String.valueOf(pet.getTvName()));

        holder.ivBoneWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "You like " + holder.tvName.getText(), Toast.LENGTH_SHORT).show();

                ConstructorPets constructorPets = new ConstructorPets(activity);
                constructorPets.giveLike(pet);

                holder.tvRating.setText(String.valueOf(constructorPets.getLikesPet(pet)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivPet, ivBoneWhite, ivBoneOrange;
        private TextView tvName, tvRating;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPet =         (ImageView) itemView.findViewById(R.id.ivPet);
            tvName =        (TextView) itemView.findViewById(R.id.tvName);
            tvRating =      (TextView) itemView.findViewById(R.id.tvRating);
            ivBoneWhite =   (ImageView) itemView.findViewById(R.id.ivBoneWhite);
            ivBoneOrange =  (ImageView) itemView.findViewById(R.id.ivBoneOrange);
        }
    }
}
