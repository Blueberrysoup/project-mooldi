package se.mooldi.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import se.mooldi.otherclasses.Game;
import se.mooldi.otherclasses.Player;

public class MainFrame {

	private JFrame frmMooldi;
	private JTextField textFieldName;
	private JButton btnMulti;
	private JButton btnDivision;
	private JPanel startPage = new JPanel();
	private JPanel multiPage = new JPanel();
	private JLabel lblHejNamn;
	private Player player = new Player();
	private Game game = new Game();
	private JButton btnSluta;
	private JLabel lblXTalet;
	private JTextField textFieldSvar;
	private JLabel labelCurrPoints;
	private JLabel labelCompleted;
	private JButton btnNstaTal;
	private JLabel labelResultCorrect;
	private JLabel labelResultError;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frmMooldi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		createGUI();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createGUI() {
		//Frame
		frmMooldi = new JFrame();
		frmMooldi.setTitle("MOOLDI");
		frmMooldi.setBounds(100, 100, 750, 600);
		frmMooldi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMooldi.getContentPane().setLayout(new CardLayout(0, 0));
		
		//Pages
		startPage.setBackground(Color.CYAN);
		frmMooldi.getContentPane().add(startPage, "name_23428416361482");
		startPage.setLayout(null);
		
		multiPage.setBackground(Color.ORANGE);
		frmMooldi.getContentPane().add(multiPage, "name_23490729527832");
		multiPage.setLayout(null);
		
		createStartPageGUI();
		createMultiPageGUI();	//TODO - flytta ner till onClickMulti?
		
	}
	
	public void createStartPageGUI(){
		//Labels - text fields
		JLabel lblVlkommenTill = new JLabel("Välkommen till");
		lblVlkommenTill.setBounds(325, 91, 103, 15);
		startPage.add(lblVlkommenTill);
		
		JLabel lblMooldi = new JLabel("MOOLDI");
		lblMooldi.setFont(new Font("Century Schoolbook L", Font.BOLD, 60));
		lblMooldi.setBounds(239, 105, 355, 62);
		startPage.add(lblMooldi);
		
		JLabel lblSkrivDittNamn = new JLabel("Skriv ditt namn:");
		lblSkrivDittNamn.setBounds(247, 243, 128, 15);
		startPage.add(lblSkrivDittNamn);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(379, 241, 114, 19);
		startPage.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblVljVadDu = new JLabel("Välj vad du vill träna på:");
		lblVljVadDu.setBounds(287, 363, 209, 15);
		startPage.add(lblVljVadDu);

		//Buttons
		btnMulti = new JButton("Multiplikation");
		btnMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickMulti();
			}
		});
		
		btnMulti.setBounds(192, 397, 143, 25);
		startPage.add(btnMulti);
		
		btnDivision = new JButton("Division");
		btnDivision.setBounds(404, 397, 143, 25);
		startPage.add(btnDivision);
	}

	public void createMultiPageGUI(){
		//Labels - text fields
		lblHejNamn = new JLabel();
		lblHejNamn.setBounds(41, 43, 315, 15);
		multiPage.add(lblHejNamn);
		
		labelCurrPoints = new JLabel("0");
		labelCurrPoints.setBounds(75, 410, 500, 15);
		multiPage.add(labelCurrPoints);		

		labelCompleted = new JLabel("0");
		labelCompleted.setBounds(75, 445, 500, 15);
		multiPage.add(labelCompleted);

		lblXTalet = new JLabel();
		lblXTalet.setHorizontalAlignment(SwingConstants.CENTER);
		lblXTalet.setFont(new Font("Dialog", Font.BOLD, 32));
		lblXTalet.setBounds(288, 137, 133, 79);
		multiPage.add(lblXTalet);
		
		textFieldSvar = new JTextField();
		textFieldSvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onAnswering();
			}
		});
		textFieldSvar.setBounds(298, 210, 138, 36);
		multiPage.add(textFieldSvar);
		textFieldSvar.setColumns(10);
		
		labelResultCorrect = new JLabel("RÄTT SVAR!!");
		labelResultCorrect.setFont(new Font("Dialog", Font.BOLD, 32));
		labelResultCorrect.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultCorrect.setBounds(130, 287, 509, 40);
		multiPage.add(labelResultCorrect);
		
		labelResultError = new JLabel("Tyvärr var det fel svar - försök igen!");
		labelResultError.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultError.setBounds(120, 275, 509, 15);
		multiPage.add(labelResultError);

		//Button
		btnSluta = new JButton("Sluta spela och spara poängen");
		btnSluta.setBounds(420, 496, 255, 25);
		multiPage.add(btnSluta);
		
		btnNstaTal = new JButton("Nästa tal");
		btnNstaTal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runGame();
			}
		});
		btnNstaTal.setBounds(512, 215, 117, 25);
		multiPage.add(btnNstaTal);
		
		
	}
	
	public void onAnswering(){
		if (game.checkAnswer(Integer.parseInt(textFieldSvar.getText())) == true){
				player.increasePoints();
				labelResultCorrect.setVisible(true);
				labelCurrPoints.setText("Du har haft " + player.getPoints() + " rätta svar den här spelomgången.");				
		} else {
			labelResultError.setVisible(true);
		}
	}
	
	public void runGame(){
		labelResultCorrect.setVisible(false);
		labelResultError.setVisible(false);
		textFieldSvar.setText("");
		lblXTalet.setText(game.runGame());
	}
	
	public void onClickMulti(){
		player.setName(textFieldName.getText());
		game.setGameType("Mult");
		game.newMultArray();
		
		lblHejNamn.setText("Hej " + textFieldName.getText() + "!");
		labelCurrPoints.setText("Du har haft " + player.getPoints() + " rätta svar den här spelomgången.");
		labelCompleted.setText("Du har klarat av " + player.getCompleted() + " av 156 tal.");
		
		//createMultiPageGUI();     //TODO - flytta från konstruktorn
		startPage.setVisible(false);
		multiPage.setVisible(true);
		
		runGame();
	}
}
