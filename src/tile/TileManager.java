package tile;

import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	
	GamePanel gp;
<<<<<<< HEAD
	public Tile[] tile;
	public int mapTileNum[][];
=======
	Tile[] tile;
	int mapTileNum[][];
>>>>>>> b4da4e74f0398286409019b779bdf6b9e406376b
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[10];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/world01.txt");
	}
	
	public void getTileImage() {
		try {
			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/grass.png"));
			
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/wall.png"));
<<<<<<< HEAD
			tile[1].collision = true;
=======
>>>>>>> b4da4e74f0398286409019b779bdf6b9e406376b
			
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water.png"));
<<<<<<< HEAD
			tile[2].collision= true;
=======
>>>>>>> b4da4e74f0398286409019b779bdf6b9e406376b
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/earth.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/tree.png"));
<<<<<<< HEAD
			tile[4].collision= true;
=======
>>>>>>> b4da4e74f0398286409019b779bdf6b9e406376b
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/sand.png"));
			
			
	}
		catch(IOException e) {
		e.printStackTrace();
	}
	
}
	public void loadMap(String filePatch) {
		
		try {
			
			InputStream is = getClass().getResourceAsStream(filePatch);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
			
		}
		catch(Exception e) {
			
		}
		
		
	}
	public void draw(Graphics2D g2) {
		
		int worldCol = 0;
		int worldRow = 0;
		
		while(worldCol <gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
<<<<<<< HEAD
			int screenX = worldX - gp.player.worldX + gp.player.screenX+6;
			int screenY = worldY - gp.player.worldY + gp.player.screenY+6;
=======
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
>>>>>>> b4da4e74f0398286409019b779bdf6b9e406376b
			
			if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
					worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
					worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
					worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
				
				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

			}
			worldCol++;
			
<<<<<<< HEAD
			if(worldCol == gp.maxWorldCol) {
=======
			if(worldCol == gp.maxScreenCol) {
>>>>>>> b4da4e74f0398286409019b779bdf6b9e406376b
				worldCol = 0;
				worldRow++;
			}
			
		}
		
		
	}
}