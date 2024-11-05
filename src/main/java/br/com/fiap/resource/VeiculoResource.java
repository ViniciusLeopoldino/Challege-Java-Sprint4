package br.com.fiap.resource;


import br.com.fiap.bo.VeiculoBO;
import br.com.fiap.to.VeiculoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/veiculo")
public class VeiculoResource {
    private VeiculoBO veiculoBO = new VeiculoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<VeiculoTO> resultado = veiculoBO.findAll();
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
        VeiculoTO resultado = veiculoBO.findById(codigo);
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
    public  Response save(@Valid VeiculoTO veiculo) {
        VeiculoTO resultado = veiculoBO.save(veiculo);
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
        if (veiculoBO.delete(codigo)) {
            response = Response.status(204); // 204 no content
        } else {
            response = Response.status(404); // 404 not found
        }
        return response.build();
    }

    @PUT
    @Path("/{idVeiculo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response update(@Valid VeiculoTO veiculo, @PathParam("idVeiculo") Long idVeiculo) {
        veiculo.setIdVeiculo(idVeiculo);
        VeiculoTO resultado = veiculoBO.update(veiculo);
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

