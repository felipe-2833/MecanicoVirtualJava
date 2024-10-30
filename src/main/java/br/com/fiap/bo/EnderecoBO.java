package br.com.fiap.bo;

import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.to.EnderecoTO;

import java.util.ArrayList;

public class EnderecoBO {
    private EnderecoDAO enderecoDAO;

    public ArrayList<EnderecoTO> findAll(){
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.findAll();
    }

    public EnderecoTO findByCodigo(Long id) {
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.findByCodigo(id);
    }

    public EnderecoTO save(EnderecoTO endereco) {
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.save(endereco);
    }

    public boolean delete(Long id) {
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.delete(id);
    }

    public EnderecoTO update(EnderecoTO endereco) {
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.update(endereco);
    }
}