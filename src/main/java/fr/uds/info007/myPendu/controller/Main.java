package fr.uds.info007.myPendu.controller;
import fr.uds.info007.myPendu.controller.MyGame;

public class Main {
	
	public Main()
	{
		//Un test
		MyGame newGame = new MyGame();
		newGame.pickMistery();
		newGame.startGame();
		newGame.playLetter('n');
		newGame.playLetter('u');
		newGame.playLetter('l');
		System.out.println(newGame.isGameOver());
		
	}
	
	

}
