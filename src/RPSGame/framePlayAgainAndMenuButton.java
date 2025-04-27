package RPSGame;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class framePlayAgainAndMenuButton extends JFrame {

	JFrame pAFrame;
	private JButton btnplayAgain;
	private JPanel panel;
	private JLabel lblPlayAgain;
	private JLabel lblExit;
	private JLabel lblHome;
	JFrame menuFrame;
	private JLabel lblRestart;
	private JLabel lblBgImg;
	static classMusicCall i = new classMusicCall();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					framePlayAgainAndMenuButton window = new framePlayAgainAndMenuButton();
					window.pAFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public framePlayAgainAndMenuButton() {
		pAFrame = new JFrame();
		pAFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("imgNew/playerImg.png"));
		pAFrame.setBounds(100, 100, 749, 553);
		pAFrame.getContentPane().setLayout(null);
		pAFrame.setLocationRelativeTo(null); 
		pAFrame.setUndecorated(true);

		panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(0, 0, 749, 553);
		pAFrame.getContentPane().add(panel);
		panel.setLayout(null);

		lblPlayAgain = new JLabel("");
		lblPlayAgain.setBounds(263, 305, 233, 69);
		panel.add(lblPlayAgain);

		lblPlayAgain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameGame a = new frameGame();
				a.frameStart.setVisible(true);
				pAFrame.dispose();
			
			}
		});

		lblHome = new JLabel("");
		lblHome.setBounds(263, 368, 233, 69);
		panel.add(lblHome);

		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameHome a = new frameHome();
				a.frameHome.setVisible(true);
				menuLabelButton();
				pAFrame.dispose();
				i.stopMusic();
			}
		});

		lblExit = new JLabel("");
		lblExit.setBounds(263, 430, 233, 69);
		panel.add(lblExit);

		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameExit j = new frameExit();
				j.framePlayAgainExit();
				j.frame.setVisible(true);   	
				pAFrame.dispose();


			}
		});



		imageButtonLabels("imgNew/playAgain.png", lblPlayAgain, 209, 260, 234, 100);   
		imageButtonLabels("imgNew/Home.png", lblHome, 209, 260, 234, 100);
		imageButtonLabels("imgNew/exit.png", lblExit, 209, 359, 234, 100);

		lblBgImg = new JLabel("");
		lblBgImg.setBounds(0, 0, 749, 554);
		panel.add(lblBgImg);
		ImageIcon icon = new ImageIcon("imgNew/playAgainBg.png");
		Image image = icon.getImage().getScaledInstance(lblBgImg.getWidth(), lblBgImg.getHeight(), Image.SCALE_SMOOTH);
		lblBgImg.setIcon(new ImageIcon(image));

	}

	public void imageButtonLabels(String imagePath, JLabel label, int x, int y, int width, int height) {
		ImageIcon icon = new ImageIcon(imagePath);
		Image image = icon.getImage();
		Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		label.setIcon(resizedIcon);
	}

	public void menuLabelButton() {
		menuFrame = new JFrame();
		menuFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("imgNew/playerImg.png"));
		menuFrame.setBounds(100, 100, 749, 553);
		menuFrame.getContentPane().setLayout(null);
		menuFrame.setLocationRelativeTo(null); 
		menuFrame.setUndecorated(true);

		panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(0, 0, 749, 553);
		menuFrame.getContentPane().add(panel);
		panel.setLayout(null);

		lblRestart = new JLabel("");
		lblRestart.setBounds(263, 305, 233, 69);
		panel.add(lblRestart);

		lblRestart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameGame a = new frameGame();
				a.frameStart.setVisible(true);
				menuFrame.dispose();

			}
		});

		lblHome = new JLabel("");
		lblHome.setBounds(263, 368, 233, 69);
		panel.add(lblHome);

		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuFrame.dispose();
				frameHome a = new frameHome();
				a.frameHome.setVisible(true);
				menuFrame.dispose();
			}
		});

		lblExit = new JLabel("");
		lblExit.setBounds(263, 430, 233, 69);
		panel.add(lblExit);

		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameExit j = new frameExit();
				j.frame.setVisible(true);
				j.frameRestartExit();
				menuFrame.dispose();
			}
		});

		imageButtonLabels("imgNew/restart.png", lblRestart, 209, 260, 234, 100);   
		imageButtonLabels("imgNew/Home.png", lblHome, 209, 260, 234, 100);
		imageButtonLabels("imgNew/exit.png", lblExit, 209, 359, 234, 100);

		lblBgImg = new JLabel("");
		lblBgImg.setBounds(0, 0, 749, 554);
		panel.add(lblBgImg);
		ImageIcon icon = new ImageIcon("imgNew/playAgainBg.png");
		Image image = icon.getImage().getScaledInstance(lblBgImg.getWidth(), lblBgImg.getHeight(), Image.SCALE_SMOOTH);
		lblBgImg.setIcon(new ImageIcon(image));

	}

}

