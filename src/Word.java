import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word {
	String word;
	//String[] rhymes;
	String[] rhymes;

	Word(String wordz) throws Exception {
		word = wordz;
		rhymes = getRhymes(wordz);
	}

	
	//TODO: Implement the rhyme approx
	public String[] getRhymes(String word) throws Exception {
		//perfect rhymes
		String link = ("http://api.datamuse.com/words?rel_rhy=" + word);
		//close rhymes
		String linkB = ("http://api.datamuse.com/words?rel_nry=" + word);
		JsonParse jp = new JsonParse(link);
		JsonParse jpB = new JsonParse(linkB);
		Rhyme[] rhymes = jp.gson.fromJson(jp.json, Rhyme[].class);
		Rhyme[] rhymesB = jp.gson.fromJson(jpB.json, Rhyme[].class);
		 
		String[] allRhyme = new String[rhymes.length + rhymesB.length];
		
		for(int i = 0; i < rhymes.length; i++){
			 allRhyme[i] = rhymes[i].word;
		 }
		
		for(int i = 0; i< rhymesB.length; i++){
			allRhyme[i + rhymes.length] = rhymesB[i].word;
		}
		
		return allRhyme;
		
	}

}
