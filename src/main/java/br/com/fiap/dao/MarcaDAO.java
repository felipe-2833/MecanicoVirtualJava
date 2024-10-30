package br.com.fiap.dao;

import br.com.fiap.to.MarcaTO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MarcaDAO extends Repository{
    public ArrayList<MarcaTO> findAll(){
        ArrayList<MarcaTO> marcas = new ArrayList<MarcaTO>();
        String sql = "select * from marca order by id_marca";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    MarcaTO marca = new MarcaTO();
                    marca.setIdMarca(rs.getLong("id_marca"));
                    marca.setNomeMarca(rs.getString("nome_marca"));
                    marcas.add(marca); //Adiciona remedio ao arrayList
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return marcas;
    }

    public MarcaTO findByCodigo(Long idMarca){
        MarcaTO marca = new MarcaTO();
        String sql = "select * from marca where id_marca = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idMarca);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                marca.setIdMarca(rs.getLong("id_marca"));
                marca.setNomeMarca(rs.getString("nome_marca"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return marca;
    }

    public MarcaTO save(MarcaTO marca){
        String sql = "insert into marca (nome_marca) values(?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, marca.getNomeMarca());
            if (ps.executeUpdate() > 0){
                return marca;
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

    public boolean delete(Long idMarca){
        String sql = "delete from marca where id_marca = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,idMarca);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public MarcaTO update(MarcaTO marca){
        String sql = "update marca set nome_marca = ? where id_marca = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, marca.getNomeMarca());
            ps.setLong(2, marca.getIdMarca());
            if (ps.executeUpdate() > 0){
                return marca;
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
