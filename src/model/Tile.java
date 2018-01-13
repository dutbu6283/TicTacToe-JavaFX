/**
 * Creator: Dutsadi Bunliang, Created: 2018-01-04 11:42:03 Updated: 
 */
package model;

public class Tile {
	//VARIABLES
	private Entity value; 
	private boolean empty;
	
	//CONTRUCTORS
	public Tile() {
		empty = true;
	}
	
	//METHODS
	public void setValue(Entity value) {
		this.value = value;
		empty = false;
	}
	
	public Entity getValue() {
		return value;
	}
	
	public boolean isEmpty() {
		return empty;
	}
	
	public void reset() {
		value = null;
		empty = true;
	}

}
