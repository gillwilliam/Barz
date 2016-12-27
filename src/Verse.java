import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Verse {

	Word[] words;
	String[] strWords;
	int numWords;
	String verse;
	ArrayList<ArrayList<Integer>> alliteration = new ArrayList<ArrayList<Integer>>();
	// index corresponds to the letter in the alphabet (0-25)
	ArrayList<ArrayList<String>> collectionStr = new ArrayList<ArrayList<String>>();

	ArrayList<ArrayList<Integer>> collection = new ArrayList<ArrayList<Integer>>();

	ArrayList<String[]> rhymePairs = new ArrayList<String[]>();

	int wordLengthThreshold;

	Verse(String s) throws Exception {

		wordLengthThreshold = 1;

		verse = s;
		strWords = s.split(" ");
		numWords = strWords.length;
		words = new Word[numWords];
		makeWords();
		whichRhyme();
		setAlliteration();
	}

	public void makeWords() throws Exception {

		for (int i = 0; i < numWords; i++) {

			words[i] = new Word(strWords[i]);

		}

	}

	public void setAlliteration() {

		for (int i = 0; i < 26; i++) {
			alliteration.add(new ArrayList<>());
		}

		for (int i = 0; i < numWords; i++) {

			if (strWords[i].length() > wordLengthThreshold) {
				char[] letters = strWords[i].toLowerCase().toCharArray();
				char firstLetter = letters[0];
				int index = firstLetter - 'a';

				if (index < 26 && index >= 0) {

					alliteration.get(index).add(i);
				}
			}
		}

		int counter = 0;
		for (ArrayList<Integer> curLetter : alliteration) {
			// for (int zero : curLetter) {
			ArrayList<ArrayList<Integer>> tempDouble = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			ArrayList<String> tempStr = new ArrayList<>();
			// int zeroIndex = zero;

			tempDouble = close(curLetter);

			for (int t = 0; t < tempDouble.size(); t++) {
				temp = tempDouble.get(t);
				if (temp.size() > 2) {
					collection.add(temp);

					for (int w = 0; w < temp.size(); w++) {

						tempStr.add(strWords[temp.get(w)]);

					}
					collectionStr.add(tempStr);
				}

			}
			// }
			counter++;
		}

	}

	public ArrayList<ArrayList<Integer>> close(ArrayList<Integer> letterIndex) {
		ArrayList<Integer> indicies = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> indiciesd = new ArrayList<ArrayList<Integer>>();

		for (int i = 1; i < letterIndex.size(); i++) {

			if (Math.abs((letterIndex.get(i) - letterIndex.get(i - 1))) < 4) {
				if (indicies.isEmpty()) {
					indicies.add(letterIndex.get(i - 1));
				}
				indicies.add(letterIndex.get(i));
			} else {
				indiciesd.add((ArrayList<Integer>) indicies.clone());
				indicies.clear();
			}

		}

		return indiciesd;

	}

	public void whichRhyme() {

		for (int i = 0; i < numWords; i++) {
			for (int j = 0; j < numWords; j++) {
				if (strWords[i].length() > 3) {
					for (int w = 0; w < words[j].rhymes.length; w++) {

						// System.out.println(words[i].rhymes[w]);
						// System.out.println(strWords[i]);
						if (words[j].rhymes[w].equals(strWords[i])) {
							String[] s = new String[2];
							s[0] = words[j].word;
							s[1] = strWords[i];
							rhymePairs.add(s);
							// System.out.println("TEST");
						}
					}
				}
			}
		}

	}

}
