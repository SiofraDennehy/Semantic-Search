package atu.ie.sdds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EmbeddingLoader {
	
	static File embeddingFile = new File("glove.6B.50d.txt");
	static File commonFile = new File("./src/atu/ie/sdds/google-1000.txt");

    public static Map<String, float[]> loadEmbeddings(File embeddingFile) throws IOException {
        Map<String, float[]> embeddings = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(embeddingFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.strip();
                if (line.isEmpty()) continue;

                String[] parts = line.split(" ");
                if (parts.length < 2) continue; // skip malformed lines

                String word = parts[0].trim();
                float[] vector = new float[parts.length - 1];

                for (int i = 1; i < parts.length; i++) {
                	String cleaned = parts[i].trim();
                	vector[i - 1] = Float.parseFloat(cleaned);
                }

                embeddings.put(word, vector);
            }
        }

        return embeddings;
    }


}
