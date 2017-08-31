package br.com.efb.controller.rest;

/**
 * Created by fepweb on 10/05/17.
 */

import br.com.efb.controller.entity.Usuario;
import hello.AppException;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;


@Api(tags = {"Menu"})
@Path("/Menu")
public class MenuRest extends BaseResource{

    private Usuario usuario = new Usuario();

    /**
     * Adiciona o Token no Header
     * @param object
     * @return
     */
    private Response addTokenHeader(Object object) {
        return Response.ok().entity(object).header("TokenEFB", "Isso").build();
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
    @Path("/findUserIDefb")
    public Response getClichedMessage(Usuario usuario) {

        if (usuarioService!=null){
            this.usuario = usuarioService.FindUsuarios(usuario);
        }

        if (this.usuario==null){
            this.usuario = new Usuario();
        }
        return addTokenHeader(this.usuario);
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
    @Path("/listaUserefb")
    public Response postClichedMessage() {

        List<Usuario> usuarios = new ArrayList<Usuario>();
        if (usuarioService!=null){
            usuarios = usuarioService.listarUsuarios();
        }

        return addTokenHeader(usuarios);
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
    @Path("/saveUserefb")
    public Response postSaveUser(Usuario a) {
        try{
            if (usuarioService!=null){
                this.usuario = usuarioService.salvar(a);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return addTokenHeader(this.usuario);
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
    @Path("/deleteUserefb")
    public Response postDeleteUser(Usuario usuario) {
        try{
            if (usuarioService!=null){
                this.usuario = usuarioService.delete(usuario);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if (this.usuario==null){
            this.usuario = new Usuario();
        }
        return addTokenHeader(this.usuario);
    }
}