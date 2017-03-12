public class SecondSmallestNumber {
    
    public static void main(String[] args) {
        //initial array
        int[] inputArray = {42, 8, 13, 79, 2, 18, 1};
        System.out.println(findSecondSmallest(inputArray));//prints the returned value to console
        
    }//main
    
    //method to find the smallest value
    public static int findSecondSmallest(int[] array){
        int length = array.length;// length of the Array
        
        int smallest = array[0];
        int secondSmallest = smallest;
        for(int i=0; i<length; i++){
            if(array[i]<smallest){
                secondSmallest = smallest;//setting the secondSmallest
                smallest = array[i];
            }
            else if (array[i] < secondSmallest && array[i] != smallest)
                secondSmallest = array[i];
        }
        return secondSmallest;//return the value
        
    }//findSecondSmallest
    
}//SecondSmallestNumber
