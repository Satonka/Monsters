package com.sam.monsters.managers;

import com.sam.monsters.gamestates.GameState;
import com.sam.monsters.gamestates.MenuState;
import com.sam.monsters.gamestates.PlayState;
import com.sam.monsters.gamestates.SplashState;

public class GameStateManager {
	
	private GameState gameState;
	
	public static final int MENU = 1;
	public static final int PLAY = 2;
	public static final int SPLASH = 0;
	
	public GameStateManager(){
		setState(MENU);
	}
	
	public void setState(int state){
		if(gameState != null) gameState.dispose();
		if(state == MENU) {
			gameState = new MenuState(this);
		}
		if(state == PLAY) {
			gameState = new PlayState(this);
		}
		if(state == SPLASH){
			gameState = new SplashState(this);
		}
	}
	
	public void update(float dt) {
		gameState.update(dt);
	}
	
	public void draw(){
		gameState.draw();
	}
}
