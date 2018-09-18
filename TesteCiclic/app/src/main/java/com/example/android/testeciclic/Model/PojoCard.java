package com.example.android.testeciclic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoCard {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("hp")
    private String hp;

    @SerializedName("number")
    private String number;

    public PojoCard(String name, String imageUrl, String hp, String number) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.hp = hp;
        this.number = number;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
