package LostCause.GameEngine;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.util.concurrent.TimeUnit;

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

    public void resetPosition() {
        clip.setMicrosecondPosition(0);
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

    public void isActiveClip() {
        //System.out.println(clip.isActive());
        System.out.println(clip.isActive());
        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        //System.out.println(clip.isRunning());
        if (!clip.isActive()) {
            for (int i = 1; i < 21; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("increasing volume of track... i = " + i);
                volume.setValue(-40f + (2f * i) ); // 1f - (float) (i / 10)
            }
            play();

        }
    }

    public void fadeOutMusic() {

        if (clip.isActive()) {
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            for (int i = 1; i < 21; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("reducing volume of track... i = " + i);
                volume.setValue(0f - (2f * i) ); // 1f - (float) (i / 10)
            }
        }
    }


    public void normalizeMusic() {

        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(0f); // 1f - (float) (i / 10)
    }
}
