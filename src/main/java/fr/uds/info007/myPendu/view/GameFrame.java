package fr.uds.info007.myPendu.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.uds.info007.myPendu.controller.GameEngine;
import fr.uds.info007.myPendu.voice.VoiceRecognizer;

public class GameFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 7257588482880116636L;

	private List<JLabel> solution;

	private List<JButton> alphabet;

	private JLabel nbTry;

	private JPanel solutionPanel;

	private JPanel alphabetPanel;

	private JPanel mainPanel;

	private GameEngine game;

	private VoiceRecognizer recognizer;

	public GameFrame() {
		super();
		game = new GameEngine();
		recognizer = new VoiceRecognizer();
		init();
	}

	private void init() {

		String randomWord = game.getSecretWord();

		this.solution = new ArrayList<JLabel>();

		for (int i = 0; i < randomWord.length(); i++) {
			this.solution.add(new JLabel("_"));
		}

		// for (char c : randomWord.length()) {
		//
		// this.solution.add(new JLabel(String.valueOf(c)));
		// }

		this.alphabet = new ArrayList<JButton>();

		for (int i = 65; i <= 90; i++) {

			this.alphabet.add(new JButton(String.valueOf((char) i)));
		}

		this.nbTry = new JLabel("5");

		panelGeneration();

		this.setTitle("My Game - Pendu");

		this.setSize(500, 300);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLocationRelativeTo(null);

		this.setVisible(true);

	}

	private void panelGeneration() {

		this.solutionPanel = new JPanel(new FlowLayout());

		this.alphabetPanel = new JPanel(new GridLayout(3, 7));

		this.mainPanel = new JPanel(new BorderLayout());

		for (JLabel label : solution) {

			this.solutionPanel.add(label);
		}

		for (JButton button : alphabet) {

			this.alphabetPanel.add(button);
			button.addActionListener(this);
		}

		this.mainPanel.add(solutionPanel, BorderLayout.NORTH);

		this.mainPanel.add(alphabetPanel, BorderLayout.SOUTH);

		this.setContentPane(mainPanel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// char c = ((JButton) e.getSource()).getText().toCharArray()[0];
		// c = Character.toLowerCase(c);

		String result = recognizer.listen();

		int confirm = JOptionPane.showConfirmDialog(null, "Did you say "
				+ result + " ?");

		// switch (game.playLetter(c)) {
		// case CONTINU:
		// break;
		// case WIN:
		// JOptionPane.showMessageDialog(null, "WIN");
		// break;
		// case MAX_TRY_LIMIT:
		// JOptionPane.showMessageDialog(null, "NO MOrE TRY");
		// break;
		// case LETTER_ALREADY_PLAY:
		// JOptionPane.showMessageDialog(null, "LETTER ALREADY PLAY");
		// break;
		// default:
		// break;
		// }
		//
		// for (JLabel label : solution) {
		//
		// String secretWord = game.getSecretWord();
		//
		// for (int i = 0; i < secretWord.length(); i++) {
		//
		// if ((secretWord.charAt(i)) == c) {
		// solution.get(i).setText(String.valueOf(c));
		// }
		// }
		// }
	}

	public static void main(String[] args) {

		new GameFrame();
	}
}
