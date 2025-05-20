package g5.ROPA;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class LogInController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField UserField;
	@FXML
	private PasswordField PasswordField;
	@FXML
	private Button CancelButton;
	@FXML
	private Button LogButton;
	@FXML
    private Label WarningText;
	
	public void goToMain(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void acceder(ActionEvent event) throws IOException {
		if (UserField.getText().isBlank() || PasswordField.getText().isBlank()) {
		    WarningText.setText("Llene todas las casillas");
		} else {
		    String consultarUsuario = "SELECT username, password, type, correo FROM usuario WHERE " +
		                              "(username = ? AND password = ?) OR (correo = ? AND password = ?)";
		    Connection conexion = DBConnection.getConnection();
		         PreparedStatement ps;
			try {
				ps = conexion.prepareStatement(consultarUsuario);
		        ps.setString(1, UserField.getText());
		        ps.setString(2, PasswordField.getText());
		        ps.setString(3, UserField.getText());
		        ps.setString(4, PasswordField.getText());

		        ResultSet rs = ps.executeQuery();

		        if (rs.next()) {
		            WarningText.setText("Bienvenido " + rs.getString("username"));
		            Utilityes util = new Utilityes();
		            User usuario = User.getInstance();
		            usuario.setNombre(rs.getString("username"));
		            usuario.setTipo(rs.getString("type"));
		            usuario.setCorreo(rs.getString("correo"));
		            goToMain(event);
		        } else {
		            WarningText.setText("Usuario o contraseña incorrectos");
		        }
		        
		    } catch (SQLException e) {
		        System.err.println("Error al buscar el usuario: " + e.getMessage());
		        WarningText.setText("Error de conexión con la base de datos");
		    }
		}
	}
}
