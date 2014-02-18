package com.sam.monsters.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.sam.monsters.managers.GameStateManager;


public class SplashState extends GameState{

	public SplashState(GameStateManager gsm) {
		super(gsm);
		// TODO Auto-generated constructor stub
	}
	
	public SpriteBatch batch;
	public Texture splash;
	public OrthographicCamera camera;
	public long timeStart;
	public long timeEnd;
	public long timeElapsed;
	public Sound theme;
	
	public BitmapFont font;
	public CharSequence[] str = {"B","I","S","M","U","T","H"};
	public CharSequence[] games = {"G","A","M","E","S"};
	public boolean[] stringAppear;
	public int stringCount = 0;
	int time = 0;

	@Override
	public void init() {
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		
		font = new BitmapFont(Gdx.files.internal("assets/towerruins.fnt"), false);
		font.setColor(0, 0, 0, 1);
		stringAppear = new boolean[7];
		for(int i = 0; i < stringAppear.length; i++)
		{
			stringAppear[i] = false;
		}		
		timeStart = TimeUtils.millis();
		
		theme = Gdx.audio.newSound(Gdx.files.internal("assets/Bismuth.mp3"));
		theme.play();
	}

	@Override
	public void update(float dt) {
		timeEnd = TimeUtils.millis();
		timeElapsed = timeEnd - timeStart;
		time++;
		if(time % 6 == 0 && stringCount < 7)
		{
			stringAppear[stringCount] = true;
			stringCount++;
		}
		
		
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
	    for(int i = 0; i < str.length; i++)
	    {
	    	if(stringAppear[i] && stringCount <= 7)
	    	{
	    		font.draw(batch, str[i], 10 + (i*45), 200);
	    		if(stringCount == 7)
	    		{
	    			for(int j = 0; j < games.length; j++)
	    			{
	    				font.draw(batch, games[j], 10+(j*45), 150);
	    			}
	    		}
	    	}
	    }
	    batch.end();
	    
//	    batch.begin();
//	    batch.draw(splash, 0, 0);	
//	    batch.end();
	}

	@Override
	public void handleInput() {

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
