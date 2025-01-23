package fodus.java.ui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainUI {
	JFrame window = new JFrame();
	
	public MainUI() {
		window.setTitle("Fodus");
		window.setSize(800, 600);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	public void createMenu() {
		JButton startButton = new JButton("Start");
		JPanel container = new JPanel();
		startButton.setBounds(130,100,100, 40);
		window.setContentPane(container);
		window.add(startButton);
	}
}
