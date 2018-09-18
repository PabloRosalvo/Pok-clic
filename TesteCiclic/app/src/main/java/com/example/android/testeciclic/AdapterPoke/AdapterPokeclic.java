package com.example.android.testeciclic.AdapterPoke;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.testeciclic.Activity.Details;
import com.example.android.testeciclic.Activity.MainActivity;
import com.example.android.testeciclic.Model.PojoCard;
import com.example.android.testeciclic.R;

import java.util.ArrayList;

public class AdapterPokeclic extends RecyclerView.Adapter<AdapterPokeclic.PokemonViewHolder> {

    ArrayList<PojoCard> listaCards;

    Context context;

    public AdapterPokeclic(ArrayList<PojoCard> listaCards, Context context) {
        this.listaCards = listaCards;
        this.context = context;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_poke, parent, false);
        return new AdapterPokeclic.PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPokeclic.PokemonViewHolder holder, int position) {
       holder.nomeCards.setText(listaCards.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {

       TextView nomeCards;


        public PokemonViewHolder(View itemView) {
            super(itemView);

         nomeCards = (TextView) itemView.findViewById(R.id.nomeCards);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {

                        Intent intent = new Intent(context, Details.class);

                        intent.putExtra("imageUrl", listaCards.get(position).getImageUrl());


                        intent.putExtra("name", listaCards.get(position).getName());

                        intent.putExtra("hp", listaCards.get(position).getHp());

                        intent.putExtra("number", listaCards.get(position).getNumber());

                        context.startActivity(intent);
                    }
                }
            });

        }
    }
}
