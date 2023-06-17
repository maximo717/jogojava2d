package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import entity.Player;
import tile.TileManager;
<<<<<<< HEAD
import objects.SuperObject;
=======
>>>>>>> b4da4e74f0398286409019b779bdf6b9e406376b

public class GamePanel extends JPanel implements Runnable {
	// Configuração da tela
	final int originalTileSize = 16;
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale;//48x48
	public final int maxScreenCol= 16;
	public final int maxScrenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol;//768 pixel
	public final int screenHeight = tileSize * maxScrenRow;//576 pixel
	
	//CONFIGURACOES DO MAPA
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	//FPS do jogo
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
<<<<<<< HEAD
	public CollisionChecker cChecker= new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public Player player = new Player(this,keyH);
	public SuperObject obj[] = new SuperObject[10];
	
=======
	public Player player = new Player(this,keyH);
>>>>>>> b4da4e74f0398286409019b779bdf6b9e406376b
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
<<<<<<< HEAD
	public void setupGame() {
		
		aSetter.setObject();
	}
	
=======
>>>>>>> b4da4e74f0398286409019b779bdf6b9e406376b
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >=1) {
				update();
				
				repaint();
				
				delta--;
				drawCount++;
				
			}
			if(timer >=1000000000) {
				System.out.println("FPS"+ drawCount);
				drawCount = 0;
				timer = 0;
			}
			}
		
	}
	public void update() {
		player.update();
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 =(Graphics2D)g;
		
<<<<<<< HEAD
		//Tile
		tileM.draw(g2);
		
		//Object
		for(int i =0; i < obj.length; i++) {
			if(obj[i] != null){
				obj[i].draw(g2, this);
			}
		}
		
		//Player
=======
		tileM.draw(g2);
		
>>>>>>> b4da4e74f0398286409019b779bdf6b9e406376b
		player.draw(g2);
		
		g2.dispose();
		
	}
	
}	
