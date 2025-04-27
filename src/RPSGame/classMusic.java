package RPSGame;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class classMusic {

	private Clip clip;

	public classMusic(String music) {
		try {
			File file = new File(music);
			if (file.exists()) {
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			} 
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playMusic() {
		if (clip != null && !clip.isRunning()) {
			clip.start();
		}
	}

	public void stopMusic() {
		if (clip != null && clip.isRunning()) {
			clip.stop();
//			clip.setFramePosition(0);
		}
	}

}
