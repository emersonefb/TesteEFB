package br.com.efb.controller.rest;

import br.com.efb.controller.entity.Usuario;

import javax.jws.*;
import javax.ws.rs.*;
import java.util.Collection;

/**
 * Created by fepweb on 18/05/17.
 */
@Path("/")//caminho onde o serviço REST fica disponibilizado, seguido pelo @Path de cada parametro
@Produces({"application/xml", "application/json"})//tipos de retorno que o nosso REST pode produzir
@WebService//definimos aqui que essa interface é um WebService WSDL
public interface Service {

    @GET//tipo do metodo REST
    @Path("/cliente")//caminho do método
    @WebMethod(operationName="getClientes")//nome do metodo no WSDL
    public Collection<Usuario> getClientes();

    @GET
    @Path("/cliente/{id}/")//aqui passamos uma ID para obter um Cliente especifico
    @WebMethod(operationName="getCliente")
    //o ID do cliente é mapeado pelo PathParam para o REST e recebe o nome dado pelo WebParam para o WSDL.
    public Usuario getCliente(@PathParam("id") @WebParam(name="id")int id) throws Exception;
}
