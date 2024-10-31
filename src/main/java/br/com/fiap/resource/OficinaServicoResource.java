package br.com.fiap.resource;

import br.com.fiap.bo.OficinaServicoBO;
import br.com.fiap.to.OficinaServicoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("mecanico/oficinaServico")
public class OficinaServicoResource {
    private OficinaServicoBO oficinaServicoBO = new OficinaServicoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response fidAll(){
        ArrayList<OficinaServicoTO> resultado = oficinaServicoBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok();
        }else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();

    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("id") Long id){
        OficinaServicoTO resultado = oficinaServicoBO.findByCodigo(id);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        }else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return  response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        Response.ResponseBuilder response = null;
        if (oficinaServicoBO.delete(id)) {
            response = Response.status(204);
        }else {
            response = Response.status(404);
        }
        return  response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid OficinaServicoTO oficinaServico, @PathParam("id") Long id){
        oficinaServico.setServicoIdservico(id);
        OficinaServicoTO resultado = oficinaServicoBO.update(oficinaServico);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.status(201);
        }else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return  response.build();
    }
}
