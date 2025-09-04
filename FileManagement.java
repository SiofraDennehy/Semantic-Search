package atu.ie.sdds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FileManagement {
	
	public static Map <String, double[]> wordEmbeddings = new HashMap<>();
	public static Map <String, double[]> commonWordEmbeddings = new HashMap<>();
	public static Set <String> commonWords = new HashSet <>();
	
	
	public static void loadEmbeddings(String embeddingPath) {
		File embeddingFile = new File("./src/atu/ie/sdds/embeddings.txt");
		if (!embeddingFile.exists()) {
			System.out.println("This file path does not exist, please enter a valid path");
			return;
		}
		
	}
	
	public static void embeddingParse(File embeddingFile){
		System.out.println(embeddingFile);
		try ( BufferedReader scanner = new BufferedReader(new FileReader(embeddingFile))) {
			String row = null;
			//keeps processing new rows while there are more in the file
			while ((row = scanner.readLine()) != null){
				//splits each row into the word and embeddings, taking out the ", " between each one
				String[] splitRow = row.split(", ");
				//first word is seperated to put as key into map later
				String word = splitRow[0];
				//creates an array to hold the embedding numbers
				//same length as the amount of numbers
				double[] embeddings = new double[splitRow.length -1];
			
				//starts at 1 because 0 is the word that is seperated from the number embeddings
			for (int i = 1; i<50; i++){
				//changes embedding numbers to doubles instead of strings
				embeddings[i-1] = Double.valueOf(row.split(", ")[i]);
			}
			//fills the "wordEmbeddings" map with each word as a key and the embeddings as an array of doubles
			wordEmbeddings.put(word, embeddings);
			}
			System.out.println("Embedding File Loaded :)");
		
			} catch (FileNotFoundException e) {
				System.out.println("Error" + e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error" + e.getMessage());
				e.printStackTrace();
			}
		
		
		
	}
	
	
	public static void loadCommon(String commonPath) {
		File commonFile = new File("./src/atu/ie/sdds/google-1000.txt");
		if (!commonFile.exists()) {
			System.out.println("This file path does not exist, please enter a valid path");
			return;
		}}
	
	public static void commonParse(File commonFile){
		System.out.println("Common file working");
		try ( BufferedReader scan = new BufferedReader(new FileReader(commonFile))) {
			String commonWord = null;
			while ((commonWord = scan.readLine()) != null) {
				commonWord = commonWord.replaceAll(" ", "");
				if (!commonWord.isBlank()) {
					commonWords.add(commonWord);
				}
				
			}System.out.println("Common Words Loaded :)");
			
		
	} catch (FileNotFoundException e) {
		System.out.println("Error" + e.getMessage());
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("Error" + e.getMessage());
		e.printStackTrace();
	}


}}
