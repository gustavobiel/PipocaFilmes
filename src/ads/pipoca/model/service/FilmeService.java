package ads.pipoca.model.service;

import ads.pipoca.model.dao.FilmeDAO;
import ads.pipoca.model.entity.Filme;

public class FilmeService {
	
	FilmeDAO filmeDAO = new FilmeDAO();
	
	public Filme atualizarFilme(Filme filme) throws Exception { 
		return filmeDAO.atualizarFilme(filme);
	}
	
	public Filme buscarFilme(int id) throws Exception { 
		return filmeDAO.buscarFilme(id);
	}
	

}
