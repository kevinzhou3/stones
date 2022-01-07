/*
 * BoardGUI.java
 * Kevin Zhou
 * Board GUI version for Stones game
 * ICS3U
 * January 9, 2020
 */

package stones;

import java.lang.Math;

/**
 * The Board GUI version class
 */

public class BoardGUI {
	private int[] pit; 
	public int winner = 0;
	private int playerNum;
	private int turnNum;
	private int numPlayers;
	private boolean turnAgain = false;;

	/**
	 * constructor
	 * pre:none
	 * post: pit has been initialized
	 */
	public BoardGUI(){
		pit = new int[14];
	}

	/**
	 * Sets the pits to the initial stones value. 
	 * pre: none
	 * post: The pits have been filled to the initial value
	 */
	public void setPits(int startNum, int gameType, int turn){
		
		if (turn == 0) {
			for (int i = 0; i < pit.length; i++){
				pit[i] = startNum;
			}
			pit[0] = 0;
			pit[7] = 0;
			numPlayers = gameType;
			//turnNum = 0;
			playerNum = 1;
			//System.out.println("Broken");
			//System.out.println(turn);
		}
		
	}
	
	/**
	 * Distributes the stones according to the pit number chosen by the player
	 * and determines if player gets another turn or can steal a stone
	 * pre: none
	 * post: Stones have been distributed, player turn has been determined, and
	 * if player can steal a stone has been determined
	 */
	public void distributeStone(int pitNum) {
		int stones, addPitNum, currentPitNum;
		
		addPitNum = 1;
		if (playerNum == 2) {
			//System.out.println("Hi");
			if (pitNum == 1) {
				pitNum = 13;
			} else if (pitNum == 2){
				pitNum = 12;
			} else if (pitNum == 3){
				pitNum = 11;
			} else if (pitNum == 4){
				pitNum = 10;
			} else if (pitNum == 5){
				pitNum = 9;
			} else if (pitNum == 6){
				pitNum = 8;
			}
		}
		stones = pit[pitNum];
		
		for (int i = 1; i <= stones; i++) {
			if (playerNum == 1) {
				if (pitNum != 7) {
					pit[pitNum] = 0;
				}
				if (pitNum + addPitNum > 13) {
					addPitNum = (pitNum + addPitNum - 1) % 13;
					pitNum = 0;
				}

				if (pitNum + addPitNum == 0) {
					addPitNum += 1;
				}

				pit[pitNum + addPitNum] += 1;

				
				//System.out.println(pitNum); System.out.println(addPitNum);
				//System.out.println(pitNum + addPitNum);
				 
			}
			
			
			
			if (playerNum == 2) {
				if (pitNum != 0) {
					pit[pitNum] = 0;
				}
				if (pitNum + addPitNum > 13) {
					addPitNum = (pitNum + addPitNum - 1) % 13;
					pitNum = 0;
				}

				if (pitNum + addPitNum == 7) {
					addPitNum += 1;
				}

				pit[pitNum + addPitNum] += 1;

				
				//System.out.println(pitNum); System.out.println(addPitNum);
				//System.out.println(pitNum + addPitNum);
				 
			}
			
			addPitNum += 1;
		}
		
		currentPitNum = pitNum + addPitNum - 1;
		
		if (currentPitNum == 0 || currentPitNum == 7) {
			turnAgain = true;
		} else {
			turnAgain = false;
		}
		
		if (pit[currentPitNum] == 1 && currentPitNum != 0 && currentPitNum != 7) {
			if (playerNum == 2) {
				if (currentPitNum == 13 || currentPitNum == 12 || currentPitNum == 11 || 
						currentPitNum == 10 || currentPitNum == 9 || currentPitNum == 8) {
					stealStone(currentPitNum);
				}
			}
			if (playerNum == 1) {
				if (currentPitNum == 1 || currentPitNum == 2 || currentPitNum == 3 || 
						currentPitNum == 4 || currentPitNum == 5 || currentPitNum == 6) {
					stealStone(currentPitNum);
				}
			}
		}
		
		if (/*turnNum != 0 && numPlayers == 2 && */turnAgain == false) {
			if (playerNum == 1) {
				playerNum = 2;
			} else {
				playerNum = 1;
			}
		} 
	}
	
	/**
	 * Checks the opponents corresponding pit to see if the player steals any stones
	 * pre: none
	 * post: Stolen stones have been added to player's home pit
	 */
	public void stealStone(int currentPitNum) {
		int stolenStones = 0;
		if (playerNum == 2) {
			if (currentPitNum == 13) {
				stolenStones = pit[1];
				pit[1] = 0;
			} else if (currentPitNum == 12) {
				stolenStones = pit[2];
				pit[2] = 0;
			} else if (currentPitNum == 11) {
				stolenStones = pit[3];
				pit[3] = 0;
			} else if (currentPitNum == 10) {
				stolenStones = pit[4];
				pit[4] = 0;
			} else if (currentPitNum == 9) {
				stolenStones = pit[5];
				pit[5] = 0;
			} else if (currentPitNum == 8) {
				stolenStones = pit[6];
				pit[6] = 0;
			}
			pit[0] += stolenStones;
		}
		if (playerNum == 1) {
			if (currentPitNum == 1) {
				stolenStones = pit[13];
				pit[13] = 0;
			} else if (currentPitNum == 2) {
				stolenStones = pit[12];
				pit[12] = 0;
			} else if (currentPitNum == 3) {
				stolenStones = pit[11];
				pit[11] = 0;
			} else if (currentPitNum == 4) {
				stolenStones = pit[10];
				pit[10] = 0;
			} else if (currentPitNum == 5) {
				stolenStones = pit[9];
				pit[9] = 0;
			} else if (currentPitNum == 6) {
				stolenStones = pit[8];
				pit[8] = 0;
			}
			pit[7] += stolenStones;
		}
	}
	
	/**
	 * Returns the pit array
	 * pre: none
	 * post: Pit array has been returned
	 */
	public int[] getArray() {
		return(pit);
	}
	
	/**
	 * Returns the player turn
	 * pre: none
	 * post: Player turn has been returned
	 */
	public int getPlayerTurn() {
		int playerTurn;
		playerTurn = playerNum;
		//System.out.println("Player " + playerTurn);
		return(playerTurn);
	}
	
	/**
	 * AI logic. Determines a random pit to empty
	 * pre: none
	 * post: AI turn has been determined
	 */
	public int AITurn() {  
		/* int moveAI;
		int MAX = 13;
		int MIN = 8;
		
		moveAI = (int)((MAX - MIN + 1) * Math.random() + MIN);
		
		while (pit[moveAI] == 0) {
			moveAI += 1;
			if (moveAI >= MAX) {
				moveAI = 8;
			}
		} */

		
		int[] pitsAI = pit; 
		int stonesAI, currentPitNumAI, currentMove, largestStone;
		int moveAI = -1;

		for (int i = 8; i < pitsAI.length; i++) { 
			int addPitNumAI = 1;
			currentMove = i;
			stonesAI = pitsAI[currentMove];

			for (int counter = 1; counter <= stonesAI; counter++) { 
				if (currentMove != 0) { 
					pitsAI[currentMove] = 0; 
				} 
				if (currentMove + addPitNumAI > 13) {
					addPitNumAI = (currentMove + addPitNumAI - 1) % 13; 
					currentMove = 0; 
				}

				if (currentMove + addPitNumAI == 7) { 
					addPitNumAI += 1; 
				}

				pitsAI[currentMove + addPitNumAI] += 1;

				addPitNumAI += 1; 
			}

			currentPitNumAI = currentMove + addPitNumAI - 1;

			if (currentPitNumAI == 0) { 
				moveAI = i;
				System.out.println("goes through 1 option"); break; 
			} else if (pitsAI[currentPitNumAI] == 1 && currentPitNumAI != 0) { 
				if (currentPitNumAI == 13 || currentPitNumAI == 12 || currentPitNumAI == 11 
						|| currentPitNumAI == 10 || currentPitNumAI == 9 || currentPitNumAI == 8) { 
					moveAI = i;
					System.out.println("goes through 2 option"); break; 
				} 
			} else { 
				largestStone = 8; 
				for (int x = 8; x < pitsAI.length; x ++) { 
					if (pitsAI[largestStone] < pitsAI[x]) { 
						largestStone = x; 
					} 
				} 
				moveAI = largestStone;
				System.out.println("goes through 3 option"); break;
			}

		}
		
		if (moveAI == 13) {
			moveAI = 1; 
		} else if (moveAI == 12) { 
			moveAI = 2; 
		} else if (moveAI == 11) { 
			moveAI = 3; 
		} else if (moveAI == 10) { 
			moveAI = 4; 
		} else if (moveAI == 9) { 
			moveAI = 5; 
		} else if (moveAI == 8) { 
			moveAI = 6; 
		}
		
		//System.out.println("Ai moves pit: " + moveAI);
		return(moveAI);

	}

	/**
	 * Determines the winner of the game when all pits on one side are empty
	 * pre: none
	 * post: Winner has been returned
	 */
	public int determineWin() {
		int p1Score, p2Score;
		if (pit[1] == 0 && pit[2] == 0 && pit[3] == 0 && 
				pit[4] == 0 && pit[5] == 0 && pit[6] == 0) {
			pit[7] += pit[8] + pit[9] + pit[10] + pit[11] + pit[12] + pit[13];
			if (pit[7] > pit[0]) {
				winner = 1;
			} else {
				winner = 2;
			}
			p1Score = pit[7];
			p2Score = pit[0];
			for (int i = 0; i < pit.length; i++){
				pit[i] = 0;
			}
			
			pit[7] = p1Score;
			pit[0] = p2Score;
			
		}
		if (pit[8] == 0 && pit[9] == 0 && pit[10] == 0 && 
				pit[11] == 0 && pit[12] == 0 && pit[13] == 0) {
			pit[0] += pit[1] + pit[2] + pit[3] + pit[4] + pit[5] + pit[6];
			if (pit[0] > pit[7]) {
				winner = 2;
			} else {
				winner = 1;
			}
			
			p1Score = pit[7];
			p2Score = pit[0];
			for (int i = 0; i < pit.length; i++){
				pit[i] = 0;
			}
			
			pit[7] = p1Score;
			pit[0] = p2Score;
		}
		if (pit[8] == 0 && pit[9] == 0 && pit[10] == 0 && 
				pit[11] == 0 && pit[12] == 0 && pit[13] == 0) {
			pit[0] += pit[1] + pit[2] + pit[3] + pit[4] + pit[5] + pit[6];
			if (pit[0] == pit[7]) {
				winner = 3;
			}
			
			p1Score = pit[7];
			p2Score = pit[0];
			for (int i = 0; i < pit.length; i++){
				pit[i] = 0;
			}
			
			pit[7] = p1Score;
			pit[0] = p2Score;
		}
		return(winner);
	}
}