package controladores;
import java.sql.Connection;
import java.sql.DriverManager;
public class DataBaseConnection {
public Connection databaseLink;
public Connection getConnection() {
    String nombrebasedatos = "sys";
    String usuariobasedatos ="root";
    String contrabasedatos = "Javeriana2024$";

    String url = "jdbc:mysql://localhost/" + nombrebasedatos;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        databaseLink = DriverManager.getConnection(url, usuariobasedatos, contrabasedatos);
    } catch (Exception e) {
        e.printStackTrace();
    }

    return databaseLink;
}
    }

