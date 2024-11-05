package br.com.fiap.resource;


import br.com.fiap.bo.ServicoBO;

import br.com.fiap.to.ServicoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;


@Path("/servico")
public class ServicoResource {

    private ServicoBO servicoBO = new ServicoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ServicoTO> resultado = servicoBO.findAll();
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
        ServicoTO resultado = servicoBO.findById(codigo);
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
    public  Response save(@Valid ServicoTO servico) {
        ServicoTO resultado = servicoBO.save(servico);
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
        if (servicoBO.delete(codigo)) {
            response = Response.status(204); // 204 no content
        } else {
            response = Response.status(404); // 404 not found
        }
        return response.build();
    }

    @PUT
    @Path("/{idServico}")
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response update(@Valid ServicoTO servico, @PathParam("idServico") Long idServico) {
        servico.setIdServico(idServico);
        ServicoTO resultado = servicoBO.update(servico);
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

