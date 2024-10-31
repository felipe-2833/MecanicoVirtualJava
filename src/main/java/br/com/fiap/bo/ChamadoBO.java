package br.com.fiap.bo;

import br.com.fiap.dao.ChamadoDAO;
import br.com.fiap.to.ChamadoTO;

import java.util.ArrayList;

public class ChamadoBO {
    private ChamadoDAO chamadoBO;

    public ArrayList<ChamadoTO> findAll(){
        chamadoBO = new ChamadoDAO();
        return chamadoBO.findAll();
    }

    public ChamadoTO findByCodigo(Long id) {
        chamadoBO = new ChamadoDAO();
        return chamadoBO.findByCodigo(id);
    }

    public ChamadoTO save(ChamadoTO chamado) {
        chamadoBO = new ChamadoDAO();
        return chamadoBO.save(chamado);
    }

    public boolean delete(Long id) {
        chamadoBO = new ChamadoDAO();
        return chamadoBO.delete(id);
    }

    public ChamadoTO update(ChamadoTO chamado) {
        chamadoBO = new ChamadoDAO();
        return chamadoBO.update(chamado);
    }
}
