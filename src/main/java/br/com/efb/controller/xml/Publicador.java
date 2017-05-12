package br.com.efb.controller.xml;


import com.sun.net.httpserver.HttpServer;
import org.glassfish.jersey.server.ResourceConfig;

//import javax.xml.ws.Endpoint;
import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.net.URI;

/**
 * Created by fepweb on 11/05/17.
 */
public class Publicador {

    public static void main(String[] args) {
        System.out.println("web service - Gerador Inicializado");
        Gerador gerador = new Gerador();
        Endpoint.publish("http://localhost:8080/gerador", gerador);
    }

//    public static void main(String[] args) throws IllegalArgumentException, IOException {
//        ResourceConfig rc = new ResourceConfig().packages(new String[]{"br.com.efb.controller.rest"});
//        HttpServer server = JdkHttpServerFactory.createHttpServer(URI.create("http://localhost:8090/"), rc);
//    }
}
