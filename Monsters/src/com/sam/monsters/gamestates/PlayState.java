package com.sam.monsters.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.sam.monsters.managers.GameStateManager;
import com.sam.monsters.managers.MenuManager;

public class PlayState extends GameState{
	
	public MenuManager menuManager;
	public Stage stage;

	public PlayState(GameStateManager gsm) {
		super(gsm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		menuManager = new MenuManager();
		menuManager.getMenu().init();
		menuManager.getMenu().draw();
		Gdx.input.setInputProcessor(menuManager.getMenu().stage);
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
        Gdx.input.setInputProcessor(menuManager.getMenu().stage);
        menuManager.getMenu().draw();
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
