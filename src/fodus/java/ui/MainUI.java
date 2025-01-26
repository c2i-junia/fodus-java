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
		JPanel mainMenuPanel = new JPanel();
		
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				playIntro(introLabel);
				createMainUI();
			}
		});
		
		JButton howToPlayButton = new JButton("How to play");
		howToPlayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("In progress");
			}
		});
		
		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mainMenuPanel.add(startButton);
		mainMenuPanel.add(howToPlayButton);
		mainMenuPanel.add(quitButton);
		mainMenuPanel.add(title);
		mainMenuPanel.add(introLabel);
		
		window.setContentPane(mainMenuPanel);
		window.revalidate();
        window.repaint();
	}
	
	public void createMainUI() {
		JPanel mainUIPanel = new JPanel();
		JLabel chooseLabel = new JLabel("Who are you ?");
		
		JButton knightButton = new JButton("Knight");
		knightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("Knight");
			}
		});
		
		JButton thiefButton = new JButton("Thief");
		thiefButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("Thief");
			}
		});
		
		JButton mageButton = new JButton("Mage");
		mageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("Mage");
			}
		});
		
		JButton priestButton = new JButton("Priest");
		priestButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("Priest");
			}
		});
		
		mainUIPanel.add(chooseLabel);
		mainUIPanel.add(knightButton);
		mainUIPanel.add(thiefButton);
		mainUIPanel.add(mageButton);
		mainUIPanel.add(priestButton);
		
		window.setContentPane(mainUIPanel);
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
