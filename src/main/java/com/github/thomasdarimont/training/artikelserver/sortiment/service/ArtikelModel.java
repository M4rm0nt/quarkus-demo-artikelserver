package com.github.thomasdarimont.training.artikelserver.sortiment.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtikelModel {

    private Long id;

    private String ean;

    private String bezeichnung;
}
