
package ClaseConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion1 {
    private String url = "jdbc:mysql://localhost:3306/LigaRuralManeadero?useSSL=false&serverTimezone=UTC";
    private String user = "root";
    private String password = "";
    private Connection cx;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver JDBC
            cx = DriverManager.getConnection(url, user, password);
            System.out.println("¡Conexión exitosa a la base de datos!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar con la base de datos:");
            e.printStackTrace();
        }
        return cx;
    }

    public void desconectar() {
        try {
            if (cx != null && !cx.isClosed()) {
                cx.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Conexion1 conexion = new Conexion1 ();
        conexion.conectar();
        conexion.desconectar();
    }
}
