package com.github.thomasdarimont.training.artikelserver.sortiment.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtikelModel {

    Long id;

    String ean;

    String bezeichnung;
}
