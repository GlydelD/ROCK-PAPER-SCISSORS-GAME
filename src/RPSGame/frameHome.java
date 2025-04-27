package RPSGame;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class frameHome extends JFrame {

	JFrame frameHome;
	private JLabel lblStart, lblHelp, lblExit;
	private JPanel panelBg;
	private JLabel lblBgImg;
	static JLabel lblMusicIcon;
	private classMusic musicPlayer;
	static String musicIconPath;   
	static classMusicCall i = new classMusicCall();
	static boolean musicStarted = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameHome window = new frameHome();
					window.frameHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frameHome() {
		frameHome = new JFrame();
		frameHome.setTitle("Rock, Paper, Scissors Game"); 
		frameHome.setIconImage(Toolkit.getDefaultToolkit().getImage("imgNew/playerImg.png"));
		frameHome.setBounds(100, 100, 756, 494);
		frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameHome.getContentPane().setLayout(null);
		frameHome.setLocationRelativeTo(null); 
		frameHome.setUndecorated(true);
		frameHome.setVisible(true);


		panelBg = new JPanel();
		panelBg.setBounds(0, 0, 758, 494);
		frameHome.getContentPane().add(panelBg);

		int panelWidth = panelBg.getWidth();
		int panelHeight = panelBg.getHeight();

		ImageIcon originalImageIcon = new ImageIcon("imgNew/homeBg.png");
		Image originalImage = originalImageIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH);
		ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
		panelBg.setLayout(null);

		lblMusicIcon = new JLabel("");
		lblMusicIcon.setBounds(664, 11, 50, 45);
		panelBg.add(lblMusicIcon);
		musicIconPath = "imgNew/music.png";
		i.setMusicIcon(lblMusicIcon, musicIconPath);

		lblExit = new JLabel("");
		lblExit.setBounds(265, 392, 234, 67);
		panelBg.add(lblExit);

		lblHelp = new JLabel("");
		lblHelp.setBounds(265, 327, 234, 72);
		panelBg.add(lblHelp);

		lblStart = new JLabel("");
		lblStart.setBounds(265, 263, 234, 72);
		panelBg.add(lblStart);

		imageButtonLabels("imgNew/start.png", lblStart, 209, 260, 234, 100);   
		imageButtonLabels("imgNew/help.png", lblHelp, 209, 260, 234, 100);
		imageButtonLabels("imgNew/exit.png", lblExit, 209, 360, 234, 100);

		lblBgImg = new JLabel("");
		lblBgImg.setBounds(0, 0, 758, 495);
		panelBg.add(lblBgImg);
		lblBgImg.setIcon(resizedImageIcon);

		i.musicHome();
		musicStarted = true;

		lblMusicIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				i.toggleMusic();
			}
		});
		
		lblStart.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frameGame j = new frameGame();
				j.frameStart.setVisible(true);
				frameHome.dispose();	

			}
		});
		lblHelp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frameHelp j = new frameHelp();
				j.frame.setVisible(true);
				frameHome.dispose();	

			}
		});
		lblExit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frameExit j = new frameExit();
				j.frameHomeExit();
				j.frame.setVisible(true);
				frameHome.dispose();
				//				i.stopMusic();
			}
		});    
	}		


	private void imageButtonLabels(String imagePath, JLabel label, int x, int y, int width, int height) {
		ImageIcon icon = new ImageIcon(imagePath);
		Image image = icon.getImage();
		Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		label.setIcon(resizedIcon);
	}	


}
