package com.uco.presentacionycanciones;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.uco.presentacionycanciones.model.Cancion;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CancionActivity extends AppCompatActivity {

    @BindView(R.id.imagenArtistaCancion)
    ImageView imagenArtista;

    @BindView(R.id.nombreArtistaCancion)
    TextView nombreArtistaCancion;

    @BindView(R.id.nombreAlbumCancion)
    TextView albumCancion;

    @BindView(R.id.nombreCancion)
    TextView nombreCancion;

    @BindView(R.id.iniciarPausarCancion)
    Button iniciarPausar;

    MediaPlayer mediaCancion;
    private List<Cancion> canciones;

    private Cancion cancion;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancion);
        ButterKnife.bind(this);
        cargarInformacion();
        Intent intent = getIntent();
        String nombreArtista = intent.getStringExtra("nombreArtista");
        cancion = buscarCancion(nombreArtista);
        imagenArtista.setImageResource(cancion.getImagen());
        nombreArtistaCancion.setText(cancion.getNombreArtista());
        albumCancion.setText(cancion.getAlbum());
        nombreCancion.setText(cancion.getNombreCancion());
        mediaCancion = MediaPlayer.create(this, cancion.getCancion());
        iniciarPausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaCancion.isPlaying()){
                    mediaCancion.pause();
                    iniciarPausar.setBackgroundResource(R.drawable.ic_play_button);
                }else {
                    mediaCancion.start();
                    iniciarPausar.setBackgroundResource(R.drawable.ic_pause_button);
                }
            }
        });


    }
    @Override
    protected void onPause() {
        super.onPause();
        mediaCancion.stop();
    }




    private Cancion buscarCancion(String nombreArtista){
        Cancion cancionReproducir = new Cancion(R.drawable.logoquuen,R.raw.help,getString(R.string.beatles),getString(R.string.help),getString(R.string.help));
        for (int i = 0; i<  canciones.size();i++){

            if(canciones.get(i).getNombreArtista().equalsIgnoreCase(nombreArtista)){
                cancionReproducir = canciones.get(i);
            }

        }
        return cancionReproducir;
    }

    private void cargarInformacion(){

        canciones = new ArrayList<>();
        canciones.add(new Cancion(R.drawable.logoquuen,R.raw.anotheronebites,getString(R.string.quuen),getString(R.string.theGame),getString(R.string.anotheOneBites)));
        canciones.add(new Cancion(R.drawable.logobeatles,R.raw.help,getString(R.string.beatles),getString(R.string.help),getString(R.string.help)));
        canciones.add(new Cancion(R.drawable.logosoad,R.raw.aerials,getString(R.string.soad),getString(R.string.toxicity),getString(R.string.aerials)));
        canciones.add(new Cancion(R.drawable.logocultura,R.raw.ilegal,getString(R.string.culturaProfetica),getString(R.string.dulzura),getString(R.string.ilegal)));
        canciones.add(new Cancion(R.drawable.logopuerocandelaria,R.raw.senderitodeamor,getString(R.string.puestoCandelaria),getString(R.string.cantinalafoule),getString(R.string.senderitodeAmor)));

    }

}
