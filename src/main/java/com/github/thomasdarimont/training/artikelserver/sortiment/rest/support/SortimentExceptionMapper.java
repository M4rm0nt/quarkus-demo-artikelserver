package com.github.thomasdarimont.training.artikelserver.sortiment.rest.support;

import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class SortimentExceptionMapper implements ExceptionMapper<Throwable> {

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
