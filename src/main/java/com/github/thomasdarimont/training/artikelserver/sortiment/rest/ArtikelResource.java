package com.github.thomasdarimont.training.artikelserver.sortiment.rest;

import static com.github.thomasdarimont.training.artikelserver.sortiment.ArtikelMapper.MAPPER;

import java.util.List;

import com.github.thomasdarimont.training.artikelserver.sortiment.service.ArtikelService;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import lombok.RequiredArgsConstructor;

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
     * curl -v -H "accept-type: application/json" http://localhost:8080/api/sortiment/artikel/5
     * @param id
     * @return
     */
    @DELETE
    @Path("{id}")
    public Response deleteById(@PathParam("id") Long id) {
    	boolean deleted = artikelService.deleteById(id);
    	
    	if (deleted) {
    		return Response.noContent().build();
    	}
    	
    	return Response.status(Status.NOT_FOUND).build();
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