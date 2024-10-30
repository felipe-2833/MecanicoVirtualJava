package br.com.fiap.dao;

import br.com.fiap.to.ClienteTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO extends Repository{
    public ArrayList<ClienteTO> findAll(){
        ArrayList<ClienteTO> clientes = new ArrayList<ClienteTO>();
        String sql = "select * from cliente order by cliente_id_user";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    ClienteTO cliente = new ClienteTO();
                    cliente.setClienteIdUser(rs.getLong("cliente_id_user"));
                    cliente.setNumeroCNH(rs.getString("numero_cnh"));
                    cliente.setCPFCliente(rs.getString("cpf_cliente"));
                    cliente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                    cliente.setSexo(rs.getString("sexo").charAt(0));
                    clientes.add(cliente); //Adiciona remedio ao arrayList
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return clientes;
    }

    public ClienteTO findByCodigo(Long clienteIdUser){
        ClienteTO cliente = new ClienteTO();
        String sql = "select * from cliente where cliente_id_user = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, clienteIdUser);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                cliente.setClienteIdUser(rs.getLong("cliente_id_user"));
                cliente.setNumeroCNH(rs.getString("numero_cnh"));
                cliente.setCPFCliente(rs.getString("cpf_cliente"));
                cliente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                cliente.setSexo(rs.getString("sexo").charAt(0));
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return cliente;
    }

    public boolean delete(Long clienteIdUser){
        String sql = "delete from cliente where cliente_id_user = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,clienteIdUser);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public ClienteTO update(ClienteTO cliente){
        String sql = "update cliente set numero_cnh = ?, cpf_cliente = ?, data_nascimento = ?, sexo = ? where cliente_id_user = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, cliente.getNumeroCNH());
            ps.setString(2, cliente.getCPFCliente());
            ps.setDate(3, Date.valueOf(cliente.getDataNascimento()));
            ps.setString(4, String.valueOf(cliente.getSexo()));
            ps.setLong(5, cliente.getClienteIdUser());
            if (ps.executeUpdate() > 0){
                return cliente;
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
