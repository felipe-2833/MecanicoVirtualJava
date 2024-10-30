package br.com.fiap.dao;

import br.com.fiap.to.UsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO extends Repository{
    public ArrayList<UsuarioTO> findAll(){
        ArrayList<UsuarioTO> usuarios = new ArrayList<UsuarioTO>();
        String sql = "select * from usuario order by id_user";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    UsuarioTO usuario = new UsuarioTO();
                    usuario.setIdUser(rs.getLong("id_user"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setSobrenome(rs.getString("sobrenome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenhaHashed(rs.getString("senha_hashed"));
                    usuario.setTipoUsuario(rs.getString("tipo_usuario"));
                    usuario.setTelefoneCelular(rs.getString("telefone_celular"));
                    usuarios.add(usuario); //Adiciona remedio ao arrayList
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return usuarios;
    }

    public UsuarioTO findByCodigo(Long idUser){
        UsuarioTO usuario = new UsuarioTO();
        String sql = "select * from usuario where id_user = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idUser);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                usuario.setIdUser(rs.getLong("id_user"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSobrenome(rs.getString("sobrenome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenhaHashed(rs.getString("senha_hashed"));
                usuario.setTipoUsuario(rs.getString("tipo_usuario"));
                usuario.setTelefoneCelular(rs.getString("telefone_celular"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return usuario;
    }

    public UsuarioTO save(UsuarioTO usuario){
        String sql = "insert into usuario (nome, sobrenome, email, senha_hashed, tipo_usuario, telefone_celular) values(?,?,?,?,?,?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSobrenome());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenhaHashed());
            ps.setString(5, usuario.getTipoUsuario());
            ps.setString(6, usuario.getTelefoneCelular());
            if (ps.executeUpdate() > 0){
                return usuario;
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

    public boolean delete(Long idUser){
        String sql = "delete from usuario where id_user = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,idUser);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public UsuarioTO update(UsuarioTO usuario){
        String sql = "update usuario set nome = ?, sobrenome = ?, email = ?, senha_hashed = ?, tipo_usuario = ?, telefone_celular = ? where id_user = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSobrenome());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenhaHashed());
            ps.setString(5, usuario.getTipoUsuario());
            ps.setString(6, usuario.getTelefoneCelular());
            ps.setLong(7, usuario.getIdUser());
            if (ps.executeUpdate() > 0){
                return usuario;
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
