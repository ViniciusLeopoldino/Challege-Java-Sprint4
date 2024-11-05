package br.com.fiap.resource;

import br.com.fiap.bo.OficinaBO;
import br.com.fiap.to.OficinaTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;


@Path("/oficina")
public class OficinaResource {
    private OficinaBO oficinaBO = new OficinaBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<OficinaTO> reultados = oficinaBO.findAll();
        Response.ResponseBuilder response = null;
        if (reultados != null) {
            response = Response.ok(); // 200 ok
        } else {
            response = Response.status(404); // not found
        }
        response.entity(reultados);
        return response.build();
    }
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("codigo") Long codigo) {
        OficinaTO oficina = oficinaBO.findById(codigo);
        Response.ResponseBuilder response = null;
        if (oficina != null) {
            response = Response.ok(); //200
        } else {
            response = Response.status(404); // not found
        }
        response.entity(oficina);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response save(@Valid OficinaTO oficina) {
        OficinaTO resultado = oficinaBO.save(oficina);
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
    @Path("/{idOficina}")
    public Response delete(@PathParam("idOficina") Long idOficina) {
        Response.ResponseBuilder response = null;
        if (oficinaBO.delete(idOficina)) {
            response = Response.status(204); // 204 no content
        } else {
            response = Response.status(404); // 404 not found
        }
        return response.build();
    }

    @PUT
    @Path("/{idOficina}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON) // Certifique-se de que está produzindo JSON
    public Response update(@Valid OficinaTO oficina, @PathParam("idOficina") Long idOficina) {
        oficina.setIdOficina(idOficina); // Define o ID da oficina a ser atualizada
        OficinaTO resultado = oficinaBO.update(oficina);

        Response.ResponseBuilder response;

        if (resultado != null) {
            response = Response.ok(resultado); // 200 OK, retorna o objeto atualizado
        } else {
            response = Response.status(Response.Status.NOT_FOUND) // 404 Not Found se a oficina não for encontrada
                    .entity("Oficina não encontrada");
        }

        return response.build();
    }

}
