package br.com.fiap.resource;


import br.com.fiap.bo.ReservaAtendimentoBO;
import br.com.fiap.to.ReservaAtendimentoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/reservaAtendimento")
public class ReservaAtendimentoResource {
    private ReservaAtendimentoBO reservaAtendimentoBO = new ReservaAtendimentoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ReservaAtendimentoTO> resultado = reservaAtendimentoBO.findAll();
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
        ReservaAtendimentoTO resultado = reservaAtendimentoBO.findById(codigo);
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
    public  Response save(@Valid ReservaAtendimentoTO reservaAtendimento) {
        ReservaAtendimentoTO resultado = reservaAtendimentoBO.save(reservaAtendimento);
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
        if (reservaAtendimentoBO.delete(codigo)) {
            response = Response.status(204); // 204 no content
        } else {
            response = Response.status(404); // 404 not found
        }
        return response.build();
    }

    @PUT
    @Path("/{idReserva}")
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response update(@Valid ReservaAtendimentoTO reservaAtendimento, @PathParam("idReserva") Long idReserva) {
        reservaAtendimento.setIdReserva(idReserva);
        ReservaAtendimentoTO resultado = reservaAtendimentoBO.update(reservaAtendimento);
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


