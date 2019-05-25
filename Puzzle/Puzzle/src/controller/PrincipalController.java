package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrincipalController implements Initializable{
	
	@FXML
    void bestSocres(ActionEvent event) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../userInterface/BestScores.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void play(ActionEvent event) {
   
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
}
