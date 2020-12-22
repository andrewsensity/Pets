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
import com.coursera.pets.pojo.PetProfile;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {

    public ProfileAdapter(ArrayList<PetProfile> petsProfile, Activity activity) {
        this.petsProfile = petsProfile;
        this.activity   = activity;
    }

    ArrayList<PetProfile> petsProfile;
    Activity activity;

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_profile, parent, false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        PetProfile petProfile = petsProfile.get(position);
        holder.tvRatingProfile.setText(String.valueOf(petProfile.getTvRatingProfile()));
        holder.ivPetProfile.setImageResource(petProfile.getIvPetProfile());
    }

    @Override
    public int getItemCount() {
        return petsProfile.size();
    }

    public static class ProfileViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivPetProfile;
        private TextView tvRatingProfile;

        public ProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPetProfile    = (ImageView) itemView.findViewById(R.id.ivPetProfile);
            tvRatingProfile = (TextView) itemView.findViewById(R.id.tvRatingProfile);
        }
    }
}
