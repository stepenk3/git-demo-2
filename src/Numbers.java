import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Gia Bao Tran
 * Student Number: 041048694
 * Section #:  	300 
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * 
 */
public class Numbers {
	/**
	 * Store boolean value to check if numbers has a given size (by users).
	 */
	private boolean hasMaxSize;
	
	/**
	 * Stores Float values.
	 */
	private Float [] numbers;
	
	/**
	 * Store the number of items currently in the array.
	 */
	private int numItems;

	/**
	 * Declare the array but not initialize it yet
	 * Default Constructor
	 */
	public Numbers() {		
		numbers = null;
		numItems = 0;

	}

	/**
	 * Constructor that initializes the numbers array.
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		numbers = new Float[size];
		numItems = 0;
		hasMaxSize = true;
	}
	
	/**
	 * Adds a value in the array
	 * @param keyboard - Scanner object to use for input
	 * 
	 */
	public void addValue(Scanner keyboard) {
		//If users choose to give a max size then operate this way
		if(numbers != null && hasMaxSize) {
			//Check if array is full, if not
			if(numItems < numbers.length) {
				System.out.print("Enter value: ");
				numbers[numItems] = keyboard.nextFloat();
				numItems++;
			}
			//Check if array is full, if yes
			else {
				System.out.println("Array full");
			}
		}
		
		//If user has not instantiate an array, the block below will generate one and allow them to add value to that 
		else if(numbers == null) {
			numbers = new Float[numItems+1];
			System.out.print("Enter value: ");
			numbers[numItems] = keyboard.nextFloat();
			numItems++;
			
		}
		//if user has had an array ( no max size given) it will operate this way so that it can grow freely
		else {
			//Copy numbers to a temporary buffer
			Float[] bufferArray = new Float[numbers.length];
			for(int i = 0 ; i < numbers.length; i++) {
				bufferArray[i] = numbers[i];
			}
			
			//Instantiate a new adaptive array
			numbers = new Float[numItems+1];
			
			//Copy previous values
			for(int i = 0 ; i < bufferArray.length; i++) {
				numbers[i] = bufferArray[i];
			}
			
			//Add a new value to the array
			System.out.print("Enter value: ");
			numbers[numItems] = keyboard.nextFloat();
			
			numItems++;
		}				
		
	}
	
	/**
	 * Calculates the average of all the values in the numbers array.
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		
		//The case the array is not empty, average can be calculated and returned
		if(numbers != null) {
			float total = 0;
			
			for(int i =0 ; i < numItems; i++) {
				total += numbers[i];
			}
			
			return (float)total / numbers.length;

		}
		//If array does not exist it is impossible to find average, and to avoid any exception or error, simply set it 0
		else{
			return 0;
		}
		
	}

	@Override
	//A for loop that will loop through the array and appends each element to a variable and return it
	public String toString() {
		//Empty string that will append values from the array(if array exists), if not, remains the same
		String array="";
		if(numbers != null) {
			for(int i = 0; i<numbers.length;i++) {
				array = array + numbers[i] + "\n";
			}
		}
		return "Numbers are:\n" + array;
	}
	
	public String findMinMax() {
		//instantiate the necessary variables 
		float min=0;
		float max=0;
		float mod=0;
		
		//Since the array is null, minimum maximum simply do not exist and is 0
		if(numbers == null || numbers[0] ==null) {
			min=0;
			max=0;
			mod=0;	
		}
		
		
		//Since the the array only has one element. Minimum maximum are itself
		else if(numbers.length ==1){
			min=numbers[0];
			max=numbers[0];
			mod = min/max;
		}
		
		//Normal cases
		else {
			min=numbers[0];
			max =numbers[0];
			
			//Find maximum,set the first value as maximum, if the next value is smaller then swap (leveraging bubble sort)
			for(int i = 1; i<numItems; i++) {
				if(max < numbers[i]) {
					max = numbers[i];
				}
			}
			
			//Find minimum, set the first value as minimum, if the next value is larger then swap (leveraging bubble sort)
			for(int i = 1; i<numItems; i++) {
				if(min > numbers[i]) {
					min = numbers[i];
				}
			}
			
			
		}
		return "Average is: " + Math.round(calcAverage() * 100.00)/100.00 + ", Minimum value is " + min + ", Maximum value is " + max+", MaxValue modulo MinValue is"+ mod; 
	}
	
	
	
}
