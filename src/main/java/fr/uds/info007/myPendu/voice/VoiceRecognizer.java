package fr.uds.info007.myPendu.voice;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import edu.cmu.sphinx.util.props.PropertyException;

public class VoiceRecognizer {

	private ConfigurationManager manager;

	private Recognizer recognizer;

	private Microphone microphone;

	public VoiceRecognizer() {

		System.out.println("Loading...");

		try {
			manager = new ConfigurationManager(Thread.currentThread()
					.getContextClassLoader().getResource("game.config.xml"));

			recognizer = (Recognizer) manager.lookup("recognizer");
			recognizer.allocate();

			microphone = (Microphone) manager.lookup("microphone");

		} catch (PropertyException e) {
			System.out.println("Fail Loading...");
			e.printStackTrace();
		}
	}

	public String listen() {

		if (!microphone.isRecording()) {
			microphone.startRecording();
		}

		// if (microphone.startRecording()) {
		Result result = recognizer.recognize();

		if (result != null) {
			microphone.stopRecording();
			return result.getBestFinalResultNoFiller();
		} else {
			System.out.println("I can't hear what you said.\n");
			microphone.stopRecording();
			return null;
		}

		// } else {
		// System.out.println("Cannot start microphone.");
		// return null;
		// }

	}
}
