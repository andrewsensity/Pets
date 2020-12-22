package com.coursera.pets.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.coursera.pets.pojo.Pet;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper{

    private Context context;

    public DataBase(@Nullable Context context) {
        super(context, ConstantsDataBase.DATABASE_NAME, null, ConstantsDataBase.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String queryCreateTablePets = "CREATE TABLE " + ConstantsDataBase.TABLE_PETS + "(" +
                                    ConstantsDataBase.TABLE_PETS_ID     + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    ConstantsDataBase.TABLE_PETS_NAME   + " TEXT," +
                                    ConstantsDataBase.TABLE_PETS_FOTO   + " INTEGER" +
                                    ")";

        String queryCreateTableRating = "CREATE TABLE " + ConstantsDataBase.TABLE_RATINGS_PETS  + "(" +
                                    ConstantsDataBase.TABLE_RATING_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    ConstantsDataBase.TABLE_RATING_PETS_ID_PETS + " INTEGER, " +
                                    ConstantsDataBase.TABLE_RATING_PETS_NUMBER_LIKES + " INTEGER, " +
                                    "FOREIGN KEY ("+ ConstantsDataBase.TABLE_RATING_PETS_ID_PETS + ") " +
                                    "REFERENCES " + ConstantsDataBase.TABLE_PETS + "(" + ConstantsDataBase.TABLE_PETS_ID + ")" +
                                    ")";
        database.execSQL(queryCreateTablePets);
        database.execSQL(queryCreateTableRating);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantsDataBase.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantsDataBase.TABLE_RATINGS_PETS);
        onCreate(db);
    }

    public ArrayList<Pet> getAllPets(){
        ArrayList<Pet> pets = new ArrayList<Pet>();

        String query = "SELECT * FROM " + ConstantsDataBase.TABLE_PETS;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor registers = database.rawQuery(query, null);

        while (registers.moveToNext()){
            Pet petsActual = new Pet();
            petsActual.setId(registers.getInt(0));
            petsActual.setTvName(registers.getString(1));
            petsActual.setIvPet(registers.getInt(2));

            String queryRating = "SELECT COUNT(" + ConstantsDataBase.TABLE_RATING_PETS_NUMBER_LIKES + ") as rating " +
                                " FROM " + ConstantsDataBase.TABLE_RATINGS_PETS +
                                " WHERE " + ConstantsDataBase.TABLE_RATING_PETS_ID_PETS + "=" + petsActual.getId();

            Cursor registersRating = database.rawQuery(queryRating, null);

            //petsActual.setTvRating(registersRating.getInt(0));
            if (registersRating.moveToNext()){
                petsActual.setTvRating(registersRating.getInt(0));
            }else{
                petsActual.setTvRating(0);
            }

            pets.add(petsActual);
        }

        database.close();

        return pets;
    }

    public void insertPet(ContentValues contentValues){
        SQLiteDatabase database = this.getWritableDatabase();
        database.insert(ConstantsDataBase.TABLE_PETS, null, contentValues);
        database.close();
    }

    public void insertLikePet(ContentValues contentValues){
        SQLiteDatabase database = this.getWritableDatabase();
        database.insert(ConstantsDataBase.TABLE_RATINGS_PETS , null, contentValues);
        database.close();
    }

    public int getRatingPet(Pet pet){
        int rating = 0;
        String query = "SELECT COUNT(" + ConstantsDataBase.TABLE_RATING_PETS_NUMBER_LIKES + ")" +
                " FROM " + ConstantsDataBase.TABLE_RATINGS_PETS  +
                " WHERE " + ConstantsDataBase.TABLE_RATING_PETS_ID_PETS + "=" + pet.getId();

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor registers = database.rawQuery(query, null);

        if (registers.moveToNext()){
            rating = registers.getInt(0);
        }

        database.close();

        return rating;
    }
}
