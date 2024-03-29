package com.sam.monsters.managers;

import inGameMenus.AttackMenu;
import inGameMenus.BagMenu;
import inGameMenus.MainMenu;
import inGameMenus.Menu;
import inGameMenus.PartyMenu;

public class MenuManager {
	
	public Menu menu;
	
	public static final int MAIN = 0;
	public static final int ATTACK = 1;
	public static final int BAG = 2;
	public static final int PARTY = 3;


	public MenuManager(){
		setMenu(MAIN);
		menu.init();
	}
	
	public void setMenu(int men){
		if(men == MAIN){
			menu = new MainMenu(this);
			menu.init();
			menu.update();
		}
		if(men == ATTACK){
			menu = new AttackMenu(this);
			menu.init();
			menu.update();
		}
		if(men == BAG){
			menu = new BagMenu(this);
			menu.init();
			menu.update();
		}
		if(men == PARTY){
			menu = new PartyMenu(this);
			menu.init();
			menu.update();
		}
	}
	
	public Menu getMenu(){
		return menu;
	}
}
