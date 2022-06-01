public class Model {
	
	int playerTurn = 1;
	int turnCounter, playerOScore, playerXScore;
	char[] board = new char[] {'#','#','#','#','#','#','#','#','#'};
	
	public int getPlayerTurn() {
		return playerTurn;
	}
	
	public int getPlayerOScore() {
		return playerOScore;
	}
	
	public int getPlayerXScore() {
		return playerXScore;
	}
	
	public char checkForWinner() {
		
		char c;
		
		if(playerTurn == 1) {
			c = 'X';
		} else {
			c = 'O';
		}
		
		
		//check horizontally
		for(int i=0;i<3;i++) {
			if(board[i] == c && board[i+3] == c && board[i+6] == c) {
				resetGame(c);
				return c;
			}
		}

		//check vertically
		for(int i=0;i<3;i++) {
			if(board[i*3] == c && board[i*3+1] == c && board[i*3+2] == c) {
				resetGame(c);
				return c;
			}
		}
		
		//check diagonally
		for(int i=0;i<2;i++) {
			if(board[i*2] == c && board[4] == c && board[(i+8)-i*3] == c) {
				resetGame(c);
				return c;
			}
		}		
		
		if(turnCounter == 9) {
			resetGame('#');
			return '#';
		}		
		
		return 'A';
	}
	
	private void resetGame(char c) {
		
		if(c == 'X')
			playerOScore++;
		else if(c == 'O')
			playerXScore++;
		
		playerTurn = 1;
		turnCounter = 0;
		
		for(int i=0;i<9;i++) {
			board[i] = '#';
		}
	
	}

	public boolean switchPlayerTurn(int btnNr){
		
		if(playerTurn == 1 && board[btnNr] == '#') {
			
			board[btnNr] = 'O';
			turnCounter++;

			playerTurn = 2;
			
			return true;
			

		} else if (board[btnNr] == '#') {
			
			board[btnNr] = 'X';
			turnCounter++;
			
			playerTurn = 1;
			
			return true;
			
		}
		
		return false;
	}
	
}