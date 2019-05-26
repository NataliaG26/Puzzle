package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScoresPlayersController implements Initializable{
	

	
	public void goToPrincipal(ActionEvent event) {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("../userInterface/principal.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
