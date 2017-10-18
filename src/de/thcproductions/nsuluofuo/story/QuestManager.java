package de.thcproductions.nsuluofuo.story;

import java.awt.Graphics;
import java.util.ArrayList;

import de.thcproductions.nsuluofuo.main.Handler;

public class QuestManager {
	
	private Quest trivel;
	private ArrayList<Quest> quests;
	private int currentQuest = 0;
		
	public QuestManager(Handler handler){
		quests = new ArrayList<Quest>();
		trivel = new Beginning(handler);
		quests.add(trivel);
	}
	
	public void update(){
		trivel.update();
		for(int current = currentQuest; current < quests.size(); current++){
			if(quests.get(current).isDone()){
				quests.get(current++).setActive(true);
				quests.get(current).update();
				
				setCurrentQuest(current);
			}
	
		}
	}
	
	public void render(Graphics g){
		
	}

	public int getCurrentQuest() {
		return currentQuest;
	}

	public void setCurrentQuest(int current) {
		this.currentQuest = current;
	}
	
	

}
