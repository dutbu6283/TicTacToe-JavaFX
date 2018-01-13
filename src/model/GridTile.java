/**
 * Creator: Dutsadi Bunliang, Created: 2018-01-04 11:41:55 Updated: 
 */
package model;

public class GridTile {
	//VARIABLES
	private final int row; // y
	private final int column; // x
	private Tile[][] grid;
		
	//CONTRUCTORS
	public GridTile(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public GridTile(int d) {
		row = d;
		column = d;
	}
		
	//METHODS
	public void create() {
		grid = new Tile[row][column];
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < column; c++) {
				grid[r][c] = new Tile();
			}
		}
	}
	
	public void reset() {
		for(Tile[] r : grid) {
			for(Tile c : r) {
				c.reset();
			}
		}
	}
	
	public void setValue(Entity value, int x, int y) {
		grid[x][y].setValue(value);
	}
		
	public Entity getValue(int x, int y) {
		return grid[x][y].getValue();
	}
	
	public boolean isEmpty(int x, int y) {
		return grid[x][y].isEmpty();
	}
		
	public int getRow() {
		return row;
	}
		
	public int getColumn() {
		return column;
	}

}
