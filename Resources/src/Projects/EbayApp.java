package Projects;

//importing the LinckedStack class to make linked lists
import ch03.stacks.LinkedStack;

//importing all of java.util, mainly to use the scanner
import java.util.*;

// creating the class and method
public class EbayApp {
	public static void main(String args[]){
		
// creating a scanner to get user input		
Scanner scan = new Scanner(System.in);


//making linked lists to take in all the bidding information 
	LinkedStack<Integer> HighBid = new LinkedStack();
	LinkedStack<Integer> MaximumBid = new LinkedStack();
	LinkedStack<String> NewBid = new LinkedStack();
	LinkedStack<String> ResultBid = new LinkedStack();
	LinkedStack<String> HighBidder = new LinkedStack();

//making linked lists that will sort the data properly so it is exported in the right order	
	LinkedStack<Integer> HighBid1 = new LinkedStack();
	LinkedStack<Integer> MaximumBid1 = new LinkedStack();
	LinkedStack<String> NewBid1 = new LinkedStack();
	LinkedStack<String> ResultBid1 = new LinkedStack();
	LinkedStack<String> HighBidder1 = new LinkedStack();

//creating initial variables used in the if,while,for loops 
	int MaxBid = 0;
	int CurrentBid = 0;
	String MaxName;
	String name;
	int number;
	int x = 0;
	
	//runs as long as x is not 1 which will happen only if the user types end
	while(x!=1){
		
		// prompts the user to enter a name number combo or end the program and scans for the user input
		System.out.println("enter new bid in the form of: name number");
		System.out.println("If bidding is over enter: END");
		String input = scan.nextLine();
	
		//if the user inputs end it sets x = 1, ending the program
		if(input.toString().toLowerCase().equals("end")){
    		x = 1;
    		
    		
    		// a while loop to reorganize the linked list stacks that runs until the linked list is empty
    		while(!HighBidder.isEmpty()){
    			
    			// sets one linked list to the top of its corresponding linked list
    			NewBid1.push(NewBid.top());
    			ResultBid1.push(ResultBid.top());
    			HighBidder1.push(HighBidder.top());
    			HighBid1.push(HighBid.top());
    			MaximumBid1.push(MaximumBid.top());
    			
    			// pops the top of the original linked list off
    			NewBid.pop();
    			ResultBid.pop();
    			HighBidder.pop();
    			HighBid.pop();
    			MaximumBid.pop();
    		}
    		
    		// prints out a label for each column that will be output 
    		System.out.printf("%-25s %-25s %-25s %-25s %-25s\n", "New Bid", "Result", "High Bidder", "High Bid", "Maximum Bid");
    		
    		
    		//prints out the result of the e-bay auction row by row, popping off the top before re-looping and outputting another row
    		while(!HighBidder1.isEmpty()){
    			 
    			System.out.printf("%-25s %-25s %-25s %-25s %-25s\n",NewBid1.top(),ResultBid1.top(),HighBidder1.top(),HighBid1.top(),MaximumBid1.top());
    			
    			NewBid1.pop();
    			ResultBid1.pop();
    			HighBidder1.pop();
    			HighBid1.pop();
    			MaximumBid1.pop();	
    			
    		}	
		}
		
		// runs if the user doesn't prompt the program to end
		else{
			
			// splits the user input of (name number) into their respective variable
			String[] value = input.split(" ");
			name = value[0];
			number = Integer.parseInt(value[1]);	
    	
			//pushes the correct information onto the stacks if the new number inputed is larger than the max
			if(number > MaxBid){
				
				//sets CurrentBid to one greater than the current MaxBid
				CurrentBid = MaxBid+1;
				//sets the MaxBid to the number given
				MaxBid = number;
				//sets the person who has the largest bid to the new name
				MaxName = name;
				
				//pushes the info given and set onto the correct stacks 
				HighBid.push(CurrentBid);
				MaximumBid.push(MaxBid);
				NewBid.push(input);
				ResultBid.push("New High Bidder");
				HighBidder.push(MaxName);
				
				
			}
			// runs when the inputed number is equal to the current bid
			else if(number == CurrentBid){
			
				// Sets the CurrentBid to the new number and then sets MaxName to the name of whoever has the highest MaximumBid
				CurrentBid = number;
				MaxName = HighBidder.top();
				
				//pushes the info given and set onto the correct stacks 
				HighBid.push(CurrentBid);
				MaximumBid.push(MaxBid);
				NewBid.push(input);
				ResultBid.push("No Change");
				HighBidder.push(MaxName);
			}
			// runs when the inputed number is larger than the current bid but less than the current MaxBid
			else if(number > CurrentBid){
			
				// Sets the CurrentBid to the new number and then sets MaxName to the name of whoever has the highest MaximumBid
				CurrentBid = number;
				MaxName = HighBidder.top();
				
				//pushes the info given and set onto the correct stacks 
				HighBid.push(CurrentBid);
				MaximumBid.push(MaxBid);
				NewBid.push(input);
				ResultBid.push("High Bid Increased");
				HighBidder.push(MaxName);
				
			}
			//outputs the current bid for the E-bay Auction in real time
			System.out.println("Current Bid is: " + CurrentBid);
			System.out.println();
		}

		}

	}
}
