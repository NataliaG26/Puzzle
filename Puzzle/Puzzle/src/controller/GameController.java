package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class GameController implements Initializable{
	
	private MainController mainController;
	
	 @FXML
	 private GridPane gridPane;

	 @FXML
	 private Label time;

	@FXML
	void pausa(ActionEvent event) {
		load();
	}
	    
	@FXML
	void touch(ActionEvent event) {

	}
	
	
	public void load() {
		//WritableImage(PixelReader reader, int width, int height)
		gridPane.setAlignment(Pos.CENTER);
		File file = new File("2.jpg");
		Image img = new Image("2.jpg");
		ImageView imgV = new ImageView();
		int w = (int)img.getWidth()/2;
		int h = (int)img.getHeight()/2;
		PixelReader px = img.getPixelReader();
		WritableImage wi = new WritableImage(px, w, h);
		imgV.setImage(wi);
		gridPane.add(imgV, 0, 0);
		
		gridPane.getColumnConstraints().add(new ColumnConstraints());
		gridPane.getRowConstraints().add(new RowConstraints());
		//WritableImage wi2 = new WritableImage(px, w, h, w, h);
		wi= new WritableImage(px, w, h, w, h);
		ImageView imgV2 = new ImageView();
		imgV2.setImage(wi);
		gridPane.add(imgV2, 1, 1);
		
	}

	public GameController() {
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		GameController gC = new GameController();
		
	}
	
}
