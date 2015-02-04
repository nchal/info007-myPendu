package fr.uds.info007.myPendu.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.uds.info007.myPendu.controller.GameEngine;
import fr.uds.info007.myPendu.voice.VoiceRecognizer;

public class GameFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 7257588482880116636L;

	// private static final Map<String, URL> penduImages = new HashMap<String,
	// URL>();
	// static {
	// for (int i = 0; i <= 6; i++) {
	// penduImages.put("img" + i, Thread.currentThread()
	// .getContextClassLoader().getResource("img/pendu" + i));
	// }
	// }

	private List<JLabel> solution;

	private JButton microButton;

	private int tries;

	private JLabel pendu;

	private JPanel solutionPanel;

	private JPanel leftPanel;

	private JPanel mainPanel;

	private GameEngine game;

	private VoiceRecognizer recognizer;

	public GameFrame() {
		super();
		tries = 0;
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

		this.microButton = new JButton(new ImageIcon(Thread.currentThread()
				.getContextClassLoader().getResource("img/micro.png")));

		this.microButton.addActionListener(this);

		this.pendu = new JLabel(new ImageIcon(Thread.currentThread()
				.getContextClassLoader()
				.getResource("img/pendu" + tries + ".png")));

		panelGeneration();

		this.setTitle("My Game - Pendu");

		this.setSize(500, 300);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLocationRelativeTo(null);

		this.setVisible(true);

	}

	private void panelGeneration() {

		this.solutionPanel = new JPanel(new FlowLayout());
		this.leftPanel = new JPanel(new BorderLayout());
		this.mainPanel = new JPanel(new BorderLayout());

		for (JLabel label : solution) {
			this.solutionPanel.add(label);
		}

		this.leftPanel.add(solutionPanel, BorderLayout.NORTH);
		this.leftPanel.add(pendu, BorderLayout.CENTER);

		this.mainPanel.add(leftPanel, BorderLayout.CENTER);
		this.mainPanel.add(microButton, BorderLayout.EAST);

		this.setContentPane(mainPanel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String result = null;

		result = recognizer.listen();

		char letter = JOptionPane.showInputDialog(this,
				"I heard " + result + ". OK ? ", result).charAt(0);

		System.out.println(result);

		switch (game.playLetter(letter)) {
		case CONTINU:
			break;
		case WIN:
			this.pendu.setIcon(new ImageIcon(Thread.currentThread()
					.getContextClassLoader().getResource("img/win.jpg")));
			break;
		case FAIL:
			tries++;
			this.pendu.setIcon(new ImageIcon(Thread.currentThread()
					.getContextClassLoader()
					.getResource("img/pendu" + tries + ".png")));
			break;
		case MAX_TRY_LIMIT:
			this.pendu.setIcon(new ImageIcon(Thread.currentThread()
					.getContextClassLoader().getResource("img/fail.png")));
			break;
		case LETTER_ALREADY_PLAY:
			JOptionPane.showMessageDialog(this, "LETTER ALREADY PLAY");
			break;
		default:
			break;
		}

		// for (JLabel label : solution) {

		String secretWord = game.getSecretWord();

		for (int i = 0; i < secretWord.length(); i++) {

			if ((secretWord.charAt(i)) == letter) {
				solution.get(i).setText(String.valueOf(letter));
			}
		}
		// }
	}

	public static void main(String[] args) {

		new GameFrame();
	}
}
