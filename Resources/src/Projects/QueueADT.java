package Projects;

//imports the Circular Linked list and scanner class
import ch05.queues.CircularLinkedList;
import java.util.*;

public class QueueADT {

	public static void main(String args[]){
		
		// makes a new circular linked list
		CircularLinkedList myQueue = new CircularLinkedList();
		
		//creates two scanners
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		
		// makes x = 0
		int x = 0;
		
		// prompts user to enter information
		System.out.println("Enter how you'd like to modify the Queue:");
		
		// runs as long as x is not 1
		while(!(x == 1)){
			
		// shows the user the options to modify the queue
		System.out.println("(A) add to the Queue");
		System.out.println("(T) take away from the Queue");
		System.out.println("(E) check if Queue is empty");
		System.out.println("(P) Print Queue");
		System.out.println("(END) end program");
		System.out.println("--------------------------------------------");
		
		// scans user input
		String inp = scan.nextLine();
		
		// if user wants to add element
		if(inp.toLowerCase().equals("a")){
			//prompts user for an int and takes it
			System.out.println("enter Int to add to Queue:");
			int var = scan2.nextInt();
			//runs enqueue for inputed Int
			myQueue.enqueue(var);
		}
		// if user wants to subtract front element
		else if(inp.toLowerCase().equals("t")){
			//dequeues the queue
			myQueue.dequeue();
		}
		// if user wants to check if the queue is empty or not
		else if(inp.toLowerCase().equals("e")){
			// informs user if queue is empty or not
			if(myQueue.isEmpty()){
				System.out.println("Queue is empty");
			}
			else{
				System.out.println("Queue is not empty");
			}
		}
		// if user wants to print queue
		else if(inp.toLowerCase().equals("p")){
			//stores and prints the printed string
			String ans = myQueue.Print();
			System.out.println(ans);
		}
		// if user wants to end the program
		else if(inp.toLowerCase().equals("end")){
			x = 1;
		}
		// if user types an invalid input
		else{
			// tells user an invalid input was used
			System.out.println("Invalid Input");
		}
		}
	}
}
