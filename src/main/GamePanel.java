package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import entity.Player;
import tile.TileManager;
import objects.SuperObject;

public class GamePanel extends JPanel implements Runnable {
	//CONFIGURACOES DA TELA
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
	
	//FPS DO JOGO
	int FPS = 60;
	
	//SISTEMA
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler(this);
	Sound music = new Sound();
	Sound se = new Sound();
	public CollisionChecker cChecker= new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui=new UI(this);
	Thread gameThread;
	
	//ENTIDADE E OBJETO
	public Player player = new Player(this,keyH);
	public SuperObject obj[] = new SuperObject[10];
	
	// Game State
	public int gameState;
	public final int playState = 1 ;
	public final int pauseState = 2 ;
	 
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	public void setupGame() {
		
		//aSetter.setObject();
		playMusic(0);
		gameState = playState;
		
	}
	
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
		
		if(gameState== playState) {
			player.update();
			
		}
		if (gameState == pauseState) {
			
		}
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 =(Graphics2D)g;
		
		// Debug
		long drawStart = 0;
		if(keyH.checkDrawTime == true) {
			drawStart = System.nanoTime();
		}
		
		//Tile
		tileM.draw(g2);
		
		//Object
		for(int i =0; i < obj.length; i++) {
			if(obj[i] != null){
				obj[i].draw(g2, this);
			}
		}
		
		//Player
		player.draw(g2);
		//UI
		ui.draw(g2);
		
		//Debug
		if(keyH.checkDrawTime == true) {
			long drawnEnd = System.nanoTime();
			long passed = drawnEnd - drawStart;
			g2.setColor(Color.white);
			g2.drawString("Draw Time: "+ passed, 10, 400);
			System.out.println("Draw Time: "+ passed);
		}
		
		
		
		g2.dispose();
		
	}
	
	public void playMusic(int i) {
		music.setFile(i);
		music.play();
		music.loop();
	}
	
	public void stopMusic() {
		music.stop();
	}
	
	public void playSoundEffects(int i) {
		se.setFile(i);
		se.play();
	}
}	
