/**
@author ${Dutsadi Bunliang} Created: 2017-11-28 00:58:09 Updated: 
 */
package main;

import controller.GridViewController;
import controller.ResetViewController;
import model.Game;

public class ControllerManager {
	//VARIABLES
	private Game model;
	private GridViewController gridCon;
	private ResetViewController resetCon;
	
	//CONTRUCTORS
	public ControllerManager(){
		model = new Game();
		
		gridCon = new GridViewController(model);
		resetCon = new ResetViewController(model);
	}
	
	//METHODS
	public GridViewController getGridViewController() {
		return gridCon;
	}
	
	public ResetViewController getResetViewController() {
		return resetCon;
	}
	
}
