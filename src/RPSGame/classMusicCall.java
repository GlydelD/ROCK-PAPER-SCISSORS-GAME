package RPSGame;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class classMusicCall {
	private classMusic musicPlayer;

	void musicHome() {
		if(frameHome.musicStarted != true) {
			//			stopMusic();	
			musicPlayer = new classMusic("music.wav");
			musicPlayer.playMusic();
		}
	}
	void stopMusic() {
		if (musicPlayer != null) {
			musicPlayer.stopMusic();
		}
	}

	void toggleMusic() {
		if (frameHome.musicStarted) {
			stopMusic();
			frameHome.musicIconPath = "imgNew/noMusic.png";
			setMusicIcon(frameHome.lblMusicIcon, frameHome.musicIconPath);
			frameHome.musicStarted = false;
		} else {	
			frameHome.musicIconPath = "imgNew/music.png";	 
			setMusicIcon(frameHome.lblMusicIcon, frameHome.musicIconPath);
			musicHome();        
			frameHome. musicStarted = true;
		}
	}

	void setMusicIcon(JLabel label, String imagePath) {
		ImageIcon music = new ImageIcon(imagePath);
		music = new ImageIcon(music.getImage().getScaledInstance(50, 45, java.awt.Image.SCALE_SMOOTH));
		frameHome.lblMusicIcon.setIcon(music);		

	}
}

