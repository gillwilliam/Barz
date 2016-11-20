
public class Bar {
	
	String lineOne;
	String[] wordsOne;
	
	String lineTwo;
	String[] wordsTwo;
	
	Bar(String lineA, String lineB){
		lineOne = lineA;
		lineTwo = lineB;
		
		wordsOne = lineOne.split(" ");
		wordsTwo = lineTwo.split(" ");
	}
	
	

}
