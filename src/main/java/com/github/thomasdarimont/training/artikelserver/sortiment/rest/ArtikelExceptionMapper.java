package com.github.thomasdarimont.training.artikelserver.sortiment.rest;

import java.util.Map;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ArtikelExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        var errorDetails = getErrorDetails(exception);
        return Response.status(Status.INTERNAL_SERVER_ERROR)
                       .entity(errorDetails)
                       .build();
    }

    Map<String, Object> getErrorDetails(Throwable exception) {
        return Map.of("error", exception.getMessage());
    }
    
}
