package com.github.thomasdarimont.training.artikelserver.sortiment.service;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "t_artikel")
public class ArtikelEntity extends PanacheEntity {

    private String ean;

    private String bezeichnung;
}
