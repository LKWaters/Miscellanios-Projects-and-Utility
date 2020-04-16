//tol must be between 1 and 0

package Projects;

//imports the scanner used in the code below
import java.util.*;

public class sqrApp {

	public static void main(String[] args){
		
		//creates two new variables of sqrRoot
		sqrRoot recur = new sqrRoot(); 
		sqrRoot nonrecur = new sqrRoot(); 
		
		//creates a scanner to scan in user input's
		Scanner scan = new Scanner(System.in);
		
		//sets approx which is used in the Recur and NonRecur methods
		double approx = 1;
	
		//prompts user to enter a number which the square root will be approximated and scans for it
		System.out.println("Please enter the number which you would like to approximate the square root of: ");
		double number = scan.nextDouble();
		
		//prompts user for the tolerance and then scnas for it
		System.out.println("enter a tolerence between 0 and 1 for this approximation: ");
		double tol = scan.nextDouble();
		
		System.out.println("----------------------------------------------------------------------------------");
		
		//calculates the approximation recursively and iteratively
		double answerx = recur.Recur(number, approx, tol);
		double answery = nonrecur.NonRecur(number, approx, tol);
		
		//prints out the answer recursively and iteratively
		System.out.println("the answer using the recursive method is: " + answerx);		
		System.out.println("the answer using the itterative method is: " + answery);		
		
	}
}
