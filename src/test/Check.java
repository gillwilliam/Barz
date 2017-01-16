package test;

import java.util.ArrayList;
import java.util.Arrays;

public class Check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> letterIndex = new ArrayList<Integer>(
				Arrays.asList(14, 16, 18, 19, 62, 74, 76, 81, 115, 132));

		ArrayList<Integer> indicies = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> indiciesd = new ArrayList<ArrayList<Integer>>();

		
		
		for (int i = 1; i < letterIndex.size(); i++) {

			if (Math.abs((letterIndex.get(i) - letterIndex.get(i - 1))) < 4) {

				if (indicies.isEmpty()) {
					indicies.add(letterIndex.get(i - 1));
				}
				indicies.add(letterIndex.get(i));

			} else {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp = (ArrayList<Integer>) indicies.clone();
				indiciesd.add(temp);
				indicies.clear();
			}

		}

		for (ArrayList<Integer> a : indiciesd) {
			System.out.println(a);
		}

	}

}
