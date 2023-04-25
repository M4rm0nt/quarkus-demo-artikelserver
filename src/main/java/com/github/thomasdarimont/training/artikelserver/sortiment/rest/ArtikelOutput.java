package com.github.thomasdarimont.training.artikelserver.sortiment.rest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ArtikelOutput {

    private Long id;

    private String ean;

    private String bezeichnung;
}
