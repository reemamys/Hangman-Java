package Hangman;
import java.util.Scanner;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean play = true;
		
		while(play) {
		System.out.println("====================================");
		System.out.println("=========== Hangman Game ===========");
		System.out.println("============== Marvel ==============");
		System.out.println("====================================");
		
		Hangman h = new Hangman();
		ArrayList<Character> guessedLetters = new ArrayList<>();
		h.rL();
		char ch;
		h.print();
		
		while(h.deadMan() == false && h.wordCompleted() == false) {
			System.out.println("\nEnter Letter: ");
			ch = input.next().charAt(0);
			
			if(!Character.isLetter(ch)) {
				System.out.println("Invalid Input. Please Enter a Letter: ");
				continue;
			}
			
			ch = Character.toLowerCase(ch);
			
			if(guessedLetters.contains(ch)) {
				System.out.println("You already guessed that letter. Try a different one.");
				continue;
			}
			
			guessedLetters.add(ch);
			h.check(ch);
		}
		
		if(h.deadMan() == false) {
			System.out.println("\n**** WIN ****");
			System.out.println("Word: " + h.getWord());
		}
		
		if(h.deadMan() == true) {
			System.out.println("\n**** LOSE ****");
			System.out.println("Correct Word: " + h.getWord());
		}
		
		
		String playAgain = " ";
		while(true) {
			System.out.println("Do you want to play again? (Yes/No) ");
			playAgain = input.next();
			
			if(playAgain.equalsIgnoreCase("yes")) {
				play = true;
				break;
			}
			else {
				if(playAgain.equalsIgnoreCase("no")) {
					play = false;
					System.out.println("Exiting...");
					break;
			    }
				else
					System.out.println("Invalid Input. Please Enter Yes or No: ");
			}
		}
		
		
		}//end while
	}//end main

}//end main class
