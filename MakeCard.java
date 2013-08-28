/** This is the MakeCard.java file. In order to run the graphical user interface program, make sure you also
 * have the Bingo_Card.java and BINGOFINAL.java, or this WILL NOT WORK, as you need ALL THREE FILES TO RUN.
 * 
 * PLEASE READ: According to the specifications, the cell numbers MUST be in Times New Roman (according to the
 * criteria sheet), however, looking at the GUI example on the second page, the font used there is actually Arial,
 * because the font there is non-serif (with Times New Roman being a serif font). In my code here, I made the cell 
 * numbers as Times New Roman and the title as Arial, which corresponds to the criteria sheet.
**/

package bingofinal;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.GridLayout;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 *
 * @author loop (Jacky Liang Xiao Ming 12455852)
 */

class Cell extends JPanel // This class represents a cell in the Bingo game.
{
	/**
         * Unique integer identifier starts from 0
         */
	private int cellNo;

	/**
         * Constructor that assigns ID to a cell
         * @param num 
         */
	public Cell(String num)
	{
		JTextPane tp = new JTextPane();	// This TextPane has the numbers inside
		tp.setText(num); // Set the cell value
		tp.setBounds(30, 20, 31, 34); // Set the TextPane size and location in parent container
		tp.setBackground(Color.WHITE);	// Set background to white
		tp.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Sets font the 24, bold, and Times New Roman. 
		setSize(80, 80); // Set the cell size
		setBackground(new Color(255,255,255));	//Set the cell background to white
		setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK)); // Set the cell border
		setLayout(null);
		add(tp); // Add the TextPane
		setVisible(true); // Make it visible
	}
        
        /**
         * Method that draws a circle over the number
         */
	public void animate(){
		Graphics2D g=(Graphics2D)getGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);	// Draws anti-aliased shapes (makes the circles look good
		g.setColor(Color.red); //Sets the color as red
		g.fillOval(7, 7, 65, 65); // Draws the circle
	}
        
        /**
         * Accessor method that gets the cell number
         * @return cell number
         */
	public int getCellNo(){
		return cellNo;
	}
        
        /**
         * Method that sets the cell number
         * @param cellNo 
         */
	public void setCellNo(int cellNo){
		this.cellNo = cellNo;
	}
}

public class MakeCard{

	private JFrame frame; // Parent frame
	private JTextField textField; // The text field in which user enters a number
	
	public static void main(String[] args){
            EventQueue.invokeLater(new Runnable(){
                public void run(){
                    try{ // tries doing the things below. If there is an error, catch it.
                        MakeCard window = new MakeCard();
                        window.frame.setVisible(true);
                    }catch (Exception e) { // catches errors and prints it
                        e.printStackTrace();
                    }
                }
            });
        }

	/**
	 * Constructor that creates the application
	 */
	public MakeCard(){
		initialize();
	}

	/**
	 * Method that initializes the contents of the JFrame.
	 */
	private void initialize(){
		frame = new JFrame(); // Initializes the frame
		frame.getContentPane().setBackground(Color.WHITE); // sets parent pane background color to white
		frame.setBounds(100, 100, 450, 574); // Sets the size and position
		frame.setTitle("BINGO Card"); // Sets title according to specifications
		frame.setBackground(Color.WHITE); // Sets the background color to white
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		/**
		 * Inner Panel which has all the cards 400*400
		 */
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 80, 400, 400);
		frame.getContentPane().add(panel);

		panel.setLayout(new GridLayout(5, 5)); // Sets the GridLayout of 5x5

		/**
		 * Bottom most panel to hold the TextBox and the button
		 */
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 491, 400, 34);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		// Goes to panel_1
		JTextPane txtpnEnterANumber = new JTextPane();
		txtpnEnterANumber.setBounds(0, 0, 106, 23);
		txtpnEnterANumber.setText("Enter a Number");
		panel_1.add(txtpnEnterANumber);
		
		// Goes to panel_1
		textField = new JTextField();
		textField.setBounds(116, 3, 45, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		// Goes to panel_1
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(171, 0, 89, 23);
		panel_1.add(btnSubmit);

		/**
		 * Top most panel to hold the panels having words B, I, N, G, O
		 */
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 400, 58);
		panel_2.setLayout(new GridLayout(1, 5, 0, 0));
		panel_2.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_2);
		
		//This holds txtpnB having B
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_2.add(panel_3);
		
		JTextPane txtpnB = new JTextPane();
		txtpnB.setForeground(Color.BLUE);
		txtpnB.setFont(new Font("Arial", Font.BOLD, 44)); // Arial font, bold, and size 44
		txtpnB.setText("B");
		panel_3.add(txtpnB);
		
		//This holds txtpnI having I
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_2.add(panel_4);
		
		JTextPane txtpnI = new JTextPane();
		txtpnI.setForeground(Color.BLUE);
		txtpnI.setFont(new Font("Arial", Font.BOLD, 44)); // Arial font, bold, and size 44
		txtpnI.setText("I");
		panel_4.add(txtpnI);
		
		//This holds txtpnN having N
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_2.add(panel_5);
		
		JTextPane txtpnN = new JTextPane();
		txtpnN.setForeground(Color.BLUE);
		txtpnN.setFont(new Font("Arial", Font.BOLD, 44)); // Arial font, bold, and size 44
		txtpnN.setText("N");
		panel_5.add(txtpnN);
		
		//This holds txtpnG having G
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_2.add(panel_6);
		
		JTextPane txtpnG = new JTextPane();
		txtpnG.setForeground(Color.BLUE);
		txtpnG.setFont(new Font("Arial", Font.BOLD, 44)); // Arial font, bold, and size 44
		txtpnG.setText("G");
		panel_6.add(txtpnG);
		
		//This holds txtpnO having O
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_2.add(panel_7);
		
		JTextPane txtpnO = new JTextPane();
		txtpnO.setForeground(Color.BLUE);
		txtpnO.setFont(new Font("Arial", Font.BOLD, 44)); // Arial font, bold, and size 44
		txtpnO.setText("O");
		panel_7.add(txtpnO);


		final HashMap<Integer, Cell> cells=new HashMap<Integer, Cell>(); // A hashmap to store all cells with a unique index of 0 to 24. This makes sure there are no repeating values (recall in Discrete Mathematics, a set does not contain repeating values. This is what a hashmap does)

		final Bingo_Card b = new Bingo_Card();

		int[][] cards = b.getCard(); // Get the randomized 2D Array

		int cellCounter=0; // Initializing the cell counter

		// Creates the cells and increments/counts them
		for(int i=0;i<cards.length;i++){
			for(int j=0;j<cards[0].length;j++){
				Cell c=new Cell(String.valueOf(cards[i][j])); // Create a cell for the current array element
				c.setCellNo(cellCounter); // Give a counter to this cell
				panel.add(c); // Adds it to 5x5 grid
				cells.put(cellCounter, c); //Put in the HashMap with the same id to make sure no values are repeated
				cellCounter++; //increment the counter by 1
			}
		}
		
		btnSubmit.addActionListener(new ActionListener() { // Add ActionListener

			/**
			 * This will be called each time we click on the Submit Button
			 */
			public void actionPerformed(ActionEvent e){
                            int input=Integer.parseInt(textField.getText()); // Gets the entered number
                            int cardPos=b.check_match(input); // Call check_match to get the index
                            if(cardPos == -1){
                                JOptionPane.showMessageDialog(frame, "Sorry, no match.");
                            }else{
                                cells.get(cardPos).animate();
                                if(b.check_bingo()){
                                    JOptionPane.showMessageDialog(frame, "BINGO!"); // Shows winning message
                                }else{
                                    textField.setText(""); // Empty the TextField
                                }
                            }
                        }
                });
	}
}