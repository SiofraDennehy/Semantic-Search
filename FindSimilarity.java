package atu.ie.sdds;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindSimilarity{
	
	//returns a string of the most similar word
	//takes in embeddings as argument
	public static String findSimilarWord(double[] embedding) {
		//setting up the string
		String similarWord = null;
		//starts at -1.0 because its the lowest cosine similarity score
		//this lets us keep swapping for higher scores in the loop
		double mostSimilar = -1.0;
		
		//loop to find most similar words in the google 1000 common words file
		//loops through each word in the commonWords double array I made earlier
		for (String commonWord:FileManagement.commonWords ) {
			//gets the embedding for each word
			double[] commonEmbedding = FileManagement.commonWordEmbeddings.get(commonWord);
			//checks the cosine similarity of the common word against the new word in the user input
			double cosine = SimilarityMethods.cosineSimilarity(commonEmbedding, embedding);
		
			//This is where the swap happens
			//if the similarity is higher than the last word checked
			//then the cosine becomes the new higher similarity score
		if (cosine > mostSimilar) {
			mostSimilar = cosine;
			//and the most similar word with the higher similarity score is kept in the SimilarWord string
			similarWord = commonWord;
		}//This runs until there are no more words in the common file to check
		}
		//then returns the most similar word
		return similarWord;
	}
	
	
	public static void modifyTextFile(String userTextFilePath) {
		//checks if file path exists
		//if not it tells the user and user must restart
		 File userTextFile = new File(userTextFilePath);
		 if (!userTextFile.exists()) {
		 		System.out.println("Please specify a valid pathway");
		 		return;
		 }
		 
		 //TODO:
		//scanner to take in userTextFile from command line
//		try (Scanner scan = new Scanner(userTextFile)) {
//			
//			//Used an arraylist rather than array because I dont know how long the User specified text will be.
//			List<String> newText = new ArrayList<>();
//			
//			//keeps reading lines from the user text file until there arent anymore left
//			while (scan.hasNextLine()) {
//				String userLine = scan.nextLine();
//				//splits the lines into words everytijme theres a space
//				//this doesnt account for punctuation
//				String[] userWords = userLine.split(" ");
//				//use of StringBuilder to be able to append rather than create a new string every time
//				StringBuilder newUserLine = new StringBuilder();
//				
//				//this method isnt finished
//				if (FileManagement.wordEmbeddings.containsKey(word)) {
//					
//				}
//				
//			}
//		}
	}
	
	

}
