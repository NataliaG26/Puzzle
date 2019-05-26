package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import model.Player;
import model.Score;

public class GameController implements Initializable{
	
	private MainController mainController;
	
	
	
		@FXML
	    private GridPane gridPane;

	    @FXML
	    private TableView<Score> scoresTable;

	    @FXML
	    private Label time;

	    @FXML
	    private Button scoresButton;

	    @FXML
	    private ChoiceBox<?> playersNames;

	    @FXML
	    private Label playerNmaeLabel;

	 



	@FXML
	void pausa(ActionEvent event) {
		mainController.newLevel();//controllerselectlevel
		Image img = new Image(mainController.getImage());
		int width = (int)img.getWidth();
		int hight = (int)img.getHeight();
		System.out.println("w"+width);
		System.out.println("h"+hight);
		mainController.loadLevel(width, hight);
		createGridPane(3);
		load(3);
	}
	    
	@FXML
	void touch(ActionEvent event) {
		String datos = ((Node)event.getSource()).getId();
	}
	
	public void createGridPane(int n) {
		gridPane.getColumnConstraints().clear();
		gridPane.getRowConstraints().clear();
		while(n > 0) {
			gridPane.getColumnConstraints().add(new ColumnConstraints(74));
			gridPane.getRowConstraints().add(new RowConstraints(100));
			n--;
		}
		
	}
	
	public void load(int m) {
		//WritableImage(PixelReader reader, int width, int height)
		gridPane.setGridLinesVisible(true);
		Image img = new Image(mainController.getImage());
		PixelReader px = img.getPixelReader();
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if(i != m-1 || j !=m-1) {
				int[] inf = mainController.dimentions(i, j);
				System.out.println("siii");
				WritableImage wi = new WritableImage(px, inf[0], inf[1], inf[2], inf[3]);
				ImageView imgV = new ImageView();
				imgV.setImage(wi);

				gridPane.add(imgV, j, i);
				}
			}
		}
		/*
		
		gridPane.setAlignment(Pos.CENTER);
		File file = new File("../ImagesLevels/2.jpg");
		
		//int w = (int)img.getWidth()/2;
		//int h = (int)img.getHeight()/2;
		
		
		imgV.setImage(wi);
		gridPane.add(imgV, 0, 0);
		boolean f = imgV.getImage() != null;
		
		gridPane.getColumnConstraints().add(new ColumnConstraints());
		gridPane.getRowConstraints().add(new RowConstraints());
		//WritableImage wi2 = new WritableImage(px, w, h, w, h);
		wi= new WritableImage(px, w, h, w, h);
		ImageView imgV2 = new ImageView();
		imgV2.setImage(wi);
		gridPane.add(imgV2, 1, 1);
		*/
	}

	public GameController() {
		mainController = new MainController();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		GameController gC = new GameController();
		this.showTable();
		
		
	}
	
	public void scoresActionF(ActionEvent event) {
		if(!scoresTable.isVisible()) {
			scoresTable.setVisible(true);
			scoresButton.setText("Back To the game");
			gridPane.setVisible(false);
		} 
		else {
		scoresTable.setVisible(false);
		scoresButton.setText("Scores");
		gridPane.setVisible(true);
		}
			
	}

	public void showTable() {
		
		
		ObservableList<Score> data = FXCollections.observableArrayList(mainController.getPuzzle().getScoresvector());

		

		TableColumn<Score, String> name = new TableColumn<Score, String>("Namewe");
		name.setCellValueFactory(new PropertyValueFactory<Score, String>("name"));
		name.setMinWidth(140);
		
		TableColumn<Score, String> score = new TableColumn<Score, String>("Score");
		score.setCellValueFactory(new PropertyValueFactory<Score, String>("totaltime"));
		score.setMinWidth(140);
		

		
	
		scoresTable.setItems(data);
		scoresTable.getColumns().addAll( score);
		
	}
	
}
