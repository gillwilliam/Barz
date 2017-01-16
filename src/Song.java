import java.util.ArrayList;
import java.util.HashSet;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Song {

	String[] strVerses;
	Document doc;
	int numVerses;
	Elements type1;
	Verse[] verses;
	HashSet<String[]> totRhymePairs = new HashSet<String[]>();

	Song(Document docz) throws Exception {
		doc = docz;
		type1 = doc.getElementsByClass("verse");
		numVerses = getNumVerses();
		strVerses = getVerse();
		verses = new Verse[numVerses];
		setVerses();
		removeDuplicates();
	}

	// gets the verses
	public String[] getVerse() {

		String[] sarr = new String[numVerses];
		for (int i = 0; i < numVerses; i++) {
			sarr[i] = type1.get(i).text();
		}

		return sarr;
	}

	public void setVerses() throws Exception {

		for (int i = 0; i < numVerses; i++) {
			verses[i] = new Verse(strVerses[i]);
		}

	}

	// sets the number of verses in the song
	public int getNumVerses() {
		return type1.size();
	}

	public void removeDuplicates() {
		for (int i = 0; i < numVerses; i++) {
			for (int j = 0; j < numVerses; j++) {
				for (int k = 0; k < verses[i].rhymePairs.size(); k++) {
					for (int w = 0; w < verses[j].rhymePairs.size(); w++) {

						if (i != k) {
							String[] verseARhyme = verses[i].rhymePairs.get(k);
							String[] verseBRhyme = verses[j].rhymePairs.get(w);
							// System.out.println("what");
							if (verseARhyme[0].equals(verseBRhyme[0])) {
								// System.out.println("A:" + verseARhyme[0] + "
								// " + verseBRhyme[0]);

							} else if (verseARhyme[0].equals(verseBRhyme[1])) {
								// System.out.println("B:" + verseARhyme[0] + "
								// " + verseBRhyme[1]);

							} else if (verseARhyme[1].equals(verseBRhyme[0])) {
								// System.out.println("C:" + verseARhyme[1] + "
								// " + verseBRhyme[0]);

							} else if (verseARhyme[1].equals(verseBRhyme[1])) {
								// System.out.println("D:" + verseARhyme[1] + "
								// " + verseBRhyme[1]);
							} else {
								// System.out.println("E:" + verseARhyme[0] + "
								// " + verseARhyme[1]);

								totRhymePairs.add(verseARhyme);
							}

						}

					}
				}
			}
		}

	}

}
