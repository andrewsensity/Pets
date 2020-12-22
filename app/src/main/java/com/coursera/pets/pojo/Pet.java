package com.coursera.pets.pojo;

public class Pet {

    private int ivPet, ivBoneWhite, ivBoneOrange;
    private String tvName;
    private int id, tvRating;

    public Pet(int ivPet, String tvName, int id) {
        this.ivPet = ivPet;
        this.tvName = tvName;
        this.id = id;
    }

    public Pet() {

    }

    public int getIvPet() {
        return ivPet;
    }

    public void setIvPet(int ivPet) {
        this.ivPet = ivPet;
    }

    public int getIvBoneWhite() {
        return ivBoneWhite;
    }

    public void setIvBoneWhite(int ivBoneWhite) {
        this.ivBoneWhite = ivBoneWhite;
    }

    public int getIvBoneOrange() {
        return ivBoneOrange;
    }

    public void setIvBoneOrange(int ivBoneOrange) {
        this.ivBoneOrange = ivBoneOrange;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public int getTvRating() {
        return tvRating;
    }

    public void setTvRating(int tvRating) { this.tvRating = tvRating; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
}
