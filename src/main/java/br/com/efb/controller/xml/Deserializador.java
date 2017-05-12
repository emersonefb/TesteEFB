package br.com.efb.controller.xml;

import br.com.efb.controller.entity.Usuario;

import javax.xml.bind.*;
import java.io.File;

/**
 * Created by fepweb on 11/05/17.
 */
public class Deserializador {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Usuario.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Usuario conta = (Usuario) unmarshaller.unmarshal(new File("conta.xml"));
        System.out.println(conta.getCcNomUsuarios()); System.out.println(conta.getCvIDUsuarios());
    }
}
