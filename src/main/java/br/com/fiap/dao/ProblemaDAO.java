package br.com.fiap.dao;

import br.com.fiap.to.ProblemaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProblemaDAO extends Repository{
    public ArrayList<ProblemaTO> findAll(){
        ArrayList<ProblemaTO> problemas = new ArrayList<ProblemaTO>();
        String sql = "select * from problema order by id_problema";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    ProblemaTO problema = new ProblemaTO();
                    problema.setVeiculoIdVeiculo(rs.getLong("veiculo_id_veiculo"));
                    problema.setIdProblema(rs.getLong("id_problema"));
                    problema.setTipoProblema(rs.getString("tipo_problema"));
                    problema.setRelatoProblema(rs.getString("relato_problema"));
                    problemas.add(problema); //Adiciona remedio ao arrayList
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return problemas;
    }

    public ProblemaTO findByCodigo(Long idProblema){
        ProblemaTO problema = new ProblemaTO();
        String sql = "select * from problema where id_problema = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idProblema);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                problema.setVeiculoIdVeiculo(rs.getLong("veiculo_id_veiculo"));
                problema.setIdProblema(rs.getLong("id_problema"));
                problema.setTipoProblema(rs.getString("tipo_problema"));
                problema.setRelatoProblema(rs.getString("relato_problema"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return problema;
    }

    public ProblemaTO save(ProblemaTO problema){
        String sql = "insert into problema (veiculo_id_veiculo,tipo_problema,relato_problema) values(?,?,?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, problema.getVeiculoIdVeiculo());
            ps.setString(2, problema.getTipoProblema());
            ps.setString(3, problema.getRelatoProblema());
            if (ps.executeUpdate() > 0){
                return problema;
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

    public boolean delete(Long idProblema){
        String sql = "delete from problema where id_problema = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,idProblema);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public ProblemaTO update(ProblemaTO problema){
        String sql = "update problema set veiculo_id_veiculo = ?, tipo_problema = ?, relato_problema = ? where id_problema = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, problema.getVeiculoIdVeiculo());
            ps.setString(2, problema.getTipoProblema());
            ps.setString(3, problema.getRelatoProblema());
            ps.setLong(4, problema.getIdProblema());
            if (ps.executeUpdate() > 0){
                return problema;
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
