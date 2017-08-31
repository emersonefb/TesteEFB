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

	public Usuario salvar(Usuario usuario) {

		return usuarioDao.salvar(usuario);
	}

	public Usuario delete(Usuario usuario) {

		try{
			usuario = usuarioDao.find(usuario.getCvIDUsuarios());
			usuarioDao.delete(usuario);

		}catch (Exception e){
			e.printStackTrace();
		}
		return usuarioDao.find(usuario.getCvIDUsuarios());
	}

	public List<Usuario> listarUsuarios() {
		return usuarioDao.list();
	}

	public Usuario FindUsuarios(Usuario usuario) {
		Usuario ret = new Usuario();
		try{
			ret = usuarioDao.find(usuario.getCvIDUsuarios());
		}catch (Exception e){
			e.printStackTrace();
		}
		return ret;
	}
	
}
