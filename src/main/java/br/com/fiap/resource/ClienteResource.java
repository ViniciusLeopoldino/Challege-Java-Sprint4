package br.com.fiap.resource;


import br.com.fiap.bo.ClienteBO;
import br.com.fiap.to.ClienteTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/cliente")
public class ClienteResource {
    private ClienteBO clienteBO = new ClienteBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        ArrayList<ClienteTO> resultado = clienteBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); //200 ok
        } else {
            response = response.status(400); // not found
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("codigo") Long idCliente) {
        ClienteTO resultado = clienteBO.findById(idCliente);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); //200 ok
        } else {
            response = response.status(400); //not fount
        }
        response.entity(resultado);
        return response.build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response save(@Valid ClienteTO cliente) {
        ClienteTO resultado = clienteBO.save(cliente);
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
    @Path("/{idCliente}")
    public Response delete(@PathParam("idCliente") Long idCliente) {
        Response.ResponseBuilder response = null;
        if (clienteBO.delete(idCliente)) {
            response = Response.status(204); // 204 no content
        } else {
            response = Response.status(404); // 404 not found
        }
        return response.build();
    }

    @PUT
    @Path("/{idCliente}")
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response update(@Valid ClienteTO cliente, @PathParam("idCliente") Long idCliente) {
        cliente.setIdCliente(idCliente);
        ClienteTO resultado = clienteBO.update(cliente);
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
