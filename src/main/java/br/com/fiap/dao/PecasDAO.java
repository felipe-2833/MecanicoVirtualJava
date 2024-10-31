package br.com.fiap.dao;

import br.com.fiap.to.PecasTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PecasDAO extends Repository{
    public ArrayList<PecasTO> findAll(){
        ArrayList<PecasTO> pecasList = new ArrayList<PecasTO>();
        String sql = "select * from pecas order by id_peca";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    PecasTO pecas = new PecasTO();
                    pecas.setIdPecas(rs.getLong("id_peca"));
                    pecas.setNomePeca(rs.getString("nome_peca"));
                    pecas.setMarca(rs.getString("marca"));
                    pecas.setModelo(rs.getString("modelo"));
                    pecas.setCategoria(rs.getString("categoria"));
                    pecas.setPrecoPeca(rs.getDouble("preco_peca"));
                    pecasList.add(pecas); //Adiciona remedio ao arrayList
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return pecasList;
    }

    public PecasTO findByCodigo(Long idPecas){
        PecasTO pecas = new PecasTO();
        String sql = "select * from pecas where id_peca = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idPecas);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                pecas.setIdPecas(rs.getLong("id_peca"));
                pecas.setNomePeca(rs.getString("nome_peca"));
                pecas.setMarca(rs.getString("marca"));
                pecas.setModelo(rs.getString("modelo"));
                pecas.setCategoria(rs.getString("categoria"));
                pecas.setPrecoPeca(rs.getDouble("preco_peca"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return pecas;
    }

    public PecasTO save(PecasTO pecas){
        String sql = "insert into pecas (nome_peca, marca, modelo, categoria, preco_peca) values(?,?,?,?,?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, pecas.getNomePeca());
            ps.setString(2, pecas.getMarca());
            ps.setString(3, pecas.getModelo());
            ps.setString(4, pecas.getCategoria());
            ps.setDouble(5, pecas.getPrecoPeca());
            if (ps.executeUpdate() > 0){
                return pecas;
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

    public boolean delete(Long idPecas){
        String sql = "delete from pecas where id_peca = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,idPecas);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public PecasTO update(PecasTO pecas){
        String sql = "update pecas set nome_peca = ?, marca = ?, modelo = ?, categoria = ?, preco_peca = ? where id_peca = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, pecas.getNomePeca());
            ps.setString(2, pecas.getMarca());
            ps.setString(3, pecas.getModelo());
            ps.setString(4, pecas.getCategoria());
            ps.setDouble(5, pecas.getPrecoPeca());
            ps.setLong(6, pecas.getIdPecas());
            if (ps.executeUpdate() > 0){
                return pecas;
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
