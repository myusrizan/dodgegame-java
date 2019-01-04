package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.Color;

public class EnemyBoss extends GameObject {

	private Handler handler;
	Random r = new Random();
	
	private int timer = 80;
	private int timer2 = 50;
	
	public EnemyBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 0;
		velY = 0;
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle( (int)x, (int)y, 16,16);
	}

	@Override
	public void tick() {
		x += velX;
	    y += velY;
	    
	    if (timer <= 0) {
	    	velY=0;
	    	timer2--;
	    }
	    else timer--;
	    
	    
	    if (timer2<=0){
	    	if (velX==0) velX=2;
	    
	    	if(velX>0) velX+=0.005f;
	    	if(velX<0) velX-=0.005f;
	    	
	    	velX = Game.clamp(velX, -6,6); 
	    	
	    	int spawn = r.nextInt(10);
	    	if(spawn == 0) handler.addObject(new EnemyBossBullet((int)x,(int)y, ID.BasicEnemy,handler));
	    }
	    
	    
	    
	    if(y <= 0|| y>= Game.HEIGHT-32) velY *=-1;
	    if(x <= 0|| x>= Game.WIDTH-32) velX *=-1;
	    
	    handler.addObject(new Trail(x , y, ID.Trail , Color.red , 16 , 16, 0.1f, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}
	
	

}
