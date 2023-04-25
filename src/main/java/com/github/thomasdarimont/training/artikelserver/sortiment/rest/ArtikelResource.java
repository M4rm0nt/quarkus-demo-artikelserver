package com.github.thomasdarimont.training.artikelserver.sortiment.rest;

import com.github.thomasdarimont.training.artikelserver.sortiment.service.ArtikelService;

import lombok.RequiredArgsConstructor;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import static com.github.thomasdarimont.training.artikelserver.sortiment.ArtikelMapper.MAPPER;

import java.util.List;

@Path("/api/sortiment/artikel")
@RequiredArgsConstructor
public class ArtikelResource {

    private final ArtikelService artikelService;

    @GET
    public List<ArtikelOutput> findAll() {
        return artikelService.findAll().stream().map(MAPPER::modelToOutput).toList();
    }

    /**
     * curl -v -H "accept-type: application/json" http://localhost:8080/api/sortiment/artikel/search\?q=ean:EAN1
     * 
     * curl -v -H "accept-type: application/json" http://localhost:8080/api/sortiment/artikel/search\?q\=artikel:Artikel%202
     * 
     * curl -v -H "accept-type: application/json" http://localhost:8080/api/sortiment/artikel/search\?page=0&size=4
     * 
     * curl -v -H "accept-type: application/json" http://localhost:8080/api/sortiment/artikel/search\?page\=0\&size\=4\&sort\=bezeichnung:desc
     * @param input
     * @return
     */
    @GET
    @Path("search")
    public List<ArtikelOutput> search(@BeanParam ArtikelSearchInput input) {
        return artikelService.search(MAPPER.inputToModel(input)).stream().map(MAPPER::modelToOutput).toList();
    }

    /**
     * curl -v -H "accept-type: application/json" http://localhost:8080/api/sortiment/artikel/5
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    public ArtikelOutput findById(@PathParam("id") Long id) {
        return MAPPER.modelToOutput(artikelService.getFindById(id));
    }

    /**
     * curl -v -H "content-type: application/json" -X POST -d '{"ean":"EAN10", "bezeichnung":"Artikel 10"}' http://localhost:8080/api/sortiment/artikel
     * @param input
     * @param uriInfo
     * @return
     */
    @POST
    public ArtikelOutput createArtikel(ArtikelCreateInput input) {
        return MAPPER.modelToOutput(artikelService.createArtikel(MAPPER.inputToModel(input)));
    }
}