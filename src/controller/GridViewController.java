/**
 * Creator: Dutsadi Bunliang, Created: 2017-12-27 17:53:00 Updated: 
 */
package controller;

import interfaces.ObjectPool;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Game;
import view.StatusView;
import view.TileView;

public class GridViewController implements EventHandler<MouseEvent>, ObjectPool {
	//VARIABLES
	private Game model;
	private TileView tileView;
	private StatusView statusView;
	
	//CONSTRUCTORS
	public GridViewController(Game model) {
		this.model = model;
	}
	
	//METHODS
	@Override
	public void handle(MouseEvent e) {
		tileView = (TileView) e.getSource();
		
		if(model.getWinner() != null) return;
		
		if(model.getBoard().isEmpty(tileView.getPosX(), tileView.getPosY()) == true) {
			tileView.update(model.getCurrentPlayer().toString());
			
			model.getBoard().setValue(model.getCurrentPlayer(), tileView.getPosX(), tileView.getPosY());
			model.increaseTurn();
			model.printBoard();
			model.checkWinner();
			
			statusView = (StatusView) getObject("status");
			
			if(model.getWinner() == null) {
				model.switchPlayer();
				statusView.update(model.getTurnString());
				
			}else if(model.getWinner() != null){
				statusView.update(model.getWinnerString());
		
			}else if(model.getTurn() == 9) {
				statusView.update(model.getNoWinnerString());
			}
			
			System.out.println("Winner " + model.getWinner()+"Turn: " + model.getTurn());	
		}
		
	}
}
