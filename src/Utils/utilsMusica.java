package Utils;

import controlador.MainController;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class utilsMusica {
    private Clip clip;
    private long clipPosition;
    private static utilsMusica uniqueInstance;

    public static utilsMusica getInstancia() {
        if (uniqueInstance == null) {
            uniqueInstance = new utilsMusica();
        }
        return uniqueInstance;
    }

    public void cargarOST(String ruta) {
        if (clip != null && clip.isOpen()) {
            return;
        }
        try {
            File pista = new File(ruta);
            AudioInputStream audioImputStream = AudioSystem.getAudioInputStream(pista);
            clip = AudioSystem.getClip();
            clip.open(audioImputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playuntil() {
        if (clip != null && !clip.isRunning()) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }
    }

    public void play() {
        if (clip != null && !clip.isRunning()) {
            clip.start();
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

    public void replay() {
        if (clip != null) {
            clip.setFramePosition(0);
            play();
        }
    }

    public void pause() {
        if (clip != null && clip.isRunning()) {
            clipPosition = clip.getMicrosecondPosition();
            clip.stop();
        }
    }

    public void resume() {
        if (clip != null && !clip.isRunning()) {
            clip.setMicrosecondPosition(clipPosition);
            clip.start();
        }
    }
}