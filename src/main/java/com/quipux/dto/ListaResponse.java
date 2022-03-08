package com.quipux.dto;

import com.quipux.model.Cancion;

import java.io.Serializable;
import java.util.List;

public class ListaResponse implements Serializable {
    private static final long serialVersionUID = -4470731856559718638L;
    private List<Cancion> canciones;

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
}
