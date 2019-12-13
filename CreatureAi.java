package rltut;

public class CreatureAi {
	protected Creature creature;
	
	private CreatureAi ai;
	public void setCreatureAi(CreatureAi ai) { this.ai = ai; }
	
	public CreatureAi(Creature creature) {
		this.creature = creature;
		this.creature.setCreatureAi(this);
	}

	public void onEnter(int x, int y, Tile tile) {
	
	}
	
	public void onUpdate() {
	}

}