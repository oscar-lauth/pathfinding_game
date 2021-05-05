import javax.swing.*;
import java.awt.Color;
import java.awt.*;

public class Tile extends JLabel{
	private boolean visited; //has the tile been visited
	private boolean wall; //is the tile a wall

	public Tile() { //creates blank Tile
		super.setBackground(Color.white);
		super.setOpaque(true);
		super.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		visited = false;
		wall = false;
	}
	public Tile(String structure) {
		super.setOpaque(true);
		super.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		visited = false;
		if(structure.equals("WALL")) {
			super.setBackground(Color.black);
			wall = true;
		}
		else if(structure.equals("PORTAL")) {
			super.setBackground(Color.green);
			wall = false;
		}
		// else {
		// 	this();
		// }
	}
	public void createWall() {
		super.setBackground(Color.black);
		wall = true;
	}
	public void removeWall() {
		super.setBackground(Color.white);
		wall = false;
	}
	public boolean isVisited() {
		return visited;
	}
	public boolean isWall() {
		return wall;
	}
	public boolean isPortal() {
		return false;
	}
}