package br.com.fiap.resource;


import br.com.fiap.bo.SeguradoraBO;
import br.com.fiap.to.SeguradoraTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/seguradora")
public class SeguradoraResource {

    private SeguradoraBO seguradoraBO = new SeguradoraBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<SeguradoraTO> resultado = seguradoraBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("codigo") Long codigo) {
        SeguradoraTO resultado = seguradoraBO.findById(codigo);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200 ok
        } else {
            response = Response.status(404); // 404 not found
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response save(@Valid SeguradoraTO seguradora) {
        SeguradoraTO resultado = seguradoraBO.save(seguradora);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null); // 201 - CREATED
        }else {
            response = Response.status(400); // bad request
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{codigo}")
    public Response delete(@PathParam("codigo") Long codigo) {
        Response.ResponseBuilder response = null;
        if (seguradoraBO.delete(codigo)) {
            response = Response.status(204); // 204 no content
        } else {
            response = Response.status(404); // 404 not found
        }
        return response.build();
    }

    @PUT
    @Path("/{idSeguradora}")
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response update(@Valid SeguradoraTO seguradora, @PathParam("idSeguradora") Long idSeguradora) {
        seguradora.setIdSeguradora(idSeguradora);
        SeguradoraTO resultado = seguradoraBO.update(seguradora);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null); // 201
        } else {
            response = Response.status(400); // bad request
        }
        response.entity(resultado);
        return response.build();
    }
}

