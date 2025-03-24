package LostCause.GameEngine;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
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
        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        //System.out.println(clip.isRunning());
        if (!clip.isRunning()) {

            new Thread(() -> {
                for (int i = 0; i < 41; i++) {
                    try {
                        Thread.sleep(25);
                        volume.setValue(-40f + (1f * i)); // 1f - (float) (i / 10)
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                    play();
                }

            }).start();

        }
    }

    public void fadeOutMusic(Runnable onComplete) {

        if (clip.isRunning()) { // TODO: ask ChatGPT to elaborate lambdas and controlling with threads.

            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            new Thread(() -> {

                for (int i = 0; i < 41; i++) {
                    try {
                        Thread.sleep(25);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    volume.setValue(0f - (1f * i));
                }
                if (onComplete != null) {
                    onComplete.run();
                }
            }).start();

        } else {
            if (onComplete != null) onComplete.run();
        }
    }


    public void normalizeMusic() {

        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(0f); // 1f - (float) (i / 10)
    }
}