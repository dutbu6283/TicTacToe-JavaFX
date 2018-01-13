/**
 * Creator: Dutsadi Bunliang, Created: 2017-12-17 20:15:11 Updated: 
 */
package fxControlsCustom;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TButton extends StackPane {
	//VARIABLES
	private Rectangle background;
	private Color onEntered;
	private Color onExited;
	
	private TButtonListener listener;
	
	//CONSTRUCTOR
	public TButton(double width, double height, ImageView imgView) {
		
		background = new Rectangle(width, height);
		
		//StackPane
		setMaxWidth(width);
		setMaxHeight(height);
		getChildren().addAll(background, imgView);
		
		listener = new TButtonListener();
		addEventHandler(MouseEvent.ANY, listener);
	}
	
	public TButton(Label label, double width, double height) {
		
		background = new Rectangle(width, height);	
		
		//StackPane
		setMaxWidth(width);
		setMaxHeight(height);
		getChildren().addAll(background, label);
		
		listener = new TButtonListener();
		addEventHandler(MouseEvent.ANY, listener);
	}
	
	//METHODS
	public void setBackgroundColor(Color color) {
		background.setFill(color);
	}
	
	public void onEntered(Color color) {
		onEntered = color; 
	}
	
	public void onExited(Color color) {
		onExited = color;
	}
	
	//Nested Class
	private class TButtonListener implements EventHandler<MouseEvent>{
		@Override
		public void handle(MouseEvent e) {
			switch(e.getEventType().toString()) {
			 case "MOUSE_ENTERED":
				 background.setFill(onEntered);
			     break; 
			     
			 case "MOUSE_EXITED":
				 background.setFill(onExited);
			     break;
			     
			 case "MOUSE_PRESSED":
				 background.setOpacity(0.6);
			     break; 
			     
			 case "MOUSE_RELEASED":
				 background.setOpacity(1);
			     break;
			}
		}
	}
	
}
