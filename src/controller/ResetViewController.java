/**
 * Creator: Dutsadi Bunliang, Created: 2017-12-31 05:22:38 Updated: 
 */
package controller;

import interfaces.ObjectPool;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Game;
import view.GridView;
import view.StatusView;

public class ResetViewController implements EventHandler<MouseEvent>, ObjectPool{
	//VARIABLES
	private Game model;
	private StatusView status;
	private GridView grid;

	//CONTRUCTOR
	public ResetViewController(Game model) {
		this.model = model;
	}

	//METHODS
	@Override
	public void handle(MouseEvent e) {
		status = (StatusView) getObject("status");
		grid = (GridView) getObject("grid");
		
		model.reset();
		grid.reset();
		status.reset();
	}
	
}
