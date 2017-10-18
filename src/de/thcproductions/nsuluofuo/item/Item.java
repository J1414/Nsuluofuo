package de.thcproductions.nsuluofuo.item;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import de.thcproductions.nsuluofuo.graphics.Assets;
import de.thcproductions.nsuluofuo.main.Handler;

public class Item {

	public static Item[] items = new Item[256];
	

	public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;

	private Handler handler;
	private BufferedImage texture;
	private String name;
	private final int id;
	private Rectangle bounds;
	private int prize;
	private int strength;
	private int attack;
	private int x, y, count;
	protected boolean pickedUp = false;
	
	public Item(BufferedImage texture, String name, int prize, int strength, int attack, int id) {
		this.texture = texture;
		this.prize = prize;
		this.strength = strength;
		this.attack = attack;
		this.name = name;
		this.id = id;
		count = 1;
		bounds = new Rectangle(x, y, ITEMWIDTH, ITEMHEIGHT);

		items[id] = this;
	}

	public void update() {
		if (handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds) && getId() != 2) {
			setPickedUp(true);
			handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
		}else if((handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds) && getId() == 2)){
			setPickedUp(true);
			handler.getWorld().getEntityManager().getPlayer().setMoney(handler.getWorld().getEntityManager().getPlayer().getMoney() + 100);
		}
	}

	public void render(Graphics g) {
		if (handler == null)
			return;

		render(g, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));

	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
	}

	public Item createNew(int count) {
		Item i = new Item(texture, name, prize, strength, attack, id);
		i.setPickedUp(true);
		i.setCount(count);
		return i;
	}

	public Item createNew(int x, int y) {
		Item i = new Item(texture, name, prize, strength, attack, id);
		i.setPosition(x, y);
		return i;
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
	}

	public Handler getHandler() {
		return handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getCount() {
		return count;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isPickedUp() {
		return pickedUp;
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}

	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	

}
