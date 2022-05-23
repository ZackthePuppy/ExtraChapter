
package meow;

import java.awt.font.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Meow { // GOODLUCK!

	private static int[][] winCombinations = new int[][] {
			{ 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, // horizontal wins
			{ 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, // vertical wins
			{ 0, 4, 8 }, { 2, 4, 6 } // diagonal wins
	};// PAG-ARALAN NIYO NALANG 'TO, GALING INTERNET EH HAHAHA

	private static JButton buttons[] = new JButton[9]; // create 9 buttons (DUN SA MISMONG LARO TO NA BUTTONS)

	private static void gamePanel() { // DITO MAGSISIMULA YUNG WHOLE CODE NG LARO
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel(); // creating a panel with a box like a tic tac toe board
		panel.setLayout(new GridLayout(3, 3));
		panel.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
		panel.setBackground(Color.white);

		for (int i = 0; i <= 8; i++) { // placing the button onto the board
			buttons[i] = new MyButton();
			panel.add(buttons[i]);
		}

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(500, 500);// set frame size and let teh game begin
	}

	public static int xOrO = 0; // used for counting

	private static class MyButton extends JButton
			implements ActionListener {// creating own button class because JButton sucks:)

		int again = 1000;// set again at 1000 so we don't make the mistake we can play again
		boolean win = false; // there is not a win
		String letter; // x or o

		public MyButton() { // creating blank board
			super();
			letter = " ";
			setFont(new Font("Dialog", 1, 60));
			setText(letter);
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent e) { // placing x or o's
			if ((xOrO % 2) == 0 && getText().equals(" ") && win == false) {
				letter = "X";
				xOrO = xOrO + 1;
				System.out.println(letter + "\n" + xOrO);
			} else if ((xOrO % 2) == 1 && getText().equals(" ") && win == false) {
				letter = "O";
				xOrO = xOrO + 1;
				System.out.println(letter + "\n" + xOrO);
			} // if user does click on a button that is already played, nothing will happen

			setText(letter); // place the x or the o on the actual board

			for (int i = 0; i <= 7; i++) { // check for the winning combinations
				if (buttons[winCombinations[i][0]].getText().equals(buttons[winCombinations[i][1]].getText()) &&
						buttons[winCombinations[i][1]].getText().equals(buttons[winCombinations[i][2]].getText()) &&
						buttons[winCombinations[i][0]].getText() != " ") {// the winning is true
					win = true;
				}
			}

			if (win == true) { // if the game ends let the user know who wins and give option to play again
				again = JOptionPane.showConfirmDialog(null, letter + " wins the game!  Do you want to play again?",
						letter + "won!", JOptionPane.YES_NO_OPTION);

			} else if (xOrO == 9 && win == false) {// tie game, announce and ask if the user want to play again
				again = JOptionPane.showConfirmDialog(null, "The game was tie!  Do you want to play again?",
						"Tie game!", JOptionPane.YES_NO_OPTION);
				win = true;
			}

			if (again == JOptionPane.YES_OPTION && win == true) { // ETO YUNG CODE PAG GUSTO NIYO PA MAGLARO
				clearButtons();
				win = false;
			} else if (again == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Thank you for playing!");
				System.exit(0); // KAPAG AYAW NIYO NA MAGLARO, MAG-KU-QUIT NA
			}

		}

	}

	public static void clearButtons() {

		for (int i = 0; i <= 8; i++) {// clear all 8 buttons
			buttons[i].setText(" ");
		}
		xOrO = 0; // reset the count, INTINDIHIN NIYO NALANG WAHAHA

	}

	public static void main(String[] args) // ETO YUNG MAIN GUI NA GINAWA KO
	{
		for (int z = 0; z <= 999; z++) { // LOOPING PARA BUMALIK SA MAIN GUI PAG NI-CLICK NIYO YUNG HELP AT ABOUT NA
											// OPTION

			Object[] message = {
					"Play",
					"Help", "About", "Exit" }; // ETO YUNG NAKALAGAY SA BUTTON

			int a = JOptionPane.showOptionDialog(null, "Let's Play Tic Tac Toe!", "Welcome!",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, message, message[3]);
			// YUNG message[3] NA NASA DULO, KAYA 3 YAN, KINUHA NIYA YUNG 4 ARRAY NA NASA
			// OBJECT.
			// NAGSIMULA YUNG BILANG SA 0 KAYA HANGGANG 3 LANG YUNG NAKA-DECLARE

			if (a == 0) { // PLAY OPTION

				gamePanel(); // PUPUNTA NA SA MISMONG GAME
				JOptionPane.showMessageDialog(null, "Have fun!", "TIC TAC TOE", JOptionPane.INFORMATION_MESSAGE);
				break; // MAG-E-EXIT NA YUNG MAIN GUI HABANG NAKA-RUN PA YUNG LARO
			}

			else if (a == 1) { // HELP OPTION
				JOptionPane.showMessageDialog(null, "This is a memory and strategy game.\n\n"
						+ "> X is always the first move.\n\n"
						+ "> The first player that can create \n"
						+ "   an 'XXX' or 'OOO' wins.\n\n"
						+ "> You can make an agreement with\n"
						+ "   your opponent if how many scores\n"
						+ "   to win this game.\n\n"
						+ "> Remember your current score.", "TIC TAC TOE", JOptionPane.QUESTION_MESSAGE);
			}

			else if (a == 2) { // ABOUT OPTION
				JOptionPane.showMessageDialog(null, "This game was created by: \n"
						+ "> Aracid, Andy \n"
						+ "> Aquino, Beauwolf \n"
						+ "> Cinto, John Rick \n"
						+ "> Chan, Mike Lemuel \n"
						+ "> Hangsithang, Mark \n"
						+ "> Perino, Mariejoy \n"
						+ "> Viernes, Dominic \n"
						+ "> Viniegra, Jeffrey \n"
						+ "> Zarriz, Benjie", "TIC TAC TOE", JOptionPane.INFORMATION_MESSAGE);
			}

			else { // EXIT OPTION
				JOptionPane.showMessageDialog(null, "Thank you for playing!", "TIC TAC TOE", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}

		}

	}
}