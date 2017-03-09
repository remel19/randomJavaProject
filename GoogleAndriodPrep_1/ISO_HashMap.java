/*
 * @author Remel Kabir
 * 
 * This is preparation practice program for google's Applied CS with Android.
 * 
 * This program takes in a three-letter country code and returns the full name of the country to which it belongs. For example:
	
	Input | Output
	----- | ----------------------------------------------------
	 GBR  | United Kingdom of Great Britain and Northern Ireland
	 IDN  | Indonesia
	 IND  | India
	 As an extension, if the input is greater than 3 letters, it is consider as the name of a country,
	 and returns the three-letter code for it. Write a helpful error message if the input is neither a valid code nor a country name.
 */
import java.io.*;
import java.util.*;

public class ISO_HashMap {
	private static HashMap<String, String> codeName = new HashMap<String, String>(); //creating a HashMap to put the name and code of the country. 
	public static void main(String args[]){
		
		String fileName= "CodeAndNameOfCountry.txt"; //initailzing the filename to the txt file that contains all the code and name.
		String line = null; // variable to read one line at a time from the txt file.
		
		try{
			
			FileReader fileReader = new FileReader(fileName); //reads the .txt file
			BufferedReader bufferedReader = new BufferedReader(fileReader); // this object will import method that reads the .txt file line by line.
			
			while((line=bufferedReader.readLine()) != null ){ // keeps reading till every line has been processed.
				//Temporary array and variable to process all the codes and names.
				String[] tempCodeName = line.split(","); // splits the string if there is a comma in the line.
				String CountryName = tempCodeName[0];// first String of the line is the name of the country 
				String CountryCode = tempCodeName[1];// second String of the line is the Code of the Country
				//HashMap Entry adding.
				codeName.put(CountryCode, CountryName); //adds the name and the code of the country in the HashMap, Code as the key and Name as the value;
			}//end of while loop
			
			bufferedReader.close();// Closing the file after reading it.
		}//end of try
		
		catch(FileNotFoundException ex) {
            System.out.println("File Not Found '" + fileName + "'");                
        }//end of catch
		
        catch(IOException ex) {
            System.out.println("Error '" + fileName + "'");                  
        }//end of catch
		
		inputOutput();
		
	}//end of main

	private static void inputOutput() {
		Scanner scan = new Scanner(System.in);// scan object for scanning. 
		
		String inputForInfo;// user's input
		
		System.out.println("Please Enter a three Digit Country Code to get the full name of the country:");
		inputForInfo= scan.nextLine();//read the line that user inputed and saves it in the variable InputForInfo
		int lengthOfInput = inputForInfo.length(); // length of the input to check if the user input anything other than a three digit country code.
		if(!validInput(inputForInfo)){
			System.out.println("Not a valid Input. It's neither a code of a country nor it's name ");
		}//if
		if(lengthOfInput == 3){
			System.out.println(getCountry(inputForInfo));
		}//if
		else 
			System.out.println(getCode(inputForInfo));
	}//end of inputOutput
	
	//To check if the input is either a valid code or country's name
	private static boolean validInput(String input){
		//returns true if the the three digits code is either a name or code of a country.
		if(codeName.containsValue(input)) return true;
		if(codeName.containsKey(input)) return true;
		return false; // else returns false.
	}//end of validInput
	
	// returns the code if country's name is entered.
	private static String getCode(String input){
		for (Map.Entry<String, String> en : codeName.entrySet()) {
            if (en.getValue().equals(input)) {
                return en.getKey();
            }//if
        }//end of for
		return "Code of the country not found";
	}//end of getCode
	
	//returns the name of the country if correct code entered
	private static String getCountry(String input){
		if(!codeName.containsKey(input)) return "country not Found";
		return codeName.get(input);
	}

}//end of class
