package com.coursera.pets.pojo;

public class Favorite {

    private int ivPetFavorites;
    private String tvNameFavorite;
    private int tvRatingFavorite;

    public Favorite(int ivPetFavorites, String tvNameFavorite, int tvRatingFavorite) {
        this.ivPetFavorites = ivPetFavorites;
        this.tvNameFavorite = tvNameFavorite;
        this.tvRatingFavorite = tvRatingFavorite;
    }

    public int getIvPetFavorites() {
        return ivPetFavorites;
    }

    public void setIvPetFavorites(int ivPetFavorites) {
        this.ivPetFavorites = ivPetFavorites;
    }

    public String getTvNameFavorite() {
        return tvNameFavorite;
    }

    public void setTvNameFavorite(String tvNameFavorite) {
        this.tvNameFavorite = tvNameFavorite;
    }

    public int getTvRatingFavorite() {
        return tvRatingFavorite;
    }

    public void setTvRatingFavorite(int tvRatingFavorite) {
        this.tvRatingFavorite = tvRatingFavorite;
    }
}
