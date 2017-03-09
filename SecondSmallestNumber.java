package x;


public class SecondSmallestNumber {

	public static void main(String[] args) {
		//initial array
		int[] inputArray = {42, 8, 13, 79, 5, 2, 18};
		System.out.println(findSecondSmallest(inputArray));//prints the returned value to console
		
	}//main

	//method to find the smallest value
	public static int findSecondSmallest(int[] array){
		int length = array.length;// length of the Array
		
		int smallest = array[0]; //assuming that is the smallest
		int secondSmallest = 0; //yet to determine
		
		for(int i=0; i<length; i++){
			if(smallest>array[i]){
				secondSmallest = smallest;//setting the secondSmallest
				smallest = array[i];
			}
		}
		return secondSmallest;//return the value
		
	}//findSecondSmallest
	
}//SecondSmallestNumber
