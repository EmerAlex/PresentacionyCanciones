package com.uco.presentacionycanciones.model;

public class Artista {

    private int imagenArtista;
    private String nombreArtista;
    private String generoMusical;

    public Artista(int imagenArtista, String nombreArtista, String generoMusical) {
        this.imagenArtista = imagenArtista;
        this.nombreArtista = nombreArtista;
        this.generoMusical = generoMusical;
    }

    public int getImagenArtista() {
        return imagenArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }


}
