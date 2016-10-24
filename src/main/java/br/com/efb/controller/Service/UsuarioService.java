package br.com.efb.controller.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.efb.controller.DAO.UsuarioDAO;
import br.com.efb.controller.entity.Usuario;

@Service
public class UsuarioService {

	@Inject
	UsuarioDAO usuarioDao;
	
	public void salvar(Usuario Usuario) {
		usuarioDao.merge(Usuario);
	}

	public List<Usuario> listarUsuarios() {
		return usuarioDao.list();
	}
	
}
