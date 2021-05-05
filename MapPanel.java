import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class MapPanel extends JPanel{
	private static Tile[][] gameMap;
	private int ROW_DIMENSION, COL_DIMENSION;
	//private static LinkedList

	public MapPanel() { //for creating default blank map
		ROW_DIMENSION=30;
		COL_DIMENSION = 30;
		this.setLayout(new GridLayout(ROW_DIMENSION,COL_DIMENSION));
		this.setBackground(Color.DARK_GRAY);
		gameMap = new Tile[ROW_DIMENSION][COL_DIMENSION];
		for(int r=0;r<gameMap.length;r++) {
		for(int c=0;c<gameMap[r].length;c++) {
			gameMap[r][c] = new Tile();
			//gameMap[r][c].setActionCommand(r+","+c);
			//gameMap[r][c].addActionListener(new TileListener());
			gameMap[r][c].addMouseListener(new TileMouseAdapter());
			this.add(gameMap[r][c]);
			}
		}
		// JButton btn = new JButton("PRESS TO SAVE MAP:");
		// btn.addActionListener(new ButtonListener());
		// this.add(btn);
	}
	// public MapPanel(Tile[][] gMap) {
	// 	gameMap = gMap;
	// 	ROW_DIMENSION = gameMap.length;
	// 	COL_DIMENSION = gameMap[0].length;
	// 	this.setLayout(new GridLayout(ROW_DIMENSION,COL_DIMENSION));
	// 	this.setBackground(Color.DARK_GRAY);
	// 	for(int r=0;r<gameMap.length;r++) {
	// 	for(int c=0;c<gameMap[r].length;c++) {
	// 		//gameMap[r][c].setActionCommand(r+","+c);
	// 		//gameMap[r][c].addActionListener(new TileListener());
	// 		gameMap[r][c].addMouseListener(new TileMouseAdapter());
	// 		this.add(gameMap[r][c]);
	// 		}
	// 	}
	//
	//
	//}
	// public void repaintMap(Tile[][] m) {
	// 	this = new MapPanel(m);
	// }
	// private class TileListener implements ActionListener {
	// 	public void actionPerformed(ActionEvent e) {
	// 		// String[] location = e.getActionCommand().split(",");
	// 		// int row = Integer.parseInt(location[0]);
	// 		// int col = Integer.parseInt(location[1]);
	// 		Tile t = (Tile)e.getSource();
	// 		t.createWall();
	// 	}
	// }
	// private class ButtonListener implements ActionListener{
	// 	public void actionPerformed(ActionEvent e) {
			
	// 		repaintMap(MapUtilities.generateMapFromSave("myMap.txt"));

	// 	}
	// }
	private class TileMouseAdapter extends MouseAdapter {
		public void mouseEntered(MouseEvent e) { //mouseEntered allows you to quickly drag cursor to draw map
			Tile t = (Tile)e.getSource();
			if(e.getButton()==MouseEvent.BUTTON1) { //mouse left click
				t.createWall();
			}
			else if(e.getButton()==MouseEvent.BUTTON3) { //mouse right click
				t.removeWall();
			}
		}
		public void mousePressed(MouseEvent e) { //mousePressed allows precise map creation
			Tile t = (Tile)e.getSource();
			if(e.getButton()==MouseEvent.BUTTON1) { //mouse left click
				t.createWall();
			}
			else if(e.getButton()==MouseEvent.BUTTON3) { //mouse right click
				t.removeWall();
			}
		}
	}
}