package com.github.thomasdarimont.training.artikelserver.sortiment.data;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


/**
 * Example JPA entity defined as a Panache Entity.
 * An ID field of Long type is provided, if you want to define your own ID field extends <code>PanacheEntityBase</code> instead.
 * <p>
 * This uses the active record pattern, you can also use the repository pattern instead:
 * .
 * <p>
 * Usage (more example on the documentation)
 * <p>
 * {@code
 * public void doSomething() {
 * MyEntity entity1 = new MyEntity();
 * entity1.field = "field-1";
 * entity1.persist();
 * <p>
 * List<MyEntity> entities = MyEntity.listAll();
 * }
 * }
 */
@Entity
@Getter
@Setter
public class ArtikelEntity extends PanacheEntity {

    private String ean;

    private String bezeichnung;
}
