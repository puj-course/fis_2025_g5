package application;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;


public class SingupController {
	
	@FXML
	private VBox field;
	private Parent fxml;
	
	public void initialize () {
		try {
			fxml = FXMLLoader.load(getClass().getResource("Loggin.fxml"));
			field.getChildren().removeAll();
			field.getChildren().setAll(fxml);
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
	
	public void goToLoggin(ActionEvent event) throws IOException {
		try {
			fxml = FXMLLoader.load(getClass().getResource("Loggin.fxml"));
			field.getChildren().removeAll();
			field.getChildren().setAll(fxml);
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
	
	public void goToSignUpU(ActionEvent event) throws IOException {
		try {
			fxml = FXMLLoader.load(getClass().getResource("SignupU.fxml"));
			field.getChildren().removeAll();
			field.getChildren().setAll(fxml);
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
	public void goToSignUpE(ActionEvent event) throws IOException {
		try {
			fxml = FXMLLoader.load(getClass().getResource("SignupE.fxml"));
			field.getChildren().removeAll();
			field.getChildren().setAll(fxml);
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
	public void goToSignUpP(ActionEvent event) throws IOException {
		try {
			fxml = FXMLLoader.load(getClass().getResource("SignupP.fxml"));
			field.getChildren().removeAll();
			field.getChildren().setAll(fxml);
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
}
