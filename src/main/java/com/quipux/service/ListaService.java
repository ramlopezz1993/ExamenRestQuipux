package com.quipux.service;

import com.quipux.dto.CrearListaRequest;
import com.quipux.dto.ListaResponse;
import com.quipux.model.Lista;

import java.util.List;

public interface ListaService {
    void insertarLista(CrearListaRequest crearListaRequest);
    ListaResponse obtenerTodasLasListas(int idLista);
    Lista obtenerDescripcionLista(String titulo);
    boolean eliminarLista(int listName);
    List<Lista> obtenerListas();
}
