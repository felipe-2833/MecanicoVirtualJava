package br.com.fiap.dao;

import br.com.fiap.to.OrcamentoPecasTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrcamentoPecasDAO extends Repository{
    public ArrayList<OrcamentoPecasTO> findAll(){
        ArrayList<OrcamentoPecasTO> orcamentosPecas = new ArrayList<OrcamentoPecasTO>();
        String sql = "select * from orcamento_pecas order by orcamento_id_orcamento";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    OrcamentoPecasTO orcamentoPecas = new OrcamentoPecasTO();
                    orcamentoPecas.setOrcamentoIdOrcamento(rs.getLong("orcamento_id_orcamento"));
                    orcamentoPecas.setPecasIdPecas(rs.getLong("pecas_id_peca"));
                    orcamentoPecas.setQuantidade(rs.getDouble("quantidade"));
                    orcamentosPecas.add(orcamentoPecas); //Adiciona remedio ao arrayList
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return orcamentosPecas;
    }

    public OrcamentoPecasTO findByCodigo(Long idOrcamentoPecas){
        OrcamentoPecasTO orcamentoPecas = new OrcamentoPecasTO();
        String sql = "select * from orcamento_pecas where orcamento_id_orcamento = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idOrcamentoPecas);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                orcamentoPecas.setOrcamentoIdOrcamento(rs.getLong("orcamento_id_orcamento"));
                orcamentoPecas.setPecasIdPecas(rs.getLong("pecas_id_peca"));
                orcamentoPecas.setQuantidade(rs.getDouble("quantidade"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return orcamentoPecas;
    }

    public boolean delete(Long idOrcamentoPecas){
        String sql = "delete from orcamento_pecas where orcamento_id_orcamento = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,idOrcamentoPecas);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public OrcamentoPecasTO update(OrcamentoPecasTO orcamentoPecas){
        String sql = "update orcamento_pecas set pecas_id_peca = ?, quantidade = ? where orcamento_id_orcamento = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, orcamentoPecas.getPecasIdPecas());
            ps.setDouble(2, orcamentoPecas.getQuantidade());
            ps.setLong(3, orcamentoPecas.getOrcamentoIdOrcamento());
            if (ps.executeUpdate() > 0){
                return orcamentoPecas;
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
