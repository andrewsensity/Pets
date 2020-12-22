package com.coursera.pets.dataBase;

import android.content.ContentValues;
import android.content.Context;

import com.coursera.pets.R;
import com.coursera.pets.pojo.Pet;

import java.util.ArrayList;

public class ConstructorPets {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorPets(Context context) {
        this.context = context;
    }

    public ArrayList<Pet> getData(){
        DataBase dataBase = new DataBase(context);
        insertFivePets(dataBase);
        return dataBase.getAllPets();
    }

    public void insertFivePets(DataBase dataBase){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantsDataBase.TABLE_PETS_ID, 1);
        contentValues.put(ConstantsDataBase.TABLE_PETS_NAME, "Arya Stark");
        contentValues.put(ConstantsDataBase.TABLE_PETS_FOTO, R.drawable.horse);
        dataBase.insertPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantsDataBase.TABLE_PETS_ID, 2);
        contentValues.put(ConstantsDataBase.TABLE_PETS_NAME, "Hodor");
        contentValues.put(ConstantsDataBase.TABLE_PETS_FOTO, R.drawable.bear);
        dataBase.insertPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantsDataBase.TABLE_PETS_ID, 3);
        contentValues.put(ConstantsDataBase.TABLE_PETS_NAME, "Jon Snow");
        contentValues.put(ConstantsDataBase.TABLE_PETS_FOTO, R.drawable.dolphin);
        dataBase.insertPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantsDataBase.TABLE_PETS_ID, 4);
        contentValues.put(ConstantsDataBase.TABLE_PETS_NAME, "Sansa Stark");
        contentValues.put(ConstantsDataBase.TABLE_PETS_FOTO, R.drawable.eagle);
        dataBase.insertPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantsDataBase.TABLE_PETS_ID, 5);
        contentValues.put(ConstantsDataBase.TABLE_PETS_NAME, "Khal Drogo");
        contentValues.put(ConstantsDataBase.TABLE_PETS_FOTO, R.drawable.grampus);
        dataBase.insertPet(contentValues);
    }

    public void giveLike(Pet pet){
        DataBase dataBase = new DataBase(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantsDataBase.TABLE_RATING_PETS_ID_PETS, pet.getId());
        contentValues.put(ConstantsDataBase.TABLE_RATING_PETS_NUMBER_LIKES, LIKE);
        dataBase.insertLikePet(contentValues);
    }

    public int getLikesPet(Pet pet){
        DataBase dataBase = new DataBase(context);
        return dataBase.getRatingPet(pet);
    }
}
