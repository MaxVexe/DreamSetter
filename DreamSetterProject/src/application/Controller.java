package application;

import java.io.IOException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.*;
public class Controller {
	public HashMap<String,String> Logins = new HashMap<>();
	
	private Stage stage;
	private Scene scene; 
	 @FXML 
	 private TextField userID;
	 
	 @FXML
	 private TextField passwordID;
	
	 public void createAcc() {
		
	 }
	 public void createLogin() {
		 Logins.put("Admin","Admin123");
		 Logins.put("Guest", "123");
	 }
	 public void Login(ActionEvent event) throws IOException {
		 String username = userID.getText();
		 String password = passwordID.getText(); 
		
		 if(!Logins.containsKey(username)) {
			Alert alert = new Alert(AlertType.ERROR);
			 alert.setHeaderText("Error Username not found!");
			 alert.showAndWait();
		 	}
		 else if(!Logins.get(username).equals(password)) {
			 Alert alert = new Alert(AlertType.ERROR);
			 alert.setHeaderText("Error Password is incorrect");
			 alert.showAndWait(); 
		 }else {
	
			 Parent root = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
			 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			 scene = new Scene(root);
			 stage.setScene(scene);
		 }
	 }
}
  