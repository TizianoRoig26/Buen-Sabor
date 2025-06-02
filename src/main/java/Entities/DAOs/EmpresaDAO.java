package Entities.DAOs;

import Entities.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {

    public Empresa getById(Connection conex, Long id) throws SQLException {
        String sqlSelect = "SELECT * FROM empresa WHERE id = ?";
        try (PreparedStatement psSelect = conex.prepareStatement(sqlSelect)) {
            psSelect.setLong(1, id);
            try (ResultSet rs = psSelect.executeQuery()) {
                if (rs.next()) {
                    return Empresa.builder()
                            .id(rs.getLong("id"))
                            .nombre(rs.getString("nombre"))
                            .razonSocial(rs.getString("razon_social"))
                            .cuil(rs.getInt("cuil"))
                            .build();
                }
            }
        }
        return null;
    }

    public List<Empresa> getAll(Connection conex) throws SQLException {
        String sqlSelectAll = "SELECT * FROM empresa";
        List<Empresa> listaEmpresas = new ArrayList<>();

        try (PreparedStatement psSelectAll = conex.prepareStatement(sqlSelectAll);
             ResultSet rs = psSelectAll.executeQuery()) {

            while (rs.next()) {
                Empresa empresa = Empresa.builder()
                        .id(rs.getLong("id"))
                        .nombre(rs.getString("nombre"))
                        .razonSocial(rs.getString("razon_social"))
                        .cuil(rs.getInt("cuil"))
                        .build();
                listaEmpresas.add(empresa);
            }
        }

        return listaEmpresas;
    }

    public Long save(Connection conex, Empresa empresa) throws SQLException {
        String sqlInsert = "INSERT INTO empresa (nombre, razon_social, cuil) VALUES (?, ?, ?)";
        Long idGenerado = null;

        try (PreparedStatement ps = conex.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, empresa.getNombre());
            ps.setString(2, empresa.getRazonSocial());
            ps.setInt(3, empresa.getCuil());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    idGenerado = rs.getLong(1);
                    empresa.setId(idGenerado); // Opcional: guardar el ID en el objeto
                }
            }
        }

        return idGenerado;
    }


    public void update(Connection conex, Empresa empresa) throws SQLException {
        String sqlUpdate = "UPDATE empresa SET nombre = ?, razon_social = ?, cuil = ? WHERE id = ?";

        try (PreparedStatement psUpdate = conex.prepareStatement(sqlUpdate)) {
            psUpdate.setString(1, empresa.getNombre());
            psUpdate.setString(2, empresa.getRazonSocial());
            psUpdate.setInt(3, empresa.getCuil());
            psUpdate.setLong(4, empresa.getId());
            int filasActualizadas = psUpdate.executeUpdate();
            System.out.println("🟡 Filas actualizadas: " + filasActualizadas);
        }
    }

    public void delete(Connection conex, Long id) throws SQLException {
        String sqlDelete = "DELETE FROM empresa WHERE id = ?";

        try (PreparedStatement psDelete = conex.prepareStatement(sqlDelete)) {
            psDelete.setLong(1, id);
            int filasEliminadas = psDelete.executeUpdate();
            System.out.println("🔴 Filas eliminadas: " + filasEliminadas);
        }
    }

}

