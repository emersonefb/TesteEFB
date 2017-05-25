package br.com.efb.controller.rest;

/**
 * Created by fepweb on 10/05/17.
 */

import br.com.efb.controller.entity.Usuario;
import hello.AppException;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.io.IOException;


@Api(tags = {"helloworld"})
@Path("/helloworld")
public class HelloWorld extends BaseResource{

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
    public Usuario getClichedMessage() {

        if (usuarioService!=null){
            this.usuario = usuarioService.FindUsuarios();
        }
        return this.usuario;
    }
}