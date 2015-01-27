package fr.uds.info007.myPendu.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class MyGame {
	
	private String motMystere;
	private int nbChance;
	private List<Character> lettersUsed;
	private int nbLetterGuess; //Nombre de lettre devinées
	
	public MyGame(){
		nbChance = 0;
		lettersUsed = new ArrayList<Character>();
		nbLetterGuess = 0;
		pickMistery();
		
	}
	
	private void pickMistery()
	{
		//TODO : Dictionnaire
		motMystere = "totole";
	}
	
	public void startGame()
	{
		//TODO : Launch IHM
	}
	
	//A invoquer à chaque choix d'une lettre
	public void playLetter(Character ch) 
	{
		if(lettersUsed.contains(ch))
		{
			//Afficher "lettre déjà utilisée dans l'ihm ou enlever le bouton
			//Mais dans le cas de la voix on peut pas prévoir
			throw new IllegalArgumentException();
		}
		
		Boolean fault = true;
		lettersUsed.add(ch);
		for (int i=0; i<motMystere.length();i++)
		{
			if (motMystere.charAt(i) == ch)
			{
				nbLetterGuess++;
				fault= false;
				//TODO : Afficher la lettre dans la case i sur l'ihm
			}
		}
		if (fault)
		{
			nbChance++;
		}
		
	}
	
	//A invoquer à chaque lettre jouée
	public boolean isGameOver()
	{
		return (nbLetterGuess==motMystere.length());
	}

	public String getMotMystere() {
		return motMystere;
	}

	public void setMotMystere(String motMystere) {
		this.motMystere = motMystere;
	}

	public int getNbChance() {
		return nbChance;
	}

	public void setNbChance(int nbChance) {
		this.nbChance = nbChance;
	}

	public List<Character> getLettersUsed() {
		return lettersUsed;
	}

	public void setLettersUsed(List<Character> lettersUsed) {
		this.lettersUsed = lettersUsed;
	}

	public int getNbLetterGuess() {
		return nbLetterGuess;
	}

	public void setNbLetterGuess(int nbLetterGuess) {
		this.nbLetterGuess = nbLetterGuess;
	}

	@Override
	public String toString() {
		return "MyGame [motMystere=" + motMystere + ", nbChance=" + nbChance
				+ ", lettersUsed=" + lettersUsed + ", nbLetterGuess="
				+ nbLetterGuess + "]";
	}
}
