package test;

import java.util.ArrayList;

public class AlliterationRecurse {

	public static ArrayList<ArrayList<Integer>> alliteration = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "And this is rigamortis and it's gorgeous when you die Ali recorded and I'm Morpheus, the Matrix of my mind I'm out the orbit, you an orphan and a hairdresser combined I'm on the toilet when I rhyme if you the shit then I decline I climax where you begin and then I end on Cloud 9 And that's important when you morph into a angel in the sky And don't be forging all my signatures, my listeners reply and tell me That you biting style, you got a hell of an appetite And I'mma be here for a while just buckle up before the ride Or knuckle up if you could fight, we always making them duck or die A suit and tie is suitable and usual in suicide CSI just might investigate this fucking parasite";

		String[] strWords = s.split(" ");
		int numWords = strWords.length;
		ArrayList<ArrayList<Integer>> collection = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<String>> collectionStr = new ArrayList<ArrayList<String>>();

		for (int i = 0; i < 26; i++) {
			alliteration.add(new ArrayList<>());
		}

		for (int i = 0; i < numWords - 1; i++) {

			if (strWords[i].length() > 1) {
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

		// int counter = 0;
		int init = 0;
		for (ArrayList<Integer> a : alliteration) {

			System.out.println((char) (init + 'A') + " " + a);
			init++;
		}

		System.out.println("Collection");

		for (ArrayList<Integer> b : collection) {
			System.out.println(b);
		}

		for (ArrayList<String> c : collectionStr) {
			System.out.println(c);
		}

		System.out.println("done");

	}

	public static ArrayList<ArrayList<Integer>> close(ArrayList<Integer> letterIndex) {
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

}
