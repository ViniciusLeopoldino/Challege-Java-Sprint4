package br.com.fiap.resource;


import br.com.fiap.bo.HistoricoManutencaoBO;
import br.com.fiap.to.HistoricoManutencaoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/historico")
public class HistoricoResource {
    private HistoricoManutencaoBO historicoBO = new HistoricoManutencaoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<HistoricoManutencaoTO> resultado = historicoBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); //200 ok
        } else {
            response = Response.status(404); // not found
        }
        response.entity(resultado);
        return response.build();
    }
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("codigo") Long codigo) {
        HistoricoManutencaoTO resultado = historicoBO.findById(codigo);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200 ok
        } else {
            response = Response.status(404); // not found
        }
        response.entity(resultado);
        return response.build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response save(@Valid HistoricoManutencaoTO historico) {
        HistoricoManutencaoTO resultado = historicoBO.save(historico);
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
        if (historicoBO.delete(codigo)) {
            response = Response.status(204); // 204 no content
        } else {
            response = Response.status(404); // 404 not found
        }
        return response.build();
    }

    @PUT
    @Path("/{idHistorico}")
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response update(@Valid HistoricoManutencaoTO historicos, @PathParam("idHistorico") Long historico) {
        historicos.setIdManutencao(historico);
        HistoricoManutencaoTO resultado = historicoBO.update(historicos);
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
