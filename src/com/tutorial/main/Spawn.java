package com.tutorial.main;

import java.util.Random;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	
	public Spawn(Handler handler,HUD hud){
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick(){
		scoreKeep++;
		
		if(scoreKeep >= 250){
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			if((hud.getLevel()%2)==0){
 				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy,handler));
			}
			else if((hud.getLevel()%5)==0){
				handler.clearEnemys(); //fungsi ngehilangin enemy
				handler.addObject(new EnemyBoss((Game.WIDTH)-30,0,ID.EnemyBoss,handler));
 				handler.addObject(new EnemyBoss(Game.WIDTH/2,0,ID.EnemyBoss,handler));
 				handler.addObject(new EnemyBoss(30,0,ID.EnemyBoss,handler));
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.SmartEnemy,handler));
			}
			else if((hud.getLevel()%7)==0){
				handler.clearEnemys(); //fungsi ngehilangin enemy
 				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy,handler));
 				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy,handler));
 				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy,handler));
			}
				
		}
		
	}
	
	
}
