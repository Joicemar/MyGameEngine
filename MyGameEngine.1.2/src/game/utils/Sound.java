package game.utils;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {

	private AudioClip clip;

	public static final Sound musicBackground = new Sound("/music.wav");

	public static final Sound hurtEffect = new Sound("/hurt.wav");

	public Sound(String name) {

		try {

			this.clip = Applet.newAudioClip(Sound.class.getResource(name));
		} catch (Throwable localThrowable) {
		}
	}

	public void play() {

		try {
			new Thread() {
				public void run() {
					Sound.this.clip.play();
				}
			}.start();
		} catch (Throwable localThrowable) {
		}
	}

	public void loop() {
		try {
			new Thread() {
				public void run() {
					Sound.this.clip.loop();
				}
			}.start();
		} catch (Throwable localThrowable) {
		}
	}
}
