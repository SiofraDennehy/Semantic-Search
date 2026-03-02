package atu.ie.sdds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FileManagement {

	
	public static Map <String, float[]> wordEmbeddings = new HashMap<>();
	public static Map <String, float[]> commonWordEmbeddings = new HashMap<>();
	public static Set <String> commonWords = new HashSet <>();
	

	static File embeddingFile = new File("glove.6B.50d.txt");
	static File commonFile = new File("1000-most-common-words.txt");
	

	
	public static String hardWordChoice() {
		Scanner hardWordScanner = new Scanner (System.in);
		String hardWord = hardWordScanner.nextLine();
		hardWordScanner.close();
		
		return hardWord;
	}
	

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
