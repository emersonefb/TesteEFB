package br.com.efb.controller.rest;

import br.com.efb.controller.DAO.UsuarioDAO;
import br.com.efb.controller.entity.Usuario;

import javax.jws.WebService;
import java.util.Collection;

/**
 * Created by fepweb on 18/05/17.
 */
@WebService(endpointInterface = "br.com.efb.controller.rest.Service")
public class ServiceImpl implements Service {

    private UsuarioDAO clienteDao;

    public Collection<Usuario> getClientes() {
        return clienteDao.list();
    }

    public Usuario getCliente(int id) throws Exception {
        return clienteDao.find(String.valueOf(id));
    }

//    @Override
//    public Usuario getCliente(String id) throws Exception {
//        return clienteDao.find(id);
//    }

//    @Override
//    public Collection<Cliente> getClientes() {
//        return clienteDao.getClientes();
//    }
//
//    public Usuario getCliente(int id) throws Exception {
//        return null;
//    }
//
//    public void setClienteDAO(ClienteDAO clienteDao) {
//        this.clienteDao = clienteDao;
//    }
//
//    public ClienteDAO getClienteDao() {
//        return clienteDao;
//    }
}