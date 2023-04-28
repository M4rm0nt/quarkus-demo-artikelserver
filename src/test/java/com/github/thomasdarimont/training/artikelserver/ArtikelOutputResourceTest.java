package com.github.thomasdarimont.training.artikelserver;

import com.github.thomasdarimont.training.artikelserver.sortiment.rest.ArtikelOutput;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class ArtikelOutputResourceTest {

    @Test
    public void shouldReturnArtikelById() {

        var artikelOutput = given()
                .when().get("/api/sortiment/artikel/1")
                .then()
                .statusCode(200)
                .extract()
                .as(ArtikelOutput.class);

        assertThat(artikelOutput).hasFieldOrPropertyWithValue("ean", "EAN1");
    }

}