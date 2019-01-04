package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private Random r = new Random();
	private HUD hud;
	
	public Menu(Game game, Handler handler,HUD hud){
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Menu){
			//tombol play
			if(mouseOver(mx,my,210,150,200,64)){
				game.gameState = STATE.Game;				
				handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32, ID.Player,handler));
				handler.clearEnemys();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.BasicEnemy , handler ));
				
			}
			//tombol help
			if(mouseOver(mx,my,210,250,200,64)){
				game.gameState = STATE.Help;				
				
			}
			//tombol quit
			else if(mouseOver(mx,my,210,350,200,64)){
				System.exit(1);
			}
		}		
		//tombol back help
		if(game.gameState == STATE.Help){
			if(mouseOver(mx,my,210,350,200,64)){
				game.gameState = STATE.Menu;
				return;
			}
		}

		//try again
		if (game.gameState == STATE.End){
			if(mouseOver(mx,my,210,350,200,64)){
				hud.setLevel(1);
				hud.setScore(0);
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32, ID.Player,handler));
				handler.clearEnemys();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.BasicEnemy , handler ));

			}
			if(mouseOver(mx,my,210,250,200,64)){
				game.gameState = STATE.Menu;
				hud.setLevel(1);
				hud.setScore(0);
		
			}
		}

		
	}

	public void mouseReleased(MouseEvent e){
		
	}

	private boolean mouseOver(int mx, int my ,int x, int y ,int width , int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			}else return false;
		}else return false;
		
	}
	
	public void tick(){
		
		
	}
	
	public void render (Graphics g){
		
		if(game.gameState == STATE.Menu){
			Font fnt = new Font("arial",1,50);
			Font fnt2 = new Font("arial",1,30);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Menu", 250, 50);

			g.setFont(fnt2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Play", 280, 190);
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Help", 280, 290);
				
			g.drawRect(210, 350, 200, 64);
			g.drawString("Quit", 280, 390);
		}else if(game.gameState == STATE.Help){
			Font fnt = new Font("arial",1,50);
			Font fnt2 = new Font("arial",1,30);
			Font fnt3 = new Font("arial",1,20);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Help", 250, 50);

			g.setFont(fnt3);
			g.setColor(Color.WHITE);
			g.drawString("Gunakan tombol WASD untuk menggerakkan Player", 50,200);
			g.drawString("dan dapatkan Score sebesar - besarnya", 110,220);

			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 280, 390);
			
		}else if(game.gameState == STATE.End){
			Font fnt = new Font("arial",1,50);
			Font fnt2 = new Font("arial",1,30);
			Font fnt3 = new Font("arial",1,20);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Game Over", 180, 50);

			g.setFont(fnt3);
			g.setColor(Color.WHITE);
			g.drawString("Score anda : " +hud.getScore() , 175,200);

			g.setFont(fnt2);
			g.drawRect(210, 250, 200, 64);
			g.drawString("Menu", 270, 290);

			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Try Again", 245, 390);
			
		}
	}
}
