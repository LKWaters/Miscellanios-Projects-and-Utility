/**
 * @author Phil laMastra
 * @date 05Oct13
 * 
 * Program to test time recursive vs. non-recursive stacks
 */

public class TestRevPrint {
	//create a global variable to set size of stack
	static final int LENGTH = 5000;
	static long startTime, 
				endTime, 
				recTotalTime = 0,
				nonRecTotalTime = 0;
	
	public static void main(String[] args) {
		LinkedStack3<Integer> intNonRecStack = new LinkedStack3<Integer>();
		LinkedStack2<Integer> intRecStack = new LinkedStack2<Integer>();
			
		//Load the two stacks with data
		for(int i=0; i<LENGTH; i++){
			intNonRecStack.push(i);
			intRecStack.push(i);
		}

		//Reversing the order of the 2 following blocks of code
		//shows the timing is more dependent on the position in the program
		
		//Run non-recursive stack
		startTime = System.currentTimeMillis();
		intNonRecStack.printReversed();
		endTime = System.currentTimeMillis();
		nonRecTotalTime += endTime-startTime;
			
		//Run recursive stack
		startTime = System.currentTimeMillis();
		intRecStack.printReversed();
		endTime = System.currentTimeMillis();
		recTotalTime += endTime - startTime;
				
		System.out.println("Total recursive execution time: " + recTotalTime);
		System.out.println("Total non-recursive execution time: " + nonRecTotalTime);
	}
}
