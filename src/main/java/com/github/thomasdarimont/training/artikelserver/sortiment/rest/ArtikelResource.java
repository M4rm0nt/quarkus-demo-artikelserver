package com.github.thomasdarimont.training.artikelserver.sortiment.rest;

import com.github.thomasdarimont.training.artikelserver.sortiment.service.ArtikelService;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static com.github.thomasdarimont.training.artikelserver.sortiment.ArtikelMapper.ARTIKEL_MAPPER;

@Path("/api/sortiment/artikel")
@RequiredArgsConstructor
public class ArtikelResource {

    private final ArtikelService artikelService;

    @GET
    public Response findAll() {
        return Response.ok(artikelService.findAll().stream().map(ARTIKEL_MAPPER::modelToOutput)).build();
    }

    @GET
    @Path("{id}") // /api/sortiment/artikel/42
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(ARTIKEL_MAPPER.modelToOutput(artikelService.getFindById(id))).build();
    }

    @POST
    public Response createArtikel(ArtikelInput input, @Context UriInfo uriInfo) {
        var result = artikelService.createArtikel(ARTIKEL_MAPPER.inputToModel(input));
        var uri = uriInfo.getAbsolutePathBuilder().path("{id}").build(result.getId());
        return Response.created(uri).build();
    }
}