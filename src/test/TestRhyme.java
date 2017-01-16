package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;


public class TestRhyme {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		
		
		String json = readUrl("http://api.datamuse.com/words?rel_nry=" + word);
		String json2 = readUrl("http://api.datamuse.com/words?rel_rhy=" + word);

		System.out.println(json);
		
		Gson gson = new Gson();
		
		
		 
		 Rhyme[] rhymes = gson.fromJson(json, Rhyme[].class);
		 Rhyme[] rhymes2 = gson.fromJson(json2, Rhyme[].class);
		 
		 
		 for(int i = 0; i < rhymes.length; i++){
			 System.out.println(rhymes[i].word);
		 }
		 
		 System.out.println("APPROX!!");
		 System.out.println();
		 for(int i = 0; i < rhymes2.length; i++){
			 System.out.println(rhymes2[i].word);
		 }
		 
		
		

	}
	
	private static String readUrl(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}

	static class Rhyme{
		String word;
		int score;
		int numSyllables;
	}
		
}


