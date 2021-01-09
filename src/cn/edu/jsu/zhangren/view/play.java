package cn.edu.jsu.zhangren.view;

import java.io.BufferedInputStream;
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javazoom.jl.decoder.JavaLayerException; 
import javazoom.jl.player.*; 
 /**
  * ∂®“Â±≥æ∞“Ù¿÷¿‡
  * @author 10073
  *
  */
class play extends Thread{
    Player player;
    String music;
    public play(String file) {
        this.music = file;
    }
     public void run() {
        try {
            play();     
        } catch (FileNotFoundException | JavaLayerException e) {
             e.printStackTrace();
        }
    }
    public void play() throws FileNotFoundException, JavaLayerException { 
        BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(music)); 
        player = new Player(buffer); 
        player.play(); 
    } 
}