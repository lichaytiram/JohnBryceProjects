package Program42;

import javax.swing.JLabel;

public class YossiThread extends Thread {

	@SuppressWarnings("unused")
	private boolean aviAnswered;
	private boolean aviStartedWorking;
	private JLabel yossiStatus;

	private int emailIndex;

	public YossiThread(JLabel yossiStatus) {
		aviAnswered = false;
		this.yossiStatus = yossiStatus;
		this.aviStartedWorking = false;
	}

	public void run() {
		try {
			while (true) {
				this.emailIndex = 0;
				while (!this.aviStartedWorking) {
					this.emailIndex++;
					yossiStatus.setText("Yossi sent Avi an e-mail number " + this.emailIndex);
					Thread.sleep(2000);
				}
				synchronized (this) {
					this.wait();
				}
				this.aviStartedWorking = false;
			}
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}

	public void aviStartedWorkingOnIt() {
		try {
			yossiStatus.setText("Waiting for Avi's reply");
			this.aviStartedWorking = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void aviSentAReply() {
		yossiStatus.setText("Checking on Avi's answer");
		try {
			Thread.sleep(5000);
			synchronized (this) {
				notify();
			}
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}

}
