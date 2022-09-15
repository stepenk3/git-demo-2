import java.util.InputMismatchException;
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
public class Lab1 {
	public static void displayMainMenu() {
		System.out.println("Please select one of the following:");
		System.out.println("1: Initialize a default array");
		System.out.println("2: To specify the max size of the array	");
		System.out.println("3: Add value to the array");
		System.out.println("4: Display values in the array");
		System.out.println("5: Display average of the values, minimum value, maximum value, MaxValue modulo MinValue");
		System.out.println("6: To Exit");
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int option =0;
		Numbers number = new Numbers();
		
				//Print the menu and ask for user option, also check for invalid options		
		do {			
			try {
				Lab1.displayMainMenu();
				option = keyboard.nextInt();
				
				switch(option) {
				case 1:
					number = new Numbers();
					break;
				case 2:
					System.out.println("Enter new size of array: ");
					number = new Numbers(keyboard.nextInt());
					break;
				case 3:
					number.addValue(keyboard);
					break;
				case 4: 
					System.out.println(number.toString());
					break;
				case 5:
					System.out.println(number.findMinMax());
					break;
				case 6:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid option ... Please try again!");
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.printf("Invalid option ... Please try again!\n \n");
				keyboard.nextLine();
			}
			
		
		}while(option != 6);
		
		
	}
}


