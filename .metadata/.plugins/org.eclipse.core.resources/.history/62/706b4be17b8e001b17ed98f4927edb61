package NAI01;

import java.awt.*;

import javax.swing.*;

public class Window {
	
	JFrame Window;
	JPanel panel;
	
	JButton button;
	JButton but;
	
	public Window() {
		Window = new JFrame("Start");
		Window.setLayout(new BorderLayout());
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		button = new JButton("Ok");
		but = new JButton("Oki");
		
		SwingUtilities.invokeLater(()->{
			button.addActionListener(e->{
				System.out.println("ok");
			});
			
			but.addActionListener(e->{
				System.out.println("oki");
			});
		});
		
		
		
		panel.add(button);
		panel.add(but);
		Window.add(panel,BorderLayout.CENTER);
		Window.setSize(380,380);
		Window.setLocationByPlatform(true);
		
		Window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Window.setVisible(true);
	}
	
}
