package com.example.bardouni.animalview;

/**
 * Created by bardouni on 5/8/2016.
 */

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("publisher")
    public String publicher;

    @SerializedName("image")
    public String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublicher() {
        return publicher;
    }

    public void setPublicher(String publicher) {
        this.publicher = publicher;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
