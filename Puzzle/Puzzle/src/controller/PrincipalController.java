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
	
private MainController mainController;
	
	@FXML
    void bestSocres(ActionEvent event) {
			
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../userInterface/selectPlayer.fxml"));
    		Parent root = loader.load();
    		mainController.conection(loader, "bestScores");
			//root = FXMLLoader.load(getClass().getResource("../userInterface/BestScores.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void play(ActionEvent event) {
    	//Parent root;
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../userInterface/selectPlayer.fxml"));
    		Parent root = loader.load();
    		mainController.conection(loader, "SelectedPlayer");
    		//SelectedPlayerController ven = loader.getController();
    		//ven.setMainController(mainController);
    		//ven.setStage(stage)
    		
			//root = FXMLLoader.load(getClass().getResource("../userInterface/selectPlayer.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		/*Object obj = ro;
		SelectedPlayerController n = (SelectedPlayerController)obj;
		n.setMainController(mainController);*/
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
    
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setMainController(new MainController());
		//mainController.conexion(mainController);
		
	}
	
}
