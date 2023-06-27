package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	
	//Debug
	boolean checkDrawTime = false;
	
	public KeyHandler(GamePanel gp) {
		this.gp =gp;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		//TITLE STATE
		if(gp.gameState == gp.titleState) {
			if(code == KeyEvent.VK_W) {
				gp.ui.commandNumber--;
				if(gp.ui.commandNumber < 0) {
					gp.ui.commandNumber = 2;
				}
			}
			if(code == KeyEvent.VK_S) {
				gp.ui.commandNumber++;
				if(gp.ui.commandNumber > 2) {
					gp.ui.commandNumber = 0;
				}
			}
			if(code == KeyEvent.VK_ENTER) {
				if(gp.ui.commandNumber == 0) {
					gp.gameState = gp.playState;
					gp.playMusic(0);
				}
				if(gp.ui.commandNumber == 1) {
					//ADICIONAR POSTERIORMENTE
				}
				if(gp.ui.commandNumber == 2) {
					System.exit(0);
				}
			}
		}
		
		//PLAY STATE
		if(code == KeyEvent.VK_W) {
			upPressed = true;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = true;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = true;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = true;
		}
		if(code == KeyEvent.VK_P) {
			if(gp.gameState == gp.playState) {
				gp.gameState = gp.pauseState;
				
			}
			else if (gp.gameState==gp.pauseState) {
				gp.gameState=gp.playState;
			}
		}
		//Debug
		if(code == KeyEvent.VK_T) {
			if(checkDrawTime == false) {
				checkDrawTime = true;
			}
			else if(checkDrawTime == true) {
				checkDrawTime = false;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = false;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = false;
		}
		
	}

}
