package br.com.fiap.resource;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.to.UsuarioTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("mecanico/usuario")
public class UsuarioResource {
    private UsuarioBO usuarioBO = new UsuarioBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response fidAll(){
        ArrayList<UsuarioTO> resultado = usuarioBO.findAll();
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
        UsuarioTO resultado = usuarioBO.findByCodigo(id);
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
    public Response save(@Valid UsuarioTO usuario){
        UsuarioTO resultado = usuarioBO.save(usuario);
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
        if (usuarioBO.delete(id)) {
            response = Response.status(204);
        }else {
            response = Response.status(404);
        }
        return  response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid UsuarioTO usuario, @PathParam("id") Long id){
        usuario.setIdUser(id);
        UsuarioTO resultado = usuarioBO.update(usuario);
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
