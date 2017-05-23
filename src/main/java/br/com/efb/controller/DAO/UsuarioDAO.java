package br.com.efb.controller.DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import br.com.efb.controller.entity.Usuario;

@Repository
public class UsuarioDAO extends DAO<Usuario> implements Serializable {

	public UsuarioDAO() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	EntityManager em;
	
	public void salvar(Usuario cadastro) {
		
		em.merge(cadastro);
		
	}

	@Override
	public Usuario find(Long id) {
		return super.find(id);
	}

//	public List<Usuario> list () {
//		CriteriaQuery<Usuario> query = em.getCriteriaBuilder().createQuery(Usuario.class);
//		query.select(query.from(Usuario.class));
//		List<Usuario> lista = em.createQuery(query).getResultList();
//		return lista;
//	}

}
