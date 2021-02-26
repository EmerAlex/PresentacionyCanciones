package com.uco.presentacionycanciones.model;

public class Cancion {

    private int imagen;
    private int cancion;
    private String nombreArtista;
    private String nombreCancion;
    private String album;

    public Cancion(int imagen , int cancion,String nombreArtista, String album, String nombreCancion) {
        this.imagen = imagen;
        this.cancion = cancion;
        this.nombreArtista = nombreArtista;
        this.nombreCancion = nombreCancion;
        this.album = album;
    }

    public int getImagen() {
        return imagen;
    }

    public int getCancion() {
        return cancion;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public String getAlbum() {
        return album;
    }
}
