import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Starting...");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter song title: ");
		String songTitle = sc.nextLine();

		String[] songTitleArr = songTitle.split(" ");
		String songTitlehyph = songTitleArr[0];

		if(songTitleArr.length > 1) {
			for (int i = 1; i < songTitleArr.length; i++) {
				songTitlehyph += "-";
				songTitlehyph += songTitleArr[i];

			}
		}

		System.out.println("Enter artist name: ");
		String artistName = sc.nextLine();

		String[] artistNameArr = artistName.split(" ");

		String artistNamehyph = artistNameArr[0];

		if(artistNameArr.length > 1) {
			for (int i = 1; i < artistNameArr.length; i++) {
				artistNamehyph += "-";
				artistNamehyph += artistNameArr[i];

			}
		}

		Document doc = Jsoup.connect("http://www.metrolyrics.com/" + songTitlehyph + "-lyrics-" + artistNamehyph + ".html").get();


		Song s = new Song(doc);

		printRhymes(s);
		System.out.println("Collection");
		printAlliterations(s);





		System.out.println("done");

	}

	static void printRhymes(Song s){
		for (Verse v : s.verses) { ArrayList<String[]> rhyme = v.rhymePairs;
			for (String[] c : rhyme) { System.out.println(c[0] + " " + c[1]);

			} }

		for (String[] a : s.totRhymePairs) { System.out.println(a[0] + " " +
				a[1]); }
	}

	static void printAlliterations(Song s){
		for (Verse a : s.verses) {
			for (ArrayList<String> b : a.collectionStr) {
				System.out.println(b);
			}
		}
	}

}
