package RPSGame;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class classTimer {
	private static Timer countdownTimer;

	public static void setCountdownTimer(Timer timer) {
		countdownTimer = timer;
	}

	public static void updateTimerLabel() {
		frameGame.timerCountDown.setText(Integer.toString(frameGame.timerCount) + "s");
	}

	public static void handleTimeout() {
		JOptionPane.showMessageDialog(frameGame.frameStart, "Time's up! Select a weapon!.");
		resetTimer();

	}

	public static void resetTimer() {
		if (countdownTimer != null && countdownTimer.isRunning()) {
			countdownTimer.stop();
		}
		frameGame.timerCount = 5;
		updateTimerLabel();
	}

}
