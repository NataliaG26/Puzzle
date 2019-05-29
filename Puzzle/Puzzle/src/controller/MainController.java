package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import exceptions.LevelNotSelectedException;
import exceptions.NameWithSpaceException;
import exceptions.PlayerNotSelectedException;
import exceptions.SameNameException;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import model.Category;
import model.Level;
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
	
	public void addPlayer(String name) throws NameWithSpaceException, SameNameException {
		if(name.equals("") || name.contains(" ")) {
		throw new NameWithSpaceException();
		}else if(puzzle.searchPlayer(name)!=null){
			throw new SameNameException(name);
		}else {
			puzzle.addPlayer(name);
		}
	}
	
	public int[] dimentions(int row, int column) {
		return puzzle.getDimentions(row, column);
	}
	
	public void levelSelected(String nameLevel) throws LevelNotSelectedException {
		if(nameLevel == null) {
			throw new LevelNotSelectedException(nameLevel);
		}else {
			puzzle.levelSelected(nameLevel);
		}
	}
	
	public boolean verifiGame(int[][] puzzleID) {
		return puzzle.verifiGame(puzzleID);
	}
	
	public Level getLevel() {
		return puzzle.currentCategory().currentLevel();
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
