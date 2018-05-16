package CardGame;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


//BGM of Game 
public class GameSound{	
	public GameSound() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("img/backmusic.wav"));
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
}

// Sound of cardChange  
class ButtonSound implements Runnable{
	public void run() {
		try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("img/changeCard.wav"));
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
}
// Sound of Door
class doorSound implements Runnable{
	public void run() {
		try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("img/buttonSound.wav"));
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
}




