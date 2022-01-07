package stones;

public class StorageGUI {
	public int initialValues;
	public int players;
	
	public StorageGUI() {
		initialValues = 0;
		players = 0;
	}
	
	public StorageGUI(int startStones, int playNum) {
		initialValues = startStones;
		players = playNum;
	}
	
	public int giveInitial() {
		System.out.println("InitialValue: " + initialValues);
		return(initialValues);
	}
	
	public int givePlayers() {
		System.out.println("Players: " + players);
		return(players);
	}
}
