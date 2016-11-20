package test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class ScrapeTest {
	public static void main(String[] args) throws IOException {

		
		Document doc = Jsoup.connect("http://www.metrolyrics.com/energy-lyrics-drake.html").get();
		
		Elements type1 = doc.getElementsByClass("verse"); //list of all verses
		
		System.out.println(type1.first().text());
		
		System.out.println(type1.get(1).text());
		
		
	    
	    
		
		
		
		
		
		
		

	}

}
