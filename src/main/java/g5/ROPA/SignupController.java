package g5.ROPA;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;


public class SignupController {
	
	@FXML
	private VBox field;
	private Parent fxml;
	
	public void initialize () {
		try {
			fxml = FXMLLoader.load(getClass().getResource("Loggin.fxml"));
			field.getChildren().removeAll();
			field.getChildren().setAll(fxml);
		} catch (IOException ex) {
		//	Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
	
	public void goToLoggin(ActionEvent event) throws IOException {
		try {
			fxml = FXMLLoader.load(getClass().getResource("Loggin.fxml"));
			field.getChildren().removeAll();
			field.getChildren().setAll(fxml);
		} catch (IOException ex) {
		//	Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
	
	public void goToSignUpU(ActionEvent event) throws IOException {
		try {
			fxml = FXMLLoader.load(getClass().getResource("SignupU.fxml"));
			field.getChildren().removeAll();
			field.getChildren().setAll(fxml);
		} catch (IOException ex) {
		//	Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
	public void goToSignUpE(ActionEvent event) throws IOException {
		try {
			fxml = FXMLLoader.load(getClass().getResource("SignupE.fxml"));
			field.getChildren().removeAll();
			field.getChildren().setAll(fxml);
		} catch (IOException ex) {
		//	Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
	public void goToSignUpP(ActionEvent event) throws IOException {
		try {
			fxml = FXMLLoader.load(getClass().getResource("SignupP.fxml"));
			field.getChildren().removeAll();
			field.getChildren().setAll(fxml);
		} catch (IOException ex) {
		//	Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
		}	
	}
}
