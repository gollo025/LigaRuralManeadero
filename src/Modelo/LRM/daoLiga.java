/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.LRM;

import ClaseConexion.Conexion1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;                   // java.sql.Date para el PreparedStatement
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gzlzz
 */

public class daoLiga {

    // Instancia de tu manejador de conexión
    public final Conexion1 cx = new Conexion1();

    public daoLiga() { }

    /**
     * Inserta una nueva Liga en la BD.
     * @param liga Objeto Liga con nameLiga, fechaInicio y fechaFin.
     * @return true si la inserción fue exitosa.
     */
    public boolean create(Liga liga) {
        String sql = "INSERT INTO liga (nameLiga, fechaInicio, fechaFin) VALUES (?, ?, ?)";
        
        // try-with-resources para cerrar conn y ps automáticamente
        try (Connection conn = cx.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Convertir de java.util.Date a java.sql.Date
            Date fi = new Date(liga.getFechaInicio().getTime());
            Date ff = new Date(liga.getFechaFin().getTime());

            ps.setString(1, liga.getNameLiga());
            ps.setDate(2, fi);
            ps.setDate(3, ff);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException ex) {
            Logger.getLogger(daoLiga.class.getName())
                  .log(Level.SEVERE, "Error al insertar liga", ex);
            return false;
        }
    }
}
