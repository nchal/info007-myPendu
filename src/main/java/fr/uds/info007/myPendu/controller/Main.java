package fr.uds.info007.myPendu.controller;
import fr.uds.info007.myPendu.controller.MyGame;

public class Main {
	
	public static void main(String[] args)
	{
		//Un test
		MyGame newGame = new MyGame();
		newGame.startGame();
		newGame.playLetter('o');
		newGame.playLetter('e');
		newGame.playLetter('l');
		newGame.playLetter('t');
		System.out.println(newGame.isGameOver());
		
	}
}
