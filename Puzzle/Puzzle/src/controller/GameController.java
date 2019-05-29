package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import threads.MakeAMessOfThread;

public class GameController implements Initializable, EventHandler<KeyEvent>{
	
	private MainController mainController;
	
	 @FXML
	 private Pane pane;
	
	 @FXML
	 private GridPane gridPane;
	 
	 private int[] posNull;
	 
	 private Node[][] images;

	 @FXML
	 private Label time;

	@FXML
	void start(ActionEvent event) {
		Image img = new Image(mainController.getImage());
		int width = (int)img.getWidth();
		int hight = (int)img.getHeight();
		int dif = mainController.loadImage(width, hight);
		createGridPane(dif);
		load(dif, img);
		try {
			MakeAMessOfThread thread = new MakeAMessOfThread(this, dif);
			thread.run();
			//thread.join();
			System.out.println("hilo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void makeAMessOf(int n) {
		switch (n) {
		case 1: 
			moveDown();
		break;
		case 2:
			moveUp();
			break;
		case 3:
			moveLeft();
			break;
		case 4:
			moveRight();
			break;
		default:
			break;
		}
		
	}

	public void moveDown() {
		int max = gridPane.getChildren().size()-1;
		int n = (int) Math.sqrt(max);
		if(posNull[0] != 0) {
			Node image = images[posNull[0]-1][posNull[1]];
			Node nul = images[posNull[0]][posNull[1]];
			
			gridPane.getChildren().remove(image);
			gridPane.getChildren().remove(nul);
			
			gridPane.add(image, posNull[1], posNull[0]);
			gridPane.add(nul, posNull[1], posNull[0]-1);
			
			images[posNull[0]-1][posNull[1]] = nul;
			images[posNull[0]][posNull[1]] = image;
			
			posNull[0]--;
			
		}
	}
	
	public void moveUp() {
		int max = gridPane.getChildren().size()-1;
		int n = (int) Math.sqrt(max);
		if(posNull[0] != n-1) {
			Node image = images[posNull[0]+1][posNull[1]];
			Node nul = images[posNull[0]][posNull[1]];
			
			gridPane.getChildren().remove(image);
			gridPane.getChildren().remove(nul);
			
			gridPane.add(image, posNull[1], posNull[0]);
			gridPane.add(nul, posNull[1], posNull[0]+1);
			
			images[posNull[0]+1][posNull[1]] = nul;
			images[posNull[0]][posNull[1]] = image;
			
			posNull[0]++;
			
		}
	}
	
	public void moveLeft() {
		int max = gridPane.getChildren().size()-1;
		int n = (int) Math.sqrt(max);
		if(posNull[1] != n-1) {
			Node image = images[posNull[0]][posNull[1]+1];
			Node nul = images[posNull[0]][posNull[1]];
			
			gridPane.getChildren().remove(image);
			gridPane.getChildren().remove(nul);
			
			gridPane.add(image, posNull[1], posNull[0]);
			gridPane.add(nul, posNull[1]+1, posNull[0]);
			
			images[posNull[0]][posNull[1]+1] = nul;
			images[posNull[0]][posNull[1]] = image;
			
			posNull[1]++;
			
		}
		
	}
	
	public void moveRight() {
		int max = gridPane.getChildren().size()-1;
		int n = (int) Math.sqrt(max);
		if(posNull[1] != 0) {
			Node image = images[posNull[0]][posNull[1]-1];
			Node nul = images[posNull[0]][posNull[1]];
			
			gridPane.getChildren().remove(image);
			gridPane.getChildren().remove(nul);
			
			gridPane.add(image, posNull[1], posNull[0]);
			gridPane.add(nul, posNull[1]-1, posNull[0]);
			
			images[posNull[0]][posNull[1]-1] = nul;
			images[posNull[0]][posNull[1]] = image;
			
			posNull[1]--;
			
		}
	}
	
	@Override
	public void handle(KeyEvent event) {
		switch (event.getCode()) {
		case DOWN: 
			moveDown();
		break;
		case UP:
			moveUp();
			break;
		case LEFT:
			moveLeft();
			break;
		case RIGHT:
			moveRight();
			break;
		default:
			break;
		}
	}

	public void createGridPane(int n) {
		images = new Node[n][n];
		gridPane.getColumnConstraints().clear();
		gridPane.getRowConstraints().clear();
		System.out.println(n+"");
		while(n > 0) {
			gridPane.getColumnConstraints().add(new ColumnConstraints());
			gridPane.getRowConstraints().add(new RowConstraints());
			n--;
		}
	}
	
	public void load(int m, Image img) {
		gridPane.setGridLinesVisible(true);
		PixelReader px = img.getPixelReader();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				ImageView imgV = new ImageView();
				if(i != m-1 || j !=m-1) {
				int[] inf = mainController.dimentions(i, j);
				WritableImage wi = new WritableImage(px, inf[0], inf[1], inf[2], inf[3]);
				imgV.setImage(wi);
				imgV.setId(inf[4]+"");
				gridPane.add(imgV, j, i);
				}else {
					gridPane.add(imgV, j, i);
				}
				images[i][j] = imgV;
			}
		}
		posNull[0] = m-1;
		posNull[1] = m-1;
		gridPane.setAlignment(Pos.CENTER);
		
	}

	public GameController() {
		mainController = new MainController();
	}
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		GameController gC = new GameController();
		posNull = new int[2];
	}
	
}
