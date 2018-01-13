/**
S@author ${Dutsadi Bunliang} Created: 2017-11-27 15:40:17 Updated: 
 */
package model;

public class Game {
	//VARIABLES
	private GridTile board;
	private int streak;
	private int row;
	private int column;
	private int x;
	private int y;
	private int xCounter;
	private int oCounter;
	
	private Entity currentPlayer;
	private Entity winner;
	private int turn;
	
	private static String winnerString = "Winner ";
	private static String turnString = "Turn ";
	private static String noWinnerString = "No Winner";
	
	//CONTRUCTORS
	public Game() {
		board = new GridTile(3);
		board.create();
		streak = 3;
		row = board.getRow();
		column = board.getColumn();
		currentPlayer = Entity.X;
		turn = 0;
	}

	//METHODS
	public void checkWinner() {
		if(winner == null) {
			checkHorizantalLine();
		}
		if(winner == null) {
			checkVerticalLine();
		}
		if(winner == null) {
			checkRightDiagonalLine();
		} 
		if(winner == null) {
			checkLeftDiagonalLine();
		}
	}
		
	private void checkHorizantalLine() {
		for(y = 0; y < row; y++) {
			xCounter = 0;
			oCounter = 0;
			
			for(x = 0; x < column; x++) {
				if(board.isEmpty(x, y) == true) break;
				
				if(board.getValue(x, y) == Entity.X) {
					xCounter++;
					if(xCounter == streak) {
						winner = Entity.X;
						return;
					}
					
				}else {
					oCounter++;
					if(oCounter == streak) {
						winner = Entity.O;
						return;
					}
				}
			}
		}
	}
	
	private void checkVerticalLine() {
		for(x = 0; x < column; x++) {
			xCounter = 0;
			oCounter = 0;
			
			for(y = 0; y < row; y++) {
				if(board.isEmpty(x, y) == true) break;
				
				if(board.getValue(x, y) == Entity.X) {
					xCounter++;
					if(xCounter == streak) {
						winner = Entity.X;
						return;
					}
					
				}else {
					oCounter++;
					if(oCounter == streak) {
						winner = Entity.O;
						return;
					}
				}
			}
		}
	}
	
	private void checkRightDiagonalLine() {
		xCounter = 0;
		oCounter = 0;

		for(x = 0; x < column; x++) {
			if(board.isEmpty(x, x) == true) break;
			
			if(board.getValue(x, x) == Entity.X) {
				xCounter++;
				if(xCounter == streak) {
					winner = Entity.X;
					return;
				}
				
			}else {
				oCounter++;
				if(oCounter == streak) {
					winner = Entity.O;
					return;
				}
			}

		}
	}
	
	private void checkLeftDiagonalLine() {
		xCounter = 0;
		oCounter = 0;
    	y = row - 1;
    	
    	for(x = 0; x < column; x++) {
			if(board.isEmpty(x, y) == true) break;

            if(board.getValue(x, y) == Entity.X) {
				xCounter++;
				if(xCounter == streak) {
					winner = Entity.X;
					return;
				}
				
			}else {
				oCounter++;
				if(oCounter == streak) {
					winner = Entity.O;
					return;
				}
			}
            y--;
		}
	}
	
	public void printBoard() {
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 3; x++) {
				System.out.print(x + "," + y + " " + board.getValue(x, y) + "\t");
			}
			System.out.println();
		}
	}
	
	public void reset() {
		board.reset();
		currentPlayer = Entity.X;
		winner = null;
		turn = 0;
		printBoard();
	}
	
	public void increaseTurn() {
		turn++;
	}
	
	public GridTile getBoard() {
		return board;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public void setCurrentPlayer(Entity currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	public Entity getCurrentPlayer() {
		return currentPlayer;
	}
	
	public Entity getWinner() {
		return winner;
	}
	
	public String getTurnString(){
		return turnString + currentPlayer.toString();
	}
	
	public String getWinnerString() {
		return winnerString + winner.toString();
	}
	
	public String getNoWinnerString() {
		return noWinnerString;
	}
	
	public void switchPlayer() {
		if(currentPlayer == Entity.X) {
			currentPlayer = Entity.O;
		}else {
			currentPlayer = Entity.X;
		}
	}
	
}
