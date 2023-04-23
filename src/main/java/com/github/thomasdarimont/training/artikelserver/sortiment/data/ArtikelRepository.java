package com.github.thomasdarimont.training.artikelserver.sortiment.data;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArtikelRepository implements PanacheRepository<ArtikelEntity> {
}
