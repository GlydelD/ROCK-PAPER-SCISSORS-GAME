package RPSGame;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class frameGame extends JFrame {
	static JFrame frameStart;
	private JLabel faceBoy;
	private JLabel faceCpu;
	private JLabel userRock;
	private JLabel imgPaper;
	private JLabel userScissor;
	private JLabel playerScoree;
	private JLabel cpuScoree;
	private JLabel answerUser;
	private JLabel answerCpu;
	private JLabel imgWin;
	private JLabel imgTie;
	private framePlayAgainAndMenuButton playAgain;
	private JPanel dinosaurPanel;
	private JPanel titleBothPanel;
	private JPanel cpuPanel;
	private JLabel cpuName;
	private JLabel dinosaurName;
	private JLabel lblVS;
	private JLabel userPaper;
	private JLabel lblChoose;
	private JPanel panel_1;
	private JPanel answerPanel;
	private JPanel bgPanel;
	private JLabel imgBg;
	private int playerScore = 0;
	private int cpuScore = 0;    
	private Timer countdownTimer;
	private Timer playAgainTimer;
	static int timerCount;
	private static JLabel facePlayer;
	private static JLabel faceCPU;
	static JPanel panelBg;
	private JLabel lblRock;
	private JLabel lblPaper;
	private JLabel lblScissor;
	private classMusic musicPlayer;

	static JLabel timerCountDown;
	ImageIcon image_rock, image_paper, image_Scissor;
	private JLabel lblMenu;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameGame window = new frameGame();
					window.frameStart.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frameGame() {
		frameStart = new JFrame();
		frameStart.setTitle("ROCK, PAPER, SCISSOR");
		frameStart.setIconImage(Toolkit.getDefaultToolkit().getImage("imgNew/playerImg.png"));
		frameStart.setBounds(100, 100, 749, 521);
		frameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameStart.setLocationRelativeTo(null);
		frameStart.setResizable(true);
	    frameStart.setUndecorated(true);
		frameStart.setVisible(true);

		panelBg = new JPanel();
		panelBg.setForeground(new Color(250, 250, 210));
		panelBg.setBounds(0, -13, 670, 81);
		panelBg.setBackground(new Color(0, 128, 0));
		frameStart.getContentPane().add(panelBg);
		panelBg.setOpaque(false);
		String winImagePath = "imgNew/win.png";

		ImageIcon winIcon = new ImageIcon(winImagePath); 
		ImageIcon rockIcon = new ImageIcon("imgNew/rock.png");
		ImageIcon paperIcon = new ImageIcon("imgNew/paper.png"); 
		ImageIcon scissorIcon = new ImageIcon("imgNew/scissor.png");  

		icon ();

		faceCpu = new JLabel();
		faceCpu.setBounds(535, 0, 114, 75);
		panelBg.add(faceCpu);

		icon (faceCpu);

		playerScoree = new JLabel("0");
		playerScoree.setBounds(209, 6, 69, 69);
		playerScoree.setFont(new Font("Tahoma", Font.BOLD, 35));
		panelBg.add(playerScoree);

		cpuScoree = new JLabel("0");
		cpuScoree.setBounds(518, 6, 30, 69);
		cpuScoree.setFont(new Font("Tahoma", Font.BOLD, 35));
		panelBg.add(cpuScoree);

		timerCountDown = new JLabel("");
		timerCountDown.setBounds(346, 23, 63, 39);
		timerCountDown.setFont(new Font("Tahoma", Font.BOLD, 30));
		panelBg.add(timerCountDown);

		bgPanel = new JPanel();
		bgPanel.setBounds(0, 73, 749, 449);
		bgPanel.setBackground(new Color(250, 250, 210));
		panelBg.add(bgPanel);
		bgPanel.setLayout(null);

		lblRock = new JLabel("Rock ");
		lblRock.setForeground(new Color(0, 0, 0));
		lblRock.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRock.setBounds(139, 382, 59, 32);
		bgPanel.add(lblRock);

		lblScissor = new JLabel("Scissor");
		lblScissor.setForeground(new Color(0, 0, 0));
		lblScissor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblScissor.setBounds(536, 380, 100, 32);
		bgPanel.add(lblScissor);

		lblPaper = new JLabel("Paper");
		lblPaper.setForeground(new Color(0, 0, 0));
		lblPaper.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPaper.setBounds(315, 382, 59, 32);
		bgPanel.add(lblPaper);

		imgTie = new JLabel("");
		imgTie.setBounds(223, 56, 305, 162);
		bgPanel.add(imgTie);

		userRock = new JLabel("");
		userRock.setBounds(40, 265, 188, 147);
		bgPanel.add(userRock);
		Image rockImage = rockIcon.getImage().getScaledInstance(userRock.getWidth(), userRock.getHeight(), Image.SCALE_SMOOTH);
		userRock.setIcon(new ImageIcon(rockImage));

		userScissor = new JLabel("");
		userScissor.setBounds(468, 265, 188, 147);
		bgPanel.add(userScissor);
		Image scissorImage = scissorIcon.getImage().getScaledInstance(userScissor.getWidth(), userScissor.getHeight(), Image.SCALE_SMOOTH);
		userScissor.setIcon(new ImageIcon(scissorImage));

		titleBothPanel = new JPanel();
		titleBothPanel.setBounds(95, 28, 561, 29);
		bgPanel.add(titleBothPanel);
		titleBothPanel.setBackground(new Color(0, 0, 0));
		titleBothPanel.setForeground(new Color(255, 255, 128));
		titleBothPanel.setLayout(null);

		cpuPanel = new JPanel();
		cpuPanel.setBounds(273, 0, 288, 30);
		cpuPanel.setForeground(new Color(255, 255, 128));
		cpuPanel.setBackground(new Color(128, 64, 0));
		titleBothPanel.add(cpuPanel);

		cpuName = new JLabel("CPU");
		cpuPanel.add(cpuName);
		cpuName.setForeground(new Color(255, 255, 255));
		cpuName.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 20));

		dinosaurPanel = new JPanel();
		dinosaurPanel.setBounds(0, 0, 272, 30);
		dinosaurPanel.setForeground(new Color(255, 255, 128));
		dinosaurPanel.setBackground(new Color(128, 64, 0));
		titleBothPanel.add(dinosaurPanel);

		dinosaurName = new JLabel("DINOSAUR");
		dinosaurPanel.add(dinosaurName);
		dinosaurName.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 20));
		dinosaurName.setForeground(new Color(255, 255, 255));

		imgWin = new JLabel("");
		imgWin.setBounds(223, 56, 307, 289);
		imgWin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bgPanel.add(imgWin);

		answerUser = new JLabel("");
		answerUser.setBounds(114, 96, 188, 101);
		bgPanel.add(answerUser);

		answerCpu = new JLabel("");
		answerCpu.setBounds(448, 96, 188, 101);
		bgPanel.add(answerCpu);

		String imagePath = "imgNew/choose.png";
		ImageIcon imgChooseIcon = new ImageIcon(imagePath);
		imgChooseIcon = new ImageIcon(imgChooseIcon.getImage().getScaledInstance(400, 250, java.awt.Image.SCALE_SMOOTH));

		lblVS = new JLabel("VS.");
		lblVS.setBounds(325, 96, 107, 76);
		lblVS.setBackground(new Color(139, 69, 19));
		bgPanel.add(lblVS);
		lblVS.setFont(new Font("Wide Latin", Font.BOLD, 30));
		lblVS.setForeground(new Color(139, 69, 19));

		userPaper = new JLabel("");
		userPaper.setBounds(266, 272, 171, 140);
		bgPanel.add(userPaper);
		Image paperImage = paperIcon.getImage().getScaledInstance(userPaper.getWidth(), userPaper.getHeight(), Image.SCALE_SMOOTH);
		userPaper.setIcon(new ImageIcon(paperImage));

		lblChoose = new JLabel("");
		lblChoose.setBounds(163, 11, 453, 464);
		bgPanel.add(lblChoose);
		lblChoose.setForeground(new Color(102, 51, 0));
		lblChoose.setIcon(imgChooseIcon);

		answerPanel = new JPanel();
		answerPanel.setBounds(95, 56, 561, 147);
		answerPanel.setBackground(new Color(255, 255, 255));
		bgPanel.add(answerPanel);
		answerPanel.setLayout(null);

		String backgroundImagePath = "imgNew/gameBg2.png";
		ImageIcon backgroundIcon = new ImageIcon(backgroundImagePath);

		imgBg = new JLabel("");
		imgBg.setBounds(0, -74, 760, 535);
		bgPanel.add(imgBg);
		Image backgroundImage = backgroundIcon.getImage().getScaledInstance(imgBg.getWidth(), imgBg.getHeight(), Image.SCALE_SMOOTH);
		imgBg.setIcon(new ImageIcon(backgroundImage));	    

		lblMenu = new JLabel("");
		lblMenu.setBounds(670, 11, 56, 51);
		panelBg.add(lblMenu);

		ImageIcon backIcon = new ImageIcon("imgNew/menu.png");
		backIcon = new ImageIcon(backIcon.getImage().getScaledInstance(56, 51, java.awt.Image.SCALE_SMOOTH));
		lblMenu.setIcon(backIcon);	
		
		
		lblMenu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				framePlayAgainAndMenuButton j = new framePlayAgainAndMenuButton();
				j.menuLabelButton();
				j.menuFrame.setVisible(true);
				frameStart.dispose();	      
				countdownTimer.stop();
			
			}
		});	        

		userRock.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setChoiceAndCheckWinner(0);
			}
		});

		userPaper.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setChoiceAndCheckWinner(1);	
			}
		});

		userScissor.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setChoiceAndCheckWinner(2);
			}
		});

		countdownTimer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				classTimer.updateTimerLabel();
				if (timerCount == 0) {
					classTimer.handleTimeout();
				} else {
					timerCount--;
				}
			}
		});
		classTimer.setCountdownTimer(countdownTimer);

	}

	public static void icon () {
		panelBg.setLayout(null);
		facePlayer = new JLabel();
		facePlayer.setBounds(106, 0, 100, 75);
		panelBg.add(facePlayer);
		ImageIcon icon = new ImageIcon("imgNew/playerImg.png"); 
		Image image = icon.getImage().getScaledInstance(facePlayer.getWidth(),facePlayer.getHeight(), Image.SCALE_SMOOTH);
		facePlayer.setIcon(new ImageIcon(image));
	}

	public static void icon (JLabel image) {
		ImageIcon cpuIcon = new ImageIcon("imgNew/cpuImg.png");  
		Image cpuImage = cpuIcon.getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(cpuImage));
	} 

	private void setChoiceAndCheckWinner(int playerChoice) {
		int compChoice;
		String winner;
		Random randomChoice = new Random();
		compChoice = randomChoice.nextInt(3);
		winner = findWinner(playerChoice, compChoice);

		setChoiceImage(answerCpu, getChoiceImageName(compChoice));
		setChoiceImage(answerUser, getChoiceImageName(playerChoice));

		if (countdownTimer.isRunning()) {
			countdownTimer.stop();
		}

		timerCount = 5;
		countdownTimer.start();

		if (playerChoice == compChoice) {
			setChoiceImage(imgTie, "imgNew/draw.png");  
		} else {
			imgTie.setIcon(null);  
		}

		if (winner.equals("Player")) {
			playerScore++;
		} else if (winner.equals("Computer")) {
			cpuScore++;
		}

		playerScoree.setText(Integer.toString(playerScore));
		cpuScoree.setText(Integer.toString(cpuScore));

		if (playerScore == 5 || cpuScore == 5) {
			declareWinner();
			return;
		}
	}

	private void declareWinner() {
		String winner;
		String winnerImagePath;

		if (playerScore == 5) {
			winner = "Player";
			winnerImagePath = "imgNew/win.png"; 

		} else if (cpuScore == 5) {
			winner = "Computer";
			winnerImagePath = "imgNew/computerWins.png";  
		} else {
			return; 
		}
		classTimer.resetTimer();

		setChoiceImage(imgWin, winnerImagePath);
		resetGame();       


		playAgainTimer = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				framePlayAgainAndMenuButton a = new framePlayAgainAndMenuButton();
				a.pAFrame.setVisible(true);
				frameStart.dispose();
				playAgainTimer.stop(); 
				countdownTimer.stop();
			}
		});
		playAgainTimer.setRepeats(false); 
		playAgainTimer.start();


	}

	private void resetGame() {
		playerScore = 0;
		cpuScore = 0;
		playerScoree.setText("0");
		cpuScoree.setText("0");

		if (userRock != null) {
			userRock.setEnabled(true);
		}

		if (imgPaper != null) {
			imgPaper.setEnabled(true);
		}

		if (userScissor != null) {
			userScissor.setEnabled(true);
		}
	}

	private String getChoiceImageName(int choiceUser) {
		switch (choiceUser) {
		case 0:
			return "imgNew/rock.png";
		case 1:
			return "imgNew/paper.png";
		case 2:
			return "imgNew/scissor.png";
		default:
			return "";
		}
	}

	private void setChoiceImage(JLabel label, String imageName) {
		if (label != null) {
			String imagePath = imageName;
			ImageIcon choiceIcon = new ImageIcon(imagePath);
			Image choiceImage = choiceIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(),
					Image.SCALE_SMOOTH);
			label.setIcon(new ImageIcon(choiceImage));
		}
	}

	private String findWinner(int playerChoice, int compChoice) {
		if (playerChoice == compChoice) {
			return "";
		} else if ((playerChoice == 0 && compChoice == 2) ||
				(playerChoice == 1 && compChoice == 0)
				|| (playerChoice == 2 && compChoice == 1)) {
			return "Player";
		} else {
			return "Computer";
		}
	}
}