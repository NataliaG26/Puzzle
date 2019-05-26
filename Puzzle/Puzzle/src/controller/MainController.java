package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import model.Category;
import model.Scene;

public class MainController implements Initializable {
	
	private Scene puzzle;
	
	//nuevo jugador
	
	public MainController() {
		puzzle = new Scene();
	}
	
	public void newLevel() {
		puzzle.setFirstCategory(new Category("caricatura"));
		puzzle.getFirstCategory().createLevel();
	}
	
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
		int[] dim = new int[4];
		dim[0] = puzzle.getFirstCategory().getFirstLevel().getPuzzle()[r][c].getStartWidth();
		dim[1] = puzzle.getFirstCategory().getFirstLevel().getPuzzle()[r][c].getStartHight();
		dim[2] = puzzle.getFirstCategory().getFirstLevel().getPuzzle()[r][c].getFinishWidth();
		dim[3] = puzzle.getFirstCategory().getFirstLevel().getPuzzle()[r][c].getFinishHight();
		System.out.println(dim[0]+" "+dim[1]+" "+dim[2]+" "+dim[3]);
		return dim;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		MainController mC = new MainController();
		
	}
	
	@FXML
    void changeWindow(ActionEvent event) {
		try {
			javafx.scene.Scene	root = FXMLLoader.load(getClass().getResource("../Puzzle/Puzzle/src/userInterfaceBestScores.fxml"));
		Stage stage = new Stage();
		stage.setScene(root);
		stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	public Scene getPuzzle() {
		return puzzle;
	}
	
	

}
