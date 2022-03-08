package com.quipux.dto;

import com.quipux.model.Cancion;

import java.io.Serializable;
import java.util.List;

public class CrearListaRequest implements Serializable {
    private static final long serialVersionUID = 5681909795333423101L;
    private String nombre;
    private String descripcion;
    private List<Cancion> canciones;

    public CrearListaRequest() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
}
