package br.com.efb.controller.xml;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Created by fepweb on 11/05/17.
 */
@WebService
@Stateless
public class Random {

    public double next(double max) {
        return Math.random() * max;
    }
}
