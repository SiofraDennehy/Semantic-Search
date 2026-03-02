package atu.ie.sdds;

public class SimilarityMethods {
	

		public static double cosineSimilarity(float[] vector1, float[] vector2) {
			if (vector1.length != vector2.length) {
	            throw new IllegalArgumentException("Vectors must be of the same length.");
	        }
	        double dotProduct = 0.0;
	        double normA = 0.0;
	        double normB = 0.0;
	        for (int i = 0; i < vector1.length; i++) {
	            dotProduct += vector1[i] * vector2[i];
	            normA += Math.pow(vector1[i], 2);
	            normB += Math.pow(vector2[i], 2);
	        }
	        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
	    }

		
		
		
		public static double euclideanDistance(double[] vector1, double[] vector2) {
	        if (vector1.length != vector2.length) {
	            throw new IllegalArgumentException("Vectors must be of the same length.");
	        }
	        double sum = 0.0;
	        for (int i = 0; i < vector1.length; i++) {
	            sum += Math.pow(vector1[i] - vector2[i], 2);
	        }
	        return Math.sqrt(sum);
	    }
		
		
	
		    public static double manhattanDistance(double[] vector1, double[] vector2) {
		        if (vector1.length != vector2.length) {
		            throw new IllegalArgumentException("Vectors must be of the same length.");
		        }
		        double sum = 0.0;
		        for (int i = 0; i < vector1.length; i++) {
		            sum += Math.abs(vector1[i] - vector2[i]);
		        }
		        return sum;
		    }
}
