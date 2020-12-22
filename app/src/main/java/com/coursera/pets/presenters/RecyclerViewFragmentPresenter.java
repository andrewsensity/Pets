package com.coursera.pets.presenters;

import android.content.Context;

import com.coursera.pets.dataBase.ConstructorPets;
import com.coursera.pets.fragments.IRecycleviewFragmentView;
import com.coursera.pets.pojo.Pet;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecycleviewFragmentView iRecycleviewFragmentView;
    private Context context;
    private ConstructorPets constructorPets;
    private ArrayList<Pet> pets;

    public RecyclerViewFragmentPresenter(IRecycleviewFragmentView iRecycleviewFragmentView, Context context) {
        this.iRecycleviewFragmentView = iRecycleviewFragmentView;
        this.context = context;
        getPetsBaseData();
    }

    @Override
    public void getPetsBaseData() {
        constructorPets = new ConstructorPets(context);
        pets = constructorPets.getData();
        showPetsRV();
    }

    @Override
    public void showPetsRV() {
        iRecycleviewFragmentView.beginAdapterRV(iRecycleviewFragmentView.createAdapter(pets));
        iRecycleviewFragmentView.generateLinearLayoutVertical();
    }
}
