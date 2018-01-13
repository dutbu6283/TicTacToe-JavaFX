package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TicTacToeApp extends Application {
	//VARIABLES
	private static final String TITLE = "Tic-Tac-Toe v0.1.0";
	private Scene scene;
	private ViewManager view;
	
	//METHODS
	@Override
	public void start(Stage window) {
		view = new ViewManager(window, new ControllerManager());
		
		scene = new Scene(view.createContent());
		scene.setFill(Color.TRANSPARENT);
		
		window.setScene(scene);
		window.setTitle(TITLE);
		window.setWidth(300);
		window.initStyle(StageStyle.TRANSPARENT);
		window.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
	
}
