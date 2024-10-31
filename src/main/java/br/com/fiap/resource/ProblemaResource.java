package br.com.fiap.resource;

import br.com.fiap.bo.ProblemaBO;
import br.com.fiap.to.ProblemaTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/mecanico/problema")
public class ProblemaResource {
    private ProblemaBO problemaBO = new ProblemaBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response fidAll(){
        ArrayList<ProblemaTO> resultado = problemaBO.findAll();
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
        ProblemaTO resultado = problemaBO.findByCodigo(id);
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
    public Response save(@Valid ProblemaTO problema){
        ProblemaTO resultado = problemaBO.save(problema);
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
        if (problemaBO.delete(id)) {
            response = Response.status(204);
        }else {
            response = Response.status(404);
        }
        return  response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ProblemaTO problema, @PathParam("id") Long id){
        problema.setIdProblema(id);
        ProblemaTO resultado = problemaBO.update(problema);
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
