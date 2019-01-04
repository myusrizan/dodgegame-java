package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.Color;

public class Player extends GameObject{

	Random r = new Random();
	Handler handler;
	
	
	public Player(int x ,int y , ID id, Handler handler){
		super(x,y,id);
		this.handler = handler;

	}
	
	public Rectangle getBounds(){
		return new Rectangle( (int)x, (int)y, 32,32);
	}

	
	public void tick() {
		x+= velX;
		y+= velY;
		
		x = Game.clamp(x , 0 , Game.WIDTH-38);
		y = Game.clamp(y , 0 , Game.HEIGHT-62);
		
		collision();
	}

	
	private void collision(){
		for (int i = 0 ; i<handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy||tempObject.getId() == ID.SmartEnemy||tempObject.getId() == ID.HardEnemy ||tempObject.getId() == ID.EnemyBoss){
				if (getBounds().intersects(tempObject.getBounds())){
				
					//collision code
					HUD.HEALTH -= 2;
				
				}
			}
		}
	}
	
	public void render(Graphics g) {
	/*		
	 	//Kalo mau ada player2
	 
	 	if (id == ID.Player)
			g.setColor(Color.white);
		if (id ==ID.Player2)
			g.setColor(Color.black);
	*/
		Graphics2D g2d = (Graphics2D) g;
		
		
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
	
	}
	
	
}
