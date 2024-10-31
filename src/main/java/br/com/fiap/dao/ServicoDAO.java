package br.com.fiap.dao;

import br.com.fiap.to.ClienteTO;
import br.com.fiap.to.OficinaServicoTO;
import br.com.fiap.to.OficinaTO;
import br.com.fiap.to.ServicoTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicoDAO extends Repository{
    public ArrayList<ServicoTO> findAll(){
        ArrayList<ServicoTO> servicos = new ArrayList<ServicoTO>();
        String sql = "select * from servico order by id_servico";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    ServicoTO servico = new ServicoTO();
                    servico.setIdServico(rs.getLong("id_servico"));
                    servico.setTipoServico(rs.getString("tipo_servico"));
                    servicos.add(servico); //Adiciona remedio ao arrayList
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return servicos;
    }

    public ServicoTO findByCodigo(Long idServico){
        ServicoTO servico = new ServicoTO();
        String sql = "select * from servico where id_servico = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idServico);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                servico.setIdServico(rs.getLong("id_servico"));
                servico.setTipoServico(rs.getString("tipo_servico"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return servico;
    }

    public ServicoTO save(ServicoTO servico){
        String sql = "insert into servico (tipo_servico) values(?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, servico.getTipoServico());
            if (ps.executeUpdate() > 0){
                String sqlCodServico = "select id_servico from servico order by id_servico DESC";
                try(PreparedStatement ps1 = getConnection().prepareStatement(sqlCodServico)){
                    ResultSet rs = ps1.executeQuery();
                    if (rs.next()) {
                        long codServico = rs.getLong("id_servico");
                        if (servico.getOficinaServicoTO() != null){
                            String sqlOficinaServico = "insert into oficina_servico (oficina_id_oficina, servico_id_servico, preco_servico) values(?,?,?)";
                            try (PreparedStatement ps2 = getConnection().prepareStatement(sqlOficinaServico)) {
                                OficinaServicoTO oficinaServico = servico.getOficinaServicoTO();
                                ps2.setLong(1, oficinaServico.getOficinaIdOficina());
                                ps2.setLong(2, codServico);
                                ps2.setDouble(3, oficinaServico.getPrecoServico());
                                if (ps2.executeUpdate() <= 0) {
                                    return null;
                                }
                            } catch (SQLException e) {
                                System.out.println("Erro ao salvar: " + e.getMessage());
                            }
                        } else {
                            return null;
                        }
                        return servico;
                    }
                }
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

    public boolean delete(Long idServico){
        String sql = "delete from servico where id_servico = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,idServico);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public ServicoTO update(ServicoTO servico){
        String sql = "update servico set tipo_servico = ? where id_servico = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, servico.getTipoServico());
            ps.setLong(2, servico.getIdServico());
            if (ps.executeUpdate() > 0){
                return servico;
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
