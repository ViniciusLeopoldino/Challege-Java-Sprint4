package br.com.fiap.dao;

import br.com.fiap.to.ClienteTO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO extends Repository {
    public ArrayList<ClienteTO> findAll() {
        ArrayList<ClienteTO> clientes = new ArrayList<ClienteTO>();
        String sql = "SELECT * FROM T_CPS_CLIENTE order by id_cliente";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ClienteTO cliente = new ClienteTO();
                    cliente.setIdCliente(rs.getLong("ID_CLIENTE"));
                    cliente.setNome(rs.getString("NOME"));
                    cliente.setEmail(rs.getString("EMAIL"));
                    cliente.setDocumento(rs.getString("DOCUMENTO"));
                    cliente.setSeguroVeiculo(rs.getString("SEGURO_VEICULO"));
                    cliente.setEndereco(rs.getString("ENDERECO"));
                    cliente.setAnoNascimento(rs.getLong("ANO_NASCIMENTO"));
                    cliente.setSenha(rs.getString("SENHA"));
                    cliente.setTelefone(rs.getLong("TELEFONE"));
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return clientes;
    }

    public ClienteTO findById(Long id) {
        ClienteTO cliente = new ClienteTO();
        String sql = "SELECT * FROM T_CPS_CLIENTE WHERE id_cliente = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                cliente.setIdCliente(rs.getLong("ID_CLIENTE"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setEmail(rs.getString("EMAIL"));
                cliente.setDocumento(rs.getString("DOCUMENTO"));
                cliente.setSeguroVeiculo(rs.getString("SEGURO_VEICULO"));
                cliente.setEndereco(rs.getString("ENDERECO"));
                cliente.setAnoNascimento(rs.getLong("ANO_NASCIMENTO"));
                cliente.setSenha(rs.getString("SENHA"));
                cliente.setTelefone(rs.getLong("TELEFONE"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return cliente;
    }

    public ClienteTO save(ClienteTO cliente) {
        String sql = "insert into T_CPS_CLIENTE(nome, email, documento, seguro_veiculo, endereco, ano_nascimento, senha, telefone) values(?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getDocumento());
            ps.setString(4, cliente.getSeguroVeiculo());
            ps.setString(5, cliente.getEndereco());
            ps.setLong(6, cliente.getAnoNascimento());
            ps.setString(7, cliente.getSenha());
            ps.setLong(8, cliente.getTelefone());
            if (ps.executeUpdate() > 0) {
                return cliente;
            }
        } catch (SQLException e) {
            System.out.println("erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo) {
        String sql = "delete from T_CPS_CLIENTE where id_cliente = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return false;
    }

    public ClienteTO update(ClienteTO cliente) {
        String sql = "update T_CPS_CLIENTE set nome=?, email=?, documento=?,seguro_veiculo=?, endereco=?, ano_nascimento=?, senha=?, telefone=? where id_cliente=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
           ps.setString(1, cliente.getNome());
           ps.setString(2, cliente.getEmail());
           ps.setString(3, cliente.getDocumento());
           ps.setString(4, cliente.getSeguroVeiculo());
           ps.setString(5, cliente.getEndereco());
           ps.setLong(6, cliente.getAnoNascimento());
           ps.setString(7, cliente.getSenha());
           ps.setLong(8, cliente.getTelefone());
           ps.setLong(9, cliente.getIdCliente());
            if (ps.executeUpdate() > 0) {
                return cliente;
            } else {
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

