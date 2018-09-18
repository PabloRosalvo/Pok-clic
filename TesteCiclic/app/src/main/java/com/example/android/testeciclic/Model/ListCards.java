package com.example.android.testeciclic.Model;

import java.util.ArrayList;

public class ListCards {

    ArrayList<PojoCard> cards;

    public ListCards(ArrayList<PojoCard> cards) {
        this.cards = cards;
    }

    public ArrayList<PojoCard> getCards() {
        return cards;
    }

    public void setCards(ArrayList<PojoCard> cards) {
        this.cards = cards;
    }
}


