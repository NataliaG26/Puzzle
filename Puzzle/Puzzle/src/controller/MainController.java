package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
	
	/*
	 * dar un arraylist con los nombres de los jugadores
	 */
	public ArrayList<String> getPlayersName(){
		ArrayList<String> list = puzzle.getPlayersName();
		return list;
	}
	
	public void selectedPlayer(String name) {
		if(name !=null) {
    		puzzle.selectedPlayer(name);
    	}else {
    		//lanzarException crear exception
    	}
	}
	
	public void newLevel() {
		puzzle.setFirstCategory(new Category("caricatura"));
//		puzzle.getFirstCategory().createLevel();
	}
	
	//
	public String getImage() {
		String image = puzzle.getFirstCategory().getFirstLevel().getImage();
		return image;
	}
	
	public void loadLevel(int width, int hight) {
		puzzle.getFirstCategory().getFirstLevel().setWidth(width);
		puzzle.getFirstCategory().getFirstLevel().setHight(hight);
		puzzle.getFirstCategory().loadPuzzle();
	}
	
	public int[] dimentions(int r, int c) {
		int[] dim = new int[5];
		dim[0] = puzzle.getFirstCategory().getFirstLevel().getPuzzle()[r][c].getStartWidth();
		dim[1] = puzzle.getFirstCategory().getFirstLevel().getPuzzle()[r][c].getStartHight();
		dim[2] = puzzle.getFirstCategory().getFirstLevel().getPuzzle()[r][c].getWidth();
		dim[3] = puzzle.getFirstCategory().getFirstLevel().getPuzzle()[r][c].getHight();
		dim[4] = puzzle.getFirstCategory().getFirstLevel().getPuzzle()[r][c].getId();
		return dim;
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
