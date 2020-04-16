package Projects;

//imports the scanner and ArraySortedList
import java.util.*;
import ch06.lists.ArraySortedList;

public class MergeTestApp {	

	public static void main(String args[]){
		
		//makes two ArraySortedList
		ArraySortedList<String> first = new ArraySortedList<String>();
		ArraySortedList<String> second = new ArraySortedList<String>();
		
		//creats a scanner
		Scanner scan = new Scanner(System.in);
		
		//informs user on how program works
		System.out.println("In this program we will create two arrays to be merged");
		System.out.println("Enter Strings for the first array or type (end) to go to the second array");
		
		int x = 0;
		
		//while x is not 1 this runs
		while(!(x == 1)){
			
			//prompts user for a string to enter in first array then recives it
			System.out.println("enter Strings or (end): ");
			String inp = scan.nextLine();
			
			//if the input is end the first array ends else it adds it to the first array
			if(inp.equals("end")){
				x = 1;
			}
			else{
				first.add(inp);
			}
			
		}
		//informs user that the second array is being entered into
			System.out.println("Enter Strings for the second array or type (end) to go to merge the two arrays");
			
			int y = 0;
			//while y is not 1 this runs
			while(!(y == 1)){
				
				//prompts user for string and recives it
				System.out.println("enter Strings or (end): ");
				String inp2 = scan.nextLine();
				
				// if user input is end it sets y to 1
				if(inp2.equals("end")){
					y = 1;
				}
				
				// else it adds the input onto the second array
				else{
					second.add(inp2);
				}
		}
			
			//merges the two arrays
			first.merge(second);
			
			// displays the merged array
			System.out.println("The merged array is: ");
			System.out.println(first.print());
			
	}
	
}