/*
 * This project has two classes (three, if you count the MakeCard.java, for the 
 * graphical user interface), one for the main program , and the other that 
 * deals with making and operating on the bingo card (this is what you are
 * looking at right now.
 */

package bingofinal;

import java.util.ArrayList;

/**
 *
 * @author loop (Jacky Liang Xiao Ming 12455852)
 */

public class Bingo_Card {

	/**
	 * Initializes an instance variable for our bingo card array
	 */
	private int[][]card = new int [5][5]; 	// At home I changed this to private
        
        /**
         * Accessor method that gets the card value
         * @return 
         */
	public int[][] getCard(){
		return card;
	}
        
        /**
         * Method that sets the value of the card
         * @param card 
         */
	public void setCard(int[][] card) {		//Added Setter
		this.card = card;
	}

	/**
	 * A constructor that creates and initializes the bingo card
	 */
	public Bingo_Card(){
		ArrayList<Integer> alreadyUsed = new ArrayList<Integer>(); // Creates a new arrayList called alreadyUsed to store variables already picked
		boolean valid = false; // Initializing a boolean variable called false
		int tmp = 0; // iniializing a temporary int to store values later on

		// The block of code below checks whether or not a variable is already in the array for bingo card.
		for(int row = 0; row <= 4; row++){ // for-loop for the column
			for(int col = 0; col < card.length; col++){ // for-loop for the row
				while(!valid){ // while not valid
					tmp = (int)(Math.random() * 15)+1 + 15 * col; // temporary variables finds a new random variable, depending on which column you are on. Remember that the random integer conditions for the first to fifth columns are different.
					if(!alreadyUsed.contains(tmp)){ // if the temporary variable is not already used
						valid = true; // set valid as true
						alreadyUsed.add(tmp); // add this value into our arrayList called alreadyUsed.
					}
				}
				card[row][col] = tmp; // temporary becomes the i-th row/col
				valid = false; // sets valid as false, restarting the loop above
			}
		}

		card[2][2] = 0; // sets the middle value as 0

	}

	/**
	 * A method that prints out the card
	 */
	public void print_card(){

		String title[] = {"  B  ","  I  ","  N  ","  G  ","  O  "}; // prints out the title of the game
		for(int i = 0; i < title.length; i++){ // run the title title.length times (which in this case is 5
			System.out.print(title[i]); // prints out each individual array
		}
		System.out.println(); // Prints new line

		for(int row = 0; row < card.length; row++){ // for the length of card
			System.out.print("|"); // print out | bars
			for(int col = 0; col < card[row].length; col++){ // for the row length of the card
				System.out.print(card[row][col] + "\t|"); // print out spaces and |
			}
			System.out.println("\n-----------------------------------------"); // prints ou this dividing line thing
		}
	}

	/**
	 * A method that checks to see if the number chosen matches a value on the
	 * card. If there's a match, place a zero on the value of the location.
	 * @param input 
	 */
	public int check_match(int input){ //Changed Return type from void to int to return card position
		int cardPos=0; // Added a card position variable from the in-class app
		for(int row = 0; row <= 4; row++){ // for-loop for the column
			for(int col = 0; col < card.length; col++){ // runs through the columns
				if(card[row][col]==input){ // if the i-th row or i-th column contains the input' value
					card[row][col]=0;
					return cardPos; // card[row][col] becomes 0, effectively meaning that it's "circled"
				}
                                cardPos++; // increment the card position
                        }
		}
		return -1;
	}

	/**
	 * A method that checks to see if a bingo exists. There are 12 total conditions
	 * for BINGO condition. 5 conditions for all horizontal == 0. 5 conditions for
	 * all vertical == 0, and 2 conditions for all diagonal == 0.
	 * @return True or false. If true, in the main function, this wins the game.
	 */
	public boolean check_bingo(){
		if(card[0][0]==0&&card[0][1]==0&&card[0][2]==0&&card[0][3]==0&&card[0][4]==0){ // first row all == 0
			return true;
		}else if(card[1][0]==0&&card[1][1]==0&&card[1][2]==0&&card[1][3]==0&&card[1][4]==0){
			return true;
		}else if(card[2][0]==0&&card[2][1]==0&&card[2][2]==0&&card[2][3]==0&&card[2][4]==0){
			return true;
		}else if(card[3][0]==0&&card[3][1]==0&&card[3][2]==0&&card[3][3]==0&&card[3][4]==0){
			return true;
		}else if(card[4][0]==0&&card[4][1]==0&&card[4][2]==0&&card[4][3]==0&&card[4][4]==0){
			return true;
		}else if(card[0][0]==0&&card[1][0]==0&&card[2][0]==0&&card[3][0]==0&&card[4][0]==0){
			return true;
		}else if(card[0][1]==0&&card[1][1]==0&&card[2][1]==0&&card[3][1]==0&&card[4][1]==0){
			return true;
		}else if(card[0][2]==0&&card[1][2]==0&&card[2][2]==0&&card[3][2]==0&&card[4][2]==0){
			return true;
		}else if(card[0][3]==0&&card[1][3]==0&&card[2][3]==0&&card[3][3]==0&&card[4][3]==0){
			return true;
		}else if(card[0][4]==0&&card[1][4]==0&&card[2][4]==0&&card[3][4]==0&&card[4][4]==0){
			return true;
		}else if(card[0][0]==0&&card[1][1]==0&&card[2][2]==0&&card[3][3]==0&&card[4][4]==0){
			return true;
		}else if(card[4][4]==0&&card[3][3]==0&&card[2][2]==0&&card[1][1]==0&&card[0][0]==0){
			return true;
		}else{ // if none of those conditions are satisfied, then return false.
                    return false;
		}
	}

}
