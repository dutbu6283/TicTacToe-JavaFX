/**
 * Creator: Dutsadi Bunliang, Created: 2017-12-09 19:30:03 Updated: 
 */
package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TileView extends StackPane{		
	//VARIABLES
	private Label tileLabel;
	private int x, y;

	//CONSTRUCTORS
	public TileView(int x , int y) {
		this.x = x;
		this.y = y;
		initDefault();
    }

	//METHODS
	private void initDefault() {
		tileLabel = new Label("");
		tileLabel.setFont(Font.font(50));
		tileLabel.setTextFill(Color.rgb(51,51,51));
		
		setPrefSize(100, 100);
		setAlignment(Pos.CENTER);
		setStyle("-fx-background-color: white;");
		getChildren().add(tileLabel);
	}
	
	public void update(String value) {
		tileLabel.setText(value);
	}
		
	public void reset() {
		tileLabel.setText("");
	}
	
	public int getPosX() {
		return x;
	}
	
	public int getPosY() {
		return y;
	}
}