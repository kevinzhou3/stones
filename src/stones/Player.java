/*
 * Player.java
 * Kevin Zhou
 * ICS3U
 * January 9, 2020
 * Tester File for Stones Game
 */

package stones;
import java.util.Scanner;

public class Player {
	public static void main(String[] args){
		int initialStones, pitNum, playerNum, gameType;
		playerNum = 1;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of players: ");
		gameType = input.nextInt();
		
		System.out.print("Enter the intital value of stones: ");
		initialStones = input.nextInt();
		
		while (initialStones < 2 || initialStones > 5) {
			System.out.println("Sorry the value you just entered is invalid");
			System.out.print("Enter the intital value of stones: ");
			initialStones = input.nextInt();
		}
		
		Board game = new Board(initialStones, gameType);
		
		game.ShowBoardGame();
		
		while (game.determineWin() == 0) {
			System.out.print("Enter the pit number you want to empty: ");
			pitNum = input.nextInt();
			
			game.distributeStone(pitNum);
			game.ShowBoardGame();
			
		}
		
	}
}