/*
 * StonesGame.java
 * Kevin Zhou
 * Client Code for Culminating Assignment
 * ICS3U
 * January 10, 2020
 */

package stones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Client code for the stones game
 */
public class StonesGame implements ActionListener {
	JFrame frame, boardFrame;
	JPanel contentPane, boardPanel;
	JLabel initialLabel, playerLabel, errorLabel, player1Home, player2Home,
	player1Pit1, player1Pit2, player1Pit3, player1Pit4, player1Pit5, player1Pit6,
	player2Pit1, player2Pit2, player2Pit3, player2Pit4, player2Pit5, player2Pit6, 
	emptyLabel, turnLabel, turnNum, errorMessage;
	JTextField startingStones, numPlayers;
	JButton startButton, pit1Button, pit2Button, pit3Button, pit4Button, pit5Button, pit6Button;
	int initialValue = 0;
	int players = 0;
	int turn = 0;
	int gameStart = 0;
	BoardGUI game = new BoardGUI();
	
	public StonesGame() {
		frame = new JFrame("Stones Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(0, 2, 10, 5));
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		initialLabel = new JLabel("Input the starting number of stones. (2, 3, 4, 5)");
		contentPane.add(initialLabel);
		
		startingStones = new JTextField(10);
		contentPane.add(startingStones);
		
		playerLabel = new JLabel("Input who you want to play against. Enter 1 to play against AI. Enter 2 to play with another person");
		contentPane.add(playerLabel);
		
		numPlayers = new JTextField(10);
		contentPane.add(numPlayers);
		
		errorLabel = new JLabel("Press Start when you are ready");
		contentPane.add(errorLabel);
		
		startButton = new JButton("Start");
		startButton.setAlignmentX(JLabel.BOTTOM_ALIGNMENT);
		startButton.setActionCommand("Start");
		startButton.addActionListener(this);
		contentPane.add(startButton);
		
		frame.setContentPane(contentPane);
		
		frame.pack();
		frame.setVisible(true);
		
		boardFrame = new JFrame("Stones Board");
		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(0, 8, 5, 5));
		boardPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		turnNum = new JLabel("Turn 1");
		turnNum.setForeground(Color.BLACK);
		turnNum.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		turnNum.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		boardPanel.add(turnNum);
		
		player2Pit1 = new JLabel("0");
		player2Pit1.setForeground(Color.BLUE);
		player2Pit1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		player2Pit1.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		boardPanel.add(player2Pit1);
		
		player2Pit2 = new JLabel("0");
		player2Pit2.setForeground(Color.BLUE);
		player2Pit2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		player2Pit2.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		boardPanel.add(player2Pit2);
		
		player2Pit3 = new JLabel("0");
		player2Pit3.setForeground(Color.BLUE);
		player2Pit3.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		player2Pit3.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		player2Pit3.setBackground(Color.MAGENTA);
		boardPanel.add(player2Pit3);
		
		player2Pit4 = new JLabel("0");
		player2Pit4.setForeground(Color.BLUE);
		player2Pit4.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		player2Pit4.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		boardPanel.add(player2Pit4);
		
		player2Pit5 = new JLabel("0");
		player2Pit5.setForeground(Color.BLUE);
		player2Pit5.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		player2Pit5.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		boardPanel.add(player2Pit5);
		
		player2Pit6 = new JLabel("0");
		player2Pit6.setForeground(Color.BLUE);
		player2Pit6.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		player2Pit6.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		boardPanel.add(player2Pit6);
		
		turnLabel = new JLabel("Player 1's turn");
		turnLabel.setForeground(Color.BLUE);
		turnLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		turnLabel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		boardPanel.add(turnLabel);
		
		player2Home = new JLabel("Player 2: 0");
		player2Home.setForeground(Color.BLUE);
		player2Home.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		player2Home.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		boardPanel.add(player2Home);
		
		player1Pit1 = new JLabel("0");
		player1Pit1.setForeground(Color.MAGENTA);
		player1Pit1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		player1Pit1.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		boardPanel.add(player1Pit1);
		
		player1Pit2 = new JLabel("0");
		player1Pit2.setForeground(Color.MAGENTA);
		player1Pit2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		player1Pit2.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		boardPanel.add(player1Pit2);
		
		player1Pit3 = new JLabel("0");
		player1Pit3.setForeground(Color.MAGENTA);
		player1Pit3.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		player1Pit3.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		player1Pit3.setBackground(Color.MAGENTA);
		boardPanel.add(player1Pit3);
		
		player1Pit4 = new JLabel("0");
		player1Pit4.setForeground(Color.MAGENTA);
		player1Pit4.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		player1Pit4.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		boardPanel.add(player1Pit4);
		
		player1Pit5 = new JLabel("0");
		player1Pit5.setForeground(Color.MAGENTA);
		player1Pit5.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		player1Pit5.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		boardPanel.add(player1Pit5);
		
		player1Pit6 = new JLabel("0");
		player1Pit6.setForeground(Color.MAGENTA);
		player1Pit6.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		player1Pit6.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		boardPanel.add(player1Pit6);
		
		player1Home = new JLabel("Player 1: 0");
		player1Home.setForeground(Color.MAGENTA);
		player1Home.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		player1Home.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		boardPanel.add(player1Home);
		
		emptyLabel = new JLabel(" ");
		boardPanel.add(emptyLabel);
		
		pit1Button = new JButton("Pit 1");
		pit1Button.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		pit1Button.setActionCommand("Pit 1");
		pit1Button.addActionListener(this);
		boardPanel.add(pit1Button);
		
		pit2Button = new JButton("Pit 2");
		pit2Button.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		pit2Button.setActionCommand("Pit 2");
		pit2Button.addActionListener(this);
		boardPanel.add(pit2Button);
		
		pit3Button = new JButton("Pit 3");
		pit3Button.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		pit3Button.setActionCommand("Pit 3");
		pit3Button.addActionListener(this);
		boardPanel.add(pit3Button);
		
		pit4Button = new JButton("Pit 4");
		pit4Button.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		pit4Button.setActionCommand("Pit 4");
		pit4Button.addActionListener(this);
		boardPanel.add(pit4Button);
		
		pit5Button = new JButton("Pit 5");
		pit5Button.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		pit5Button.setActionCommand("Pit 5");
		pit5Button.addActionListener(this);
		boardPanel.add(pit5Button);
		
		pit6Button = new JButton("Pit 6");
		pit6Button.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		pit6Button.setActionCommand("Pit 6");
		pit6Button.addActionListener(this);
		boardPanel.add(pit6Button);
		
		errorMessage = new JLabel(" ");
		boardPanel.add(errorMessage);
		
		boardFrame.setContentPane(boardPanel);
		
		boardFrame.pack();
		boardFrame.setVisible(false);
	}
	
	/**
	 * Handle button click action event
	 * pre: Action event is Start or Pit 1-6
	 * post: An error message is displayed or a game board frame is displayed
	 */
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		int play = 0;
		int[] pits;
		int winner, moveAI;
		
		if (eventName.equals("Start")) {
			gameStart = 1;
		}
		
		if (gameStart == 1) {
			String start = startingStones.getText();
			String num = numPlayers.getText();
			
			start.trim();
			num.trim();
			
			if (start.equals("2")) {
				initialValue = 2;
				play += 1;
			} else if (start.equals("3")) {
				initialValue = 3;
				play += 1;
			} else if (start.equals("4")) {
				initialValue = 4;
				play += 1;
			} else if (start.equals("5")) {
				initialValue = 5;
				play += 1;
				System.out.println("5");
			}
			
			if (num.equals("1")) {
				players = 1;
				play += 1;
			} else if (num.equals("2")) {
				players = 2;
				play += 1;
			} 
			
			if (play == 2) {
				frame.setVisible(false);
				boardFrame.setVisible(true);
				game.setPits(initialValue, players, turn);
				turn += 1;
				
				pits = game.getArray();
				
				if (players == 1) {
					//System.out.println("Ai game type");
					if (game.getPlayerTurn() == 1) {
						if (eventName.equals("Pit 1")) {
							if (pits[1] == 0) {
								errorMessage.setText("There are no stones in that pit!");
								turn -= 1;
							} else {
								game.distributeStone(1);
								errorMessage.setText(" ");
							}
						} else if (eventName.equals("Pit 2")) {
							if (pits[2] == 0) {
								errorMessage.setText("There are no stones in that pit!");
								turn -= 1;
							} else {
								game.distributeStone(2);
								errorMessage.setText(" ");
							}
							
						} else if (eventName.equals("Pit 3")) {
							if (pits[3] == 0) {
								errorMessage.setText("There are no stones in that pit!");
								turn -= 1;
							} else {
								game.distributeStone(3);
								errorMessage.setText(" ");
							}
							
						} else if (eventName.equals("Pit 4")) {
							if (pits[4] == 0) {
									errorMessage.setText("There are no stones in that pit!");
									turn -= 1;
							} else {
									game.distributeStone(4);
									errorMessage.setText(" ");
								}
							
						} else if (eventName.equals("Pit 5")) {
							if (pits[5] == 0) {
								errorMessage.setText("There are no stones in that pit!");
								turn -= 1;
							} else {
								game.distributeStone(5);
								errorMessage.setText(" ");
							}
						} else if (eventName.equals("Pit 6")) {
							if (pits[6] == 0) {
								errorMessage.setText("There are no stones in that pit!");
								turn -= 1;
							} else {
								game.distributeStone(6);
								errorMessage.setText(" ");
							}
						}
						
					} else if (game.getPlayerTurn() == 2) {
						System.out.println("Ai's turn");
						moveAI = game.AITurn();
						System.out.println("Ai moves pit: " + moveAI);
						game.distributeStone(moveAI);
					}
					
				} else if (players == 2) {
					if (eventName.equals("Pit 1")) {
						if (game.getPlayerTurn() == 2) {
							if (pits[13] == 0) {
								errorMessage.setText("There are no stones in that pit!");
								turn -= 1;
							} else {
								game.distributeStone(1);
								errorMessage.setText(" ");
							}
						} else if (game.getPlayerTurn() == 1) {
							if (pits[1] == 0) {
								errorMessage.setText("There are no stones in that pit!");
								turn -= 1;
							} else {
								game.distributeStone(1);
								errorMessage.setText(" ");
							}
						}
					} else if (eventName.equals("Pit 2")) {
						if (game.getPlayerTurn() == 2) {
							if (pits[12] == 0) {
								errorMessage.setText("There are no stones in that pit!");
								turn -= 1;
							} else {
								game.distributeStone(2);
								errorMessage.setText(" ");
							}
						} else if (game.getPlayerTurn() == 1) {
							if (pits[2] == 0) {
								errorMessage.setText("There are no stones in that pit!");
								turn -= 1;
							} else {
								game.distributeStone(2);
								errorMessage.setText(" ");
							}
						}
					} else if (eventName.equals("Pit 3")) {
						if (game.getPlayerTurn() == 2) {
							if (pits[11] == 0) {
								errorMessage.setText("There are no stones in that pit!");
								turn -= 1;
							} else {
								game.distributeStone(3);
								errorMessage.setText(" ");
							}
						} else if (game.getPlayerTurn() == 1) {
							if (pits[3] == 0) {
								errorMessage.setText("There are no stones in that pit!");
								turn -= 1;
							} else {
								game.distributeStone(3);
								errorMessage.setText(" ");
							}
						}
					} else if (eventName.equals("Pit 4")) {
						if (game.getPlayerTurn() == 2) {
							if (pits[10] == 0) {
								errorMessage.setText("There are no stones in that pit!");
								turn -= 1;
							} else {
								game.distributeStone(4);
								errorMessage.setText(" ");
							}
						} else if (game.getPlayerTurn() == 1) {
							if (pits[4] == 0) {
								errorMessage.setText("There are no stones in that pit!");
								turn -= 1;
							} else {
								game.distributeStone(4);
								errorMessage.setText(" ");
							}
						}
					} else if (eventName.equals("Pit 5")) {
						if (game.getPlayerTurn() == 2) {
							if (pits[9] == 0) {
								errorMessage.setText("There are no stones in that pit!");
								turn -= 1;
							} else {
								game.distributeStone(5);
								errorMessage.setText(" ");
							}
						} else if (game.getPlayerTurn() == 1) {
							if (pits[5] == 0) {
								errorMessage.setText("There are no stones in that pit!");
								turn -= 1;
							} else {
								game.distributeStone(5);
								errorMessage.setText(" ");
							}
						}
					} else if (eventName.equals("Pit 6")) {
						if (game.getPlayerTurn() == 2) {
							if (pits[8] == 0) {
								errorMessage.setText("There are no stones in that pit!");
								turn -= 1;
							} else {
								game.distributeStone(6);
								errorMessage.setText(" ");
							}
						} else if (game.getPlayerTurn() == 1) {
							if (pits[6] == 0) {
								errorMessage.setText("There are no stones in that pit!");
								turn -= 1;
							} else {
								game.distributeStone(6);
								errorMessage.setText(" ");
							}
						}
					}
				}
				
				pits = game.getArray();
				
				player1Pit1.setText(String.valueOf(pits[1]));
				player1Pit2.setText(String.valueOf(pits[2]));
				player1Pit3.setText(String.valueOf(pits[3]));
				player1Pit4.setText(String.valueOf(pits[4]));
				player1Pit5.setText(String.valueOf(pits[5]));
				player1Pit6.setText(String.valueOf(pits[6]));
				
				player2Pit1.setText(String.valueOf(pits[13]));
				player2Pit2.setText(String.valueOf(pits[12]));
				player2Pit3.setText(String.valueOf(pits[11]));
				player2Pit4.setText(String.valueOf(pits[10]));
				player2Pit5.setText(String.valueOf(pits[9]));
				player2Pit6.setText(String.valueOf(pits[8]));
				
				player1Home.setText("Player 1: " + String.valueOf(pits[7]));
				player2Home.setText("Player 2: " + String.valueOf(pits[0]));
				
				turnLabel.setText("Player " + String.valueOf(game.getPlayerTurn()) + "'s turn");
				if (game.getPlayerTurn() == 2) {
					turnLabel.setForeground(Color.BLUE);
				} else if (game.getPlayerTurn() == 1) {
					turnLabel.setForeground(Color.MAGENTA);
				}
				
				if (players == 1) {
					if (game.getPlayerTurn() == 2) {
						turnLabel.setText("AI's Turn");
						errorMessage.setText("Press any button to continue.");
					} else {
						errorMessage.setText(" ");
					}
				}
				
				turnNum.setText("Turn: " + turn);
				
				winner = game.determineWin();
				
				if (winner == 1) {
					errorMessage.setText("Congrats! Player 1 has won!");
					pits = game.getArray();
					player1Pit1.setText(String.valueOf(pits[13]));
					player1Pit2.setText(String.valueOf(pits[12]));
					player1Pit3.setText(String.valueOf(pits[11]));
					player1Pit4.setText(String.valueOf(pits[10]));
					player1Pit5.setText(String.valueOf(pits[9]));
					player1Pit6.setText(String.valueOf(pits[8]));
					
					player2Pit1.setText(String.valueOf(pits[1]));
					player2Pit2.setText(String.valueOf(pits[2]));
					player2Pit3.setText(String.valueOf(pits[3]));
					player2Pit4.setText(String.valueOf(pits[4]));
					player2Pit5.setText(String.valueOf(pits[5]));
					player2Pit6.setText(String.valueOf(pits[6]));
					
					player1Home.setText("Player 1: " + String.valueOf(pits[7]));
					player2Home.setText("Player 2: " + String.valueOf(pits[0]));
				} else if (winner == 2) {
					errorMessage.setText("Congrats! Player 2 has won!");
					pits = game.getArray();
					player1Pit1.setText(String.valueOf(pits[13]));
					player1Pit2.setText(String.valueOf(pits[12]));
					player1Pit3.setText(String.valueOf(pits[11]));
					player1Pit4.setText(String.valueOf(pits[10]));
					player1Pit5.setText(String.valueOf(pits[9]));
					player1Pit6.setText(String.valueOf(pits[8]));
					
					player2Pit1.setText(String.valueOf(pits[1]));
					player2Pit2.setText(String.valueOf(pits[2]));
					player2Pit3.setText(String.valueOf(pits[3]));
					player2Pit4.setText(String.valueOf(pits[4]));
					player2Pit5.setText(String.valueOf(pits[5]));
					player2Pit6.setText(String.valueOf(pits[6]));
					
					player1Home.setText("Player 1: " + String.valueOf(pits[7]));
					player2Home.setText("Player 2: " + String.valueOf(pits[0]));
				} else if (winner == 3) {
					errorMessage.setText("It's a tie!");
					pits = game.getArray();
					player1Pit1.setText(String.valueOf(pits[13]));
					player1Pit2.setText(String.valueOf(pits[12]));
					player1Pit3.setText(String.valueOf(pits[11]));
					player1Pit4.setText(String.valueOf(pits[10]));
					player1Pit5.setText(String.valueOf(pits[9]));
					player1Pit6.setText(String.valueOf(pits[8]));
					
					player2Pit1.setText(String.valueOf(pits[1]));
					player2Pit2.setText(String.valueOf(pits[2]));
					player2Pit3.setText(String.valueOf(pits[3]));
					player2Pit4.setText(String.valueOf(pits[4]));
					player2Pit5.setText(String.valueOf(pits[5]));
					player2Pit6.setText(String.valueOf(pits[6]));
					
					player1Home.setText("Player 1: " + String.valueOf(pits[7]));
					player2Home.setText("Player 2: " + String.valueOf(pits[0]));
				}
				
			} else {
				errorLabel.setText("You have inputed something incorrect. Please reinput your choices");
				System.out.println("error check");
			}
		}
		
		
	}
	
	/**
	 * Create and show the GUI
	 */
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		StonesGame greetings = new StonesGame();
	}
	public static void main(String[] args) {
		/* Methods that create and show a GUI should be 
		   run from an event-dispatching thread */
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
	}

}