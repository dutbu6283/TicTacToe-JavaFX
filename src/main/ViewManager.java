/**
@author ${Dutsadi Bunliang} Created: 2017-11-29 09:08:05 Updated: 
 */
package main;

import fxControlsCustom.TitleBar;
import interfaces.ObjectPool;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.GridView;
import view.ResetView;
import view.StatusView;

public class ViewManager implements ObjectPool {
	//VARIABLES
	private Stage window; 
	private VBox vBox;
	private StackPane root;
		
	private TitleBar title;
	private StatusView status;
	private GridView grid;
	private ResetView reset;
	
	private ControllerManager controller;

	//CONTRUCTORS
	public ViewManager(Stage stage, ControllerManager controller) {
		window = stage;
		this.controller = controller;
	}

	//METHODS
	public StackPane createContent() {				
		title = new TitleBar("Tic Tac Toe", window);
		status = new StatusView();
		grid = new GridView(controller.getGridViewController());
		reset = new ResetView(controller.getResetViewController());
		
		vBox = new VBox();
		root = new StackPane();
		
		vBox.setAlignment(Pos.CENTER);
		vBox.setStyle("-fx-stroke: #808080;");
		
		vBox.getChildren().addAll(title, status, grid, reset);
		
		root.setStyle("-fx-background-color: transparent;");
		root.getChildren().addAll(vBox);
		ObjectPool.addOf("status", status,
				 "grid", grid,
				 "reset", reset);
		
		return root;
	}

}
