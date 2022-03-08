package com.quipux.service;

import com.quipux.dto.CrearListaRequest;
import com.quipux.dto.ListaEspecifica;
import com.quipux.dto.ListaResponse;
import com.quipux.model.Cancion;
import com.quipux.model.Lista;
import com.quipux.repository.CancionRepository;
import com.quipux.repository.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListaServiceImpl implements ListaService {

    @Autowired
    private ListaRepository listaRepository;
    @Autowired
    private CancionRepository cancionRepository;

    @Override
    public void insertarLista(CrearListaRequest crearListaRequest) {
        Lista lista = new Lista();
        lista.setTitulo(crearListaRequest.getNombre());
        lista.setDescripcion(crearListaRequest.getDescripcion());
        Lista listaCancion = listaRepository.save(lista);
        crearListaRequest.getCanciones().forEach(cancionResgistro -> {
            Cancion cancion = new Cancion();
            cancion.setTitulo(cancionResgistro.getTitulo());
            cancion.setArtista(cancionResgistro.getArtista());
            cancion.setAlbum(cancionResgistro.getAlbum());
            cancion.setAnno(cancionResgistro.getAnno());
            cancion.setLista(listaCancion);
            cancionRepository.save(cancion);
        });
    }

    @Override
    public ListaResponse obtenerTodasLasListas(int idLista) {
//        List<Lista> listas = listaRepository.findById(idLista);
//        List<ListaEspecifica> listaEspecificas = listas.stream().map(listaEncontrada -> {
//            ListaEspecifica listaEspecifica = new ListaEspecifica();
//            List<Cancion> listaCancion = cancionRepository.findByListaId(listaEncontrada.getId());
//            listaEspecifica.setCanciones(listaCancion);
//            return listaEspecifica;
//        }).collect(Collectors.toList());
//        ListaResponse listaResponse = new ListaResponse();
//        listaResponse.setListaEspecificas(listaEspecificas);
//        return listaResponse;
        ListaResponse listaResponse = new ListaResponse();
        Lista listaEncontrada = listaRepository.findById(idLista);
        List<Cancion> listaCancion = cancionRepository.findByListaId(listaEncontrada.getId());
        listaResponse.setCanciones(listaCancion);
        return listaResponse;
    }

    @Override
    public Lista obtenerDescripcionLista(String titulo) {
        return listaRepository.findByTitulo(titulo);
    }

    @Override
    public boolean eliminarLista(int id) {
        Lista lista = listaRepository.findById(id);
        if (lista != null) {
            listaRepository.delete(lista);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Lista> obtenerListas() {
        List<Lista> listas = listaRepository.findAll();
        return listas;
    }
}
