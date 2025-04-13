package Modelo.LRM;

import ClaseConexion.Conexion1;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class daoUsuario {

    // Instancia de conexión a la base de datos
    Conexion1 cx = new Conexion1();

    // Constructor
    public daoUsuario() {
    }

    // Método para registrar un usuario
    public boolean create(Usuario nombreUsuario) {
        PreparedStatement ps = null;
        try {
            // Conexión a la base de datos
            if (cx.conectar() == null) {
                System.out.println("Error: No se pudo establecer la conexión");
                return false;
            }

            // Consulta SQL para insertar un nuevo usuario
            String sqlInsert = "INSERT INTO usuario (idusuario, nombreUsuario, password, rol) VALUES (null, ?, ?, 'usuario')";

            // Preparar la consulta con parámetros
            ps = cx.conectar().prepareStatement(sqlInsert);
            ps.setString(1, nombreUsuario.getNombreUsuario());      // Nombre de usuario
            ps.setString(2, nombreUsuario.getPassword()); // Contraseña

            // Ejecutar la consulta
            ps.execute();
            System.out.println("Usuario registrado exitosamente");

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(daoUsuario.class.getName()).log(Level.SEVERE, "Error al registrar usuario", ex);
            return false; // Retorna falso si hay un error

        } finally {
            try {
                // Asegurar que se cierre el PreparedStatement
                if (ps != null) {
                    ps.close();
                }
                cx.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(daoUsuario.class.getName()).log(Level.SEVERE, "Error al cerrar recursos", ex);
            }
        }
    }
}
