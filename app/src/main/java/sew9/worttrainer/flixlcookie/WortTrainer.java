package sew9.worttrainer.flixlcookie;


import java.util.Random;
/**
 * Ein WortTrainer
 * @author Felix Warmuth
 * @version 20.09.2023
 */
public class WortTrainer {

	protected WortListe wortliste;
	protected int fragen;
	protected int richtig;
	protected int falsch;
	protected int ungueltig;

	/**
	 *  erstellt ein Objekt WortTrainer
	 * @param wortListe
	 */
	public WortTrainer(WortListe wortListe){
		this.wortliste=wortListe;
		this.fragen=0;
		this.richtig=0;
		this.falsch=0;
		this.ungueltig=0;
	}

	public WortListe getWortListe(){
		return this.wortliste;
	}

	/**
	 * gibt einen zufälligen Worteintrag aus der Liste zurück
	 * @return Worteintrag
	 */
	public WortEintrag getRandomWort() {
		boolean x=true;
		Random r=new Random();
		int random= r.nextInt(this.wortliste.getLength());
		while(x){
			if(this.wortliste.getWort(random)!=null){
				return this.wortliste.getWort(random);
			}
		}
		return null;
	}

	public WortEintrag getWort(int index) {
		return this.wortliste.getWort(index);
	}

	/**
	 * überprüft ob das übergebene Wort mit dem Worteintrag übereinstimmt
	 * @param wort String
	 * @param index int
	 * @return boolean
	 */
	public boolean check(String wort,int index) {
		this.fragen++;
		if(index>wortliste.getLength()-1){
			this.ungueltig++;
			return false;
		}
		if(this.wortliste.getWort(index).getWort().equals(wort)){
			this.richtig++;
			return true;
		}
		this.falsch++;
		return false;
	}

	/**
	 * überprüft ob das übergebene Wort mit dem Worteintrag übereinstimmt, ignoriert jedoch Groß- und Kleinschreibung
	 * @param wort String
	 * @param index int
	 * @return
	 */
	public boolean checkIgnoreCase(String wort,int index) {
		this.fragen++;
		if(index>wortliste.getLength()-1){
			this.ungueltig++;
			return false;
		}
		String vorlage= this.wortliste.getWort(index).getWort().toLowerCase();
		if(vorlage.equals(wort.toLowerCase())){
			this.richtig++;
			return true;
		}else{
			this.falsch++;
			return false;
		}
	}

	public String getFehlerQuote(){
		String fehlerQuote= new String("Sie haben "+this.fragen+" Wörter geprüft. Davon waren "+this.richtig+" Wörter richtig und "+this.falsch+" Wörter falsch. "+this.ungueltig+" Ihrer Eingaben waren ungültig");
		return fehlerQuote;
	}

	public int getFragen(){
		return this.fragen;
	}

	public int getRichtig(){
		return this.richtig;
	}

	public int getFalsch(){
		return this.falsch;
	}
	
	public int getUngueltig(){
		return this.ungueltig;
	}

	public void addRichtig(int i){
		this.richtig+=i;
	}

	public void addFalsch(int i){
		this.falsch+=i;
	}

}
