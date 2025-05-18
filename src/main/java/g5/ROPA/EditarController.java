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
import javafx.stage.Stage;

public class EditarController {
	
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
	private Button CancelButton;
	@FXML
	private Button AplicarButton;
	@FXML
    private Label WarningText;
	@FXML
    private Label TituloLabel;
	
	public void initialize () {
		User usuario = User.getInstance();
		String consultarUsuario = "";
		if(usuario.getTipo().equals("P")) {
			consultarUsuario = "SELECT nombre, descripcion, pagina, imagen, correo FROM proveedores WHERE (nombre = ? AND correo = ?)";
		}
		else if(usuario.getTipo().equals("E")) {
			consultarUsuario = "SELECT nombre, descripcion, pagina, imagen, correo FROM emprendimientos WHERE (nombre = ? AND correo = ?)";
		}
		Connection conexion = DBConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = conexion.prepareStatement(consultarUsuario);
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getCorreo());
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				TituloLabel.setText(rs.getString("nombre"));
				UserField.setText(rs.getString("nombre"));
				InfoField.setText(rs.getString("descripcion"));
				URLPageField.setText(rs.getString("pagina"));
				URLImageField.setText(rs.getString("imagen"));
			} else {
			WarningText.setText("Error");
			}
		
		} catch (SQLException e) {
			System.err.println("Error al buscar el usuario: " + e.getMessage());
			WarningText.setText("Error de conexión con la base de datos");
		}
	}
	
	public void goToMain(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void editarInfo(ActionEvent event) throws IOException, SQLException {
		User usuario = User.getInstance();
		if(UserField.getText().isBlank() || InfoField.getText().isBlank() || URLPageField.getText().isBlank() || URLImageField.getText().isBlank()) {
			WarningText.setText("llene todas las casillas");
		} else {
			String editarU = "UPDATE usuario SET username = ? WHERE username = ?";
	        Connection conexion = DBConnection.getConnection();
	        PreparedStatement ps = conexion.prepareStatement(editarU);
	        ps.setString(1, UserField.getText());
	        ps.setString(2, usuario.getNombre());
	        ps.executeUpdate();
	        if(usuario.getTipo().equals("P")) {
	        	String editarP = "UPDATE proveedores SET nombre = ?, descripcion = ?, pagina = ?, imagen = ? WHERE (nombre = ? AND correo = ?)";
	        	ps = conexion.prepareStatement(editarP);
	        	ps.setString(1, UserField.getText());
	        	ps.setString(2, InfoField.getText());
	        	ps.setString(3, URLPageField.getText());
	        	ps.setString(4, URLImageField.getText());
	        	ps.setString(5, usuario.getNombre());
	        	ps.setString(6, usuario.getCorreo());
	        	ps.executeUpdate();
	        	usuario.setNombre(UserField.getText());
	        	SMS sms = SMS.getInstance();																		//singleton
	        	sms.enviarSMS("se ha editado un proveedor: " + UserField.getText());
	        	goToMain(event); 	
	        }
	        else if(usuario.getTipo().equals("E")) {
	        	String editare = "UPDATE emprendimientos SET nombre = ?, descripcion = ?, pagina = ?, imagen = ? WHERE (nombre = ? AND correo = ?)";
	        	ps = conexion.prepareStatement(editare);
	        	ps.setString(1, UserField.getText());
	        	ps.setString(2, InfoField.getText());
	        	ps.setString(3, URLPageField.getText());
	        	ps.setString(4, URLImageField.getText());
	        	ps.setString(5, usuario.getNombre());
	        	ps.setString(6, usuario.getCorreo());
	        	ps.executeUpdate();
	        	usuario.setNombre(UserField.getText());
	        	SMS sms = SMS.getInstance();																		//singleton
	        	sms.enviarSMS("se ha editado un emprendimiento: " + UserField.getText());
	        	goToMain(event); 	
	        }
		}
	}
}
