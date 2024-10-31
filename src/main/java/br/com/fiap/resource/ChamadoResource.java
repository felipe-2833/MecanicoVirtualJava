package br.com.fiap.resource;

import br.com.fiap.bo.ChamadoBO;
import br.com.fiap.to.ChamadoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/mecanico/chamado")
public class ChamadoResource {
    private ChamadoBO chamadoBO = new ChamadoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response fidAll(){
        ArrayList<ChamadoTO> resultado = chamadoBO.findAll();
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
        ChamadoTO resultado = chamadoBO.findByCodigo(id);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        }else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return  response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid ChamadoTO chamado){
        ChamadoTO resultado = chamadoBO.save(chamado);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        }else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return  response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        Response.ResponseBuilder response = null;
        if (chamadoBO.delete(id)) {
            response = Response.status(204);
        }else {
            response = Response.status(404);
        }
        return  response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ChamadoTO chamado, @PathParam("id") Long id){
        chamado.setIdChamdo(id);
        ChamadoTO resultado = chamadoBO.update(chamado);
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
