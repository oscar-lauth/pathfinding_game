import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TileDriver {
	public static void main(String[]args) {
		JFrame frame = new JFrame();
	MapPanel map = new MapPanel();
	frame.add(map);
	frame.setSize(1000,1000);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
	}
}