package br.com.efb.controller.xml;

import br.com.efb.controller.entity.Usuario;

import javax.xml.bind.*;
import java.io.File;

/**
 * Created by fepweb on 11/05/17.
 */
public class Serializador {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usuario.class);
        Marshaller marshaller = context.createMarshaller();

        Usuario conta = new Usuario();
        conta.setCcNomUsuarios("Test");
//        conta.setCvIDUsuarios("1");

        marshaller.marshal(conta, new File("conta.xml"));
        System.out.println(conta);

    }

}
