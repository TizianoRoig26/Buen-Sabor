package Entities.DAOs;

import Entities.Sucursal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

public class SucursalDAO {

    public void save(Connection conex, Sucursal sucursal, Long empresaId) throws SQLException {

        String sqlInsert = "INSERT INTO sucursal (nombre, horario_apertura, horario_cierre, empresa_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conex.prepareStatement(sqlInsert)) {
            ps.setString(1, sucursal.getNombre());
            ps.setTime(2, Time.valueOf(sucursal.getHorarioApertura()));
            ps.setTime(3, Time.valueOf(sucursal.getHorarioCierre()));
            ps.setLong(4, empresaId);
            ps.executeUpdate();
        }

    }
}
