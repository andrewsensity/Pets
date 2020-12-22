package com.coursera.pets.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coursera.pets.R;
import com.coursera.pets.adapters.PetAdapter;
import com.coursera.pets.pojo.Pet;
import com.coursera.pets.presenters.IRecyclerViewFragmentPresenter;
import com.coursera.pets.presenters.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerviewFragment extends Fragment implements IRecycleviewFragmentView{

    private ArrayList<Pet> pets;
    private RecyclerView recyclerView;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rvPet);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return view;
    }

    @Override
    public void generateLinearLayoutVertical() {
        LinearLayoutManager linearLayout = new LinearLayoutManager(getActivity());
        linearLayout.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayout);
    }

    @Override
    public PetAdapter createAdapter(ArrayList<Pet> pets) {
        PetAdapter adapter = new PetAdapter(pets, getActivity());
        return adapter;
    }

    @Override
    public void beginAdapterRV(PetAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}