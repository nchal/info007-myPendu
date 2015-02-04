package fr.uds.info007.myPendu.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.Normalizer;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {

	private final int LIMIT_TRY = 6;

	private String secretWord;

	private String lettersThrown;

	private String currentWord;

	private int tries;

	private List<Character> lettersUsed;

	private int nbLetterGuess;

	public GameEngine() {
		lettersThrown = "";
		tries = 0;
		lettersUsed = new ArrayList<Character>();
		nbLetterGuess = 0;
		pickMistery();

	}

	private void pickMistery() {

		int pickedLine = (int) (Math.random() * 336531);

		try (BufferedReader reader = new BufferedReader(new FileReader(
				new File(Thread.currentThread().getContextClassLoader()
						.getResource("dictionnaire.txt").toURI())))) {

			int i = 0;
			while (i != pickedLine) {
				reader.readLine();
				i++;
			}

			// secretWord = DIACRITICS_AND_FRIENDS
			// .matcher(
			// Normalizer.normalize(reader.readLine(),
			// Normalizer.Form.NFD)).replaceAll("");

			secretWord = Normalizer.normalize(reader.readLine(),
					Normalizer.Form.NFD).replaceAll("[\u0300-\u036F]", "");

			// secretWord = Normalizer.normalize(reader.readLine(),
			// Normalizer.Form.NFD);

			currentWord = secretWord.replaceAll(".", " ");

			// StringBuilder builder = new StringBuilder(secretWord.length());
			// currentWord = builder.toString();

			System.out.println(secretWord);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public ReturnType playLetter(char letterPlay) {

		if (currentWord.contains(String.valueOf(letterPlay))
				|| lettersThrown.contains(String.valueOf(letterPlay))) {
			return ReturnType.LETTER_ALREADY_PLAY;
		}

		if (secretWord.contains(String.valueOf(letterPlay))) {

			StringBuilder builder = new StringBuilder(currentWord);

			for (int i = 0; i < secretWord.length(); i++) {

				if ((secretWord.charAt(i)) == letterPlay) {
					builder.setCharAt(i, letterPlay);
				}
			}

			currentWord = builder.toString();
			return isGameOver(letterPlay);

		} else {

			tries++;
			lettersThrown += letterPlay;
			return isGameOver(letterPlay);
		}
	}

	private ReturnType isGameOver(char letterPlay) {

		if (tries > LIMIT_TRY) {
			return ReturnType.MAX_TRY_LIMIT;
		} else if (currentWord.equals(secretWord)) {
			return ReturnType.WIN;
		} else if (lettersThrown.contains(String.valueOf(letterPlay))) {
			return ReturnType.FAIL;
		} else {
			return ReturnType.CONTINU;
		}
	}

	public String getSecretWord() {
		return secretWord;
	}

	public void setSecretWord(String motMystere) {
		this.secretWord = motMystere;
	}

	public int getTries() {
		return tries;
	}

	public void setTries(int nbChance) {
		this.tries = nbChance;
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

	public String getLettersThrown() {
		return lettersThrown;
	}

	public void setLettersThrown(String lettersThrown) {
		this.lettersThrown = lettersThrown;
	}

	public String getCurrentWord() {
		return currentWord;
	}

	public void setCurrentWord(String currentWord) {
		this.currentWord = currentWord;
	}

	@Override
	public String toString() {
		return "GameEngine [LIMIT_TRY=" + LIMIT_TRY + ", secretWord="
				+ secretWord + ", lettersThrown=" + lettersThrown
				+ ", currentWord=" + currentWord + ", tries=" + tries
				+ ", lettersUsed=" + lettersUsed + ", nbLetterGuess="
				+ nbLetterGuess + "]";
	}
}
