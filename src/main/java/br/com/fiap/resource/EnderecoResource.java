package br.com.fiap.resource;

import br.com.fiap.bo.EnderecoBO;
import br.com.fiap.to.EnderecoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;


@Path("/endereco")
public class EnderecoResource {
    private EnderecoBO enderecoBO = new EnderecoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<EnderecoTO> resultado = enderecoBO.findAll();
        if (resultado != null && !resultado.isEmpty()) {
            return Response.ok(resultado).build(); // 200 OK
        } else {
            return Response.status(Response.Status.NO_CONTENT).build(); // 204 No Content
        }
    }
    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") long id) {
        EnderecoTO resultado = enderecoBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(200);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid EnderecoTO endereco) {
        EnderecoTO resultado = enderecoBO.save(endereco);
        if (resultado != null) {
            return Response.status(Response.Status.CREATED).entity(resultado).build(); // 201 Created
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao criar endereço").build(); // 400 Bad Request
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long idEndereco) {
        if (enderecoBO.delete(idEndereco)) {
            return Response.status(Response.Status.NO_CONTENT).build(); // 204 No Content
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Endereço não encontrado").build(); // 404 Not Found
        }
    }

    @PUT
    @Path("/{idEndereco}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid EnderecoTO endereco, @PathParam("idEndereco") Long idEndereco) {
        endereco.setIdEndereco(idEndereco);
        EnderecoTO resultado = enderecoBO.update(endereco);
        if (resultado != null) {
            return Response.ok(resultado).build(); // 200 OK
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao atualizar endereço").build(); // 400 Bad Request
        }
    }
}
