package view;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class GridView extends GridPane {
	//VARIABLES
	private TileView[][] grid;
	private EventHandler<MouseEvent> listener;
	
	//CONTRUCTORS
	public GridView(EventHandler<MouseEvent> listener) {
		this.listener = listener;
		initDefault();
	}

	//METHODS	
	private void initDefault(){
		create();
		setWidth(300); 
		setHeight(300);
		setAlignment(Pos.CENTER);
		setGridLinesVisible(true);
	}
	
	public void reset() {
		for(TileView[] y : grid) {
			for(TileView x : y) {
				x.reset();
			}
		}
	}
	
	//Private methods
	private void create() {
		grid = new TileView[3][3];
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 3; x++) {
				grid[x][y] = new TileView(x, y);
				grid[x][y].addEventHandler(MouseEvent.MOUSE_CLICKED, listener);
				add(grid[x][y], x, y);
			}
		}
	}
}
