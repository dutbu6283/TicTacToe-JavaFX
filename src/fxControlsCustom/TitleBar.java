package fxControlsCustom;
/**
 * Creator: Dutsadi Bunliang, Created: 2017-12-15 21:54:18 Updated: 
 */

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TitleBar extends BorderPane {
	//VARIABLES
	private DropShadow drop;
	private InnerShadow inner;
	private TButton minimizeBtn;
	private TButton closeBtn;
	private HBox hBox;
	private Label titleLabel;
	private Rectangle bottomRec;

	private String title;
	private Stage stage;
	private ImageView iconImgView;
	private ImageView minimizeImgView;
	private ImageView closeImgView;
	
	private double xOffset = 0;
	private double yOffset = 0;
	
	private TitleBarListener listener;
	private TitleBarButtonListener btnListener;
	
	//CONTRUCTOR
	public TitleBar(String title, Stage stage) {
		this.title = title;
		this.stage = stage;
		initDefault();
	}
	
	//METHODS
	private void initDefault() {
		try {
			iconImgView = new ImageView(getClass().getResource("img/icons8_Java_32px_1.png").toExternalForm());
			minimizeImgView = new ImageView(getClass().getResource("img/icons8_Horizontal_Line_24px_2.png").toExternalForm());
			closeImgView = new ImageView(getClass().getResource("img/icons8_Delete_24px_1.png").toExternalForm());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		titleLabel = new Label(title);
		titleLabel.setTextFill(Color.WHITE);
		titleLabel.setFont(Font.font(16));
		
		btnListener = new TitleBarButtonListener();
		
		minimizeBtn = new TButton(30, 25, minimizeImgView);
		minimizeBtn.setBackgroundColor(Color.TRANSPARENT);
		minimizeBtn.onEntered(Color.BLUE);
		minimizeBtn.onExited(Color.TRANSPARENT);
		minimizeBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, btnListener);

		closeBtn = new TButton(30, 25, closeImgView);
		closeBtn.setBackgroundColor(Color.web("#B22222"));
		closeBtn.onEntered(Color.web("#FF0000"));
		closeBtn.onExited(Color.web("#B22222"));
		closeBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, btnListener);
		
		hBox = new HBox(3);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(minimizeBtn, closeBtn);
		
		bottomRec = new Rectangle();
		bottomRec.setHeight(3);
		bottomRec.setWidth(300);
		bottomRec.setFill(Color.WHITE);
		bottomRec.setEffect(inner);
		
		drop = new DropShadow();
		drop.setBlurType(BlurType.GAUSSIAN);
		drop.setRadius(5);
		
		inner = new InnerShadow();
		inner.setBlurType(BlurType.GAUSSIAN);
		inner.setRadius(2);
		
		//BorderPane
		setLeft(iconImgView);
		setAlignment(iconImgView, Pos.CENTER);
		leftProperty();
		setMargin(iconImgView, new Insets(3,3,3,3));
		
		setCenter(titleLabel);
		setAlignment(titleLabel, Pos.CENTER);
		setMargin(titleLabel, new Insets(3,3,3,3));
		
		setRight(hBox);
		setAlignment(hBox, Pos.CENTER);
		
		setBottom(bottomRec);
		setAlignment(bottomRec, Pos.TOP_CENTER);
		
		setMaxWidth(300);
		setPrefHeight(25 - 3);
		setStyle("-fx-background-color: #002849;");
		setEffect(drop);
		
		listener = new TitleBarListener();
		addEventHandler(MouseEvent.ANY, listener);
	}
	
	public String getBarTitle() {
		return title;
	}
	public void setBarTitle(String title) {
		this.title = title;
	}
	
	//Nested Class
	private class TitleBarListener implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent e) {
			switch(e.getEventType().toString()) {
			case "MOUSE_PRESSED":
				xOffset = e.getSceneX();
		        yOffset = e.getSceneY();
		        break;
		   
			case "MOUSE_DRAGGED":
				stage.setX(e.getScreenX() - xOffset);
	        	stage.setY(e.getScreenY() - yOffset);
				break;
			}
		}
	}
	
	private class TitleBarButtonListener implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent e) {
			if(e.getSource() == minimizeBtn) {
				stage.setIconified(true);
				
			}else if(e.getSource() == closeBtn) {
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
