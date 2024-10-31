package br.com.fiap.bo;

import br.com.fiap.dao.ModeloDAO;
import br.com.fiap.to.ModeloTO;

import java.util.ArrayList;

public class ModeloBO {
    private ModeloDAO modeloDAO;

    public ArrayList<ModeloTO> findAll(){
        modeloDAO = new ModeloDAO();
        return modeloDAO.findAll();
    }

    public ModeloTO findByCodigo(Long id) {
        modeloDAO = new ModeloDAO();
        return modeloDAO.findByCodigo(id);
    }

    public ModeloTO save(ModeloTO modelo) {
        modeloDAO = new ModeloDAO();
        return modeloDAO.save(modelo);
    }

    public boolean delete(Long id) {
        modeloDAO = new ModeloDAO();
        return modeloDAO.delete(id);
    }

    public ModeloTO update(ModeloTO modelo) {
        modeloDAO = new ModeloDAO();
        return modeloDAO.update(modelo);
    }
}
