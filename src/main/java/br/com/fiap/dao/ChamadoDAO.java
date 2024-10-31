package br.com.fiap.dao;

import br.com.fiap.to.ChamadoTO;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChamadoDAO extends Repository{
    public ArrayList<ChamadoTO> findAll(){
        ArrayList<ChamadoTO> chamados = new ArrayList<ChamadoTO>();
        String sql = "select * from chamado order by id_chamado";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    ChamadoTO chamado = new ChamadoTO();
                    chamado.setClienteUserId(rs.getLong("cliente_user_id"));
                    chamado.setOficinaUserId(rs.getLong("oficina_user_id"));
                    chamado.setVeiculoIdVeiculo(rs.getLong("veiculo_id_veiculo"));
                    chamado.setIdChamdo(rs.getLong("id_chamado"));
                    chamado.setStatus(rs.getString("status"));
                    chamado.setDataAbertura(rs.getDate("data_abertura").toLocalDate());
                    chamados.add(chamado); //Adiciona remedio ao arrayList
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return chamados;
    }

    public ChamadoTO findByCodigo(Long idChamado){
        ChamadoTO chamado = new ChamadoTO();
        String sql = "select * from chamado where id_chamado = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idChamado);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                chamado.setClienteUserId(rs.getLong("cliente_user_id"));
                chamado.setOficinaUserId(rs.getLong("oficina_user_id"));
                chamado.setVeiculoIdVeiculo(rs.getLong("veiculo_id_veiculo"));
                chamado.setIdChamdo(rs.getLong("id_chamado"));
                chamado.setStatus(rs.getString("status"));
                chamado.setDataAbertura(rs.getDate("data_abertura").toLocalDate());
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return chamado;
    }

    public ChamadoTO save(ChamadoTO chamado){
        String sql = "insert into chamado (cliente_user_id, oficina_user_id, veiculo_id_veiculo, status, data_abertura) values(?,?,?,?,?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, chamado.getClienteUserId());
            ps.setLong(2, chamado.getOficinaUserId());
            ps.setLong(3, chamado.getVeiculoIdVeiculo());
            ps.setString(4, chamado.getStatus());
            ps.setDate(5, Date.valueOf(chamado.getDataAbertura()));
            if (ps.executeUpdate() > 0){
                return chamado;
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

    public boolean delete(Long idChamado){
        String sql = "delete from chamado where id_chamado = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,idChamado);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public ChamadoTO update(ChamadoTO chamado){
        String sql = "update chamado set cliente_user_id = ?, oficina_user_id = ?, veiculo_id_veiculo = ?, status = ?, data_abertura = ? where id_chamado = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, chamado.getClienteUserId());
            ps.setLong(2, chamado.getOficinaUserId());
            ps.setLong(3, chamado.getVeiculoIdVeiculo());
            ps.setString(4, chamado.getStatus());
            ps.setDate(5, Date.valueOf(chamado.getDataAbertura()));
            ps.setLong(6, chamado.getIdChamdo());
            if (ps.executeUpdate() > 0){
                return chamado;
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
