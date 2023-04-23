package com.github.thomasdarimont.training.artikelserver.sortiment.service;

import com.github.thomasdarimont.training.artikelserver.sortiment.data.ArtikelRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

import static com.github.thomasdarimont.training.artikelserver.sortiment.ArtikelMapper.ARTIKEL_MAPPER;

@ApplicationScoped
@RequiredArgsConstructor
public class ArtikelService {

    private final ArtikelRepository artikelRepository;

    public ArtikelModel getFindById(Long id) {
        return ARTIKEL_MAPPER.entityToModel(artikelRepository.findById(id));
    }

    public List<ArtikelModel> findAll() {
        return artikelRepository.findAll().stream().map(ARTIKEL_MAPPER::entityToModel).toList();
    }

    /**
     * curl -v -H "content-type: application/json" -X POST -d '{"ean":"EAN1", "bezeichnung":"Artikel 1"}' http://localhost:8080/api/sortiment/artikel
     *
     * @param model
     * @return
     */
    @Transactional
    public ArtikelModel createArtikel(ArtikelModel model) {
        var entity = ARTIKEL_MAPPER.modelToEntity(model);
        artikelRepository.persist(entity);
        return ARTIKEL_MAPPER.entityToModel(entity);
    }
}
