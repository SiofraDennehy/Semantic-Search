package atu.ie.sdds;

public class SimilarityMethods {
	
	   //TODO: This (all 3 methods) were taken from copilot when I looked up
		// "vector comparison algo java"
		//change for project
		public static double cosineSimilarity(double[] vector1, double[] vector2) {
	       //checks vector length as they need to be the same
			//throws error otherwise
			if (vector1.length != vector2.length) {
	            throw new IllegalArgumentException("Vectors must be of the same length.");
	        }
			//initilises the variables needed
	        double dotProduct = 0.0;
	        double normA = 0.0;
	        double normB = 0.0;
	        //loops through the vector
	        for (int i = 0; i < vector1.length; i++) {
	        	//calculates the sum
	            dotProduct += vector1[i] * vector2[i];
	            //calculates the squared sum
	            normA += Math.pow(vector1[i], 2);
	            normB += Math.pow(vector2[i], 2);
	        }
	        //returns the cosine similarity
	        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
	    }}

		
		
		
//		public static double euclideanDistance(double[] vector1, double[] vector2) {
//	        if (vector1.length != vector2.length) {
//	            throw new IllegalArgumentException("Vectors must be of the same length.");
//	        }
//	        double sum = 0.0;
//	        for (int i = 0; i < vector1.length; i++) {
//	            sum += Math.pow(vector1[i] - vector2[i], 2);
//	        }
//	        return Math.sqrt(sum);
//	    }
//		
//		
//	
//		    public static double manhattanDistance(double[] vector1, double[] vector2) {
//		        if (vector1.length != vector2.length) {
//		            throw new IllegalArgumentException("Vectors must be of the same length.");
//		        }
//		        double sum = 0.0;
//		        for (int i = 0; i < vector1.length; i++) {
//		            sum += Math.abs(vector1[i] - vector2[i]);
//		        }
//		        return sum;
//		    }
//}
