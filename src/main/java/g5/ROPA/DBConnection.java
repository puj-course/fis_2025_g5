package g5.ROPA;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String URL ="jdbc:mysql://root:qtBRtoiMJYRuQfPchGUjvhwdaRBmxbkZ@hopper.proxy.rlwy.net:39806/railway";
	private static String USER = "root";
	private static String PASS = "qtBRtoiMJYRuQfPchGUjvhwdaRBmxbkZ";
	private static Connection conex;
	
	
    @SuppressWarnings("exports")
	public static Connection getConnection() {

        if(conex == null){
            try {
                conex = DriverManager.getConnection(URL,USER,PASS);
            }
            catch (SQLException ex){
                System.out.println("Error: " + ex.toString());
                ex.printStackTrace();
            }
        }
        System.out.println("se conecto");
        return conex;
    }

    public static void terminateConnection() {
        if (conex != null) {
            try {
                conex.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
                ex.printStackTrace();
            }
        }
    }
}
