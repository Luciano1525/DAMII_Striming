package com.example.striming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Peliculas extends AppCompatActivity {
    private TextView tvPelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);
        //Activar Toolbar
        setSupportActionBar(findViewById(R.id.toolbar));

        tvPelicula = (TextView) findViewById(R.id.tvPelicula);

        SharedPreferences Peli = getSharedPreferences("Pelicula", Context.MODE_PRIVATE);
        String PeliSelect = Peli.getString("PeliculaSelect", "Pelicula No Existente");

        if (PeliSelect.equals("Frozen")) {
            String PeliculaSelects = "Frozen II";
            tvPelicula.setText(PeliculaSelects);

        } else if (PeliSelect.equals("Enredados")) {
            String PeliculaSelects = "Enredados";
            tvPelicula.setText(PeliculaSelects);

        } else if (PeliSelect.equals("Ready")) {
            String PeliculaSelects = "Ready Player One: comienza el juego";
            tvPelicula.setText(PeliculaSelects);

        } else if (PeliSelect.equals("Pixeles")) {
            String PeliculaSelects = "Pixeles";
            tvPelicula.setText(PeliculaSelects);

        } else if (PeliSelect.equals("Anabelle")) {
            String PeliculaSelects = "Annabelle";
            tvPelicula.setText(PeliculaSelects);

        } else if (PeliSelect.equals("Conjuro")) {
            String PeliculaSelects = "El Conjuro";
            tvPelicula.setText(PeliculaSelects);

        } else {
            String PeliculaSelects = "No existe Pelicula";
            tvPelicula.setText(PeliculaSelects);

        }



    }
}