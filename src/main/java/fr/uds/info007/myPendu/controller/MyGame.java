package fr.uds.info007.myPendu.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Stream;

public class MyGame {
	
	private final int LIMITTRY = 7;
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
		//motMystere = "totole";
		URL path = Thread.currentThread().getContextClassLoader().getResource("dictionnaire.txt");
		//String path = "/src/main/Resources/dictionnaire.txt";
		String line;
		int nbre = (int)(Math.random()*336529);
		try {
			BufferedReader buff = new BufferedReader(new FileReader(path.getPath()));
			try {
				for(int i=0; i< nbre;i++) {
					line = buff.readLine();
				}
				motMystere=buff.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(motMystere);
		
	}
	
	//A invoquer à chaque choix d'une lettre
	public int playLetter(Character ch) 
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
	return isGameOver();
	}
	
	//A invoquer à chaque lettre jouée
	//0 perdu 1 gagné -1 continue
	public int isGameOver()
	{
		if (nbChance>LIMITTRY)
		{
			return 0;
		}
		else if (nbLetterGuess==motMystere.length())
		{
			return 1;
		}
		else
		{
			return -1;
		}
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
