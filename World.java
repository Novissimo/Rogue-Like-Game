package rltut;

import java.awt.Color;

import java.util.ArrayList;

import java.util.List;

// import com.sun.tools.javac.util.List;

import asciiPanel.AsciiPanel;

public class World {
	private Tile[][] tiles;
	private int width;
	public int width() { return width; }
	
	private int height;
	public int height() { return height; }
	
	
	private List<Creature> creatures;
	public World(Tile[][] tiles) {
		this.tiles = tiles;
		this.width = tiles.length;
		this.height = tiles[0].length;
		this.creatures = new ArrayList<Creature>();
	}
	
	public Creature creature(int x, int y) {
		for (Creature c : creatures) {
			if (c.x == x && c.y == y)
				return c;
		}
		return null;
	}
	
	public Tile tile(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y>= height)
			return Tile.BOUNDS;
		else
			return tiles[x][y];
		
	}
	
	public char glyph(int x, int y) {
		return tile(x, y).glyph();
	}
	
	public Color color(int x, int y) {
		return tile(x, y).color();
	}
	
	public void dig(int x, int y) {
		if (tile(x,y).isDiggable())
				tiles[x][y] = Tile.FLOOR;
	}
	
	public void addAtEmptyLocation(Creature creature){
		int x;
		int y;
		
		do {
			x = (int)(Math.random() * width);
			y = (int)(Math.random() * height);
		}
		while (!tile(x,y).isGround() || creature(x,y) != null);
		
		creature.x=x;
		creature.y=y;
		creatures.add(creature);
		
		}

	
	public void update() {
		List<Creature> toUpdate = new ArrayList<Creature>(creatures);
		for (Creature creature : toUpdate) {
			creature.update();
		}
	}
	
	public void remove(Creature other) {
		creatures.remove(other);
	}
	
		
	privateCreatureeature> creatures;
	
	
	private void displayTiles(AsciiPanel terminal, int left, int top) {
		for (int x = 0; x < screenWidth; x++) {
			for (int y = 0; y  < screenHeight; y++) {
				int wx = x + left;
				int wy = y + top;
				
				Creature creature = world.creature(wx, wy);
				if (creature != null)
					terminal.write(creature.glyph(), creature.x - left, creature.y - top, creature.color());
				else
					terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
				
			}
		}
	}
	
}


