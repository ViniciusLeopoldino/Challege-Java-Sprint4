package br.com.fiap.dao;

import br.com.fiap.to.VeiculoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculoDAO extends Repository {
    public ArrayList<VeiculoTO> findAll() {
        ArrayList<VeiculoTO> veiculos = new ArrayList<VeiculoTO>();
        String sql = "SELECT * FROM T_CPS_VEICULO order by id_veiculo";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    VeiculoTO veiculo = new VeiculoTO();
                    veiculo.setIdVeiculo(rs.getLong("ID_VEICULO"));
                    veiculo.setModelo(rs.getString("MODELO"));
                    veiculo.setMarca(rs.getString("MARCA"));
                    veiculo.setCor(rs.getString("COR"));
                    veiculo.setPlaca(rs.getString("PLACA"));
                    veiculo.setAnoVeiculo(rs.getLong("ANO_VEICULO"));
                    veiculo.setChassi(rs.getString("CHASSI"));
                    veiculo.setIdCliente(rs.getLong("ID_CLIENTE"));
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return veiculos;
    }

    public VeiculoTO findByCodigo(Long idVeiculo) {
        VeiculoTO veiculo = new VeiculoTO();
        String sql = "SELECT * FROM T_CPS_VEICULO WHERE id_veiculo = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idVeiculo);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                veiculo.setIdVeiculo(rs.getLong("ID_VEICULO"));
                veiculo.setModelo(rs.getString("MODELO"));
                veiculo.setMarca(rs.getString("MARCA"));
                veiculo.setCor(rs.getString("COR"));
                veiculo.setPlaca(rs.getString("PLACA"));
                veiculo.setAnoVeiculo(rs.getLong("ANO_VEICULO"));
                veiculo.setChassi(rs.getString("CHASSI"));
                veiculo.setIdCliente(rs.getLong("ID_CLIENTE"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return veiculo;
    }
    public VeiculoTO save(VeiculoTO veiculo) {
        String sql = "insert into T_CPS_VEICULO(modelo, marca, cor, placa, ano_veiculo, chassi, id_cliente) values(?,?,?,?,?,?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, veiculo.getModelo());
            ps.setString(2, veiculo.getMarca());
            ps.setString(3, veiculo.getCor());
            ps.setString(4, veiculo.getPlaca());
            ps.setLong(5, veiculo.getAnoVeiculo());
            ps.setString(6, veiculo.getChassi());
            ps.setLong(7, veiculo.getIdCliente());
            if (ps.executeUpdate() > 0) {
                return veiculo;
            }
        } catch (SQLException e) {
            System.out.println("erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo) {
        String sql = "delete from T_CPS_VEICULO where id_veiculo = ?";
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

    public VeiculoTO update(VeiculoTO veiculo) {
        String sql = "update T_CPS_VEICULO set modelo=?, marca=?, cor=?, placa=?,ano_veiculo=?, chassi=?, id_cliente=? where id_veiculo=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, veiculo.getModelo());
            ps.setString(2, veiculo.getMarca());
            ps.setString(3, veiculo.getCor());
            ps.setString(4, veiculo.getPlaca());
            ps.setLong(5, veiculo.getAnoVeiculo());
            ps.setString(6, veiculo.getChassi());
            ps.setLong(7, veiculo.getIdCliente());
            ps.setLong(8, veiculo.getIdVeiculo());
            if (ps.executeUpdate() > 0) {
                return veiculo;
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





