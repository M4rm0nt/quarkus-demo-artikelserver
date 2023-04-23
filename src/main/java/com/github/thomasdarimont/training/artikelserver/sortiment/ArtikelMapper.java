package com.github.thomasdarimont.training.artikelserver.sortiment;

import com.github.thomasdarimont.training.artikelserver.sortiment.data.ArtikelEntity;
import com.github.thomasdarimont.training.artikelserver.sortiment.rest.ArtikelInput;
import com.github.thomasdarimont.training.artikelserver.sortiment.rest.ArtikelOutput;
import com.github.thomasdarimont.training.artikelserver.sortiment.service.ArtikelModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArtikelMapper {

    ArtikelMapper ARTIKEL_MAPPER = Mappers.getMapper(ArtikelMapper.class);

    ArtikelModel inputToModel(ArtikelInput input);

    ArtikelOutput modelToOutput(ArtikelModel result);

    ArtikelModel entityToModel(ArtikelEntity entity);

    ArtikelEntity modelToEntity(ArtikelModel model);
}
