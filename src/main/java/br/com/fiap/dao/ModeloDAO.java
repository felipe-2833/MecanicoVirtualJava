package br.com.fiap.dao;

import br.com.fiap.to.ModeloTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloDAO extends Repository{
    public ArrayList<ModeloTO> findAll(){
        ArrayList<ModeloTO> modelos = new ArrayList<ModeloTO>();
        String sql = "select * from modelo order by id_modelo";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    ModeloTO modelo = new ModeloTO();
                    modelo.setIdModelo(rs.getLong("id_modelo"));
                    modelo.setMarcaIdMarca(rs.getLong("marca_id_marca"));
                    modelo.setNomeModelo(rs.getString("nome_modelo"));
                    modelo.setCarroceria(rs.getString("carroceria"));
                    modelos.add(modelo); //Adiciona remedio ao arrayList
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return modelos;
    }

    public ModeloTO findByCodigo(Long idModelo){
        ModeloTO modelo = new ModeloTO();
        String sql = "select * from modelo where id_modelo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idModelo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                modelo.setIdModelo(rs.getLong("id_modelo"));
                modelo.setMarcaIdMarca(rs.getLong("marca_id_marca"));
                modelo.setNomeModelo(rs.getString("nome_modelo"));
                modelo.setCarroceria(rs.getString("carroceria"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return modelo;
    }

    public ModeloTO save(ModeloTO modelo){
        String sql = "insert into modelo (marca_id_marca, nome_modelo, carroceria) values(?,?,?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, modelo.getMarcaIdMarca());
            ps.setString(2, modelo.getNomeModelo());
            ps.setString(3, modelo.getCarroceria());
            if (ps.executeUpdate() > 0){
                return modelo;
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

    public boolean delete(Long idModelo){
        String sql = "delete from modelo where id_modelo = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,idModelo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public ModeloTO update(ModeloTO modelo){
        String sql = "update modelo set marca_id_marca = ?, nome_modelo = ?, carroceria = ? where id_modelo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, modelo.getMarcaIdMarca());
            ps.setString(2, modelo.getNomeModelo());
            ps.setString(3, modelo.getCarroceria());
            ps.setLong(4, modelo.getIdModelo());
            if (ps.executeUpdate() > 0){
                return modelo;
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
