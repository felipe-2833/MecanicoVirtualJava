package br.com.fiap.dao;

import br.com.fiap.to.AgendamentoTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AgendamentoDAO extends Repository{
    public ArrayList<AgendamentoTO> findAll(){
        ArrayList<AgendamentoTO> agendamentos = new ArrayList<AgendamentoTO>();
        String sql = "select * from agendamento order by id_agenda";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    AgendamentoTO agendamento = new AgendamentoTO();
                    agendamento.setChamadoIdChamado(rs.getLong("chamado_id_chamado"));
                    agendamento.setIdAgenda(rs.getLong("id_agenda"));
                    agendamento.setDataAgendamentoChamado(rs.getDate("data_agendamento_chamado").toLocalDate());
                    agendamentos.add(agendamento); //Adiciona remedio ao arrayList
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return agendamentos;
    }

    public AgendamentoTO findByCodigo(Long idAgendamento){
        AgendamentoTO agendamento = new AgendamentoTO();
        String sql = "select * from agendamento where id_agenda = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idAgendamento);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                agendamento.setChamadoIdChamado(rs.getLong("chamado_id_chamado"));
                agendamento.setIdAgenda(rs.getLong("id_agenda"));
                agendamento.setDataAgendamentoChamado(rs.getDate("data_agendamento_chamado").toLocalDate());
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return agendamento;
    }

    public AgendamentoTO save(AgendamentoTO agendamento){
        String sql = "insert into agendamento (chamado_id_chamado, data_agendamento_chamado) values(?,?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, agendamento.getChamadoIdChamado());
            ps.setDate(2, Date.valueOf(agendamento.getDataAgendamentoChamado()));
            if (ps.executeUpdate() > 0){
                return agendamento;
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

    public boolean delete(Long idAgendamento){
        String sql = "delete from agendamento where id_agenda = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,idAgendamento);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public AgendamentoTO update(AgendamentoTO agendamento){
        String sql = "update agendamento set chamado_id_chamado = ?, data_agendamento_chamado = ? where id_agenda = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, agendamento.getChamadoIdChamado());
            ps.setDate(2, Date.valueOf(agendamento.getDataAgendamentoChamado()));
            ps.setLong(3, agendamento.getIdAgenda());
            if (ps.executeUpdate() > 0){
                return agendamento;
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
