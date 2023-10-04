package sew9.worttrainer.flixlcookie;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 
Testet alle Worttrainer Methoden
@author Felix Warmuth
@version 04-10-2023
*/
public class App {
    public static void main(String[] args){
        //Worteintrag
        WortEintrag worteintrag1 = new WortEintrag("Hase", "https://www.vaillant.at/images/4-1-3-historie/haseundvaillant-1470066-format-flex-height@392@retina.jpg");
        WortEintrag worteintrag2 = new WortEintrag("Schaf", "https://www.petakids.de/wp-content/uploads/2014/10/schafe-sheep-1822137_1920-c-pixabay.jpg");
        WortEintrag worteintrag3 = new WortEintrag("Kuh", "https://i.ds.at/4YE_gQ/rs:fill:750:0/plain/2022/11/14/Kuh.jpg");

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

        ImageIcon image;


        JOptionPane.showMessageDialog(null, "Herzlich Willkommen zu meinem Worttrainer");
        while(running) {
            WortEintrag neuesWort = trainer.getWortListe().getWortEintragArray()[r.nextInt(trainer.getWortListe().getWortEintragArray().length)];
            try {
                image = new ImageIcon(new URI(neuesWort.getUrl()).toURL());
            
                wortfalsch=true;
                while(wortfalsch){
                    JOptionPane.showMessageDialog(null, "Merk dir das Bild ", null,JOptionPane.INFORMATION_MESSAGE,image);
                    String antwort = JOptionPane.showInputDialog(null, "Welches Bild ist das? ");
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
            } catch (URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(null, "Richtig: "+trainer.getRichtig()+" Falsch: "+trainer.getFalsch());
    }
}
