package de.thcproductions.nsuluofuo.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import de.thcproductions.nsuluofuo.creatures.Player;
import de.thcproductions.nsuluofuo.creatures.Player2;
import de.thcproductions.nsuluofuo.main.Handler;

public class EntityManager {

	private Handler handler;
	private Player player;
	private Player2 player2;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {
		public int compare(Entity a, Entity b) {
			if (a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
				return -1;
			}
			return 1;
		}
	};

	public EntityManager(Handler handler, Player player, Player2 player2) {
		this.handler = handler;
		this.player = player;
		this.player2 = player2;
		entities = new ArrayList<Entity>();
		addEntity(player);
		addEntity(player2);
		
	}

	public void update() {
		Iterator<Entity> it = entities.iterator();
		while (it.hasNext()) {
			Entity e = it.next();
			e.update();
			if (!e.isActive()) {
				it.remove();
			}
		}
		entities.sort(renderSorter);

	}

	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g);
		}
		player.postRender(g);

	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

	public Handler getHandler() {
		return handler;
	}

	public Player getPlayer() {
		return player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public Player2 getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player2 player2) {
		this.player2 = player2;
	}
	
	

}
