package com.example.striming;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.MediaController;

import java.io.IOException;

public class Peliculas extends AppCompatActivity {
    private VideoView vvPelicula;
    private Button btnSalir;
    private MediaController Control;
    private ImageView ibtnMePop1, ibtnMePop2;
    private MediaPlayer mediaPlayerV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Recuperar Tema y Aplicarlo
        SharedPreferences TS = getSharedPreferences("Tema", Context.MODE_PRIVATE);
        String TemaSeleccionado = TS.getString("TemaSeleccionado2", "No Hay Tema Aplicado");
        if (TemaSeleccionado != null) {
            if (TemaSeleccionado.equals("Claro")) {
                setTheme(R.style.Theme_Striming);
            } else if (TemaSeleccionado.equals("Oscuro")) {
                setTheme(R.style.Oscuro);
            } else if (TemaSeleccionado.equals("Personalizado1")) {
                setTheme(R.style.MiTema1);
            } else if (TemaSeleccionado.equals("Personalizado2")) {
                setTheme(R.style.MiTema2);
            } else if (TemaSeleccionado.equals("Personalizado3")) {
                setTheme(R.style.MiTema3);
            } else if (TemaSeleccionado.equals("Personalizado4")) {
                setTheme(R.style.MiTema4);
            }
        }
        setContentView(R.layout.activity_peliculas);
        //Activar Toolbar
        setSupportActionBar(findViewById(R.id.toolbar));

        vvPelicula = findViewById(R.id.vvPelicula);
        btnSalir = (Button) findViewById(R.id.btnSalir);

        SharedPreferences Peli = getSharedPreferences("Pelicula", Context.MODE_PRIVATE);
        String PeliSelect = Peli.getString("PeliculaSelect", "Pelicula No Existente");

        mediaPlayerV = new MediaPlayer();

        int orientacion = getResources().getConfiguration().orientation;
        if (orientacion == Configuration.ORIENTATION_LANDSCAPE) {
            btnSalir.setVisibility(View.GONE);
            getSupportActionBar().hide();
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


        } else {
            btnSalir.setVisibility(View.VISIBLE);
            getSupportActionBar().show();

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


        }
        //Boton para salir
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