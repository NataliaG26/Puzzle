package controller;

import java.net.URL;
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
import javafx.scene.layout.RowConstraints;

public class GameController implements Initializable, EventHandler<KeyEvent>{
	
	private MainController mainController;
	
	 @FXML
	 private GridPane gridPane;
	 
	 private int[] posGridPaneNull;

	 @FXML
	 private Label time;

	@FXML
	void pausa(ActionEvent event) {
		mainController.newLevel();//controllerselectlevel
		Image img = new Image(mainController.getImage());
		int width = (int)img.getWidth();
		int hight = (int)img.getHeight();
		mainController.loadLevel(width, hight);
		createGridPane(3);
		load(3);
		
		
	}
	
	public void moveDown() {
		Node node = getNodeByRowColumnIndex(posGridPaneNull[0], posGridPaneNull[1]);
		gridPane.getChildren().remove(node);
		gridPane.add(node, posGridPaneNull[0], posGridPaneNull[1]);
		posGridPaneNull[0]--;
		posGridPaneNull[1]--;
		
		}
	
	@Override
	public void handle(KeyEvent event) {
		switch (event.getCode()) {
		case DOWN: 
			System.out.println("siiii");
			moveDown();
		break;
		default:
			break;
		}
	}
	    
	@FXML
	void touch(KeyEvent event) {
		//Node nod = getNodeByRowColumnIndex (2, 1)
		//if(event.getCode() == KeyCode.DOWN)
			System.out.println("siiii");
			
		gridPane.add(new Label("hhhh"), 2, 2);
	}
	
	public Node getNodeByRowColumnIndex (final int row, final int column) {
	    Node result = null;
	    ObservableList<Node> childrens = gridPane.getChildren();

	    for (Node node : childrens) {
	        if((int)gridPane.getChildren().indexOf(node) == row && (int)gridPane.getChildren().indexOf(node) == column) {
	            result = node;
	            System.out.println("if");
	            break;
	        }
	    }

	    return result;
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
				WritableImage wi = new WritableImage(px, inf[0], inf[1], inf[2], inf[3]);
				ImageView imgV = new ImageView();
				imgV.setImage(wi);
				imgV.setId(inf[4]+"");
				gridPane.add(imgV, j, i);
				GridPane.setColumnIndex(imgV, j);
				GridPane.setRowIndex(imgV, i);
				}
			}
		}
		System.out.println();
		posGridPaneNull[0] = m-1;
		posGridPaneNull[1] = m-1;
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
		posGridPaneNull = new int[2];
	}
	
}
