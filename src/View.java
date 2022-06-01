import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class View extends JFrame {
	
	Controller c;
	
	JFrame scoreFrame;
	JPanel boardPanel, scoreButtonPanel, logoPanel, turnPanel, buttomPanel, scorePanel;
	JLabel iconLabel, turnLabel, playerXScoreLabel, playerOScoreLabel;
	JButton scoreButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton;
	
	public View(Controller c) {
		
		this.c = c;
			
		scoreFrame = new JFrame();
		scorePanel = new JPanel();
		boardPanel = new JPanel(new GridLayout(3,3));
		logoPanel = new JPanel(new FlowLayout());
		scoreButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		turnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10,10));
		buttomPanel = new JPanel(new GridLayout(1,2));
		
		iconLabel = new JLabel(new ImageIcon("tttlogo-1.png"), SwingConstants.CENTER);
		turnLabel = new JLabel("<html>It's <font color=blue><b>X</b></font>'s turn</html>");
		
		playerXScoreLabel = new JLabel("<html>Player <font color=blue><b>X</b></font> score: 0</html>");
		playerOScoreLabel = new JLabel("<html>Player <font color=red><b>O</b></font> score: 0</html>");
		
		scoreButton = new JButton("Score");
		oneButton = new JButton();
		twoButton = new JButton();
		threeButton = new JButton();
		fourButton = new JButton();
		fiveButton = new JButton();
		sixButton = new JButton();
		sevenButton = new JButton();
		eightButton = new JButton();
		nineButton = new JButton();
		
		oneButton.setFont(new Font("Arial", Font.PLAIN, 80));
		twoButton.setFont(new Font("Arial", Font.PLAIN, 80));
		threeButton.setFont(new Font("Arial", Font.PLAIN, 80));
		fourButton.setFont(new Font("Arial", Font.PLAIN, 80));
		fiveButton.setFont(new Font("Arial", Font.PLAIN, 80));
		sixButton.setFont(new Font("Arial", Font.PLAIN, 80));
		sevenButton.setFont(new Font("Arial", Font.PLAIN, 80));
		eightButton.setFont(new Font("Arial", Font.PLAIN, 80));
		nineButton.setFont(new Font("Arial", Font.PLAIN, 80));
		
		scoreButton.addActionListener(c);
		scoreButton.setActionCommand("score");
		
		oneButton.addActionListener(c);
		oneButton.setActionCommand("0");
		
		twoButton.addActionListener(c);
		twoButton.setActionCommand("1");
		
		threeButton.addActionListener(c);
		threeButton.setActionCommand("2");
		
		fourButton.addActionListener(c);
		fourButton.setActionCommand("3");
		
		fiveButton.addActionListener(c);
		fiveButton.setActionCommand("4");
		
		sixButton.addActionListener(c);
		sixButton.setActionCommand("5");
		
		sevenButton.addActionListener(c);
		sevenButton.setActionCommand("6");

		eightButton.addActionListener(c);
		eightButton.setActionCommand("7");

		nineButton.addActionListener(c);
		nineButton.setActionCommand("8");

		boardPanel.add(oneButton);
		boardPanel.add(twoButton);
		boardPanel.add(threeButton);
		boardPanel.add(fourButton);
		boardPanel.add(fiveButton);
		boardPanel.add(sixButton);
		boardPanel.add(sevenButton);
		boardPanel.add(eightButton);
		boardPanel.add(nineButton);
		scoreButtonPanel.add(scoreButton);
		logoPanel.add(iconLabel);
		turnPanel.add(turnLabel);
				
		buttomPanel.add(scoreButtonPanel);
		buttomPanel.add(turnPanel);
		
		scorePanel.add(playerXScoreLabel);
		scorePanel.add(playerOScoreLabel);
		
		scoreFrame.add(scorePanel);
		scoreFrame.setSize(150,80);
		scoreFrame.setResizable(false);
		scoreFrame.setLocationRelativeTo(null);
		
		this.add(boardPanel, BorderLayout.CENTER);
		this.add(logoPanel, BorderLayout.NORTH);
		this.add(buttomPanel, BorderLayout.SOUTH);
		this.setSize(350,450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		c.setView(this);
	}

	private void clearBoard() {
		oneButton.setText("");
		twoButton.setText("");
		threeButton.setText("");
		fourButton.setText("");
		fiveButton.setText("");
		sixButton.setText("");
		sevenButton.setText("");
		eightButton.setText("");
		nineButton.setText("");
		
		turnLabel.setText("<html>It's <font color=blue><b>X</b></font>'s turn!</html>");
	
	}
	
	public void displayWinnerOrDraw(char p, int pXScore, int pOScore) {
		
		if(p == 'X'){
			JOptionPane.showMessageDialog(null, "O won the game!", "Message", JOptionPane.INFORMATION_MESSAGE);
		} else if(p == 'O') {
			JOptionPane.showMessageDialog(null, "X won the game!", "Message", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "It was a draw!", "Message", JOptionPane.INFORMATION_MESSAGE);
		}
		
		playerXScoreLabel.setText("<html>Player <font color=blue><b>X</b></font> score: " + pXScore + "</html>");
		playerOScoreLabel.setText("<html>Player <font color=red><b>O</b></font> score: " + pOScore + "</html>");
		
		clearBoard();
	}

	public void updateBoard(ActionEvent e, int playerTurn) {
		
		JButton b = (JButton)e.getSource();

		if(playerTurn == 1) {
			b.setText("O");
			b.setForeground(Color.red);
			turnLabel.setText("<html>It's <font color=blue><b>X</b></font>'s turn!</html>");
			
		} else {
			b.setText("X");
			b.setForeground(Color.blue);
			turnLabel.setText("<html>It's <font color=red><b>O</b></font>'s turn!</html>");
		}
		
	}

	public void displayScoreFrame() {
		scoreFrame.setVisible(true);
	}

}