package sew9.worttrainer.flixlcookie;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class WortTrainerSpeichern{
    private WortTrainer wortTrainer;

    public WortTrainerSpeichern(WortTrainer trainer){
        this.wortTrainer=trainer;
    }

    /**
     * Speicher den Worttrainer im übergebenen Pfad
     * @param pfad String
     */
    public void speichern(String pfad){
        File f= new File(pfad);
        try(BufferedWriter writer= new BufferedWriter(new FileWriter(f))){
            writer.write(wortTrainer.getRichtig()+";"+wortTrainer.getFalsch());
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
                wortTrainer.richtig=Integer.parseInt(splitst[0]);
                wortTrainer.falsch=Integer.parseInt(splitst[1]);
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
