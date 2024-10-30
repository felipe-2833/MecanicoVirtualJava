package br.com.fiap.dao;

import br.com.fiap.to.OficinaTO;
import br.com.fiap.to.UsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OficinaDAO extends Repository{
    public ArrayList<OficinaTO> findAll(){
        ArrayList<OficinaTO> oficinas = new ArrayList<OficinaTO>();
        String sql = "select * from oficina order by oficina_id_user";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    OficinaTO oficina = new OficinaTO();
                    oficina.setOficinaIdUser(rs.getLong("oficina_id_user"));
                    oficina.setCnpjOficina(rs.getString("cnpj_oficina"));
                    oficina.setNomeOficina(rs.getString("nome_oficina"));
                    oficinas.add(oficina); //Adiciona remedio ao arrayList
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return oficinas;
    }

    public OficinaTO findByCodigo(Long oficinaIdUser){
        OficinaTO oficina = new OficinaTO();
        String sql = "select * from oficina where oficina_id_user = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, oficinaIdUser);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                oficina.setOficinaIdUser(rs.getLong("oficina_id_user"));
                oficina.setCnpjOficina(rs.getString("cnpj_oficina"));
                oficina.setNomeOficina(rs.getString("nome_oficina"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return oficina;
    }

    public boolean delete(Long oficinaIdUser){
        String sql = "delete from oficina where oficina_id_user = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,oficinaIdUser);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public OficinaTO update(OficinaTO oficina){
        String sql = "update oficina set cnpj_oficina = ?, nome_oficina = ? where oficina_id_user = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, oficina.getCnpjOficina());
            ps.setString(2, oficina.getNomeOficina());
            ps.setLong(3, oficina.getOficinaIdUser());
            if (ps.executeUpdate() > 0){
                return oficina;
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
