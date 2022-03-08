package com.quipux.dto;

import com.quipux.model.Cancion;

import java.io.Serializable;
import java.util.List;

public class ListaEspecifica implements Serializable {
    private static final long serialVersionUID = 8995790574112703046L;

    private List<Cancion> canciones;

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
}
