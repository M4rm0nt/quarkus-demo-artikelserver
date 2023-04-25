package com.github.thomasdarimont.training.artikelserver.sortiment;

import com.github.thomasdarimont.training.artikelserver.sortiment.rest.ArtikelSearchInput;
import com.github.thomasdarimont.training.artikelserver.sortiment.service.ArtikelEntity;
import com.github.thomasdarimont.training.artikelserver.sortiment.rest.ArtikelCreateInput;
import com.github.thomasdarimont.training.artikelserver.sortiment.rest.ArtikelOutput;
import com.github.thomasdarimont.training.artikelserver.sortiment.service.ArtikelModel;
import com.github.thomasdarimont.training.artikelserver.sortiment.service.ArtikelSearchModel;

import io.quarkus.panache.common.Sort;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArtikelMapper {

    ArtikelMapper MAPPER = Mappers.getMapper(ArtikelMapper.class);

    ArtikelModel inputToModel(ArtikelCreateInput input);

    ArtikelOutput modelToOutput(ArtikelModel result);

    ArtikelModel entityToModel(ArtikelEntity entity);

    ArtikelEntity modelToEntity(ArtikelModel model);

    ArtikelSearchModel inputToModel(ArtikelSearchInput input);

    /**
     * Converts sort strings like "ean:asc,bezeichnung:desc" into proper {@link Sort} objects.
     * @param sortString
     * @return
     */
    default Sort parseSort(String sortString) {
        
        if (sortString == null) {
            return null;
        }

        var sort = Sort.empty();
        var sortFields = sortString.split(",");
        
        for(var sortField : sortFields) {
            var fieldAndDirection = sortField.split(":");
            var field = fieldAndDirection[0];
            var directionString = fieldAndDirection[1];
            Sort.Direction direction;
            if (directionString == null || "asc".equalsIgnoreCase(directionString) || "ascending".equalsIgnoreCase(directionString)) {
                direction = Sort.Direction.Ascending;
            } else {
                direction = Sort.Direction.Descending;
            }
            sort = sort.and(field, direction);
        }

        return sort;
    }
}
