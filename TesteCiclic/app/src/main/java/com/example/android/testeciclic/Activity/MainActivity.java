package com.example.android.testeciclic.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import com.example.android.testeciclic.AdapterPoke.AdapterPokeclic;
import com.example.android.testeciclic.ApiPokemon.Client;
import com.example.android.testeciclic.ApiPokemon.GetApi;
import com.example.android.testeciclic.Model.ListCards;
import com.example.android.testeciclic.Model.PojoCard;
import com.example.android.testeciclic.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdapterPokeclic adapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetApi service = Client.getClient().create(GetApi.class);

        Call<ListCards> call = service.getAllCards();
        call.enqueue(new Callback<ListCards>() {
            @Override
            public void onResponse(Call<ListCards> call, Response<ListCards> response) {
                generateListCards(response.body().getCards());
            }

            @Override
            public void onFailure(Call<ListCards> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ocorreu um erro, tente mais tarde!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void generateListCards(ArrayList<PojoCard> listCardsR) {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        adapter = new AdapterPokeclic(listCardsR, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

}
