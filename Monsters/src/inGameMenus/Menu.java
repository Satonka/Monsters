package inGameMenus;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.sam.monsters.managers.MenuManager;

public abstract class Menu {
	
	public TextButton button;
	public MenuManager menuManager;
	public Stage stage;
	public SpriteBatch batch;
	public Skin skin;
	public ChangeListener change;
	public ChangeEvent event;
	public Actor actor;
	public Window window;
	public Table table;
	public boolean drawUI;

	public abstract void init();
	public abstract void update();
	public abstract void draw();
	public abstract void clear();
}
