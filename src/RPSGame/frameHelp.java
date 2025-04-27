package RPSGame;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class frameHelp extends JFrame {

	JFrame frame;
	private JPanel panel;
	private JLabel lblBackHome;
	private JLabel lblImgBg;
	private JLabel imgBg;
	static classMusicCall i = new classMusicCall();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameHelp window = new frameHelp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public frameHelp () {
		frame = new JFrame();
		frame.setBounds(100, 100, 725, 490);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("imgNew/playerImg.png"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null); 
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 725, 490);
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		lblBackHome = new JLabel("");
		lblBackHome.setBounds(10, 416, 76, 52);
		lblBackHome.setForeground(new Color(0, 0, 0));
		lblBackHome.setBackground(new Color(0, 0, 0));
		panel.add(lblBackHome);

		ImageIcon backIcon = new ImageIcon("imgNew/back.png");
		backIcon = new ImageIcon(backIcon.getImage().getScaledInstance(76, 52, java.awt.Image.SCALE_SMOOTH));
		lblBackHome.setIcon(backIcon);		

		imgBg = new JLabel("");
		imgBg.setBounds(0, 0, 736, 490);
		panel.add(imgBg);

		String imagePath = "imgNew/helpBg.png";
		ImageIcon imgBgIcon = new ImageIcon(imagePath);
		imgBgIcon = new ImageIcon(imgBgIcon.getImage().getScaledInstance(739, 493, java.awt.Image.SCALE_SMOOTH));
		imgBg.setIcon(imgBgIcon);

		lblBackHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameHome a = new frameHome();
				a.frameHome.setVisible(true);
				frame.dispose();	
				i.stopMusic();

			}
		});
	}
}
