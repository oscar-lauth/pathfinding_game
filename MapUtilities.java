import java.io.*;
import java.util.Scanner;

public class MapUtilities {
	public static Tile[][] generateMapFromSave(String fileName) {
		Tile[][] generatedMap = null;
		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			String[] rawDimensions = fileScanner.nextLine().split(",");
			int numRows = Integer.parseInt(rawDimensions[0]);
			int numCols = Integer.parseInt(rawDimensions[1]);
			generatedMap = new Tile[numRows][numCols];
			int currentRow = 0;
			while(fileScanner.hasNextLine()) {
				String rawRow = fileScanner.nextLine();
				for(int c=0;c<numCols;c++) {
					char tileSymbol = rawRow.charAt(c);
					if(tileSymbol=='0') { //blank tile
						generatedMap[currentRow][c] = new Tile(currentRow,c);
					}
					else if(tileSymbol=='1') { //wall tile
						generatedMap[currentRow][c] = new Tile(currentRow,c,"WALL");
					}
					else if(tileSymbol=='p') { //portal tile
						generatedMap[currentRow][c] = new Tile(currentRow,c,"PORTAL");
					}
				}
				currentRow++;

			}
			fileScanner.close();
		}
		catch(IOException e) {
			System.out.println("Error: IOException");
		}
		return generatedMap;
	}
	public static void saveMap(String fileName, Tile[][] mapToSave) {
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println(mapToSave.length+","+mapToSave[0].length);
			for(Tile[] tileRow: mapToSave) {
				String rawRow = "";
				for(Tile t: tileRow) {
					if(t.isWall()) {
						rawRow+='1';
					}
					else if(t.isPortal()) {
						rawRow+='p';
					}
					else {
						rawRow+='0';
					}
				}
				printWriter.println(rawRow);
			}
			printWriter.close();
		}
		catch(IOException e) {
			System.out.println("Error: IOException");
		}
	}
}