package br.com.fiap.resource;


import br.com.fiap.bo.PessoaJuridicaBO;
import br.com.fiap.to.PessoaJuridicaTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;


@Path("/pessoaJuridica")
public class PessoaJuridicaResource {
    private PessoaJuridicaBO pessoaJuridicaBO = new PessoaJuridicaBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<PessoaJuridicaTO> resultado = pessoaJuridicaBO.findAll();
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
        PessoaJuridicaTO resultado = pessoaJuridicaBO.findById(codigo);
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
    public  Response save(@Valid PessoaJuridicaTO pessoaJuridica) {
        PessoaJuridicaTO resultado = pessoaJuridicaBO.save(pessoaJuridica);
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
        if (pessoaJuridicaBO.delete(codigo)) {
            response = Response.status(204); // 204 no content
        } else {
            response = Response.status(404); // 404 not found
        }
        return response.build();
    }

    @PUT
    @Path("/{idPessoaJuridica}")
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response update(@Valid PessoaJuridicaTO pessoaJuridica, @PathParam("idPessoaJuridica") Long idPessoaJuridica) {
        pessoaJuridica.setIdPessoaJuridica(idPessoaJuridica);
        PessoaJuridicaTO resultado = pessoaJuridicaBO.update(pessoaJuridica);
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

