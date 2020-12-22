package com.coursera.pets.fragments;

import com.coursera.pets.adapters.PetAdapter;
import com.coursera.pets.pojo.Pet;

import java.util.ArrayList;

public interface IRecycleviewFragmentView {

    public void generateLinearLayoutVertical();

    public PetAdapter createAdapter(ArrayList<Pet> pets);

    public void beginAdapterRV(PetAdapter adapter);

}
