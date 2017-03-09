import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		System.out.print("Please Enter a String to Reverse it: ");
		//scan object to read user input
		Scanner scan = new Scanner(System.in);
		
		//reading the users input
		String input = scan.nextLine();
		
		//changing string into characters
		char[] inputCharacters = input.toCharArray();
		
		//getting the length of the string, also the size of the inputCharacter array
		int length = input.length();
		
		//looping backward to print the string reverse.
		for(int i = length-1; i>=0; i--){
			System.out.print(inputCharacters[i]);
		}//for

	}//main

}//ReverseString
