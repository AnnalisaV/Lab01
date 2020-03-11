package it.polito.tdp.parole.model;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Parole{
	
	private List<String> listaParole; 
	
	public Parole() {
	
		listaParole= new LinkedList<String>(); 
	}
	
	public void addParola(String p) throws EccezioneParolaVuota{
		
		// controllo che non abbia lasciato la casella vuota
		if (p.length()!=0)
		listaParole.add(p);
		
		else {
			throw new EccezioneParolaVuota(); 
		}
		
	}
	
	public List<String> getElenco() {
		
		Collections.sort(listaParole);
		return listaParole;
	}
	
	public void reset() {
		listaParole.removeAll(getElenco());
	}



}
