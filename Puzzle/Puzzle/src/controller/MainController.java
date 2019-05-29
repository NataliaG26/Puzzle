package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import exceptions.LevelNotSelectedException;
import exceptions.PlayerNotSelectedException;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import model.Category;
import model.Scene;

public class MainController implements Initializable {
	
private Scene puzzle;
	
	//nuevo jugador
	
	public MainController() {
		puzzle = new Scene();
	}
	
	public String getImage() {
		return puzzle.getImage();
	}
	
	public int loadImage(int width, int hight) {
		int dificulty = puzzle.loadImage(width, hight);
		return dificulty;
	}
	
	public void addPlayer(String name) {
		//lanzar exception
		puzzle.addPlayer(name);
	}
	
	public int[] dimentions(int row, int column) {
		return puzzle.getDimentions(row, column);
	}
	
	public void levelSelected(String nameLevel) {
		puzzle.levelSelected(nameLevel);
	}
	
	/*
	 * 
	 */
	public void selectedPlayer(String name) throws PlayerNotSelectedException {
		if(name !=null) {
    		puzzle.selectedPlayer(name);
    	}else {
    		throw new PlayerNotSelectedException();
    	}
	}
	
	/*
	 * dar un arraylist con los nombres de los jugadores
	 */
	public ArrayList<String> getPlayersName(){
		ArrayList<String> list = puzzle.getPlayersName();
		return list;
	}
	
	public ArrayList<String> getCategoryNames() {
		return puzzle.getCategories();
	}

	public ArrayList<String> getLevelNames(String categoryName) {
		return puzzle.getLevelsCategory(categoryName);
	}
	
	//volver  los nombres unas constantes
	public void conection(FXMLLoader fxml, String controller) {
		if(controller.equals("SelectedPlayer")) {
			SelectedPlayerController obj = fxml.getController();
			obj.setMainController(this);
		}else if(controller.equals("SelectLevel")) {
			SelectLevelController obj = fxml.getController();
			obj.setMainController(this);
		}else if(controller.equals("bestScores")) {
			ScoresPlayersController obj = fxml.getController();
			obj.setMainController(this);
		}else {
			GameController obj = fxml.getController();
			obj.setMainController(this);
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		MainController mC = new MainController();
		
	}

	

}
