package com.coursera.pets.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coursera.pets.R;
import com.coursera.pets.adapters.ProfileAdapter;
import com.coursera.pets.pojo.PetProfile;

import java.util.ArrayList;

public class ProfilePetFragment extends Fragment {

    ArrayList<PetProfile> petsProfile;
    RecyclerView rvPetProfile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_pet, container, false);

        rvPetProfile = (RecyclerView) view.findViewById(R.id.rvPetProfile);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        rvPetProfile.setLayoutManager(glm);

        beginProfiles();
        beginAdapterProfile();

        return view;
    }

    public void beginProfiles(){
        petsProfile = new ArrayList<>();
        petsProfile.add(new PetProfile(R.drawable.horse1, "8"));
        petsProfile.add(new PetProfile(R.drawable.horse2, "5"));
        petsProfile.add(new PetProfile(R.drawable.horse3, "2"));
        petsProfile.add(new PetProfile(R.drawable.horse4, "9"));
        petsProfile.add(new PetProfile(R.drawable.horse5, "3"));
        petsProfile.add(new PetProfile(R.drawable.horse6, "10"));
    }

    public ProfileAdapter profileAdapter;
    private void beginAdapterProfile(){
        profileAdapter = new ProfileAdapter(petsProfile, getActivity());
        rvPetProfile.setAdapter(profileAdapter);
    }
}