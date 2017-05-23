package br.com.efb.controller.rest;

/**
 * Created by fepweb on 16/05/17.
 */
import org.apache.log4j.Logger;

public class SpringWebAppContextLoaderExample {
    public String toString() {
        LOGGER.info("SpringWebAppContextLoaderExample is called");
        return "This is Spring Webapplication Context Loader Example";
    }
    private Logger LOGGER = Logger.getLogger(SpringWebAppContextLoaderExample.class);
}