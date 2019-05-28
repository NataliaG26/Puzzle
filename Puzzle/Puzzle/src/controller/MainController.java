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
	
	public void addPlayer(String name) {
		puzzle.addPlayer(name);
	}
	
	
	public ArrayList<String> getCategoriesNames(){
		ArrayList<String> list = puzzle.getCategories();
		return list;
	}
	
	public ArrayList<String> getLevelsCategory(String nameCategory){
		System.out.println("main");
		ArrayList<String> list = puzzle.getLevelsCategory(nameCategory);
		return list;
	}
	
	public void loadCategories() {
		puzzle.loadCategorys();
	}
	
	/*
	 * dar un arraylist con los nombres de los jugadores
	 */
	public ArrayList<String> getPlayersName(){
		ArrayList<String> list = puzzle.getPlayersName();
		return list;
	}
	
	public void selectedPlayer(String name) throws PlayerNotSelectedException {
		if(name !=null) {
    		puzzle.selectedPlayer(name);
    	}else {
    		throw new PlayerNotSelectedException();
    	}
	}
	
	public void loadGame(String levelName, String category) throws LevelNotSelectedException {
		if(levelName != "" && levelName != null) {
			loadGame(levelName, category);
		}else {
			throw new LevelNotSelectedException("");
		}
	}
	
	public String getImage() {
		String image = puzzle.getImage();
		return image;
	}
	
	public void loadLevel(int width, int hight) {
		puzzle.loadPuzzle(width, hight);
	}
	
	public int[] dimentions(int r, int c) {
		int[] inf = puzzle.getInfoSection(r, c);
		return inf;
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
