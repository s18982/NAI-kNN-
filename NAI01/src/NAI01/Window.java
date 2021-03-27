package NAI01;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class Window{
	
	JFrame Window;
	JPanel panel;
	JPanel panel1;
	JPanel panel2;
	
	JButton butWyj;
	JButton but;
	
	JTextPane tp1;
	JLabel lab1;
	JTextPane tp2;
	JLabel lab2;
	JTextPane tp3;
	JLabel lab3;
	JTextPane tp4;
	JLabel lab4;
	
	double d1;
	double d2;
	double d3;
	double d4;
	
	
	public Window(String odp, String skut) {
		Window = new JFrame("Start");
		Window.setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		
		butWyj = new JButton("Wyjscie");
		but = new JButton("Sprawdz");
		
		lab1 = new JLabel("dlugosc liscia: ");
		tp1 = new JTextPane();
		lab2 = new JLabel("szerokosc liscia: ");
		tp2 = new JTextPane();
		lab3 = new JLabel("dlugosc platka: ");
		tp3 = new JTextPane();
		lab4 = new JLabel("szerokosc platka: ");
		tp4 = new JTextPane();	
			
				
		SwingUtilities.invokeLater(()->{
			butWyj.addActionListener(e->{
				Window.dispose();
				Window.setVisible(false);
			});
			
		});
		
		
		
		panel.add(but,BorderLayout.WEST);
		panel.add(butWyj,BorderLayout.EAST);
		
		panel1.add(lab1,BorderLayout.AFTER_LAST_LINE);
		panel1.add(tp1,BorderLayout.AFTER_LAST_LINE);
		panel1.add(lab2,BorderLayout.AFTER_LAST_LINE);
		panel1.add(tp2,BorderLayout.AFTER_LAST_LINE);
		panel1.add(lab3,BorderLayout.AFTER_LAST_LINE);
		panel1.add(tp3,BorderLayout.AFTER_LAST_LINE);
		panel1.add(lab4,BorderLayout.AFTER_LAST_LINE);
		panel1.add(tp4,BorderLayout.AFTER_LAST_LINE);

		
		Window.add(panel,BorderLayout.SOUTH);
		Window.add(panel1,BorderLayout.NORTH);
		Window.add(panel2,BorderLayout.CENTER);
		Window.setSize(1080,180);
		Window.setLocationByPlatform(true);
		
		Window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Window.setVisible(true);
	}
	
	
}
