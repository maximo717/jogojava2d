package main;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setTitle("AdventureGame");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
<<<<<<< HEAD
		gamePanel.setupGame();
=======
>>>>>>> b4da4e74f0398286409019b779bdf6b9e406376b
		gamePanel.startGameThread();
		
	}

}