package com.github.thomasdarimont.training.artikelserver.sortiment.rest.support;

import javax.ws.rs.QueryParam;

import io.quarkus.panache.common.Sort;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchInput {
    
    @QueryParam("q")
    private String query;

    @QueryParam("page")
    private int page;

    @QueryParam("size")
    private int size;

    @QueryParam("sort")
    private String sort;
}
