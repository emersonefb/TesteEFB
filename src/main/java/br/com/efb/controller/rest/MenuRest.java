package br.com.efb.controller.rest;

/**
 * Created by fepweb on 10/05/17.
 */

import br.com.efb.controller.entity.Usuario;
import hello.AppException;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Api(tags = {"Menu"})
@Path("/Menu")
public class MenuRest extends BaseResource{

    private Usuario usuario = new Usuario();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Service executed without errors", response = Usuario.class),
            @ApiResponse(code = 400, message = "There is errors on the validation of request input data", response = AppException.class),
            @ApiResponse(code = 500, message = "An internal error occurred", response = AppException.class)
    })
    @ApiOperation(value = "Find Operation By ID",
            response = Usuario.class)
    @Path("/disagree")
    public Usuario getClichedMessage() {

        if (usuarioService!=null){
            this.usuario = usuarioService.FindUsuarios();
            this.usuario.setCcNomUsuarios("Menu Rest");
        }
        return this.usuario;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Service executed without errors", response = Usuario.class),
            @ApiResponse(code = 400, message = "There is errors on the validation of request input data", response = AppException.class),
            @ApiResponse(code = 500, message = "An internal error occurred", response = AppException.class)
    })
    @ApiOperation(value = "Find Operation By ID",
            response = Usuario.class)
    @Path("/disagreeefb")
    public Usuario postClichedMessage(Usuario a) {

        if (usuarioService!=null){
            this.usuario = usuarioService.FindUsuarios();
            this.usuario.setCcNomUsuarios("Resp Service: " + a.getCcNomUsuarios());
        }
        return this.usuario;
    }
}