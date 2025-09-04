package atu.ie.sdds;

import java.util.HashMap;
import java.util.Map;

public class Main {

	



    public static void main(String[] args)  throws Exception {
    	
    	
        double[] vector1 = {1.0, 2.0, 3.0};
        double[] vector2 = {4.0, 5.0, 6.0};
        System.out.println("Cosine Similarity: " + SimilarityMethods.cosineSimilarity(vector1, vector2));

        
        UserInterface.menu();
		UserInterface.menuChoice();
}}