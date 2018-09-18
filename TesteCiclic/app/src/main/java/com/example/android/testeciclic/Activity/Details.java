package com.example.android.testeciclic.Activity;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.android.testeciclic.R;

public class Details extends AppCompatActivity {

    Context context;
    TextView name;
    ImageView imageView;
    Button mInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        final String nameCards = getIntent().getExtras().getString("name");

        name = (TextView) findViewById(R.id.nomeCards);

        imageView = (ImageView) findViewById(R.id.imageViewD);

        final String image = getIntent().getExtras().getString("imageUrl");

        final String life = getIntent().getExtras().getString("hp");

        final String numero = getIntent().getExtras().getString("number");

        Glide.with(this)
                .load(image)
                .placeholder(R.drawable.loading)
                .into(imageView);
                 mInfo = (Button) findViewById(R.id.moreInfo);




        mInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alerta = new AlertDialog.Builder(Details.this);
                alerta.setTitle("   "+nameCards);
                alerta.setIcon(R.drawable.icon_pokemon)
                        .setMessage("Esse pokémon possui " + life + " de HP e seu número da pokédex é " +  numero + ".")
                        .setCancelable(true)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Details.this, MainActivity.class);
                                startActivity(intent);
                            }
                        });

                AlertDialog alertaDialog = alerta.create();
                alertaDialog.show();

            }
        });

        getSupportActionBar().setTitle(nameCards);


    }



}
