package br.com.fiap.dao;

import br.com.fiap.to.EnderecoTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnderecoDAO extends Repository{
    public ArrayList<EnderecoTO> findAll(){
        ArrayList<EnderecoTO> enderecos = new ArrayList<EnderecoTO>();
        String sql = "select * from endereco order by id_endereco";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    EnderecoTO endereco = new EnderecoTO();
                    endereco.setIdEndereco(rs.getLong("id_endereco"));
                    endereco.setEnderecoIdUser(rs.getLong("endereco_id_user"));
                    endereco.setCep(rs.getString("cep"));
                    endereco.setRua(rs.getString("rua"));
                    endereco.setCidade(rs.getString("cidade"));
                    endereco.setEstado(rs.getString("estado"));
                    endereco.setNumero(rs.getInt("numero"));
                    enderecos.add(endereco); //Adiciona remedio ao arrayList
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return enderecos;
    }

    public EnderecoTO findByCodigo(Long idEndereco){
        EnderecoTO endereco = new EnderecoTO();
        String sql = "select * from endereco where id_endereco = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idEndereco);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                endereco.setIdEndereco(rs.getLong("id_endereco"));
                endereco.setEnderecoIdUser(rs.getLong("endereco_id_user"));
                endereco.setCep(rs.getString("cep"));
                endereco.setRua(rs.getString("rua"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setNumero(rs.getInt("numero"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return endereco;
    }

    public EnderecoTO save(EnderecoTO endereco){
        String sql = "insert into endereco (endereco_id_user, cep, rua, cidade, estado, numero) values(?,?,?,?,?,?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, endereco.getEnderecoIdUser());
            ps.setString(2, endereco.getCep());
            ps.setString(3, endereco.getRua());
            ps.setString(4, endereco.getCidade());
            ps.setString(5, endereco.getEstado());
            ps.setInt(6, endereco.getNumero());
            if (ps.executeUpdate() > 0){
                return endereco;
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

    public boolean delete(Long idEndereco){
        String sql = "delete from endereco where id_endereco = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,idEndereco);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public EnderecoTO update(EnderecoTO endereco){
        String sql = "update ddd_endereco_farma set endereco_id_user = ?, cep = ?, rua = ?, cidade = ?, estado = ?, numero = ? where id_endereco = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, endereco.getEnderecoIdUser());
            ps.setString(2, endereco.getCep());
            ps.setString(3, endereco.getRua());
            ps.setString(4, endereco.getCidade());
            ps.setString(5, endereco.getEstado());
            ps.setInt(6, endereco.getNumero());
            ps.setLong(7, endereco.getIdEndereco());
            if (ps.executeUpdate() > 0){
                return endereco;
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
