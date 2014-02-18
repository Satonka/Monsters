package inGameMenus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.sam.monsters.managers.MenuManager;

public class MainMenu extends Menu{

	
	
	public MainMenu(MenuManager mm){
		menuManager = mm;
	}
	
	@Override
	public void init() {
		batch = new SpriteBatch();
        stage = new Stage();

        skin = new Skin(Gdx.files.internal("uiskin.json"));

        table = new Table();
        
        window = new Window("MAIN", skin);
        window.add(table);
        window.setFillParent(true);
        
        
        stage.addActor(window);
        
        button =  new TextButton("ATTACK", skin);
		table.row();
		table.add(button);
		
		TextButton button2 = new TextButton("BAG", skin);
		table.add(button2);
		
		TextButton button3 = new TextButton("PARTY", skin);
		table.row();
		table.add(button3);
		
		TextButton button4 = new TextButton("RUN", skin);
		table.add(button4);

		
		button.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                menuManager.setMenu(MenuManager.ATTACK);
                
            }
		});
		
		button2.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                menuManager.setMenu(MenuManager.BAG);
            }
		});
		
		button3.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                menuManager.setMenu(MenuManager.PARTY);
            }
		});
		
		button4.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
            	
            }
		});
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	

}
