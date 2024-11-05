package br.com.fiap.resource;

import br.com.fiap.bo.PecasBO;
import br.com.fiap.to.PecasTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/pecas")
public class PecasResource {
    private PecasBO pecasBO = new PecasBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<PecasTO> resultado = pecasBO.findAll();
        Response.ResponseBuilder response = null;
        if ((resultado != null)) {
            response = Response.ok(); // 200 ok
        } else {
            response = Response.status(404); //not found
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{idPeca}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("idPeca") Long idPeca) {
        PecasTO resultado = pecasBO.findById(idPeca);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200 ok
        } else {
            response = Response.status(404); //not found
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid PecasTO pecas) {
        PecasTO resultado = pecasBO.save(pecas);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null); // 201 created
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();

    }

    @DELETE
    @Path("/{idPecas}")
    public Response delete(@PathParam("idPecas") Long idPeca) {
        Response.ResponseBuilder response = null;
        if (pecasBO.delete(idPeca)) {
            response = Response.status(204); // no content
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{idPecas}")
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response update(@Valid PecasTO pecas, @PathParam("idPecas") Long idPecas) {
        pecas.setId_pecas(idPecas);
        PecasTO resultado = pecasBO.update(pecas);
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
