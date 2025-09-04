package atu.ie.sdds;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInterface {
	
	static int userChoice = 0;
	 
	
	 public static void menu() throws InterruptedException, IOException {
		 
		
		while (true) { 
		 System.out.println(ConsoleColour.WHITE);
			System.out.println("************************************************************");
			System.out.println("*     ATU - Dept. of Computer Science & Applied Physics    *");
			System.out.println("*                                                          *");
			System.out.println("*             Virtual Threaded Text Simplifier             *");
			System.out.println("*                                                          *");
			System.out.println("************************************************************");
			System.out.println("(1) Specify Embeddings File");
			System.out.println("(2) Specify Google 1000 File");
			System.out.println("(3) Specify an Output File (default: ./out.txt)");
			System.out.println("(4) Specify a Text File to Modify");
			System.out.println("(5) Quit");
			
			//Output a menu of options and solicit text from the user
			System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
			System.out.print("Select Option [1-]>");
			System.out.println();
			
			menuChoice();
		}
			
//			boolean validInput = false;
//			 int help = 0;
			
			 
//			 while (!validInput) {
//				 
////				System.out.println("Please enter a valid number");
//				 help = scannerIn.nextInt();
//			 }
//			 	if (0< help && help<8){
//			 		validInput = true;
//				 	System.out.println("Number accepted");
//			 	} else {
//			 		System.out.println("Invalid number");
//			 }
			 //taken from online, change it

			
			
			
//			 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));          
//	            System.out.print("Please enter your selection: ");
//	            String userChoice = reader.readLine();
//				System.out.print(ConsoleColour.WHITE);
//	            System.out.println("Your choice was: " + userChoice);
//			
			
			//You may want to include a progress meter in you assignment!
//			System.out.print(ConsoleColour.YELLOW);	//Change the colour of the console text
//			int size = 100;							//The size of the meter. 100 equates to 100%
//			for (int i =0 ; i < size ; i++) {		//The loop equates to a sequence of processing steps
//				printProgress(i + 1, size); 		//After each (some) steps, update the progress meter
//				Thread.sleep(10);					//Slows things down so the animation is visible 
//			}
		}
	 
	 public static void menuChoice() throws IOException {			 
		 //opens scanner for console input
		 //There is an error with this because it does not keep looking for the next console input
		 //you can keep typing but it doesnt do anything once 1 case is completed
		 //should keep open so the user can keep going through the menu
		 Scanner scannerIn = new Scanner(System.in);
		 
		 while (userChoice < 1 || userChoice > 5) {
         System.out.print("Enter your choice: ");

         // Makes sure the input's an integer
         //Tells user its invalid otherwise
         if (scannerIn.hasNextInt()) {
             userChoice = scannerIn.nextInt();
             if (userChoice < 1 || userChoice > 5) {
                 System.out.println("Invalid input. Please enter a number between 1 and 7.");
             }
         } else {
             System.out.println("Invalid input. Please enter a valid integer.");
             scannerIn.next(); 
         }
     }
	 
	 //opens new scanner
	//other scanner is still open
		 Scanner scan = new Scanner(System.in);
		 
		 //switch case for the menu
		 //5 cases to choose from
		 
		 switch (userChoice) {
	 case 1:
		 System.out.println("Please enter the pathway of the embeddings file");
		 
		 //Takes in embedding file
		 // "./src/atu/ie/sdds/embeddings.txt"
		 File embeddingFile = new File(scan.nextLine());
		 	if (!embeddingFile.exists()) {
		 		System.out.println("Please specify a valid pathway");
		 		return;
		 	}
		 FileManagement.embeddingParse(embeddingFile);
		 
		 break;
		 
	 case 2:
		 //Takes in google 1000 file
		 //"./src/atu/ie/sdds/google-1000.txt"
		 System.out.println("Please enter the pathway of the Google 1000 file");
		 File commonFile = new File(scan.nextLine());
		 if (!commonFile.exists()) {
		 		System.out.println("Please specify a valid pathway");
		 		return;
		 }
		 FileManagement.commonParse(commonFile);
		 break;
		 
	 case 3:
		 //Takes in name for output file
		 //created output file
		 
		 System.out.println("Please specify your preferred name for the output file");
		 File outputFile = new File ("test.txt");
		 if (outputFile.createNewFile()) {
			 System.out.println("File created");
		 }else {
			 System.out.println("File already created in directory");
		 };
		 break;
		 
	 case 4:
		 //takes in name for user specified text file to modify
		 System.out.println("Please enter the path of the text file you would like to modify");
		String userTextFile = scan.nextLine();
		//FindSimilarity.modifyTextFile();
		
		 
		 break;
		 //case for quitting
	 case 5:
		 System.out.println("You chose to quit");
		
		 break;
		 
	default:
		System.out.println("Invalid choice: Please choose a number between 1 and 7");
		break;
	 
	 
	 }
		 scan.close();
		 scannerIn.close();
	
//		  if (userChoice = "1"){
//			  
//			 }
	 }
	
		

		
		/*
		 *  Terminal Progress Meter
		 *  -----------------------
		 *  You might find the progress meter below useful. The progress effect 
		 *  works best if you call this method from inside a loop and do not call
		 *  System.out.println(....) until the progress meter is finished.
		 *  
		 *  Please note the following carefully:
		 *  
		 *  1) The progress meter will NOT work in the Eclipse console, but will
		 *     work on Windows (DOS), Mac and Linux terminals.
		 *     
		 *  2) The meter works by using the line feed character "\r" to return to
		 *     the start of the current line and writes out the updated progress
		 *     over the existing information. If you output any text between 
		 *     calling this method, i.e. System.out.println(....), then the next
		 *     call to the progress meter will output the status to the next line.
		 *      
		 *  3) If the variable size is greater than the terminal width, a new line
		 *     escape character "\n" will be automatically added and the meter won't
		 *     work properly.  
		 *  
		 * 
		 */
	 //
		public static void printProgress(int index, int total) {
			if (index > total) return;	//Out of range
	        int size = 50; 				//Must be less than console width
		    char done = '█';			//Change to whatever you like.
		    char todo = '░';			//Change to whatever you like.
		    
		    //Compute basic metrics for the meter
	        int complete = (100 * index) / total;
	        int completeLen = size * complete / 100;
	        
	        /*
	         * A StringBuilder should be used for string concatenation inside a 
	         * loop. However, as the number of loop iterations is small, using
	         * the "+" operator may be more efficient as the instructions can
	         * be optimized by the compiler. Either way, the performance overhead
	         * will be marginal.  
	         */
	        StringBuilder sb = new StringBuilder();
	        sb.append("[");
	        for (int i = 0; i < size; i++) {
	        	sb.append((i < completeLen) ? done : todo);
	        }
	        
	        /*
	         * The line feed escape character "\r" returns the cursor to the 
	         * start of the current line. Calling print(...) overwrites the
	         * existing line and creates the illusion of an animation.
	         */
	        System.out.print("\r" + sb + "] " + complete + "%");
	        
	        //Once the meter reaches its max, move to a new line.
	        if (done == total) System.out.println("\n");
	    
	    }
	}


