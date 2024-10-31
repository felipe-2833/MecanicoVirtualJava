package br.com.fiap.resource;

import br.com.fiap.bo.DiagnosticoBO;
import br.com.fiap.to.DiagnosticosTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/mecanico/diagnostico")
public class DiagnosticoResource {
    private DiagnosticoBO diagnosticoBO = new DiagnosticoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response fidAll(){
        ArrayList<DiagnosticosTO> resultado = diagnosticoBO.findAll();
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
        DiagnosticosTO resultado = diagnosticoBO.findByCodigo(id);
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
    public Response save(@Valid DiagnosticosTO diagnostico){
        DiagnosticosTO resultado = diagnosticoBO.save(diagnostico);
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
        if (diagnosticoBO.delete(id)) {
            response = Response.status(204);
        }else {
            response = Response.status(404);
        }
        return  response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid DiagnosticosTO diagnostico, @PathParam("id") Long id){
        diagnostico.setIdDiagnostico(id);
        DiagnosticosTO resultado = diagnosticoBO.update(diagnostico);
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
