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

	ArrayList<ArrayList<Integer>> collection = new ArrayList<ArrayList<Integer>>();

	ArrayList<String[]> rhymePairs = new ArrayList<String[]>();

	Verse(String s) throws Exception {
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

			char[] letters = strWords[i].toCharArray();
			char firstLetter = letters[0];
			char ch = 'h';
			int pos = ch - 'a' + 1;
			int index = firstLetter - 'a' + 1;

			words[i] = new Word(strWords[i]);

		}

	}

	public void setAlliteration() {

		for (int i = 0; i < 26; i++) {
			alliteration.add(new ArrayList<>());
		}

		for (int i = 0; i < numWords; i++) {

			if (strWords[i].length() > 3) {
				char[] letters = strWords[i].toLowerCase().toCharArray();
				char firstLetter = letters[0];
				int index = firstLetter - 'a';

				if (index < 26 && index >= 0) {

					alliteration.get(index).add(i);
				}
			}
		}

		for (ArrayList<Integer> curLetter : alliteration) {
			for (int zero : curLetter) {
				ArrayList<Integer> temp = new ArrayList<Integer>();

				int zeroIndex = zero;

				temp = close(zeroIndex);

				if (temp.size() > 2) {
					collection.add(temp);
				}

			}
		}

	}

	public ArrayList<Integer> close(int zeroIndex) {
		ArrayList<Integer> indicies = new ArrayList<Integer>();
		for (int k = 0; k < alliteration.get(12).size(); k++) {
			if (Math.abs((alliteration.get(12).get(k) - zeroIndex)) < 4) {
				indicies.add(alliteration.get(12).get(k));
			}
		}
		return indicies;

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
