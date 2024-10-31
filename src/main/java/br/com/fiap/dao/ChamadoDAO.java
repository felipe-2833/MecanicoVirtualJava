package br.com.fiap.dao;

import br.com.fiap.to.ChamadoTO;

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
                    chamado.setIdEndereco(rs.getLong("id_chamado"));
                    chamado.setEnderecoIdUser(rs.getLong("chamado_id_user"));
                    chamado.setCep(rs.getString("cep"));
                    chamado.setRua(rs.getString("rua"));
                    chamado.setCidade(rs.getString("cidade"));
                    chamado.setEstado(rs.getString("estado"));
                    chamado.setNumero(rs.getInt("numero"));
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
                chamado.setIdEndereco(rs.getLong("id_chamado"));
                chamado.setEnderecoIdUser(rs.getLong("chamado_id_user"));
                chamado.setCep(rs.getString("cep"));
                chamado.setRua(rs.getString("rua"));
                chamado.setCidade(rs.getString("cidade"));
                chamado.setEstado(rs.getString("estado"));
                chamado.setNumero(rs.getInt("numero"));
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
        String sql = "insert into chamado (chamado_id_user, cep, rua, cidade, estado, numero) values(?,?,?,?,?,?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, chamado.getEnderecoIdUser());
            ps.setString(2, chamado.getCep());
            ps.setString(3, chamado.getRua());
            ps.setString(4, chamado.getCidade());
            ps.setString(5, chamado.getEstado());
            ps.setInt(6, chamado.getNumero());
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
        String sql = "update chamado set chamado_id_user = ?, cep = ?, rua = ?, cidade = ?, estado = ?, numero = ? where id_chamado = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, chamado.getEnderecoIdUser());
            ps.setString(2, chamado.getCep());
            ps.setString(3, chamado.getRua());
            ps.setString(4, chamado.getCidade());
            ps.setString(5, chamado.getEstado());
            ps.setInt(6, chamado.getNumero());
            ps.setLong(7, chamado.getIdEndereco());
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
