package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Category;

public class SelectLevelController implements Initializable{
	
	private MainController mainController;
	
	public SelectLevelController() {
	}
	
	@FXML
	private ListView<Category> levelsTable;
	
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
	
	
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mainController = new MainController();
		level(null);
		SelectLevelController gC = new SelectLevelController();
		loadLevels(null);
	}
	
	public void loadLevels(ActionEvent event) {

		ObservableList names = FXCollections.observableArrayList();
		ObservableList data = FXCollections.observableArrayList();
		  
	        levelsTable.setEditable(true);
	        
	        for(int i=0;i<mainController.getsCategories().size();i++) {
	        	String rn ;
	        	data.add(mainController.getsCategories().get(i).getName());
	        	for(int j=0;j<mainController.getsCategories().get(i).getLevels().size();j++) {
	        		names.add(mainController.getsCategories().get(i).getLevels().get(j).getName());
	        		ComboBoxListCell r = new ComboBoxListCell();
	        		levelsTable. setCellFactory(r.forListView(names)); 
	        	}
	        }
	        
	          
	        levelsTable.setItems(data);       
	}
}
