package com.sam.monsters.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.audio.Sound;
import com.sam.monsters.managers.GameStateManager;

public class SplashState extends GameState{

	public SplashState(GameStateManager gsm) {
		super(gsm);
		// TODO Auto-generated constructor stub
	}
	
	public SpriteBatch batch;
	public Texture splash;
	public OrthographicCamera camera;
	//public TimeUtils time;
	public long timeStart;
	public long timeEnd;
	public long timeElapsed;
	public Sound theme;

	@Override
	public void init() {
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		
		splash = new Texture(Gdx.files.internal("BismuthGames.png"));
		
		timeStart = System.currentTimeMillis();
		
		theme = Gdx.audio.newSound(Gdx.files.internal("assets/Bismuth.mp3"));
		theme.play();

	}

	@Override
	public void update(float dt) {
		timeEnd = System.currentTimeMillis();
		timeElapsed = timeEnd - timeStart;
		if(Gdx.input.isTouched() || timeElapsed > 2500){
			theme.stop();
			gsm.setState(GameStateManager.MENU);
		}
	}

	@Override
	public void draw() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
	    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	    
	    camera.update();
	    batch.setProjectionMatrix(camera.combined);
	    
	    batch.begin();
	    batch.draw(splash, 0, 0);	
	    batch.end();
	}

	@Override
	public void handleInput() {

	}

	@Override
	public void dispose() {
	//	theme.dispose();
	}

}
