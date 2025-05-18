package g5.ROPA;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

public class SignupPController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField UserField;
	@FXML
	private TextField InfoField;
	@FXML
	private TextField URLPageField;
	@FXML
	private TextField URLImageField;
	@FXML
	private TextField MailField;
	@FXML
	private PasswordField PasswordField;
	@FXML
	private Button CancelButton;
	@FXML
	private Button PRegistrarButton;
	@FXML
    private Label WarningText;
	
	public void goToMain(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void Registrar(ActionEvent event) throws IOException, SQLException{
		if(UserField.getText().isBlank() || InfoField.getText().isBlank() || URLPageField.getText().isBlank() || URLImageField.getText().isBlank() || MailField.getText().isBlank() || PasswordField.getText().isBlank()) {
			WarningText.setText("llene todas las casillas");
		} else {
			String registrarUProveedor = "INSERT INTO usuario (username, password, type, correo) values(?,?,?,?)";
	        Connection conexion = DBConnection.getConnection();
	        PreparedStatement ps = conexion.prepareStatement(registrarUProveedor);
	        ps.setString(1, UserField.getText());
	        ps.setString(2, PasswordField.getText());
	        ps.setString(3, "P");
	        ps.setString(4, MailField.getText());
	        ps.executeUpdate();
	        String registrarProveedor = "INSERT INTO proveedores (nombre, descripcion, pagina, imagen, correo) values(?,?,?,?,?)";
	        ps = conexion.prepareStatement(registrarProveedor);
	        ps.setString(1, UserField.getText());
	        ps.setString(2, InfoField.getText());
	        ps.setString(3, URLPageField.getText());
	        ps.setString(4, URLImageField.getText());
	        ps.setString(5, MailField.getText());
	        ps.executeUpdate();
	        SMS sms = SMS.getInstance();																		//singleton
	        sms.enviarSMS("se ha registrado un nuevo proveedor: " + UserField.getText());
	        goToMain(event);
		}
	}
}
