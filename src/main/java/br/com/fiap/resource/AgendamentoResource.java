package br.com.fiap.resource;


import br.com.fiap.bo.AgendamentoBO;
import br.com.fiap.to.AgendamentoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/agendamento")
public class AgendamentoResource {
    private AgendamentoBO agendamentoBO = new AgendamentoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<AgendamentoTO> resultado = agendamentoBO.findAll();
        Response.ResponseBuilder response = null;
        if(resultado != null) {
            response = Response.ok(200);
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id){
        AgendamentoTO resultado = agendamentoBO.findById(id);
        Response.ResponseBuilder response = null;
        if(resultado != null) {
            response = Response.ok(200);
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid AgendamentoTO agendamento){
        AgendamentoTO resultado = agendamentoBO.save(agendamento);
        Response.ResponseBuilder response = null;
        if(resultado != null) {
            response = Response.ok(200);
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid AgendamentoTO agendamento, @PathParam("id") Long id){
        agendamento.setIdAgendamento(id);
        AgendamentoTO resultado = agendamentoBO.update(agendamento);
        Response.ResponseBuilder response = null;
        if(resultado != null) {
            response = Response.ok(null);
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        Response.ResponseBuilder response = null;
        if(agendamentoBO.delete(id)) {
            response = Response.ok(200);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

}