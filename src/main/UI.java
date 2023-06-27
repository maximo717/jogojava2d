package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import objects.OBJ_Key;
public class UI {
	
	GamePanel gp;
	Graphics2D g2;
	Font arial_40,arial_80B;
	//BufferedImage keyImage;
	
	public boolean messageOn=false;
	public String message="";
	int messageCounter=0;
	public boolean gameFinished = false;
	public int commandNumber = 0;
	
	public UI(GamePanel gp) {
		this.gp=gp;
		arial_40=new Font("Arial",Font.PLAIN,40);
		arial_80B=new Font("Arial",Font.BOLD,80);

	//	OBJ_Key key = new OBJ_Key(gp);
	//	keyImage= key.image;
		
	}
	public void showMassage(String text) {
		message=text;
		messageOn=true;
	}
	public void draw(Graphics2D g2) {
		this.g2 =g2;
		
		g2.setFont(arial_40);
		g2.setColor(Color.YELLOW);
		
		//ESTADO DO TITULO
		if(gp.gameState == gp.titleState) {
			drawTitleScreen();
		}
		
		if(gp.gameState == gp.playState) {
			
		}
		if(gp.gameState == gp.pauseState) {
			drawPauseScreen();
			
		}
		
	}
	
	public void drawTitleScreen() {
		
		g2.setColor(new Color(0, 0, 0));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		//NOME DO TITULO
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 75F));
		String text = "Blue Boy Adventure";
		int x = getXforCenterdText(text);
		int y = gp.tileSize * 3;
		
		//SOMBRA
		g2.setColor(Color.gray);
		g2.drawString(text, x + 5, y + 5);
		
		//COR PADRAO
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		
		//IMAGEM BLUE BOY
		x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2;
		y = gp.screenHeight / 2;
		g2.drawImage(gp.player.down1, x, y, gp.tileSize*2, gp.tileSize*2, null);
		
		//MENU
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));
		
		text = "NOVO JOGO";
		x = getXforCenterdText(text);
		y += gp.tileSize * 3.5;
		g2.drawString(text, x, y);
		if(commandNumber == 0) {
			g2.drawString(">", x - gp.tileSize, y);
		}
		
		text = "CARREGAR JOGO";
		x = getXforCenterdText(text);
		y += gp.tileSize;
		g2.drawString(text, x, y);
		if(commandNumber == 1) {
			g2.drawString(">", x - gp.tileSize, y);
		}
		
		text = "SAIR";
		x = getXforCenterdText(text);
		y += gp.tileSize;
		g2.drawString(text, x, y);
		if(commandNumber == 2) {
			g2.drawString(">", x - gp.tileSize, y);
		}
	}	
	public void drawPauseScreen() {
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
		String text = "PAUSE";
		int x = getXforCenterdText(text);
		int y = gp.screenHeight/2;
		g2.drawString(text, x, y);
	}
	public int getXforCenterdText(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		return x;
	}
}
