package de.thcproductions.nsuluofuo.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import de.thcproductions.nsuluofuo.graphics.Assets;
import de.thcproductions.nsuluofuo.graphics.Text;
import de.thcproductions.nsuluofuo.item.Item;
import de.thcproductions.nsuluofuo.main.Handler;

public class Inventory {

	private Handler handler;
	private boolean itemScreen;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	private Date currentDate = new Date();
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	private String formattedDate = sdf.format(currentDate);
	private int invListCenterY = 252;
	private int invListSpacing = 40;
	private int invImageX = 531, invImageY = 208;
	private int invImageWidth = 64, invImageHeight = 64;
	private int selectedItem = 0;
	private Color color;
	private Item item;
	private Color color2;
	private Item wood;
	private Item stone;
	private Item sword1;
	private Item sword2;
	private Item trivel;

	public Inventory(Handler handler) {
		this.handler = handler;
		
		inventoryItems = new ArrayList<Item>();
		inventoryItems.add(trivel);
		inventoryItems.add(wood);
		inventoryItems.add(sword2);
		inventoryItems.add(stone);
		inventoryItems.add(sword1);
		
		color = new Color(255, 255, 255, 200);
		color2 = new Color(192, 192, 192, 200);
	}

	public void update() {
		if (!active) {
			return;
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
			active = !active;
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT)) {
			active = !active;
			handler.getWorld().getEntityManager().getPlayer().getInfo().setActive(true);
		}
	}

	public void render(Graphics g) {
		if (!active) {
			return;
		}
		
		

		g.setColor(color);
		g.fillRoundRect(20, 20, handler.getGame().getWidth() - 40, handler.getGame().getHeight() - 40, 40, 40);
		Text.drawString(g, "Inventory", 320, 240, true, Color.GREEN, Assets.smallText);
		
		g.setColor(Color.BLACK);
		g.fillRect(304, 466, 8, 8);
		
		g.fillRect(316, 466, 8, 8);
		
		g.fillRect(328, 466, 8, 8);
		
		g.setColor(Color.WHITE);
		g.fillRect(305, 467, 6, 6);
		g.setColor(Color.WHITE);
		g.fillRect(317, 467, 6, 6);
		g.setColor(Color.BLUE);
		g.fillRect(329, 467, 6, 6);
		
	}

	public void addItem(Item item) {
//		for (Item i : inventoryItems) {
//			if (i.getId() == item.getId()) {
//				i.setCount(i.getCount() + item.getCount());
//				return;
//			}
//		}
		inventoryItems.add(item);
	}

	public Handler getHandler() {
		return handler;
	}

	public boolean isActive() {
		return active;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isItemScreen() {
		return itemScreen;
	}

	public void setItemScreen(boolean itemScreen) {
		this.itemScreen = itemScreen;
	}

	public ArrayList<Item> getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(ArrayList<Item> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	

}
