package br.com.efb.controller.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by fepweb on 11/05/17.
 */
@Path("/Cotacao")
public class CotacaoResource {

    @GET
    @Path("/DollarToReal")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCotacaoDollar(){
        return "ola";
    }

    @GET
    @Path("/EuroToReal")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCotacao(){
        return "ola";
    }
}
