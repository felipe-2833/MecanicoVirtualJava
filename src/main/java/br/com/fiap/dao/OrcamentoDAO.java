package br.com.fiap.dao;

import br.com.fiap.to.OficinaServicoTO;
import br.com.fiap.to.OrcamentoPecasTO;
import br.com.fiap.to.OrcamentoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrcamentoDAO extends Repository{
    public ArrayList<OrcamentoTO> findAll(){
        ArrayList<OrcamentoTO> orcamentos = new ArrayList<OrcamentoTO>();
        String sql = "select * from orcamento order by id_orcamento";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    OrcamentoTO orcamento = new OrcamentoTO();
                    orcamento.setIdOrcamento(rs.getLong("id_orcamento"));
                    orcamento.setDiagnosticoIdDiagnostico(rs.getLong("diagnostico_id_diagnostico"));
                    orcamento.setOficinaIdOficina(rs.getLong("oficina_id_oficina"));
                    orcamento.setServicoIdServico(rs.getLong("servico_id_servico"));
                    orcamentos.add(orcamento); //Adiciona remedio ao arrayList
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return orcamentos;
    }

    public OrcamentoTO findByCodigo(Long idOrcamento){
        OrcamentoTO orcamento = new OrcamentoTO();
        String sql = "select * from orcamento where id_orcamento = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idOrcamento);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                orcamento.setIdOrcamento(rs.getLong("id_orcamento"));
                orcamento.setDiagnosticoIdDiagnostico(rs.getLong("diagnostico_id_diagnostico"));
                orcamento.setOficinaIdOficina(rs.getLong("oficina_id_oficina"));
                orcamento.setServicoIdServico(rs.getLong("servico_id_servico"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return orcamento;
    }

    public OrcamentoTO save(OrcamentoTO orcamento){
        String sql = "insert into orcamento (diagnostico_id_diagnostico, oficina_id_oficina, servico_id_servico) values(?,?,?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, orcamento.getDiagnosticoIdDiagnostico());
            ps.setLong(2, orcamento.getOficinaIdOficina());
            ps.setLong(3, orcamento.getServicoIdServico());
            if (ps.executeUpdate() > 0){
                String sqlOrcamento = "select id_orcamento from orcamento order by id_orcamento DESC";
                try(PreparedStatement ps1 = getConnection().prepareStatement(sqlOrcamento)){
                    ResultSet rs = ps1.executeQuery();
                    if (rs.next()) {
                        long codOrcamento = rs.getLong("id_orcamento");
                        for (OrcamentoPecasTO orcamentoPecas : orcamento.getOrcamentoPecasTO()) {
                            String sqlOrcamentoPecas = "insert into orcamento_pecas (orcamento_id_orcamento, pecas_id_peca, quantidade) values(?,?,?)";
                            try (PreparedStatement ps2 = getConnection().prepareStatement(sqlOrcamentoPecas)) {
                                ps2.setLong(1, codOrcamento);
                                ps2.setLong(2, orcamentoPecas.getPecasIdPecas());
                                ps2.setDouble(3, orcamentoPecas.getQuantidade());
                                if (ps2.executeUpdate() <= 0) {
                                    return null;
                                }
                            } catch (SQLException e) {
                                System.out.println("Erro ao salvar: " + e.getMessage());
                            }
                        }
                        return orcamento;
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

    public boolean delete(Long idOrcamento){
        String sql = "delete from orcamento where id_orcamento = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,idOrcamento);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public OrcamentoTO update(OrcamentoTO orcamento){
        String sql = "update orcamento set diagnostico_id_diagnostico = ?, oficina_id_oficina = ?, servico_id_servico = ? where id_orcamento = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, orcamento.getDiagnosticoIdDiagnostico());
            ps.setLong(2, orcamento.getOficinaIdOficina());
            ps.setLong(3, orcamento.getServicoIdServico());
            ps.setLong(4, orcamento.getIdOrcamento());
            if (ps.executeUpdate() > 0){
                return orcamento;
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
