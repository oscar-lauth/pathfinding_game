import java.util.*;
public class BFS { //test class for BFS algorithim
	private Stack<Tile> path;
	private boolean found;
	private Tile[][] map;
	private Tile start;
	private Tile goal;
	private Tile end;
	public BFS(Tile[][] m,Tile s, Tile g){path = new Stack<Tile>();
		found = false;
		map=m;
		start=s;
		goal=g;
		end = null;}
	public void BFSAlgo(){
		Queue<Tile> visitedTiles = new LinkedList<Tile>(); //Queue that uses LinkedList
		start.setVisited();
		start.setParentTile(null);
		visitedTiles.add(start); //enqueue start Tile
		while(!visitedTiles.isEmpty()) {
			Tile current = visitedTiles.remove(); //dequeue front Tile
			ArrayList<Tile> neighbors = getValidNeighbors(current);
			for(Tile n:neighbors) {
				n.setVisited();
				n.setParentTile(current);
				if(n==goal) {
					found=true;
					end=n;
					return;
				}
				visitedTiles.add(n);
			}

		}
	}
	private ArrayList<Tile> getValidNeighbors(Tile current) {
		int row=current.getRow();
		int col=current.getCol();
		ArrayList<Tile> validNeighbors = new ArrayList<Tile>();
		for(int r=row-1;r<=row+1;r++) {
			for(int c=col-1;c<=col+1;c++) {
				if(isValidIndex(r,c)&&!(map[r][c].isVisited()||map[r][c].isWall()))
					validNeighbors.add(map[r][c]);
			}
		}
		return validNeighbors;
	}
private boolean isValidIndex(int row,int col) {
	return (row>=0 && row<map.length)&&(col>=0 && col<map[row].length);
}
	public Stack<Tile> constructPath() {
		Tile current = end;
		while(current!=null) {
			path.push(current);
			current = current.getParentTile();
		}
		return path;
	}
	public Stack<Tile> getPath() {
		return path;
	}
	public boolean getFound() {
		return found;
	}

}