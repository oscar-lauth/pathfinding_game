import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class MapPanel extends JPanel{
	private static Tile[][] gameMap;
	private int ROW_DIMENSION, COL_DIMENSION;
	private static CLinkedList<ImageIcon> robotSprite;
	private static int spriteIndex = 0;
	//private static LinkedList

	public MapPanel() { //for creating default blank map
		ROW_DIMENSION=30;
		COL_DIMENSION = 30;
		this.setFocusable(true);
		this.setLayout(new GridLayout(ROW_DIMENSION,COL_DIMENSION));
		this.setBackground(Color.DARK_GRAY);
		this.addKeyListener(new AlgoKeyAdapter());
		gameMap = new Tile[ROW_DIMENSION][COL_DIMENSION];
		for(int r=0;r<gameMap.length;r++) {
		for(int c=0;c<gameMap[r].length;c++) {
			gameMap[r][c] = new Tile(r,c);
			//gameMap[r][c].setActionCommand(r+","+c);
			//gameMap[r][c].addActionListener(new TileListener());
			gameMap[r][c].addMouseListener(new TileMouseAdapter());
			this.add(gameMap[r][c]);
			}
			
		}
		initSprite();
		gameMap[28][28].setIcon(robotSprite.get(spriteIndex));
		spriteIndex++;
		gameMap[2][2].setBackground(Color.yellow);
			gameMap[25][25].setBackground(Color.orange);
		// JButton btn = new JButton("PRESS TO SAVE MAP:");
		// btn.addActionListener(new ButtonListener());
		// this.add(btn);
	}
	public void initSprite() {
		robotSprite = new CLinkedList<ImageIcon>();
		for(int i=0;i<=7;i++) {
			String spritePath = "robot_sprite/robot_sprite_"+i+".png";
			robotSprite.add(new ImageIcon(spritePath));
		}
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
				gameMap[28][28].setIcon(robotSprite.get(spriteIndex));
				if(spriteIndex==7)
					spriteIndex=0;
				else spriteIndex++;
			}
			else if(e.getButton()==MouseEvent.BUTTON3) { //mouse right click
				t.removeWall();
				gameMap[28][28].setIcon(robotSprite.get(spriteIndex));
				if(spriteIndex==7)
					spriteIndex=0;
				else spriteIndex++;
			}
		}
		public void mousePressed(MouseEvent e) { //mousePressed allows precise map creation
			Tile t = (Tile)e.getSource();
			if(e.getButton()==MouseEvent.BUTTON1) { //mouse left click
				t.createWall();
				gameMap[28][28].setIcon(robotSprite.get(spriteIndex));
				if(spriteIndex==7)
					spriteIndex=0;
				else spriteIndex++;
			}
			else if(e.getButton()==MouseEvent.BUTTON3) { //mouse right click
				t.removeWall();
				gameMap[28][28].setIcon(robotSprite.get(spriteIndex));
				if(spriteIndex==7)
					spriteIndex=0;
				else spriteIndex++;
			}
		}
	}
		private class AlgoKeyAdapter extends KeyAdapter {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_A) {
					try {
						
					runBFS();
				}
				catch(InterruptedException ie) {
					System.out.println("Error: InterruptedException");				}
				}
			}
		}
	
		private void runBFS() throws InterruptedException {
			BFS bfs = new BFS(gameMap, gameMap[2][2], gameMap[25][25]);
			bfs.BFSAlgo();
			Stack<Tile> path=bfs.constructPath();
			while(!path.isEmpty()) {
				Tile current = path.pop();
				current.setBackground(Color.red);
				//Thread.sleep(500);
			}
		}
	
}