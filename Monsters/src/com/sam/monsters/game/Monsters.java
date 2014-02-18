package com.sam.monsters.game;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.sam.monsters.managers.GameStateManager;

public class Monsters implements ApplicationListener {

	
public GameStateManager gsm;



public void create() {
	
	gsm = new GameStateManager();
	
}

public void resize(int width, int height) {
	// TODO Auto-generated method stub
	
}

@Override
public void render() {
	
	gsm.update(Gdx.graphics.getDeltaTime());
	gsm.draw();
}

@Override
public void pause() {
	// TODO Auto-generated method stub
	
}

@Override
public void resume() {
	// TODO Auto-generated method stub
	
}

@Override
public void dispose() {
	// TODO Auto-generated method stub
	
}
}
