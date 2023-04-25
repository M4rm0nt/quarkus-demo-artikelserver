package com.github.thomasdarimont.training.artikelserver.sortiment.service;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import io.quarkus.panache.common.Sort.Direction;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
class ArtikelRepository implements PanacheRepository<ArtikelEntity> {

    private static final int DEFAULT_PAGE = 0;

    private static final int DEFAULT_PAGE_SIZE = 1000;

    private static final Sort DEFAULT_SORT = Sort.by("ean", Direction.Ascending);

    public PanacheQuery<ArtikelEntity> query(ArtikelSearchModel search) {

        if (search == null) {
            return findAll();
        }

        PanacheQuery<ArtikelEntity> query;
        
        var queryString = search.getQuery();
        var sort = search.getSortOr(DEFAULT_SORT);

        if (queryString != null) {
            if (queryString.startsWith("ean:")) {
                var eanQuery = queryString.substring("ean:".length());
                query = find("ean", sort, eanQuery);
            } else if (queryString.startsWith("artikel:")) {
                var artikelQuery = queryString.substring("artikel:".length());
            
                if (artikelQuery.startsWith("%") || artikelQuery.endsWith("%")) {
                    query = find("bezeichnung like ?1", sort, artikelQuery);
                } else {
                    query = find("bezeichnung", sort, artikelQuery);
                }
            } else {
                query = find("ean like ?1 or bezeichnung like ?1", sort, queryString);
            }
        } else {
            query = findAll(sort);
        }

        query = query.page(search.getPageOr(DEFAULT_PAGE), search.getSizeOr(DEFAULT_PAGE_SIZE));

        return query;
    }
}
