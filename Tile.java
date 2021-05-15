import javax.swing.*;
import java.awt.Color;
import java.awt.*;

public class Tile extends JLabel{
	private boolean visited; //has the tile been visited
	private boolean wall; //is the tile a wall
	private int row;
	private int col;
	private Tile parent;

	public Tile(int r,int c) { //creates blank Tile
		row=r;
		col=c;
		super.setBackground(Color.white);
		super.setOpaque(true);
		super.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		visited = false;
		wall = false;
	}
	public Tile(int r, int c,String structure) {
		row=r;
		col=c;
		visited = false;
		super.setOpaque(true);
		//super.setBorder(BorderFactory.createLineBorder(Color.CYAN));
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
	public void setVisited() {
		visited = true;
	}
	public boolean isWall() {
		return wall;
	}
	public boolean isPortal() {
		return false;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public void setParentTile(Tile p) {
		parent = p;
	}
	public Tile getParentTile() {
		return parent;
	}
}