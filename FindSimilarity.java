package atu.ie.sdds;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindSimilarity{
	
	public static String findNearestCommonWord( 
			
			String word,
			Map<String, float[]> embeddings, 
			Set<String> commonWords 
	) { 
		float[] target = embeddings.get(word); 
		if (target == null) return null; 
		
		String bestWord = null; 
		float bestScore = -1f; 
		
		for (String common : commonWords) { 
			float[] vec = embeddings.get(common); 
			if (vec == null) continue; 
			
			float score = (float) SimilarityMethods.cosineSimilarity(target, vec); 
			if (score > bestScore) { 
				bestScore = score; 
				bestWord = common; 
			} 
			
			}float Min_Similarity = 0.55f;
			if (bestScore < Min_Similarity) {
				System.out.println("Skipping replacement for '" + word + "' (best score = " + bestScore + ")");
				return null;
		} 
		
		return bestWord; 
	}
	
	public static String simplifyText(
	        String text,
	        Map<String, float[]> embeddings,
	        Set<String> commonWords
	) {
	    StringBuilder result = new StringBuilder();

	    for (String word : text.split("\\s+")) {
	        String cleaned = word.toLowerCase().replaceAll("[^a-z]", "");

	        if (!embeddings.containsKey(cleaned)) {
	            result.append(word).append(" ");
	            continue;
	        }

	        String replacement = findNearestCommonWord(cleaned, embeddings, commonWords);
	        if (replacement == null) {
	            result.append(word).append(" ");
	        } else {
	            result.append(replacement).append(" ");
	        }
	    }

	    return result.toString().strip();
	}
	
	public static void debugTopSimilar(
	        String word,
	        Map<String, float[]> embeddings,
	        Set<String> commonWords
	) {
	    float[] target = embeddings.get(word);
	    if (target == null) {
	        System.out.println("No embedding for " + word);
	        return;
	    }

	    record Pair(String word, float score) {}

	    List<Pair> scores = new ArrayList<>();

	    for (String common : commonWords) {
	        float[] vec = embeddings.get(common);
	        if (vec == null) continue;

	        float score = 	(float) SimilarityMethods.cosineSimilarity(target, vec);
	        scores.add(new Pair(common, score));
	    }

	    scores.stream()
	            .sorted((a, b) -> Float.compare(b.score(), a.score()))
	            .limit(5)
	            .forEach(p -> System.out.println(p.word() + " = " + p.score()));
	}



}
