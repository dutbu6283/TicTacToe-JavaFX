/**
@author ${Dutsadi Bunliang} Created: 2017-11-28 00:39:15 Updated: 
 */
package view;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ResetView extends StackPane{
	//VARIABLES
	private DropShadow drop;
	private Label label;
	
	private EventHandler<MouseEvent> listener;

	//CONTRUCTORS
	public ResetView(EventHandler<MouseEvent> listener) {
		this.listener = listener;
		initDefault();
	}

	//METHODS
	private void initDefault() {
		drop = new DropShadow();
		drop.setBlurType(BlurType.GAUSSIAN);
		drop.setColor(Color.web("#E50071"));
		drop.setRadius(4);
		
		label = new Label("Reset Game");
		label.setFont(Font.font("",FontWeight.BOLD, 30));
		label.setTextFill(Color.web("#333333"));
		label.setOnMouseEntered(e ->{
			label.setEffect(drop);
			
		});
		label.setOnMouseExited(e ->{
			label.setEffect(null);
		});
		
		setMaxWidth(300);
		setStyle("-fx-background-color: white;");
		getChildren().add(label);
		setEventHandler(MouseEvent.MOUSE_CLICKED, listener);
	}

}
