
import java.io.File;
import jaco.mp3.player.MP3Player;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.phidgets.PhidgetException;

/*
* @author Samuel Orgill 15118305
* NW5 Smartwatch Control of Environment
* September 2016
*
* Music class
*/

public class Music {

	String path = "";
	Player play = new Player(null);

	/*
	* Method to play Music
	*/
	public void playSound(String choice) throws InterruptedException{
		// TODO Auto-generated method stub

		MP3Player mplay = null;
		String myChoice = choice;
		playMusic(mplay, myChoice);
	}

	// Methd to play music
	public void playMusic(MP3Player mp3, String myChoice) throws InterruptedException {

		File file = new File (myChoice + ".mp3");

		MP3Player mplay = new MP3Player(file);

		mplay.play();

		play.setMp3(mplay);
	}

	/**
	 * Method to stop the music
	 * @throws PhidgetException
	 * @throws InterruptedException
	 */

	public void stopMusic() throws PhidgetException, InterruptedException {

		MP3Player mp3 = play.getMp3();
		mp3.stop();

	}


}
