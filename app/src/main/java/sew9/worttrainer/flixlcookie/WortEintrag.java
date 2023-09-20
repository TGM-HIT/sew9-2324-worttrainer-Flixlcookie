package sew9.worttrainer.flixlcookie;

public class WortEintrag {

    private String wort;

	private String url;

	/**
	 * Erstellt einen Worteintrag
	 * @param wort String
	 * @param url String
	 */
	public WortEintrag(String wort, String url) {
		setWort(wort);
		setUrl(url);
	}

	/**
	 * Überprüft ob die URL den gegebenen Kriterien entspricht
	 * @param url String
	 * @return boolean
	 */
	public static boolean checkUrl(String url){
		if(url!=null){
			if(url.substring(0, 7).equals("http://") || url.substring(0, 8).equals("https://")){
				for(int zaehler=0;zaehler<url.length();zaehler++){
					if(url.charAt(zaehler)=='.'){
						if((int)url.charAt(zaehler-1)<=90 && (int)url.charAt(zaehler-1)>=65 || (int)url.charAt(zaehler-1)>=97 && (int)url.charAt(zaehler-1)<=122){
							if((int)url.charAt(zaehler+1)<=90 && (int)url.charAt(zaehler+1)>=65 || (int)url.charAt(zaehler+1)>=97 && (int)url.charAt(zaehler+1)<=122){
								return true;
							}else{
								return false;
							}
						}else{
							return false;
						}
					}
				}
				return false;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public void setWort(String wort) throws IllegalArgumentException{
		if(wort.length()>=2){
			this.wort=wort;
		}else{
			throw new IllegalArgumentException("Das Wort ist zu kurz!");
		}
	}

	public void setUrl(String url) throws IllegalArgumentException{
		if(checkUrl(url)){
			this.url=url;
		}else{	
			throw new IllegalArgumentException("Die URL ist nicht zulässig");
		}
	}

	public String getWort() {
		return this.wort;
	}

	public String getUrl() {
		return this.url;
	}

	/**
	 * Gibt Wort und URL als einen String zurück
	 * @return String
	 */
	@Override
	public String toString() {
		String a= new String(this.wort+";"+this.url);
		return a;
	}

}
