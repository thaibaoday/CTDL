package Lab7_1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		List<WordCount> wordCounts = new ArrayList<>();
		Set<String> distinctWords = getDistinctWords();

		for (String word : distinctWords) {
			int count = 0;
			for (String w : words) {
				if (w.equals(word)) {
					count++;
				}
			}
			wordCounts.add(new WordCount(word, count));
		}
		return wordCounts;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> uniqueWords = new HashSet<>();
		List<WordCount> wordCounts = getWordCounts();

		for (WordCount wc : wordCounts) {
			if (wc.getCount() == 1) {
				uniqueWords.add(wc.getWord());
			}
		}
		return uniqueWords;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		Set<String> distinctWords = new HashSet<>();
		for (String word : words) {
			if (!distinctWords.contains(word)) {
				distinctWords.add(word);

			}

		}
		return distinctWords;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> exportWordCounts() {
		List<WordCount> wordCounts = getWordCounts();
		wordCounts.sort(new Comparator<WordCount>() {

			public int compare(WordCount wc1, WordCount wc2) {
				return wc1.getWord().compareTo(wc2.getWord());
			}

		});

		return new LinkedHashSet<>(wordCounts);
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		List<WordCount> wordCounts = getWordCounts();
		wordCounts.sort(new Comparator<WordCount>() {
			
			public int compare(WordCount wc1, WordCount wc2) {
				return Long.compare(wc2.getCount(), wc1.getCount());
				
			}
		});
		return new LinkedHashSet<>(wordCounts);
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<WordCount> filterWords(String pattern) {
		Set<WordCount> filtereWords = new LinkedHashSet<>();
		for(WordCount wc : getWordCounts()) {
			if(!wc.getWord().startsWith(pattern)) {
				filtereWords.add(wc);
				
			}
		}
		return filtereWords;
	}
}
