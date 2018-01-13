package view;

import interfaces.ObjectPool;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StatusView extends StackPane implements ObjectPool{
	//VARIABLES
	private Label statusLabel;
	
	//CONTRUCTORS
	public StatusView() {
		initDefault();
	}

	//METHODS
	private void initDefault() {
		statusLabel = new Label();
		statusLabel.setFont(Font.font("",FontWeight.BOLD, 50));
		statusLabel.setTextFill(Color.WHITE);
		statusLabel.setAlignment(Pos.CENTER);
		reset();
	
		setPrefHeight(110);
		setMaxWidth(300);
		setStyle("-fx-background-color: #E50071;");
		getChildren().addAll(statusLabel);
	}
	
	public void update(String status) {
		statusLabel.setText(status);
	}
	
	public void reset() {
		statusLabel.setText("Turn X");
	}
	
}
