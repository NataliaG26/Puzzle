package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
	
	public SelectLevelController() {}
	
	 @FXML
	 public void start(ActionEvent event) throws LevelNotSelectedException {
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
		 String nameLevel = listView.getSelectionModel().getSelectedItem();
		 mainController.levelSelected(nameLevel);
	 }
	 
	public void loadLevels(ActionEvent event)  {
		listVewload();
	}

	public void listVewload() {
		String categoryName = comboBox.getValue();
		ArrayList<String> levelList = mainController.getLevelNames(categoryName);
		ObservableList<String> list = FXCollections.observableArrayList(levelList);
		System.out.println(comboBox.getValue());
    	listView.setItems(list);
	}
	
	public void loadChoiceBox() {
		ArrayList<String> categoryNames = mainController.getCategoryNames();
		ObservableList<String> data = FXCollections.observableArrayList(categoryNames);
		comboBox.setItems(data);     
	}
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
		loadChoiceBox();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		SelectLevelController gC = new SelectLevelController();
	}
}
