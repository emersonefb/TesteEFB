package br.com.efb.controller.xml;

import javax.jws.WebService;

/**
 * Created by fepweb on 11/05/17.
 */
@WebService
public class Gerador {
    public double geraNumero(){
        return Math.random() * 200;
    }

}
