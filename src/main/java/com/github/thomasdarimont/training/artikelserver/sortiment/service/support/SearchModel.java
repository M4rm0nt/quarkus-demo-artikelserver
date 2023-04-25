package com.github.thomasdarimont.training.artikelserver.sortiment.service.support;

import io.quarkus.panache.common.Sort;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchModel {

    private String query;

    private int page;

    private int size;

    private Sort sort;

    public Sort getSortOr(Sort fallback) {
        if (sort == null) {
            return fallback;
        }

        return sort;
    }

    public int getPageOr(int fallback) {
        if (page == 0) {
            return fallback;
        }
        return page;
    }

    public int getSizeOr(int fallback) {
        if (size == 0) {
            return fallback;
        }
        return size;
    }
}
