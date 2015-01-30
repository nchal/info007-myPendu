package fr.uds.info007.myPendu.voice;

public class Main {

	public static void main(String[] args) {

		VoiceRecognizer recognizer = new VoiceRecognizer();

		System.out.println(recognizer.listen());
	}

}
