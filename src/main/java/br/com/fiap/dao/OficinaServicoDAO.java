package br.com.fiap.dao;

import br.com.fiap.to.OficinaServicoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OficinaServicoDAO extends Repository{
    public ArrayList<OficinaServicoTO> findAll(){
        ArrayList<OficinaServicoTO> servicosOficina = new ArrayList<OficinaServicoTO>();
        String sql = "select * from oficina_servico order by servico_id_servico";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    OficinaServicoTO oficinaServico = new OficinaServicoTO();
                    oficinaServico.setOficinaIdOficina(rs.getLong("oficina_id_oficina"));
                    oficinaServico.setServicoIdservico(rs.getLong("servico_id_servico"));
                    oficinaServico.setPrecoServico(rs.getDouble("preco_servico"));
                    servicosOficina.add(oficinaServico); //Adiciona remedio ao arrayList
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return servicosOficina;
    }

    public OficinaServicoTO findByCodigo(Long idOficinaServico){
        OficinaServicoTO oficinaServico = new OficinaServicoTO();
        String sql = "select * from oficina_servico where servico_id_servico = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idOficinaServico);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                oficinaServico.setOficinaIdOficina(rs.getLong("oficina_id_oficina"));
                oficinaServico.setServicoIdservico(rs.getLong("servico_id_servico"));
                oficinaServico.setPrecoServico(rs.getDouble("preco_servico"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return oficinaServico;
    }

    public boolean delete(Long idOficinaServico){
        String sql = "delete from oficina_servico where servico_id_servico = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,idOficinaServico);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public OficinaServicoTO update(OficinaServicoTO oficinaServico){
        String sql = "update oficina_servico set oficina_id_oficina = ?, preco_servico = ? where servico_id_servico = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, oficinaServico.getOficinaIdOficina());
            ps.setDouble(2, oficinaServico.getPrecoServico());
            ps.setLong(3, oficinaServico.getServicoIdservico());
            if (ps.executeUpdate() > 0){
                return oficinaServico;
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
