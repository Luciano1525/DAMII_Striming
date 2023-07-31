package com.example.striming;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import java.util.Collections;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    private EditText etRegistroU;
    private Spinner spnTipoPerfil;
    private ListView LV;
    private TextView tvTipoUsu, tvUsuarioR, tvCategoria1, tvCategoria2, tvCategoria3;
    private ArrayList<String> Usuarios;
    private ArrayList<String> TipoUsuarios;
    private ArrayAdapter<String> adapter;
    private ImageButton ibntnPeliI1, ibntnPeliI2, ibntnPeliA1, ibntnPeliA2, ibntnPeliAD1, ibntnPeliAD2, ibnMedia;
    private MediaPlayer mediaPlayerM [] = new MediaPlayer[3];
    private boolean isPlaying = false;
    private int posicion;
    private ImageView ibtnMePop;

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
        setContentView(R.layout.activity_main);
        //Activar Toolbar
        setSupportActionBar(findViewById(R.id.toolbar));

        Usuarios = new ArrayList<>();
        TipoUsuarios = new ArrayList<>();

        ibnMedia = (ImageButton) findViewById(R.id.ibnMedia);
        tvTipoUsu = (TextView) findViewById(R.id.tvTipoUsu);
        tvUsuarioR = (TextView) findViewById(R.id.tvUsuarioR);

        SharedPreferences sharedPreferences = getSharedPreferences("MiSharedPreferences", Context.MODE_PRIVATE);
        Set<String> dataSet = sharedPreferences.getStringSet("dataSet", new HashSet<>());
        Usuarios.addAll(dataSet);

        SharedPreferences sharedPreferences1 = getSharedPreferences("MiSharedPreferences1", Context.MODE_PRIVATE);
        Set<String> dataSet1 = sharedPreferences1.getStringSet("dataSet1", new HashSet<>());
        TipoUsuarios.addAll(dataSet1);

        SharedPreferences Usa = getSharedPreferences("Usuario", Context.MODE_PRIVATE);

        String UsuRec = Usa.getString("UsuarioRegis", "No Registrado");
        String TiUsua = Usa.getString("TipoUsuarioR", "Tipo de Usuario Null");
        String[] UsuRe = UsuRec.split("   ");
        String Usua = UsuRe[0]; // Recuperar solo el usuario
        tvUsuarioR.setText(Usua);
        tvTipoUsu.setText(TiUsua);

        tvCategoria1 = (TextView) findViewById(R.id.tvCategoria1);
        tvCategoria2 = (TextView) findViewById(R.id.tvCategoria2);
        tvCategoria3 = (TextView) findViewById(R.id.tvCategoria3);

        ibntnPeliI1 = (ImageButton) findViewById(R.id.ibntnPeliI1);
        ibntnPeliI2 = (ImageButton) findViewById(R.id.ibntnPeliI2);
        ibntnPeliA1 = (ImageButton) findViewById(R.id.ibntnPeliA1);
        ibntnPeliA2 = (ImageButton) findViewById(R.id.ibntnPeliA2);
        ibntnPeliAD1 = (ImageButton) findViewById(R.id.ibntnPeliAD1);
        ibntnPeliAD2 = (ImageButton) findViewById(R.id.ibntnPeliAD2);


        mediaPlayerM[0] = MediaPlayer.create(MainActivity.this, R.raw.babyshark);
        mediaPlayerM[1] = MediaPlayer.create(MainActivity.this, R.raw.voygirando);
        mediaPlayerM[2] = MediaPlayer.create(MainActivity.this, R.raw.suspenso);

        if (TiUsua.equals("Infantil")){
            tvCategoria1.setVisibility(View.VISIBLE);
            ibntnPeliI1.setVisibility(View.VISIBLE);
            ibntnPeliI2.setVisibility(View.VISIBLE);
            tvCategoria2.setVisibility(View.GONE);
            ibntnPeliA1.setVisibility(View.GONE);
            ibntnPeliA2.setVisibility(View.GONE);
            tvCategoria3.setVisibility(View.GONE);
            ibntnPeliAD1.setVisibility(View.GONE);
            ibntnPeliAD2.setVisibility(View.GONE);
            posicion = 0;
            //Pausar y reanudar musica
            mediaPlayerM[posicion].start();

            ibnMedia.setImageResource(R.mipmap.pausa);

        } else if (TiUsua.equals("Adolecente")){
            tvCategoria1.setVisibility(View.VISIBLE);
            ibntnPeliI1.setVisibility(View.VISIBLE);
            ibntnPeliI2.setVisibility(View.VISIBLE);
            tvCategoria2.setVisibility(View.VISIBLE);
            ibntnPeliA1.setVisibility(View.VISIBLE);
            ibntnPeliA2.setVisibility(View.VISIBLE);
            tvCategoria3.setVisibility(View.GONE);
            ibntnPeliAD1.setVisibility(View.GONE);
            ibntnPeliAD2.setVisibility(View.GONE);
            posicion = 1;
            //Pausar y reanudar musica
            mediaPlayerM[posicion].start();

            ibnMedia.setImageResource(R.mipmap.pausa);

        } else if (TiUsua.equals("Adulto")){
            tvCategoria1.setVisibility(View.VISIBLE);
            ibntnPeliI1.setVisibility(View.VISIBLE);
            ibntnPeliI2.setVisibility(View.VISIBLE);
            tvCategoria2.setVisibility(View.VISIBLE);
            ibntnPeliA1.setVisibility(View.VISIBLE);
            ibntnPeliA2.setVisibility(View.VISIBLE);
            tvCategoria3.setVisibility(View.VISIBLE);
            ibntnPeliAD1.setVisibility(View.VISIBLE);
            ibntnPeliAD2.setVisibility(View.VISIBLE);
            posicion = 2;
            //Pausar y reanudar musica
            mediaPlayerM[posicion].start();

            ibnMedia.setImageResource(R.mipmap.pausa);

        } else {
            ibnMedia = (ImageButton) findViewById(R.id.ibnMedia);
        }

        //Boton para pausar y reanudar musica
        ibnMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayerM[posicion].isPlaying()){
                    mediaPlayerM[posicion].pause();
                    ibnMedia.setImageResource(R.mipmap.reproducir);

                } else {
                    mediaPlayerM[posicion].start();
                    ibnMedia.setImageResource(R.mipmap.pausa);
                }

            }
        });

        //Boton Pelicula Infantil 1
        ibntnPeliI1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Metodo
                Frozen();
            }
        });

        //Boton Pelicula Infantil 2
        ibntnPeliI2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Metodo
                Enredados();
            }
        });


        //Boton Pelicula Adolecente 1
        ibntnPeliA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Metodo
                Ready();
            }
        });

        //Boton Pelicula Adolecente 2
        ibntnPeliA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Metodo
                Pixeles();
            }
        });


        //Boton Pelicula Adulto 1
        ibntnPeliAD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Metodo
                Anabelle();
            }
        });

        //Boton Pelicula Adulto 2
        ibntnPeliAD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Metodo
                Conjuro();
            }
        });


    }

    //Metodo para mostrar y ocultar el menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //Metodo de seleccion de opciones
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.MAgregar) {

            //Dialogo de Registro
            AlertDialog.Builder Registro = new AlertDialog.Builder(MainActivity.this);
            Registro.setTitle("Registrar Usuario");
            View selectRegistro = getLayoutInflater().inflate(R.layout.registro, null);
            Registro.setView(selectRegistro);
            Registro.setCancelable(false);
            etRegistroU = (EditText) selectRegistro.findViewById(R.id.etRegistroU);
            spnTipoPerfil = (Spinner) selectRegistro.findViewById(R.id.spnTipoPerfil);

            ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(MainActivity.this, R.array.TipoPerfil, android.R.layout.simple_spinner_item);
            spnTipoPerfil.setAdapter(adapter1);


            Registro.setPositiveButton("Registrar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    //Metodo de registro
                    String ItemSelect = spnTipoPerfil.getSelectedItem().toString();
                    int SelectItem = spnTipoPerfil.getSelectedItemPosition();

                    if (SelectItem == 1){
                        String NombreU1 = etRegistroU.getText().toString();
                        String PerfilSelect1 = spnTipoPerfil.getSelectedItem().toString();
                        String RegistroUs1 = NombreU1 +  "   " + PerfilSelect1;

                        if (!NombreU1.isEmpty()) {
                            Usuarios.add(RegistroUs1);
                            etRegistroU.getText().clear();
                            SharedPreferences sharedPreferences = getSharedPreferences("MiSharedPreferences", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            Set<String> listaGuardada = new HashSet<>(Usuarios);
                            editor.putStringSet("dataSet", listaGuardada);
                            editor.apply();
                            editor.commit();

                            TipoUsuarios.add(PerfilSelect1);
                            SharedPreferences sharedPreferences1 = getSharedPreferences("MiSharedPreferences1", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                            Set<String> listaGuardada1 = new HashSet<>(TipoUsuarios);
                            editor1.putStringSet("dataSet1", listaGuardada1);
                            editor1.apply();
                            editor1.commit();

                        } else {
                            Toast.makeText(getApplicationContext(), "No se puede guardar un registro vacio " + PerfilSelect1, Toast.LENGTH_SHORT).show();
                        }


                    } else if (SelectItem == 2){
                        String NombreU1 = etRegistroU.getText().toString();
                        String PerfilSelect1 = spnTipoPerfil.getSelectedItem().toString();
                        String RegistroUs1 = NombreU1 +  "   " + PerfilSelect1;

                        if (!NombreU1.isEmpty()) {
                            Usuarios.add(RegistroUs1);
                            etRegistroU.getText().clear();
                            SharedPreferences sharedPreferences = getSharedPreferences("MiSharedPreferences", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            Set<String> listaGuardada = new HashSet<>(Usuarios);
                            editor.putStringSet("dataSet", listaGuardada);
                            editor.apply();
                            editor.commit();

                            TipoUsuarios.add(PerfilSelect1);
                            SharedPreferences sharedPreferences1 = getSharedPreferences("MiSharedPreferences1", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                            Set<String> listaGuardada1 = new HashSet<>(TipoUsuarios);
                            editor1.putStringSet("dataSet1", listaGuardada1);
                            editor1.apply();
                            editor1.commit();

                        } else {
                            Toast.makeText(getApplicationContext(), "No se puede guardar un registro vacio " + PerfilSelect1, Toast.LENGTH_SHORT).show();
                        }

                    } else if (SelectItem == 3){
                        String NombreU1 = etRegistroU.getText().toString();
                        String PerfilSelect1 = spnTipoPerfil.getSelectedItem().toString();
                        String RegistroUs1 = NombreU1 +  "   " + PerfilSelect1;

                        if (!NombreU1.isEmpty()) {
                            Usuarios.add(RegistroUs1);
                            etRegistroU.getText().clear();
                            SharedPreferences sharedPreferences = getSharedPreferences("MiSharedPreferences", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            Set<String> listaGuardada = new HashSet<>(Usuarios);
                            editor.putStringSet("dataSet", listaGuardada);
                            editor.apply();
                            editor.commit();

                            TipoUsuarios.add(PerfilSelect1);
                            SharedPreferences sharedPreferences1 = getSharedPreferences("MiSharedPreferences1", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                            Set<String> listaGuardada1 = new HashSet<>(TipoUsuarios);
                            editor1.putStringSet("dataSet1", listaGuardada1);
                            editor1.apply();
                            editor1.commit();

                        } else {
                            Toast.makeText(getApplicationContext(), "No se puede guardar un registro vacio " + PerfilSelect1, Toast.LENGTH_SHORT).show();
                        }

                    }


                }
            });

            Registro.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            AlertDialog dialogo = Registro.create();
            dialogo.show();

        }  else if(id==R.id.MCambiar) {

            //Dialogo de Cambio de Usuario
            AlertDialog.Builder Cambiar = new AlertDialog.Builder(MainActivity.this);
            Cambiar.setTitle("Cambiar de Usuario");
            View selectCambiar = getLayoutInflater().inflate(R.layout.usuarios, null);
            Cambiar.setView(selectCambiar);
            Cambiar.setCancelable(false);

            LV = (ListView) selectCambiar.findViewById(R.id.LV);

            ArrayAdapter<String> adapter2 = new ArrayAdapter<>(MainActivity.this, R.layout.listview_p, R.id.TVP, Usuarios);
            adapter2.notifyDataSetChanged();
            LV.setAdapter(adapter2);

            LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    SharedPreferences Usa1 = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
                    String cadena = LV.getItemAtPosition(position).toString();
                    String[] partes = cadena.split("   ");

                    String UsuarioPe = partes[0]; // Primera palabra
                    String TipoUsuarioR = partes[1]; // Segunda palabra

                    String UsuarioRegis = UsuarioPe;

                    SharedPreferences.Editor UsaR1 = Usa1.edit();
                    UsaR1.putString("UsuarioRegis", UsuarioRegis.toString());
                    UsaR1.putString("TipoUsuarioR", TipoUsuarioR.toString());
                    UsaR1.commit();
                    Toast.makeText(getApplicationContext(), "Bienvenido " + UsuarioPe, Toast.LENGTH_SHORT).show();


                    Log.i("INFO:", "Perfil");
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);

                }
            });

            Cambiar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            AlertDialog dialogo1 = Cambiar.create();
            dialogo1.show();

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayerM != null) {
            mediaPlayerM[posicion].release();
            mediaPlayerM = null;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayerM != null) {
            mediaPlayerM[posicion].pause();
            mediaPlayerM[posicion].release();
            mediaPlayerM = null;
        }
    }


    @Override
    protected void onStop(){
        super.onStop();
        if (mediaPlayerM!=null){
            mediaPlayerM[posicion].release();
            mediaPlayerM=null;
        }
    }


    private void Frozen(){
        SharedPreferences Peli = getSharedPreferences("Pelicula", Context.MODE_PRIVATE);
        String PeliculaSelect = "frozendos";

        SharedPreferences.Editor editPeli = Peli.edit();
        editPeli.putString("PeliculaSelect", PeliculaSelect.toString());
        editPeli.commit();
        Toast.makeText(getApplicationContext(), "Pelicula Seleccionada " + PeliculaSelect, Toast.LENGTH_SHORT).show();
        Log.i("INFO:", "Pelicula");
        Intent intent = new Intent(MainActivity.this, Peliculas.class);
        startActivity(intent);

    }

    private void Enredados(){
        SharedPreferences Peli = getSharedPreferences("Pelicula", Context.MODE_PRIVATE);
        String PeliculaSelect = "enredadospeli";

        SharedPreferences.Editor editPeli = Peli.edit();
        editPeli.putString("PeliculaSelect", PeliculaSelect.toString());
        editPeli.commit();
        Toast.makeText(getApplicationContext(), "Pelicula Seleccionada " + PeliculaSelect, Toast.LENGTH_SHORT).show();
        Log.i("INFO:", "Pelicula");
        Intent intent = new Intent(MainActivity.this, Peliculas.class);
        startActivity(intent);

    }

    private void Ready(){
        SharedPreferences Peli = getSharedPreferences("Pelicula", Context.MODE_PRIVATE);
        String PeliculaSelect = "readyplayer";

        SharedPreferences.Editor editPeli = Peli.edit();
        editPeli.putString("PeliculaSelect", PeliculaSelect.toString());
        editPeli.commit();
        Toast.makeText(getApplicationContext(), "Pelicula Seleccionada " + PeliculaSelect, Toast.LENGTH_SHORT).show();
        Log.i("INFO:", "Pelicula");
        Intent intent = new Intent(MainActivity.this, Peliculas.class);
        startActivity(intent);

    }

    private void Pixeles(){
        SharedPreferences Peli = getSharedPreferences("Pelicula", Context.MODE_PRIVATE);
        String PeliculaSelect = "pixelespeli";

        SharedPreferences.Editor editPeli = Peli.edit();
        editPeli.putString("PeliculaSelect", PeliculaSelect.toString());
        editPeli.commit();
        Toast.makeText(getApplicationContext(), "Pelicula Seleccionada " + PeliculaSelect, Toast.LENGTH_SHORT).show();
        Log.i("INFO:", "Pelicula");
        Intent intent = new Intent(MainActivity.this, Peliculas.class);
        startActivity(intent);

    }

    private void Anabelle(){
        SharedPreferences Peli = getSharedPreferences("Pelicula", Context.MODE_PRIVATE);
        String PeliculaSelect = "annable";

        SharedPreferences.Editor editPeli = Peli.edit();
        editPeli.putString("PeliculaSelect", PeliculaSelect.toString());
        editPeli.commit();
        Toast.makeText(getApplicationContext(), "Pelicula Seleccionada " + PeliculaSelect, Toast.LENGTH_SHORT).show();
        Log.i("INFO:", "Pelicula");
        Intent intent = new Intent(MainActivity.this, Peliculas.class);
        startActivity(intent);

    }

    private void Conjuro(){
        SharedPreferences Peli = getSharedPreferences("Pelicula", Context.MODE_PRIVATE);
        String PeliculaSelect = "elconjuro";

        SharedPreferences.Editor editPeli = Peli.edit();
        editPeli.putString("PeliculaSelect", PeliculaSelect.toString());
        editPeli.commit();
        Toast.makeText(getApplicationContext(), "Pelicula Seleccionada " + PeliculaSelect, Toast.LENGTH_SHORT).show();
        Log.i("INFO:", "Pelicula");
        Intent intent = new Intent(MainActivity.this, Peliculas.class);
        startActivity(intent);

    }

    public void MenuPop(View v){
        ibtnMePop = (ImageView) findViewById(R.id.ibtnMePop);
        PopupMenu mp = new PopupMenu(this, ibtnMePop);
        mp.getMenuInflater().inflate(R.menu.menu_pop_up, mp.getMenu());
        mp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId()==R.id.MIC) {
                    SharedPreferences TS = getSharedPreferences("Tema", Context.MODE_PRIVATE);
                    String TemaSeleccionado1 = "Claro";
                    SharedPreferences.Editor TC = TS.edit();
                    TC.putString("TemaSeleccionado2", TemaSeleccionado1.toString());
                    TC.commit();
                    Toast.makeText(getApplicationContext(), "Tema Claro Aplicado", Toast.LENGTH_SHORT).show();

                } else if(item.getItemId()==R.id.MIO) {
                    SharedPreferences TS = getSharedPreferences("Tema", Context.MODE_PRIVATE);
                    String TemaSeleccionado1 = "Oscuro";
                    SharedPreferences.Editor TO = TS.edit();
                    TO.putString("TemaSeleccionado2", TemaSeleccionado1.toString());
                    TO.commit();
                    Toast.makeText(getApplicationContext(), "Tema Oscuro Aplicado", Toast.LENGTH_SHORT).show();

                }  else if(item.getItemId()==R.id.MIP1) {
                    SharedPreferences TS = getSharedPreferences("Tema", Context.MODE_PRIVATE);
                    String TemaSeleccionado1 = "Personalizado1";
                    SharedPreferences.Editor TP1 = TS.edit();
                    TP1.putString("TemaSeleccionado2", TemaSeleccionado1.toString());
                    TP1.commit();
                    Toast.makeText(getApplicationContext(), "Tema Personalizado Aplicado", Toast.LENGTH_SHORT).show();

                } else if(item.getItemId()==R.id.MIP2) {
                    SharedPreferences TS = getSharedPreferences("Tema", Context.MODE_PRIVATE);
                    String TemaSeleccionado1 = "Personalizado2";
                    SharedPreferences.Editor TP2 = TS.edit();
                    TP2.putString("TemaSeleccionado2", TemaSeleccionado1.toString());
                    TP2.commit();
                    Toast.makeText(getApplicationContext(), "Tema Personalizado Aplicado", Toast.LENGTH_SHORT).show();

                } else if(item.getItemId()==R.id.MIP3) {
                    SharedPreferences TS = getSharedPreferences("Tema", Context.MODE_PRIVATE);
                    String TemaSeleccionado1 = "Personalizado3";
                    SharedPreferences.Editor TP3 = TS.edit();
                    TP3.putString("TemaSeleccionado2", TemaSeleccionado1.toString());
                    TP3.commit();
                    Toast.makeText(getApplicationContext(), "Tema Personalizado Aplicado", Toast.LENGTH_SHORT).show();

                } else if(item.getItemId()==R.id.MIP4) {
                    SharedPreferences TS = getSharedPreferences("Tema", Context.MODE_PRIVATE);
                    String TemaSeleccionado1 = "Personalizado4";
                    SharedPreferences.Editor TP4 = TS.edit();
                    TP4.putString("TemaSeleccionado2", TemaSeleccionado1.toString());
                    TP4.commit();
                    Toast.makeText(getApplicationContext(), "Tema Personalizado Aplicado", Toast.LENGTH_SHORT).show();

                }

                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                return false;

            }
        });

        mp.show();

    }



}