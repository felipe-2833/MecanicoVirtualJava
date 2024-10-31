package br.com.fiap.resource;

import br.com.fiap.bo.OrcamentoPecasBO;
import br.com.fiap.to.OrcamentoPecasTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/mecanico/orcamentoPecas")
public class OrcamentoPecasResource {
    private OrcamentoPecasBO orcamentoPecasBO = new OrcamentoPecasBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response fidAll(){
        ArrayList<OrcamentoPecasTO> resultado = orcamentoPecasBO.findAll();
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
        OrcamentoPecasTO resultado = orcamentoPecasBO.findByCodigo(id);
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
        if (orcamentoPecasBO.delete(id)) {
            response = Response.status(204);
        }else {
            response = Response.status(404);
        }
        return  response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid OrcamentoPecasTO orcamentoPecas, @PathParam("id") Long id){
        orcamentoPecas.setOrcamentoIdOrcamento(id);
        OrcamentoPecasTO resultado = orcamentoPecasBO.update(orcamentoPecas);
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
