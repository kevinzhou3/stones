/*
 * Board.java
 * Kevin Zhou
 * ICS3U
 * January 9, 2020
 * Board application for Stones Game
 */

package stones;

public class Board {
private int[] pit = new int[14]; 
public int winner = 0;
public int playerNum;
private int turnNum;
private int numPlayers;
private boolean turnAgain = false;;

	public Board(int startNum, int gameType){
		for (int i = 0; i < pit.length; i++){
			pit[i] = startNum;
		}
		pit[0] = 0;
		pit[7] = 0;
		numPlayers = gameType;
		turnNum = 0;
		playerNum = 1;
	}
	
	public void distributeStone(int pitNum) {
		int stones, addPitNum, currentPitNum;
		
		addPitNum = 1;
		if (playerNum == 1) {
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

				System.out.println(pitNum); System.out.println(addPitNum);
				System.out.println(pitNum + addPitNum);
				
			}
			
			
			
			if (playerNum == 2) {
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

				/*
				 * System.out.println(pitNum); System.out.println(addPitNum);
				 * System.out.println(pitNum + addPitNum);
				 */
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
			if (playerNum == 1) {
				if (currentPitNum == 13 || currentPitNum == 12 || currentPitNum == 11 || 
						currentPitNum == 10 || currentPitNum == 9 || currentPitNum == 8) {
					stealStone(currentPitNum);
				}
			}
			if (playerNum == 2) {
				if (currentPitNum == 1 || currentPitNum == 2 || currentPitNum == 3 || 
						currentPitNum == 4 || currentPitNum == 5 || currentPitNum == 6) {
					stealStone(currentPitNum);
				}
			}
		}
	}
	
	public void stealStone(int currentPitNum) {
		int stolenStones = 0;
		if (playerNum == 1) {
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
		if (playerNum == 2) {
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
	
	public void ShowBoardGame() {
		System.out.print("\nDirection of distribution\n\t<------");
		System.out.println("\n      " + pit[13] + " " + pit[12] + " " + pit[11]
				 + " " + pit[10] + " " + pit[9] + " " + pit[8] + " <---- P1's Pits");
		System.out.println("P1: " + pit[0] + "             P2: " + pit[7]);
		System.out.println("      " + pit[1] + " " + pit[2] + " " + pit[3]
				 + " " + pit[4] + " " + pit[5] + " " + pit[6] + " <---- P2's Pits");
		System.out.println("\t------>\nDirection of distribution");
		System.out.println("-----------------------");
		System.out.println("Pit # 1 2 3 4 5 6\n");
		
		if (turnNum != 0 && numPlayers == 2 && turnAgain == false) {
			if (playerNum == 1) {
				playerNum = 2;
			} else {
				playerNum = 1;
			}
		} 
		
		System.out.println("Player " + playerNum + "'s turn.");
		turnNum += 1;
		System.out.println("Turn Number: " + turnNum);
		
	}
	public int determineWin() {
		if (pit[1] == 0 && pit[2] == 0 && pit[3] == 0 && 
				pit[4] == 0 && pit[5] == 0 && pit[6] == 0) {
			pit[7] += pit[1] + pit[2] + pit[3] + pit[4] + pit[5] + pit[6];
			if (pit[1] > pit[7]) {
				winner = 1;
			} else {
				winner = 2;
			}
		}
		if (pit[8] == 0 && pit[9] == 0 && pit[10] == 0 && 
				pit[11] == 0 && pit[12] == 0 && pit[13] == 0) {
			pit[0] += pit[8] + pit[9] + pit[10] + pit[11] + pit[12] + pit[13];
			if (pit[1] > pit[7]) {
				winner = 1;
			} else {
				winner = 2;
			}
		}
		return(winner);
	}
}
