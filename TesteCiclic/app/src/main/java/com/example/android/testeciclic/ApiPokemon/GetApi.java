package com.example.android.testeciclic.ApiPokemon;

import com.example.android.testeciclic.Model.ListCards;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetApi {

    @GET ("cards")
    Call<ListCards> getAllCards();


}
