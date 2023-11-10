package Lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = null;
		int index = 1;
		while (true) {
			line = br.readLine();
			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, " ");
			while (tokens.hasMoreTokens()) {
				String word = tokens.nextToken();
				if (!tokens.hasMoreTokens())
					add(word, -index);
				else
					add(word, index);
			}
		}
		index++;

	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		ArrayList<Integer> positions = map.getOrDefault(word, new ArrayList<Integer>());
		positions.add(position);
		map.put(word, positions);
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		List<String> words = new ArrayList<>(map.keySet());
		Collections.sort(words);
		for (String word : words) {
			System.out.println(word + " - " + map.get(word));
		}
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		Map<Integer, String> textMap = new TreeMap<>();
	    for (String word : map.keySet()) {
	        for (Integer pos : map.get(word)) {
	            textMap.put(Math.abs(pos), word);
	        }
	    }
	    for (String word : textMap.values()) {
	        System.out.print(word + " ");
	    }
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		String mostFrequent = null;
	    int maxCount = 0;
	    for (String word : map.keySet()) {
	        int count = map.get(word).size();
	        if (count > maxCount) {
	            maxCount = count;
	            mostFrequent = word;
	        }
	    }
	    return mostFrequent;
	}

}
