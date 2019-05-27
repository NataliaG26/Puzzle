package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class SelectLevelController implements Initializable{
	
private MainController mainController;
	
	
	public void paintLevels() {
		
	}
	
	
	 @FXML
	 void level(ActionEvent event) {
		 try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../userInterface/game.fxml"));
			Parent root = loader.load();
			GameController ven = loader.getController();
	    	ven.setMainController(mainController);
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			scene.setOnKeyPressed(ven);
			stage.setScene(scene);
			stage.show();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
	 }
	
	
	public SelectLevelController() {
		// TODO Auto-generated constructor stub
	}
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		SelectLevelController gC = new SelectLevelController();
	}
}
