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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SelectedPlayerController implements Initializable{
	
	 @FXML
	    private TextField txtSearchPlayer;

	    @FXML
	    private ListView<?> listView;
	    

	    @FXML
	    void play(ActionEvent event) {
	    	try {
				Parent root;
				root = FXMLLoader.load(getClass().getResource("../userInterface/selectLevel.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }

	    @FXML
	    void searchPlayer(ActionEvent event) {

	    }
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
