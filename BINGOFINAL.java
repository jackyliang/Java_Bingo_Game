/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bingofinal;

import java.util.Scanner;

/**
 *
 * @author loop (Jacky Liang Xiao Ming 12455852)
 */
public class BINGOFINAL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bingo_Card newCard = new Bingo_Card(); // new object with the name newCard, calling the Bingo_Card class
        newCard.print_card(); // new bingo board
        System.out.println("Welcome to Jacky's Bingo Game");
        
        Scanner newInput = new Scanner(System.in); // input object
        while(!newCard.check_bingo()){ // while check_bingo() is not true, run this block of code
            System.out.print("Enter Next Bingo Number: "); // asks user for input
            int input = newInput.nextInt(); // checks for next int
            newCard.check_match(input); // check_match takes in an "input" value from the user, which checks whether or not there is a match
            newCard.print_card(); // prints out the updated board
        }
        // I have taken this ASCII message from Bingo_Card and put it outside the while-loop. It was entirely unnecessary to have it inside each
        // else-if statement. I hope I didn't change the requirements of the original code too much. Let me know if I did change it too much
        // I don't think I did.
        System.out.println("'||' '|'  ..|''||   '||'  '|'    '|| '||'  '|' '||' '|.   '|'"); // Celebratory message
	System.out.println("  || |   .|'    ||   ||    |      '|. '|.  .'   ||   |'|   |  "); // Celebratory message
	System.out.println("   ||    ||      ||  ||    |       ||  ||  |    ||   | '|. |"); // Celebratory message
	System.out.println("   ||    '|.     ||  ||    |        ||| |||     ||   |   ||| "); // Celebratory message
	System.out.println("  .||.    ''|...|'    '|..'          |   |     .||. .|.   '|  "); // Celebratory message
    }
}
