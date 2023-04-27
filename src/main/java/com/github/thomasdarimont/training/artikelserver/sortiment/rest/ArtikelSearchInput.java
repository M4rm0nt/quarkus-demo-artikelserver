package com.github.thomasdarimont.training.artikelserver.sortiment.rest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.ws.rs.QueryParam;

@Getter
@Setter
@ToString
public class ArtikelSearchInput {

    @QueryParam("q")
    private String query;

    @QueryParam("page")
    private int page;

    @QueryParam("size")
    private int size;

    @QueryParam("sort")
    private String sort;
}
