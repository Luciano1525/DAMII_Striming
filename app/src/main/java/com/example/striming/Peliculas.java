package com.example.striming;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.MediaController;

public class Peliculas extends AppCompatActivity {
    private VideoView vvPelicula;
    private Button btnSalir;
    private MediaController Control;
    private LinearLayout layoutVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);
        //Activar Toolbar
        setSupportActionBar(findViewById(R.id.toolbar));

        vvPelicula = findViewById(R.id.vvPelicula);
        layoutVideo = findViewById(R.id.layoutVideo);
        SharedPreferences Peli = getSharedPreferences("Pelicula", Context.MODE_PRIVATE);
        String PeliSelect = Peli.getString("PeliculaSelect", "Pelicula No Existente");

        int orientacion = getResources().getConfiguration().orientation;
        if (orientacion == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportActionBar().hide();
        } else getSupportActionBar().show();

        int Video = getVideo(PeliSelect);
        Uri videoU = Uri.parse("android.resource://" + getPackageName() + "/" + Video);

        // Configuracion del controlador del reproductor de video
        Control = new MediaController(this);
        vvPelicula.setMediaController(Control);
        Control.setAnchorView(vvPelicula);

        // Establece la URI del video en el VideoView
        vvPelicula.setVideoURI(videoU);

        // Inicia la reproducción del video
        vvPelicula.start();

        //Boton para salir
        btnSalir = (Button) findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("INFO:", "Pelicula");
                Intent intent = new Intent(Peliculas.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


    private int getVideo(String PeliSelect) {
        switch (PeliSelect) {
            case "frozendos":
                return R.raw.frozendos;
            case "enredadospeli":
                return R.raw.enredadospeli;
            case "readyplayer":
                return R.raw.readyplayer;
            case "pixelespeli":
                return R.raw.pixelespeli;
            case "annable":
                return R.raw.annable;
            case "elconjuro":
                return R.raw.elconjuro;
            default:
                return 0;
        }

    }


}