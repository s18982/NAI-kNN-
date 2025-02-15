package NAI01;

import java.awt.*;
import javax.swing.*;

public class ResultWindow {
	JFrame Window;
	JPanel panel;
	JLabel lab1;
	JLabel lab2;
	
	public ResultWindow(String res,String skut) {
		Window = new JFrame("Wynik");
		Window.setLayout(new BorderLayout());
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		lab1 = new JLabel("Rezultat: "+res);
		lab2 = new JLabel("Skutecznosc: "+skut);
		
		panel.add(lab1,BorderLayout.WEST);
		panel.add(lab2,BorderLayout.EAST);
		Window.add(panel);
		Window.setSize(260,180);
		Window.setLocationByPlatform(true);
		
		Window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Window.setVisible(true);
	}
}
