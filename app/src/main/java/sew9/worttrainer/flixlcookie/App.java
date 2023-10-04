package sew9.worttrainer.flixlcookie;

import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 
Testet alle Worttrainer Methoden
@author Johannes Schulz
@version 20-09-2022
*/
public class App {
    public static void main(String[] args) {
        //Worteintrag
        WortEintrag worteintrag1 = new WortEintrag("eins", "https://www.eins.com");
        WortEintrag worteintrag2 = new WortEintrag("zwei", "http://www.zwei.com");
        WortEintrag worteintrag3 = new WortEintrag("drei", "http://www.drei.com");

        //Wortliste
        WortListe wortliste1 = new WortListe();
        wortliste1.addWort(worteintrag1);
        wortliste1.addWort(worteintrag2);
        wortliste1.addWort(worteintrag3);

        //Worttrainer
        WortTrainer trainer = new WortTrainer(wortliste1);

        Random r = new Random();

        boolean wortfalsch;
        boolean running= true;

        JOptionPane.showMessageDialog(null, "Herzlich Willkommen zu meinem Worttrainer");
        while(running) {
            WortEintrag neuesWort = trainer.getWortListe().getWortEintragArray()[r.nextInt(trainer.getWortListe().getWortEintragArray().length)];
            wortfalsch=true;
            while(wortfalsch){
                String antwort = JOptionPane.showInputDialog(null, "Welches Bild ist das? "+neuesWort.getUrl());
                if(antwort.equals("")){
                    running=false;
                    break;
                }
                if(antwort.equals(neuesWort.getWort())) {
                    JOptionPane.showMessageDialog(null, "Richtig :)");
                    wortfalsch=false;
                    trainer.addRichtig(1);
                } else {
                    JOptionPane.showMessageDialog(null, "Falsch :(");
                    trainer.addFalsch(1);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Richtig: "+trainer.getRichtig()+" Falsch: "+trainer.getFalsch());
    }
}
