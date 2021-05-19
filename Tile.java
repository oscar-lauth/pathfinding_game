import javax.swing.*;
import java.awt.Color;
import java.awt.*;

@SuppressWarnings("serial")
public class Tile extends JLabel implements Comparable{
	private boolean visited; //has the tile been visited
	private boolean wall; //is the tile a wall
	private int row;
	private int col;
	private Tile parent;
	private double distance;

	public Tile(int r,int c) { //creates blank Tile
		row=r;
		col=c;
		super.setBackground(Color.white);
		super.setOpaque(true);
		//super.setBorder(BorderFactory.createLineBorder(Color.CYAN));
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
		super.setBackground(Color.blue);
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
	public void setDistance(double dist) {
		distance = dist;
	}
	public double getDistance() {
		return distance;
	}
	public int compareTo(Object o) {
		Tile that = (Tile)o;
		return Double.valueOf(this.distance).compareTo(Double.valueOf(that.distance));
	}
}