package sew9.worttrainer.flixlcookie;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class WortTrainerSpeichern extends WortTrainer{


    public WortTrainerSpeichern(WortListe liste){
        super(liste);
    }

    /**
     * Speicher den Worttrainer im übergebenen Pfad
     * @param pfad String
     */
    public void speichern(String pfad){
        File f= new File(pfad);
        try(BufferedWriter writer= new BufferedWriter(new FileWriter(f))){
            writer.write(super.getFragen()+";"+super.getRichtig()+";"+super.getFalsch()+";"+super.getUngueltig());
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Beim Speichern ist ein Fehler passiert!");
        }
    }

    /**
     * Speicher den Worttrainer in Worttrainer.txt
     */
    public void speichern(){
        this.speichern("Worttrainer.txt");
    }

    /**
     * Läd den Worttrainer aus dem übergebenen Pfad
     * @param pfad String
     */
    public void laden(String pfad){
        File f=new File(pfad);
        String[] splitst;
        try(Scanner scan=new Scanner(new BufferedReader(new FileReader(f)))){
            if(scan.hasNext()){
                splitst=scan.next().split(";");
                super.fragen=Integer.parseInt(splitst[0]);
                super.richtig=Integer.parseInt(splitst[1]);
                super.falsch=Integer.parseInt(splitst[2]);
                super.ungueltig=Integer.parseInt(splitst[3]);
                
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Beim Speichern ist ein Fehler passiert!");
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Beim Speichern ist ein Fehler passiert!");
        }
    }

    /**
     * Läd einen Worttrainer aus Worttrainer.txt
     */
    public void laden(){
        this.laden("Worttrainer.txt");
    }
}
