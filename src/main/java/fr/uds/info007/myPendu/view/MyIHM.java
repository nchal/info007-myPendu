package fr.uds.info007.myPendu.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyIHM extends JFrame {

	private static final long serialVersionUID = 7257588482880116636L;
	
	private List<JLabel> solution;
	
	private List<JButton> alphabet;
	
	private JLabel nbTry;
	
	private JPanel solutionPanel;
	
	private JPanel alphabetPanel;
	
	private JPanel mainPanel;
	
	public MyIHM() {
		super();
		init();
	}

	private void init() {

		String randomWord = "telephone";
		
		this.solution = new ArrayList<JLabel>();
		
		for (char c : randomWord.toCharArray()) {
			
			this.solution.add(new JLabel(String.valueOf(c)));
		}
		
		this.alphabet = new ArrayList<JButton>();
		
		for(int i = 65; i <= 90; i++ ) {
			
			this.alphabet.add(new JButton(String.valueOf((char) i)));
		}
		
		this.nbTry = new JLabel("5");
		
		panelGeneration();
		
		this.setTitle("My Game - Pendu");
		
	    this.setSize(500,300);
	    
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
		}
		
		this.mainPanel.add(solutionPanel,BorderLayout.NORTH);
		
		this.mainPanel.add(alphabetPanel, BorderLayout.SOUTH);
		
		this.setContentPane(mainPanel);
		
	}
	
	
	public static void main(String[] args) {
		
		new MyIHM();
	}
}
