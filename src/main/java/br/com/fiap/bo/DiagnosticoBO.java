package br.com.fiap.bo;

import br.com.fiap.dao.DiagnosticoDAO;
import br.com.fiap.to.DiagnosticosTO;

import java.util.ArrayList;

public class DiagnosticoBO {
    private DiagnosticoDAO diagnosticoBO;

    public ArrayList<DiagnosticosTO> findAll(){
        diagnosticoBO = new DiagnosticoDAO();
        return diagnosticoBO.findAll();
    }

    public DiagnosticosTO findByCodigo(Long id) {
        diagnosticoBO = new DiagnosticoDAO();
        return diagnosticoBO.findByCodigo(id);
    }

    public DiagnosticosTO save(DiagnosticosTO diagnostico) {
        diagnosticoBO = new DiagnosticoDAO();
        return diagnosticoBO.save(diagnostico);
    }

    public boolean delete(Long id) {
        diagnosticoBO = new DiagnosticoDAO();
        return diagnosticoBO.delete(id);
    }

    public DiagnosticosTO update(DiagnosticosTO diagnostico) {
        diagnosticoBO = new DiagnosticoDAO();
        return diagnosticoBO.update(diagnostico);
    }
}
