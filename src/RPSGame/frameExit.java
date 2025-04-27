package RPSGame;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class frameExit {
	/////////METHODS //////////////

	JFrame frame;
	private JPanel panel; 
	private JLabel lblYes;
	private JLabel lblNo;
	private JLabel lblImg;		
	static String bgPathYes;
	static String bgPathNo;


	public  frameExit () {
		frame = new JFrame(); 
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("imgNew/playerImg.png"));
		frame.setBounds(100, 100, 598, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); 
		frame.setUndecorated(true);   

		panel = new JPanel();
		panel.setBounds(0, 0, 626, 370);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblYes = new JLabel("");
	
		lblYes.setBounds(57, 177, 117, 61);
		panel.add(lblYes);

		lblNo = new JLabel("");
		lblNo.setBounds(216, 177, 117, 61);
		panel.add(lblNo);

		ImageIcon yesIcon = new ImageIcon("imgNew/yes.png");
		yesIcon = new ImageIcon(yesIcon.getImage().getScaledInstance(117, 61, java.awt.Image.SCALE_SMOOTH));
		lblYes.setIcon(yesIcon);		

		ImageIcon noIcon = new ImageIcon("imgNew/no.png");
		noIcon = new ImageIcon(noIcon.getImage().getScaledInstance(117, 61, java.awt.Image.SCALE_SMOOTH));
		lblNo.setIcon(noIcon);		

		lblImg = new JLabel("");
		lblImg.setBounds(0, 0, 626, 370);
		panel.add(lblImg);
		
		bgPathYes = "imgNew/exitYes.png";
		bgPathNo = "imgNew/exitNo.png";
		callingBg(lblImg, bgPathNo);
	
	}
	public void callingBg(JLabel label, String imagePath) {
		ImageIcon imageIcon = new ImageIcon(imagePath); 
		Image image = imageIcon.getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH);
		lblImg.setIcon(new ImageIcon(image));	     
		
	}
	
	
	public void frameRestartExit () {
		lblYes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				callingBg(lblImg, bgPathYes);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				callingBg(lblImg, bgPathNo);

			}
		});
		lblYes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();	

			}
		});
		lblNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				framePlayAgainAndMenuButton j = new framePlayAgainAndMenuButton();
				j.menuLabelButton();
				j.menuFrame.setVisible(true);
				frame.dispose();

			}
		});
	}  
	public void framePlayAgainExit () {
		
		lblYes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				callingBg(lblImg, bgPathYes);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				callingBg(lblImg, bgPathNo);

			}
		});
		lblYes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();	


			}
		});
		lblNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				framePlayAgainAndMenuButton j = new framePlayAgainAndMenuButton();
				j.pAFrame.setVisible(true);
				frame.dispose();

			}
		});
	}

	public void frameHomeExit () {
		
		lblYes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				callingBg(lblImg, bgPathYes);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				callingBg(lblImg, bgPathNo);

			}
		});
		lblYes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();	

			}
		});
		lblNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameHome j = new frameHome();
				j.frameHome.setVisible(true);
				frame.dispose();

			}
		});
	}	        
}

