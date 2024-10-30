package br.com.fiap.bo;

import br.com.fiap.dao.OficinaDAO;
import br.com.fiap.to.OficinaTO;

import java.util.ArrayList;

public class OficinaBO {
    private OficinaDAO oficinaDAO;

    public ArrayList<OficinaTO> findAll(){
        oficinaDAO = new OficinaDAO();
        return oficinaDAO.findAll();
    }

    public OficinaTO findByCodigo(Long id) {
        oficinaDAO = new OficinaDAO();
        return oficinaDAO.findByCodigo(id);
    }

    public boolean delete(Long id) {
        oficinaDAO = new OficinaDAO();
        return oficinaDAO.delete(id);
    }

    public OficinaTO update(OficinaTO oficina) {
        oficinaDAO = new OficinaDAO();
        return oficinaDAO.update(oficina);
    }
}
