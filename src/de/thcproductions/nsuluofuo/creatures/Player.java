package de.thcproductions.nsuluofuo.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import de.thcproductions.nsuluofuo.entities.Entity;
import de.thcproductions.nsuluofuo.graphics.Animation;
import de.thcproductions.nsuluofuo.graphics.Assets;
import de.thcproductions.nsuluofuo.inventory.Dialog;
import de.thcproductions.nsuluofuo.inventory.Inventory;
import de.thcproductions.nsuluofuo.inventory.PlayerInfo;
import de.thcproductions.nsuluofuo.inventory.Trivel;
import de.thcproductions.nsuluofuo.item.Item;
import de.thcproductions.nsuluofuo.main.Handler;

public class Player extends Creature {

	private Animation animDown, animUp, animLeft, animRight;
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	private BufferedImage currentPosition = Assets.playerDown;
	private int money = 2000;
	private int maxHealth;
	private int exp;
	private int level;
	private int maxExp;
	private Item currentWeapon;
	private String name = "Kirito";
	private Inventory inventory;
	private PlayerInfo info;
	private Trivel trivel;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		info = new PlayerInfo(handler);
		inventory = new Inventory(handler);
		trivel = new Trivel(handler);

		currentWeapon = new Item(null, null, 0, 0, 5, 0);
		bounds.x = 8;
		bounds.y = 16;
		bounds.width = 16;
		bounds.height = 16;

		animDown = new Animation(animDown.DEFAULT_SPEED, Assets.player_down);
		animUp = new Animation(animUp.DEFAULT_SPEED, Assets.player_up);
		animLeft = new Animation(animLeft.DEFAULT_SPEED, Assets.player_left);
		animRight = new Animation(animRight.DEFAULT_SPEED, Assets.player_right);

		setMaxExp(100);
		setExp(1);
		setMaxHealth(6);
		setHealth(getMaxHealth());
		setSpeed(DEFAULT_SPEED);
		setStrength(getCurrentWeapon().getAttack());
		setLevel(1);

	}

	@Override
	public void update() {

		animDown.update();
		animUp.update();
		animLeft.update();
		animRight.update();
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		checkAttack();
		checkEntity();

		info.update();
		inventory.update();
		trivel.update();

	}

	public void checkAttack() {

		if (inventory.isActive() || info.isActive() || trivel.isActive() || Dialog.isActive()) {
			return;
		}

		Rectangle attackRectangle = new Rectangle((int) (getX() - 20), (int) (getY() - 20), (int) (getWidth()) + 40,
				(int) (getHeight() + 40));

		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_A)) {

			System.out.println("A");
			for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
				if (e.equals(this)) {
					continue;
				}
				if (e.getCollisionBounds(0, 0).intersects(attackRectangle)) {
					e.hurt(getStrength());

					handler.getKeyManager().update();
					return;
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException i) {
					i.printStackTrace();
				}
			}

		}

	}

	public void checkEntity() {

		if (inventory.isActive() || info.isActive() || trivel.isActive() || Dialog.isActive()) {
			return;
		}

		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if (attackTimer < attackCooldown) {
			return;
		}
		Rectangle rect = new Rectangle((int) (getX()), (int) (getY()), (int) (getWidth()), (int) (getHeight()));

		attackTimer = 0;

		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this)) {
				continue;
			}
			if (e.getCollisionBounds(0, 0).intersects(rect)) {
				setHealth(getHealth() - e.getStrength());
				System.out.println("AAAAAAAA");
				return;
			}

		}

	}

	private void getInput() {

		setxMove(0);
		setyMove(0);

		if (inventory.isActive() || info.isActive() || trivel.isActive()  || Dialog.isActive()) {
			return;
		}

		if (handler.getKeyManager().isUp()) {
			setyMove(getyMove() - getSpeed());
		}
		if (handler.getKeyManager().isDown()) {
			setyMove(getyMove() + getSpeed());
		}
		if (handler.getKeyManager().isLeft()) {
			setxMove(getxMove() - getSpeed());
		}
		if (handler.getKeyManager().isRight()) {
			setxMove(getxMove() + getSpeed());
		}

		if (handler.getKeyManager().isSpace()) {
			setSpeed(DEFAULT_SPEED * 2);
			animDown.setSpeed(animDown.DEFAULT_SPEED / 2);
			animUp.setSpeed(animUp.DEFAULT_SPEED / 2);
			animLeft.setSpeed(animLeft.DEFAULT_SPEED / 2);
			animRight.setSpeed(animRight.DEFAULT_SPEED / 2);
		} else {
			setSpeed(DEFAULT_SPEED);
			animDown.setSpeed(animDown.DEFAULT_SPEED);
			animUp.setSpeed(animUp.DEFAULT_SPEED);
			animLeft.setSpeed(animLeft.DEFAULT_SPEED);
			animRight.setSpeed(animRight.DEFAULT_SPEED);
		}

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (getX() - handler.getGameCamera().getxOffset()),
				(int) (getY() - handler.getGameCamera().getyOffset()), getWidth(), getHeight(), null);

		inventory.render(g);
		trivel.render(g);
		info.render(g);

	}

	private BufferedImage getCurrentAnimationFrame() {
		if (getxMove() < 0) {
			currentPosition = animLeft.getCurrentFrame();
		} else if (getxMove() > 0) {
			currentPosition = animRight.getCurrentFrame();
		} else if (getyMove() < 0) {
			currentPosition = animUp.getCurrentFrame();
		} else if (getyMove() > 0) {
			currentPosition = animDown.getCurrentFrame();
		}

		else if (currentPosition == null) {

			currentPosition = Assets.playerDown;
		}

		return currentPosition;

	}

	public void postRender(Graphics g) {
		info.render(g);
		inventory.render(g);
		trivel.render(g);

	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerInfo getInfo() {
		return info;
	}

	public void setInfo(PlayerInfo info) {
		this.info = info;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getExp() {
		return exp;
	}

	public int getMaxExp() {
		return maxExp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void setMaxExp(int maxExp) {
		this.maxExp = maxExp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public BufferedImage getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(BufferedImage currentPosition) {
		this.currentPosition = currentPosition;
	}

	public Animation getAnimDown() {
		return animDown;
	}

	public Animation getAnimUp() {
		return animUp;
	}

	public Animation getAnimLeft() {
		return animLeft;
	}

	public Animation getAnimRight() {
		return animRight;
	}

	public void setAnimDown(Animation animDown) {
		this.animDown = animDown;
	}

	public void setAnimUp(Animation animUp) {
		this.animUp = animUp;
	}

	public void setAnimLeft(Animation animLeft) {
		this.animLeft = animLeft;
	}

	public void setAnimRight(Animation animRight) {
		this.animRight = animRight;
	}

	public Item getCurrentWeapon() {
		return currentWeapon;
	}

	public void setCurrentWeapon(Item currentWeapon) {
		this.currentWeapon = currentWeapon;
	}

	public Trivel getTrivel() {
		return trivel;
	}

	public void setTrivel(Trivel trivel) {
		this.trivel = trivel;
	}

}
