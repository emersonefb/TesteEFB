package br.com.efb.controller.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.efb.controller.DAO.UsuarioDAO;
import br.com.efb.controller.entity.Usuario;

@Service
public class UsuarioService {

	@Autowired
	UsuarioDAO usuarioDao;
	
	public void salvar(Usuario Usuario) {
		usuarioDao.merge(Usuario);
	}

	public List<Usuario> listarUsuarios() {
		return usuarioDao.list();
	}

	public Usuario FindUsuarios() {
		return usuarioDao.find("1");
	}
	
}
