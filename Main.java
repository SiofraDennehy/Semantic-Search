package atu.ie.sdds;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	



    public static void main(String[] args)  throws Exception {
    	
    	
    	
    		FileManagement.commonParse(FileManagement.commonFile);
//    		System.out.println(FileManagement.commonWords);
    		
            Map<String, float[]> embeddings = EmbeddingLoader.loadEmbeddings(EmbeddingLoader.embeddingFile);
//   
//            String hardWord = FileManagement.hardWordChoice().toLowerCase();
//            
//            String replacement = FindSimilarity.findNearestCommonWord(hardWord, embeddings, FileManagement.commonWords);
//
//            System.out.println("Nearest common word to '" + hardWord + "' is: " + replacement);
    
//            String text = "The frowning man undermined the salary negotiations.";
//            String simplified = FindSimilarity.simplifyText(text, embeddings, FileManagement.commonWords);
//
//            System.out.println("Original:   " + text);
//            System.out.println("Simplified: " + simplified);
//            
//            FindSimilarity.debugTopSimilar("frowning", embeddings, FileManagement.commonWords);

            FindSimilarity.debugTopSimilar("undermined", embeddings, FileManagement.commonWords);
            System.out.println("Next oneeeeeee");
            FindSimilarity.debugTopSimilar("negotiations", embeddings, FileManagement.commonWords);


        }
 	
}   	
    	
    	
    	
    	
    	
   
