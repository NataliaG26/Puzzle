package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import exceptions.LevelNotSelectedException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Category;

public class SelectLevelController implements Initializable{
	
	private MainController mainController;
	
	@FXML
    private ComboBox<String> comboBox;
	
	@FXML
	private ListView<String> listView;
	
	public SelectLevelController() {
	}
	
	 @FXML
	 void start(ActionEvent event) throws LevelNotSelectedException {
		 loadGame();
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
	
	 public void loadGame() throws LevelNotSelectedException {
		 mainController.loadGame(listView.getSelectionModel().getSelectedItem(), comboBox.getValue());
	 }
	 
	public void loadLevels(ActionEvent event)  {
		listVewload();
	}
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
		loadChoiceBox();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		SelectLevelController gC = new SelectLevelController();
	}
	
	public void listVewload() {
		ObservableList<String> list = FXCollections.observableArrayList(mainController.getLevelsCategory(comboBox.getValue()));
		System.out.println(comboBox.getValue());
    	listView.setItems(list);
	}
	
	public void loadChoiceBox() {
		ObservableList<String> data = FXCollections.observableArrayList(mainController.getCategoriesNames());
		comboBox.setItems(data);     
	}
}
