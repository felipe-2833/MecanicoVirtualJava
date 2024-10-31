package br.com.fiap.dao;

import br.com.fiap.to.VeiculoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculoDAO extends Repository{
    public ArrayList<VeiculoTO> findAll(){
        ArrayList<VeiculoTO> veiculos = new ArrayList<VeiculoTO>();
        String sql = "select * from veiculo order by id_veiculo";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    VeiculoTO veiculo = new VeiculoTO();
                    veiculo.setIdVeiculo(rs.getLong("id_veiculo"));
                    veiculo.setIdModelo(rs.getLong("id_modelo"));
                    veiculo.setClienteIdUser(rs.getLong("cliente_id_user"));
                    veiculo.setTipoVeiculo(rs.getString("tipo_veiculo"));
                    veiculo.setPlacaveiculo(rs.getString("placa_veiculo"));
                    veiculo.setAnoModelo(rs.getInt("ano_modelo"));
                    veiculo.setAnoFabricacao(rs.getInt("ano_fabricacao"));
                    veiculo.setHistoricoManutencao(rs.getString("historico_manutencao"));
                    veiculo.setCor(rs.getString("cor"));
                    veiculo.setCombustivel(rs.getString("combustivel"));
                    veiculo.setMotor(rs.getString("motor"));
                    veiculo.setQuilometragem(rs.getDouble("quilometragem"));
                    veiculo.setTipoOleo(rs.getString("tipo_oleo"));
                    veiculos.add(veiculo); //Adiciona remedio ao arrayList
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return veiculos;
    }

    public VeiculoTO findByCodigo(Long idVeiculo){
        VeiculoTO veiculo = new VeiculoTO();
        String sql = "select * from veiculo where id_veiculo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idVeiculo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                veiculo.setIdVeiculo(rs.getLong("id_veiculo"));
                veiculo.setIdModelo(rs.getLong("id_modelo"));
                veiculo.setClienteIdUser(rs.getLong("cliente_id_user"));
                veiculo.setTipoVeiculo(rs.getString("tipo_veiculo"));
                veiculo.setPlacaveiculo(rs.getString("placa_veiculo"));
                veiculo.setAnoModelo(rs.getInt("ano_modelo"));
                veiculo.setAnoFabricacao(rs.getInt("ano_fabricacao"));
                veiculo.setHistoricoManutencao(rs.getString("historico_manutencao"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setCombustivel(rs.getString("combustivel"));
                veiculo.setMotor(rs.getString("motor"));
                veiculo.setQuilometragem(rs.getDouble("quilometragem"));
                veiculo.setTipoOleo(rs.getString("tipo_oleo"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return veiculo;
    }

    public VeiculoTO save(VeiculoTO veiculo){
        String sql = "insert into veiculo (id_modelo, cliente_id_user, tipo_veiculo, placa_veiculo, ano_modelo, ano_fabricacao, historico_manutencao,cor,combustivel, motor, quilometragem, tipo_oleo) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, veiculo.getIdModelo());
            ps.setLong(2, veiculo.getClienteIdUser());
            ps.setString(3, veiculo.getTipoVeiculo());
            ps.setString(4, veiculo.getPlacaveiculo());
            ps.setInt(5, veiculo.getAnoModelo());
            ps.setInt(6, veiculo.getAnoFabricacao());
            ps.setString(7, veiculo.getHistoricoManutencao());
            ps.setString(8, veiculo.getCor());
            ps.setString(9, veiculo.getCombustivel());
            ps.setString(10, veiculo.getMotor());
            ps.setDouble(11, veiculo.getQuilometragem());
            ps.setString(12, veiculo.getTipoOleo());
            if (ps.executeUpdate() > 0){
                return veiculo;
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

    public boolean delete(Long idVeiculo){
        String sql = "delete from veiculo where id_veiculo = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,idVeiculo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public VeiculoTO update(VeiculoTO veiculo){
        String sql = "update veiculo set id_modelo = ?, cliente_id_user = ?, tipo_veiculo = ?, placa_veiculo = ?, ano_modelo = ?, ano_fabricacao = ?, historico_manutencao = ?,cor = ?,combustivel = ?, motor = ?, quilometragem = ?, tipo_oleo = ? where id_veiculo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, veiculo.getIdModelo());
            ps.setLong(2, veiculo.getClienteIdUser());
            ps.setString(3, veiculo.getTipoVeiculo());
            ps.setString(4, veiculo.getPlacaveiculo());
            ps.setInt(5, veiculo.getAnoModelo());
            ps.setInt(6, veiculo.getAnoFabricacao());
            ps.setString(7, veiculo.getHistoricoManutencao());
            ps.setString(8, veiculo.getCor());
            ps.setString(9, veiculo.getCombustivel());
            ps.setString(10, veiculo.getMotor());
            ps.setDouble(11, veiculo.getQuilometragem());
            ps.setString(12, veiculo.getTipoOleo());
            ps.setLong(13, veiculo.getIdVeiculo());
            if (ps.executeUpdate() > 0){
                return veiculo;
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
