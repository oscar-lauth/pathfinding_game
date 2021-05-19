
import java.util.*;
public class Dijkstra {
	private Tile[][] map;
	private Tile start;
	private Tile goal;
	private Stack<Tile> path;
	private boolean found;
	//private double pathLength;
	public Dijkstra(Tile[][] m, Tile s, Tile g) {
		map=m;
		start=s;
		goal=g;
		path=new Stack<Tile>();
		//pathLength=0;
	}
	public void runDijkstra() {
		start.setDistance(0);
		//HashSet<Tile> closedTiles = new HashSet<Tile>():
		PriorityQueue<Tile> openTiles = new PriorityQueue<Tile>();
		for(int r=0;r<map.length;r++) {
			for(int c=0;c<map[r].length;c++) {
				Tile current = map[r][c];
				if(current!=start) {
					current.setDistance(Integer.MAX_VALUE);
					current.setParentTile(null);
				}
				openTiles.add(current);
			}
		}
		while(openTiles.size()!=0) {
			Tile current = openTiles.poll();
			if(current==goal) {
				found = true;
				return;
			}
			ArrayList<Tile> validNeighbors = getValidNeighbors(current);
			for(Tile n:validNeighbors) {
				n.setVisited();
				double tentativeDistance = current.getDistance() + getDistanceToNeighbor(current,n); //1 is temp make getDistanceBetweenTiles() to det if its 1 or sqrt(2)
				if(tentativeDistance<n.getDistance()) {
					openTiles.remove(n);
					n.setDistance(tentativeDistance);
					n.setParentTile(current);
					openTiles.add(n);
				}
			}

		}
	}
		private ArrayList<Tile> getValidNeighbors(Tile current) {
		int row=current.getRow();
		int col=current.getCol();
		ArrayList<Tile> validNeighbors = new ArrayList<Tile>();
		for(int r=row-1;r<=row+1;r++) {
			for(int c=col-1;c<=col+1;c++) {
				if(isValidIndex(r,c)&&!(map[r][c].isWall()))
					validNeighbors.add(map[r][c]);
			}
		}
		return validNeighbors;
	}
private boolean isValidIndex(int row,int col) {
	return (row>=0 && row<map.length)&&(col>=0 && col<map[row].length);
}
public Stack<Tile> constructPath() { //creates a Stack containing the shortest path of tiles and calculates the length of the path
		Tile current = goal;
		while(current!=null) {
			path.push(current);
			current = current.getParentTile();
			// if(parent!=null)
			// 	pathLength += getDistanceToNeighbor(current, parent);
			// current = parent;
		}
		return path;
	}
	public Stack<Tile> getPath() {
		return path;
	}
	public boolean getFound() {
		return found;
	}
	private double getDistanceToNeighbor(Tile current, Tile neighbor) {
		int sumOfCoords = current.getRow() + current.getCol() + neighbor.getRow() + neighbor.getCol();
		if(sumOfCoords % 2==0) {
			return 1.4142;
		}
		return 1;
		
	}
	// public double getPathLength() {
	// 	return pathLength;
	// }

}