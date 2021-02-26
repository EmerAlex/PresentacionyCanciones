package com.uco.presentacionycanciones.ui.artistas;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.uco.presentacionycanciones.CancionActivity;
import com.uco.presentacionycanciones.R;
import com.uco.presentacionycanciones.adapter.ArtistaAdapter;
import com.uco.presentacionycanciones.model.Artista;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtistaFragment extends Fragment {

    @BindView(R.id.listaArtistas)
    ListView listViewArtista;
    private List<Artista> artistas;

    @BindView(R.id.buscarArtista)
    EditText editText;

    ArtistaAdapter artistaAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_artistas, container, false);
        ButterKnife.bind(this,root);
        cargarInformacion();
        artistaAdapter = new ArtistaAdapter(getContext(),artistas);
        listViewArtista.setAdapter(artistaAdapter);

        listViewArtista.setClickable(true);
        listViewArtista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Artista artistaSelecionado = (Artista) listViewArtista.getItemAtPosition(position);
                goToActivity(view, artistaSelecionado.getNombreArtista());
            }
        });

        editTextWatcher();

        return root;
    }

    private void goToActivity (View view , String nombreArtista){
        Intent intent = new Intent(getContext(), CancionActivity.class);
        intent.putExtra("nombreArtista",nombreArtista);
        startActivity(intent);
    }

    private void editTextWatcher(){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                artistaAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void cargarInformacion() {
        artistas = new ArrayList<>(5);
        artistas.add(new Artista(R.drawable.logoquuen, getString(R.string.quuen), getString(R.string.rock)));
        artistas.add(new Artista(R.drawable.logobeatles,getString(R.string.beatles), getString(R.string.popRock)));
        artistas.add(new Artista(R.drawable.logosoad,getString(R.string.soad), getString(R.string.rock)));
        artistas.add(new Artista(R.drawable.logocultura,getString(R.string.culturaProfetica), getString(R.string.reggae)));
        artistas.add(new Artista(R.drawable.logopuerocandelaria,getString(R.string.puestoCandelaria), getString(R.string.cumbiaRockSka)));

    }
}