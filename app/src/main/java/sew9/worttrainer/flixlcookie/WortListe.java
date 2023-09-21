package sew9.worttrainer.flixlcookie;

/**
 * Eine Wortliste
 * @author Felix Warmuth
 * @version 20.09.2023
 */
public class WortListe {

	private WortEintrag[] wortliste;

	/**
	 * erstellt ein Objekt Wortliste
	 */
	public WortListe() {
		this.wortliste= new WortEintrag[1];
	}

	/**
	 * fügt einen Worteintrag zu Wortliste hinzu
	 * @param wort Worteintrag
	 */
	public void addWort(WortEintrag wort) {
		boolean end=false;
		while(!end){
			for(int zaehler=0;zaehler<this.wortliste.length;zaehler++){
				if(this.wortliste[zaehler]==null){
					this.wortliste[zaehler]=wort;
					end=true;
				}
			}
			if(!end){
				WortEintrag[] a=new WortEintrag[this.wortliste.length+1];
				for(int x=0;x<this.wortliste.length;x++){
					a[x]=this.wortliste[x];
				}
				this.wortliste= a;
				for(int zaehler2=0;zaehler2<this.wortliste.length;zaehler2++){
					if(this.wortliste[zaehler2]==null){
						this.wortliste[zaehler2]=wort;
						end=true;
					}
				}
			}
		}
		
	}

	public WortEintrag getWort(int index) {
		return this.wortliste[index];
	}

	public int getLength(){
		return this.wortliste.length;
	}

	/**
	 *  Löscht das übergebene Wort aus der Wortliste
	 * @param wort String
	 * @return boolean
	 */
	public boolean deleteWord(String wort) {
		for(int index=0;index<this.wortliste.length;index++){
			if(this.wortliste[index].getWort().equals(wort)){
				this.wortliste[index]=null;
				return true;
			}
		}
		return false;
	}

	/**
	 * Fügt die Wortliste zu einem String zusammen
	 * @return String
	 */
	@Override
	public String toString() {
		String a= new String("");
		for(int index=0;index<this.wortliste.length;index++){
			if(this.wortliste[index]!=null){
				a=a+this.wortliste[index].toString()+"\n";
			}
		}
		return a;
	}

}