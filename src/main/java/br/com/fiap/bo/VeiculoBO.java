package br.com.fiap.bo;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.to.VeiculoTO;

import java.util.ArrayList;

public class VeiculoBO {
    private VeiculoDAO veiculoDAO;

    public ArrayList<VeiculoTO> findAll(){
        veiculoDAO = new VeiculoDAO();
        return veiculoDAO.findAll();
    }

    public VeiculoTO findByCodigo(Long id) {
        veiculoDAO = new VeiculoDAO();
        return veiculoDAO.findByCodigo(id);
    }

    public VeiculoTO save(VeiculoTO veiculo) {
        veiculoDAO = new VeiculoDAO();
        return veiculoDAO.save(veiculo);
    }

    public boolean delete(Long id) {
        veiculoDAO = new VeiculoDAO();
        return veiculoDAO.delete(id);
    }

    public VeiculoTO update(VeiculoTO veiculo) {
        veiculoDAO = new VeiculoDAO();
        return veiculoDAO.update(veiculo);
    }
}
