package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import exceptions.NameWithSpaceException;
import exceptions.PLayerNotFoundException;
import exceptions.PlayerNotSelectedException;
import exceptions.SameNameException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	
private MainController mainController;
	
	@FXML
    private TextField txtNewPlayer;

    @FXML
    private ListView<String> listView;

    @FXML
    void addPlayer(ActionEvent event) throws NameWithSpaceException, SameNameException {
    	mainController.addPlayer(txtNewPlayer.getText());
    	actualizeListView();
    }
  
    public void actualizeListView() {
    	ObservableList<String> list = FXCollections.observableArrayList(mainController.getPlayersName());
    	listView.setItems(list);
    }
    
    public void selectPlayer() throws PlayerNotSelectedException {
    	String name = listView.getSelectionModel().getSelectedItem();
    	mainController.selectedPlayer(name);
    }
    
    /*
     * play boton nueva ventana
     */
	 @FXML
	 void play(ActionEvent event) throws PlayerNotSelectedException {
		 selectPlayer();
	    try {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../userInterface/selectLevel.fxml"));
	    	Parent root = loader.load();
	    	mainController.conection(loader, "SelectLevel");
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
	 }

	/*
	 * cambia el mainController
	 */
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
