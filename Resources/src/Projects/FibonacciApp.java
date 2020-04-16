// in this program 0 is considered the 1st term

package Projects;

// imports the method used for the scanner
import java.util.*;

public class FibonacciApp {

	public static void main(String args[]){
		
		//creates a new scanner named scan
		Scanner scan = new Scanner(System.in);
		
		// prompts the user to input a string
		System.out.println("Would you like to determine the Fibonacci Sequence recursively?");
		System.out.println("Enter (yes) for recursive");
		System.out.println("Enter (no) for non-recursive");
		System.out.println("----------------------------------------------------------------");
		
		// variable used to test if the user inputed the correct phrase 
		int x = 1;
		
		// creates a variable from the FibNum class to access the recursive and non recursive methods
		FibNum ReNum = new FibNum();
		
		//while the variable x is 1 this loop will continue
		while(x == 1){
			
			// scans for the users input and stores it in the string answer
			String answer = scan.nextLine();
			
			//if the user types "yes" this will run
			if(answer.toLowerCase().equals("yes")){
				
				//sets x to 0 indicating that the while loop will end
				x = 0;
				
				//prompts user to input an integer and scans for it
				System.out.print("Enter the Nth term in the Fibonacci Sequence you wish to calculate: ");
				int fib = scan.nextInt();
				
				//prints out the solution to the inputed variable
				System.out.print("The ");
				System.out.print(fib);
				System.out.print(ReNum.end(fib));
				System.out.print(" term of the Fibonachi Sequence is: ");
				
				// accounts for the iteration where the variable is returned in the FibNum.Recursive() Method
				fib = fib-1;
				System.out.print(ReNum.Recursive(fib));
				
			}
			
			//runs if the user enters "no"
			else if(answer.toLowerCase().equals("no")){
				
				//sets x to 0 indicating that the while loop will end
				x = 0;
				
				//prompts user to input an integer and scans for it
				System.out.print("Enter the Nth term in the Fibonacci Sequence you wish to calculate: ");
				int fib = scan.nextInt();
				
				//prints out the solution to the inputed variable
				System.out.print("The ");
				System.out.print(fib);
				System.out.print(ReNum.end(fib));
				System.out.print(" term of the Fibonachi Sequence is: ");
				System.out.print(ReNum.NonRecursive(fib));
				
			}
			
			//runs if the user enters anything other than yes or no to account for error 
			else{
				
				// if the user inputs anything other than "yes" or "no" it asks them to enter "yes" or "no"
				System.out.println("please enter (yes) or (no)");
			}
		}
		
	}
}
