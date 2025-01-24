package fodus.java.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI {
	JFrame window = new JFrame();
	String windowTitle = "Fodus";
	String introText = "Tenez bon !! Car qui sait ce qui se trouve au-dela.";
	Timer timer;
	int textIndex = 0;
	
	public MainUI() {
		window.setTitle(windowTitle);
		window.setSize(800, 600);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	public void createMenu() {
		JLabel title = new JLabel("Fodus");
		JLabel introLabel = new JLabel();
		
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				playIntro(introLabel);
			}
		});
		
		JButton howToPlayButton = new JButton("How to play");
		howToPlayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("Salut le tuto !");
			}
		});
		
		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JPanel container = new JPanel();
		
		container.add(startButton);
		container.add(howToPlayButton);
		container.add(quitButton);
		container.add(title);
		container.add(introLabel);
		
		window.setContentPane(container);
		window.revalidate();
        window.repaint();
	}
	
	public void playIntro(JLabel textLabel) {
		this.textIndex = 0;
		this.timer = new Timer(25, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textIndex < introText.length()) {
					textLabel.setText(introText.substring(0, textIndex + 1));
					textIndex++;
				}
				else {
					timer.stop();
				}
			}
		});
		timer.start();
	}
}
