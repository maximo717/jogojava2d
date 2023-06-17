package entity;
import main.GamePanel;
import main.KeyHandler;
import java.awt.Graphics2D;
<<<<<<< HEAD
import java.awt.Rectangle;
=======
>>>>>>> b4da4e74f0398286409019b779bdf6b9e406376b
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Color;

public class Player extends Entity{
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
<<<<<<< HEAD
	int hasKey = 0;
=======
>>>>>>> b4da4e74f0398286409019b779bdf6b9e406376b
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
<<<<<<< HEAD
		solidArea = new Rectangle();
		solidArea.x= 8;
		solidArea.y= 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width= 32;
		solidArea.height= 32;
		
		
=======
>>>>>>> b4da4e74f0398286409019b779bdf6b9e406376b
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues() {
		worldX = gp.tileSize * 23;
<<<<<<< HEAD
		worldY = gp.tileSize * 12;
=======
		worldY = gp.tileSize * 21;
>>>>>>> b4da4e74f0398286409019b779bdf6b9e406376b
		speed = 4 ;
		direction= "down";
	}
	public void getPlayerImage() {
		try {
			
			up1= ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
			up2= ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
			down1= ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			down2= ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
			left1= ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
			left2= ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
			right1= ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
			right2= ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));

			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		if(keyH.upPressed== true ||keyH.downPressed==true||keyH.leftPressed==true
				||keyH.rightPressed==true) {
			
			if(keyH.upPressed == true) {
				direction= "up";
<<<<<<< HEAD
=======
				worldY -= speed;	
>>>>>>> b4da4e74f0398286409019b779bdf6b9e406376b
			}
			else if(keyH.downPressed == true) {
				direction= "down";
				
<<<<<<< HEAD
			}
			else if(keyH.leftPressed == true) {
				direction= "left";
			}
			else if(keyH.rightPressed == true) {
				direction= "right";
			}
			// Verificação de Tile colisão 
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			// Verificação de Objeto colisão
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			
			// se Colisão false player não se move
			if(collisionOn == false) {
				switch(direction) {
				case "up":
					worldY -= speed;
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX += speed;
					break;
				}
			}
			
=======
				worldY += speed;	
			}
			else if(keyH.leftPressed == true) {
				direction= "left";
				
				worldX -= speed;	
			}
			else if(keyH.rightPressed == true) {
				direction= "right";
				
				worldX += speed;
			}
>>>>>>> b4da4e74f0398286409019b779bdf6b9e406376b
			spriteCounter++;
			//velocidade da atualização de imagem
			if(spriteCounter > 12) {
				if(spriteNum ==1) {
					spriteNum=2;
				}
				else if (spriteNum==2) {
					spriteNum=1;
				}
				spriteCounter=0;
			}
			
		}
	}
<<<<<<< HEAD
	public void pickUpObject(int i) {
		
		if(i != 999) {
			
			String objectName = gp.obj[i].name;
			
			switch(objectName) {
			case "Key":
				hasKey++;
				gp.obj[i] = null;
				System.out.println("Key:"+ hasKey);
				break;
			case "Door":
				if(hasKey > 0) {
					gp.obj[i] = null;
					hasKey --;
				}
				System.out.println("Key:"+ hasKey);
				break;
			}
		}
	}
=======
>>>>>>> b4da4e74f0398286409019b779bdf6b9e406376b
	public void draw(Graphics2D g2) {
		//g2.setColor(Color.WHITE);
		//g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		BufferedImage image = null;
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize,gp.tileSize, null);
	}
}
