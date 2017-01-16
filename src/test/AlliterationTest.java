package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class AlliterationTest {

	public static ArrayList<ArrayList<Integer>> alliteration = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		

		
		ArrayList<ArrayList<Integer>> collection = new ArrayList<ArrayList<Integer>>();

		Scanner sc = new Scanner(System.in);
		String[] strWords;

		for (int i = 0; i < 25; i++) {
			alliteration.add(new ArrayList<>());
		}

		strWords = sc.nextLine().split(" ");

		for (int i = 0; i < strWords.length; i++) {

			
			if (strWords[i].length() > 3) {
				char[] letters = strWords[i].toLowerCase().toCharArray();
				char firstLetter = letters[0];
				int index = firstLetter - 'a';

				// System.out.println(index);
				if (index < 25 && index >= 0) {
					alliteration.get(index).add(i);
				}
			}
		}

		for (int i = 0; i < alliteration.get(12).size(); i++) {

			ArrayList<Integer> temp = new ArrayList<Integer>();
			
			int zeroIndex = alliteration.get(12).get(i);
			
			temp = close(zeroIndex);
			
			if(temp.size() > 2){
				collection.add(temp);
			}
			
			

		}

		int counter = 0;
		for (ArrayList<Integer> a : alliteration) {

			System.out.println((char) (counter + 'A') + " " + a);
			counter++;
		}
		
		System.out.println("Collection");
		
		for(ArrayList<Integer> b : collection){
			System.out.println(b);
		}

		System.out.println("done");

	}
	
	public static ArrayList<Integer> close(int zeroIndex){
		ArrayList<Integer> indicies = new ArrayList<Integer>();
		for (int k = 0; k < alliteration.get(12).size(); k++) {
			if(Math.abs((alliteration.get(12).get(k) - zeroIndex)) < 4){
				indicies.add(alliteration.get(12).get(k));
			}
		}
		return indicies;
		
	}

}
