package br.com.fiap.resource;

import br.com.fiap.bo.PessoaFisicaBO;
import br.com.fiap.to.PessoaFisicaTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/pessoaFisica")
public class PessoaFisicaResource {
    private PessoaFisicaBO pessoaFisicaBO = new PessoaFisicaBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<PessoaFisicaTO> resultado = pessoaFisicaBO.findAll();
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
        PessoaFisicaTO resultado = pessoaFisicaBO.findById(codigo);
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
    public  Response save(@Valid PessoaFisicaTO pessoaFisica) {
        PessoaFisicaTO resultado = pessoaFisicaBO.save(pessoaFisica);
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
        if (pessoaFisicaBO.delete(codigo)) {
            response = Response.status(204); // 204 no content
        } else {
            response = Response.status(404); // 404 not found
        }
        return response.build();
    }

    @PUT
    @Path("/{idPessoaFisica}")
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response update(@Valid PessoaFisicaTO pessoaFisica, @PathParam("idPessoaFisica") Long idPessoaFisica) {
        pessoaFisica.setIdPessoaFisica(idPessoaFisica);
        PessoaFisicaTO resultado = pessoaFisicaBO.update(pessoaFisica);
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
