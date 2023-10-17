package LostCause.GameEngine;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {

    Clip clip;

    public Music(String soundFileName) {

        try {
            File file = new File(soundFileName);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception ignored) {
            System.out.println("No file found...");
        }


    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        try {
            clip.stop();
            System.out.println("stopping");
        } catch (Exception e) {
            System.out.println("no play");
        }
    }
}
