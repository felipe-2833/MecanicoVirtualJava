package br.com.fiap.dao;

import br.com.fiap.to.DiagnosticosTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiagnosticoDAO extends Repository{
    public ArrayList<DiagnosticosTO> findAll(){
        ArrayList<DiagnosticosTO> diagnosticos = new ArrayList<DiagnosticosTO>();
        String sql = "select * from diagnostico order by id_diagnostico";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    DiagnosticosTO diagnostico = new DiagnosticosTO();
                    diagnostico.setChamadoIdChamado(rs.getLong("chamado_id_chamado"));
                    diagnostico.setProblemaIdProblema(rs.getLong("problema_id_problema"));
                    diagnostico.setIdDiagnostico(rs.getLong("id_diagnostico"));
                    diagnostico.setProblemaIdentificado(rs.getString("problema_identificado"));
                    diagnostico.setPecasNecessarias(rs.getString("pecas_necessarias"));
                    diagnostico.setDataDiagnostico(rs.getDate("data_diagnostico").toLocalDate());
                    diagnosticos.add(diagnostico); //Adiciona remedio ao arrayList
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return diagnosticos;
    }

    public DiagnosticosTO findByCodigo(Long idDiagnostico){
        DiagnosticosTO diagnostico = new DiagnosticosTO();
        String sql = "select * from diagnostico where id_diagnostico = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idDiagnostico);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                diagnostico.setChamadoIdChamado(rs.getLong("chamado_id_chamado"));
                diagnostico.setProblemaIdProblema(rs.getLong("problema_id_problema"));
                diagnostico.setIdDiagnostico(rs.getLong("id_diagnostico"));
                diagnostico.setProblemaIdentificado(rs.getString("problema_identificado"));
                diagnostico.setPecasNecessarias(rs.getString("pecas_necessarias"));
                diagnostico.setDataDiagnostico(rs.getDate("data_diagnostico").toLocalDate());
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return diagnostico;
    }

    public DiagnosticosTO save(DiagnosticosTO diagnostico){
        String sql = "insert into diagnostico (chamado_id_chamado, problema_id_problema, problema_identificado, pecas_necessarias, data_diagnostico) values(?,?,?,?,?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, diagnostico.getChamadoIdChamado());
            ps.setLong(2, diagnostico.getProblemaIdProblema());
            ps.setString(3, diagnostico.getProblemaIdentificado());
            ps.setString(4, diagnostico.getPecasNecessarias());
            ps.setDate(5, Date.valueOf(diagnostico.getDataDiagnostico()));
            if (ps.executeUpdate() > 0){
                return diagnostico;
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long idDiagnostico){
        String sql = "delete from diagnostico where id_diagnostico = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,idDiagnostico);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public DiagnosticosTO update(DiagnosticosTO diagnostico){
        String sql = "update diagnostico set chamado_id_chamado = ?, problema_id_problema = ?, problema_identificado = ?, pecas_necessarias = ?, data_diagnostico = ? where id_diagnostico = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, diagnostico.getChamadoIdChamado());
            ps.setLong(2, diagnostico.getProblemaIdProblema());
            ps.setString(3, diagnostico.getProblemaIdentificado());
            ps.setString(4, diagnostico.getPecasNecessarias());
            ps.setDate(5, Date.valueOf(diagnostico.getDataDiagnostico()));
            ps.setLong(6, diagnostico.getIdDiagnostico());
            if (ps.executeUpdate() > 0){
                return diagnostico;
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
