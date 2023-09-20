package sew9.worttrainer.flixlcookie;
/**
 * Die Main-Klasse
 * @author Felix Warmuth
 * @version 14.11.2021
 */
public class Main {
    public static void main(String[] args) {

        // Hier werden die Methoden von WortEintrag überprüft

        WortEintrag worteintrag1= new WortEintrag("HauS", "https://haus.com");
        WortEintrag worteintrag2= new WortEintrag("BauM", "http://baum.com");
        System.out.println(worteintrag1.toString());
        System.out.println(worteintrag2.toString());
        if(WortEintrag.checkUrl("http://.at")){
            System.out.println("Die 1.URL wurde nicht richtig überprüft");
        }else{
            System.out.println("Die 1.URL wurde richtig überprüft");
        }
        if(WortEintrag.checkUrl("https://baum.com")){
            System.out.println("Die 2.URL wurde richtig überprüft");
        }else{
            System.out.println("Die 2.URL wurde nicht richtig überprüft");
        }
        if(WortEintrag.checkUrl("apple.com")){
            System.out.println("Die 3.URL wurde nicht richtig überprüft");
        }else{
            System.out.println("Die 3.URL wurde richtig überprüft");
        }
        worteintrag1.setWort("Haus");
        worteintrag2.setWort("Baum");
        System.out.println(worteintrag1.toString());
        System.out.println(worteintrag2.toString());
        System.out.println(worteintrag1.getWort());
        System.out.println(worteintrag1.getUrl());

        //Hier werden die Methoden von WortListe überprüft

        WortListe wortliste1 = new WortListe();
        wortliste1.addWort(worteintrag1);
        wortliste1.addWort(worteintrag2);
        System.out.println(wortliste1.toString());
        System.out.println(wortliste1.getWort(1).toString());
        System.out.println(wortliste1.getLength());
        if(wortliste1.deleteWord("Baum")){
            System.out.println("Das Wort wurde geslöscht \n");
        }else{
            System.out.println("Das Wort wurde nicht gelöscht \n");
        }
        System.out.println(wortliste1.toString());
        wortliste1.addWort(worteintrag2);
        System.out.println(wortliste1.toString());

        // Hier werden die Methoden von Worttrainer überprüft
        
        WortTrainer trainer= new WortTrainer(wortliste1);
        System.out.println(trainer.getRandomWort().toString());
        System.out.println(trainer.getWort(1).toString());
        if(trainer.check("hase",1)){
            System.out.println("Check 1 funktioniert nicht");
        }else{
            System.out.println("Check 1 funktioniert");
        }
        if(trainer.check("haus",0)){
            System.out.println("Check 2 funktioniert nicht");
        }else{
            System.out.println("Check 2 funktioniert");
        }
        if(trainer.check("Haus",4)){
            System.out.println("Check 3 funktioniert nicht");
        }else{
            System.out.println("Check 3 funktioniert");
        }
        if(trainer.check("Haus",0)){
            System.out.println("Check 4 funktioniert");
        }else{
            System.out.println("Check 4 funktioniert nicht");
        }
        if(trainer.checkIgnoreCase("BaUM", 1)){
            System.out.println("checkIgnoreCase 1 funktioniert");
        }else{
            System.out.println("checkIgnoreCase 1 funktioniert nicht");
        }
        if(trainer.checkIgnoreCase("BaUM", 5)){
            System.out.println("checkIgnoreCase 2 funktioniert nicht");
        }else{
            System.out.println("checkIgnoreCase 2 funktioniert");
        }
        System.out.println(trainer.getFehlerQuote());
        System.out.println(trainer.getFragen());
        System.out.println(trainer.getRichtig());
        System.out.println(trainer.getFalsch());
        System.out.println(trainer.getUngueltig());

        WortTrainerSpeichern speicher= new WortTrainerSpeichern(wortliste1);
        System.out.println(wortliste1.toString());
        speicher.speichern("Test.txt");

        WortListe test= new WortListe();
        WortTrainerSpeichern speicher2= new WortTrainerSpeichern(test);
        speicher2.laden("Test.txt");
        System.out.println(test.toString());
    }
}
