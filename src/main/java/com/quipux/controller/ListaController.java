package com.quipux.controller;

import com.quipux.dto.CrearListaRequest;
import com.quipux.dto.ListaResponse;
import com.quipux.model.Lista;
import com.quipux.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ListaController {

    @Autowired
    private ListaService listaService;

    @GetMapping("/api/lists/{idLista}")
    public ResponseEntity<ListaResponse> obtenerListasCanciones(@PathVariable int idLista) {
        return ResponseEntity.ok(listaService.obtenerTodasLasListas(idLista));
    }

    @GetMapping("/api/lista-canciones")
    public ResponseEntity<List<Lista>> obtenerListas() {
        return ResponseEntity.ok(listaService.obtenerListas());
    }

    @GetMapping("/api/lists-nombre/{listName}")
    public ResponseEntity<Lista> obtenerDescripcionLista(@PathVariable String listName) {
        Lista lista = listaService.obtenerDescripcionLista(listName);
        if (lista == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(lista);
        }
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/api/lists")
    public ResponseEntity<Void> crearLista(@RequestBody CrearListaRequest crearListaRequest) {
        if (crearListaRequest.getNombre() == null || crearListaRequest.getCanciones() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            listaService.insertarLista(crearListaRequest);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/api/lists/{idLista}")
    public ResponseEntity<Void> eliminarLista(@PathVariable int idLista) {
        boolean banderaEliminado = listaService.eliminarLista(idLista);
        if (banderaEliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
