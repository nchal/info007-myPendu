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
	}
	
	public void pickMistery()
	{
		//TODO : Dictionnaire
		motMystere = "null";
	}
	
	public void startGame()
	{
		//TODO : Launch IHM
	}
	
	//A invoqué à chaque choix d'une lettre
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
	

	
}
