package Hangman;

public class Hangman {
	
	String[] hangman = {"face", "right-arm", "left-arm", "right-leg", "left-leg"};
	int hangmanNum = 5;
	
	WordList w = new WordList();
	String word = w.getRandomWord();
	
	String[] revealedLetters = new String[word.length()];
	char[] incorrect = new char[word.length()];
	
	public void rL() {
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == ' ')
				revealedLetters[i] = " ";
			else
				revealedLetters[i] = "_ ";
		}
	}
	
	public void check(char ch) {
		boolean found = false;
		for(int i = 0; i < word.length(); i++) {
			if(ch == word.charAt(i)) {
				revealedLetters[i] = ch + " ";
				found = true;
			}
		}
		if(found == false) {
			incorrectLetter(ch);
		}
		
		print();
	}
	
	public void incorrectLetter(char ch) {
		hangman[hangmanNum-1] = "*removed*";
		hangmanNum--;
	}
	
	public void print() {
		System.out.print("Remaining Parts: ");
		for(int i = 0; i < 5; i++) {
			System.out.print(hangman[i] + " - ");
		}
		
		System.out.print("\nCurrent Guess: ");
		for(int i = 0; i < word.length(); i++) {
			System.out.print(revealedLetters[i]);
		}
	}
	
	public boolean wordCompleted() {
		boolean completed = false;
		for(int i = 0; i < revealedLetters.length; i++) {
			if(revealedLetters[i].equals("_ "))
				return completed;
		}
		completed = true;
		
		
		return completed;
	}
	
	public boolean deadMan() {
		if(hangmanNum == 0)
			return true;
		else
			return false;
	}
	
	public String getWord() {
		return word;
	}


}//end Hangman class
