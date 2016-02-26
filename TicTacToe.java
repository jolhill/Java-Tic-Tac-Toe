/*
 * Programmed by Joshua Hill
 * Created 2/25/16
 * A Simple Tic-Tac-Toe Game
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class TicTacToe extends JFrame {
	
	private Container contents;
	private int iPlayerTurn;
	private int [] aBoard = new int[9];
	ButtonHandler bh;
	
	public TicTacToe(){
		super("Tic-Tac-Toe");
		
		contents = getContentPane();
		
		contents.setLayout(new GridLayout(3,3));
		
		bh = new ButtonHandler();
		
		iPlayerTurn = 1;
		//instantiates buttons
		
		for(int i = 0; i < 9; i++){
			JButton button = new JButton();
			button.setFont(new Font("Arial", Font.PLAIN, 60));
			button.addActionListener(bh);
			contents.add(button);
		}
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
	}
	
	private int getButtonNumber(JButton b){
		int iOut = 0;
		for(int i = 0; i < 9; i++){
			if(((JButton)contents.getComponent(i)).equals(b)){
				iOut = i;
				break;
			}
		}
		return iOut;
	}
	
	private void played(JButton button){
		aBoard[getButtonNumber(button)] = getTurn();
		if(getTurn() == 1){
			button.setText("X");
		}
		else{
			button.setText("O");
		}
		switchTurn();
	}
	
	private void switchTurn(){
		if(iPlayerTurn == 1){
			iPlayerTurn = 2;
		}
		else{
			iPlayerTurn = 1;
		}
	}
	
	private int getTurn(){
		return iPlayerTurn;
	}
	//Runs every turn to determine if there is a winner
	private String hasWinner(){
		if((aBoard[0]==1&&aBoard[1]==1&&aBoard[2]==1))
			return "Player 1";
		else if((aBoard[3]==1&&aBoard[4]==1&&aBoard[5]==1))
			return "Player 1";
		else if((aBoard[6]==1&&aBoard[7]==1&&aBoard[8]==1))
			return "Player 1";
		else if((aBoard[0]==1&&aBoard[3]==1&&aBoard[6]==1))
			return "Player 1";
		else if((aBoard[1]==1&&aBoard[4]==1&&aBoard[7]==1))
			return "Player 1";
		else if((aBoard[2]==1&&aBoard[5]==1&&aBoard[8]==1))
			return "Player 1";
		else if((aBoard[0]==1&&aBoard[4]==1&&aBoard[8]==1))
			return "Player 1";
		else if((aBoard[2]==1&&aBoard[4]==1&&aBoard[6]==1))
			return "Player 1";
		
		else if((aBoard[0]==2&&aBoard[1]==2&&aBoard[2]==2))
			return "Player 2";
		else if((aBoard[3]==2&&aBoard[4]==2&&aBoard[5]==2))
			return "Player 2";
		else if((aBoard[6]==2&&aBoard[7]==2&&aBoard[8]==2))
			return "Player 2";
		else if((aBoard[0]==2&&aBoard[3]==2&&aBoard[6]==2))
			return "Player 2";
		else if((aBoard[1]==2&&aBoard[4]==2&&aBoard[7]==2))
			return "Player 2";
		else if((aBoard[2]==2&&aBoard[5]==2&&aBoard[8]==2))
			return "Player 2";
		else if((aBoard[0]==2&&aBoard[4]==2&&aBoard[8]==2))
			return "Player 2";
		else if((aBoard[2]==2&&aBoard[4]==2&&aBoard[6]==2))
			return "Player 2";
		
		else
			return "";	
	}
	
	//Logic to decide if there is a winner, and if so, who
	private void setWinner(String winner){
		JButton middle = (JButton) contents.getComponent(4);
		middle.setFont(new Font("Arial", Font.PLAIN, 15));
		middle.setText("Winner: " + winner);
		for(int i = 0; i < 9; i ++){
			JButton b = (JButton) contents.getComponent(i);
			b.setBackground(Color.GREEN);
			b.removeActionListener(bh);
		}
	}
	
	//Used to determine ties
	private boolean isFull(){
		for(int i = 0;i<9;i++){
			if(!(aBoard[i]==1 || aBoard[i] == 2)){
				return false;
			}
		}
		return true;
	}
	
	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			played(button);
			String state = hasWinner();
			if(state.length() > 0){
				setWinner(state);
			}
			else if(isFull()){
				JButton middle = (JButton) contents.getComponent(4);
				middle.setFont(new Font("Arial", Font.PLAIN, 30));
				middle.setText("TIE!");
				for(int i = 0; i < 9; i ++){
					JButton b = (JButton) contents.getComponent(i);
					b.setBackground(Color.YELLOW);
					b.removeActionListener(bh);
				}
			}
			
		}
		
	}

	
	
}
