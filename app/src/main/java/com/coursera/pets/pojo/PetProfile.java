package com.coursera.pets.pojo;

public class PetProfile {

    private int ivPetProfile;
    private String tvRatingProfile;

    public PetProfile(int ivPetProfile, String tvRatingProfile) {
        this.ivPetProfile = ivPetProfile;
        this.tvRatingProfile = tvRatingProfile;
    }

    public int getIvPetProfile() {
        return ivPetProfile;
    }

    public void setIvPetProfile(int ivPetProfile) {
        this.ivPetProfile = ivPetProfile;
    }

    public String getTvRatingProfile() {
        return tvRatingProfile;
    }

    public void setTvRatingProfile(String tvRatingProfile) { this.tvRatingProfile = tvRatingProfile; }
}
