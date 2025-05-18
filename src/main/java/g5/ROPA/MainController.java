package g5.ROPA;

import java.io.IOException;
import java.util.*;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class MainController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private VBox field;
	private Parent fxml;
	
	@FXML
	private Button editarButton;
	@FXML
	private Label displayUsuaria;
	
	public void goToSignIn(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("SignPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void initialize () throws SQLException {
		try {
			fxml = FXMLLoader.load(getClass().getResource("Telas.fxml"));
			field.getChildren().removeAll();
			field.getChildren().setAll(fxml);
			hayUsuario();
		} catch (IOException ex) {
	//		Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
	
	public void goToTelas(ActionEvent event) throws IOException, SQLException {
		try {
			fxml = FXMLLoader.load(getClass().getResource("Telas.fxml"));
			field.getChildren().removeAll();
			field.getChildren().setAll(fxml);
		} catch (IOException ex) {
	//		Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
	
	public void goToEmprendimientos(ActionEvent event) throws IOException {
		try {
			fxml = FXMLLoader.load(getClass().getResource("Emprendimientos.fxml"));
			field.getChildren().removeAll();
			field.getChildren().setAll(fxml);
		} catch (IOException ex) {
	//		Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
	
	public void goToProveedores(ActionEvent event) throws IOException {
		try {
			fxml = FXMLLoader.load(getClass().getResource("Proveedores.fxml"));
			field.getChildren().removeAll();
			field.getChildren().setAll(fxml);
		} catch (IOException ex) {
	//		Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
	
	public void hayUsuario() {
		User usuario = User.getInstance();
		if(usuario.getNombre() == null) {
			editarButton.setVisible(false);
		} 
		if((usuario.getTipo().equals("P") || usuario.getTipo().equals("E"))) {
			editarButton.setVisible(true);
			displayUsuaria.setText(usuario.getNombre());
		} else {
			displayUsuaria.setText(usuario.getNombre());
		}
	}
	
	public void goToEdit(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Editar.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
