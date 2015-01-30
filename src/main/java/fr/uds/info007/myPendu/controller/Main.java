package fr.uds.info007.myPendu.controller;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		GameEngine game = new GameEngine();

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println(game.playLetter(sc.nextLine().charAt(0)));

			System.out.println(game);
		}
	}

}
