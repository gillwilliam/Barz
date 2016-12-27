import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Starting...");

		Scanner sc = new Scanner(System.in);

		Document doc = Jsoup.connect("http://www.metrolyrics.com/rigamortis-lyrics-kendrick-lamar.html").get();

		// Document doc =
		// Jsoup.connect("http://www.metrolyrics.com/hotel-california-lyrics-the-eagles.html").get();

		Song s = new Song(doc);

		// for (Verse v : s.verses) {
		// System.out.println(v.verse);
		// System.out.println("END BAR");
		// }

		// for (Verse v : s.verses) { ArrayList<String[]> rhyme = v.rhymePairs;
		// for (String[] c : rhyme) { System.out.println(c[0] + " " + c[1]);
		//
		// } }
		//
		// for (String[] a : s.totRhymePairs) { System.out.println(a[0] + " " +
		// a[1]); }

		// System.out.println(s.verses[3].verse);
		// System.out.println("DONE");
		// int counter = 0;
		// for (Verse a : s.verses) {
		// for (ArrayList<Integer> b : a.alliteration) {
		// System.out.println((char) (counter + 'A') + " " + b);
		// counter++;
		// }
		// counter = 0;
		//
		// }
		System.out.println("Collection");

		for (Verse a : s.verses) {
			for (ArrayList<String> b : a.collectionStr) {
				System.out.println(b);
			}
		}

		System.out.println("done");

	}

}
