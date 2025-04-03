package application;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private VBox field;
	private Parent fxml;
	
	public void goToSignIn(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("SignPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void initialize () {
		try {
			fxml = FXMLLoader.load(getClass().getResource("Telas.fxml"));
			field.getChildren().removeAll();
			field.getChildren().setAll(fxml);
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
	
	public void goToTelas(ActionEvent event) throws IOException {
		try {
			fxml = FXMLLoader.load(getClass().getResource("Telas.fxml"));
			field.getChildren().removeAll();
			field.getChildren().setAll(fxml);
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
	
	public void goToEmprendimientos(ActionEvent event) throws IOException {
		try {
			fxml = FXMLLoader.load(getClass().getResource("Emprendimientos.fxml"));
			field.getChildren().removeAll();
			field.getChildren().setAll(fxml);
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
	
	public void goToProveedores(ActionEvent event) throws IOException {
		try {
			fxml = FXMLLoader.load(getClass().getResource("Proveedores.fxml"));
			field.getChildren().removeAll();
			field.getChildren().setAll(fxml);
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
}
