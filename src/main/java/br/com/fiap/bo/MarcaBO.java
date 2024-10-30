package br.com.fiap.bo;

import br.com.fiap.dao.MarcaDAO;
import br.com.fiap.to.MarcaTO;

import java.util.ArrayList;

public class MarcaBO {
    private MarcaDAO marcaDAO;

    public ArrayList<MarcaTO> findAll(){
        marcaDAO = new MarcaDAO();
        return marcaDAO.findAll();
    }

    public MarcaTO findByCodigo(Long id) {
        marcaDAO = new MarcaDAO();
        return marcaDAO.findByCodigo(id);
    }

    public MarcaTO save(MarcaTO marca) {
        marcaDAO = new MarcaDAO();
        return marcaDAO.save(marca);
    }

    public boolean delete(Long id) {
        marcaDAO = new MarcaDAO();
        return marcaDAO.delete(id);
    }

    public MarcaTO update(MarcaTO marca) {
        marcaDAO = new MarcaDAO();
        return marcaDAO.update(marca);
    }
}
