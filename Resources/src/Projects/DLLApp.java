package Projects;

import Projects.DoublyLinkedListInterface;
import java.util.*;

public class DLLApp {
	public static void main(String[] args){
		
		DoublyLinkedList<Integer> first = new DoublyLinkedList<Integer>();
		
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		
		int x = 0;
		
		while(!(x == 1)){
			System.out.println("Choose one of the following options to modify or know about your linked list");
			System.out.println("(A)add (S)size (C)contains (R)removes (G)get (STR)display list (RES)reset");
			System.out.println("(GN)get next (GP)get previous (end)to end the program : ");
			
			String inp = scan.nextLine();
			
			if(inp.toLowerCase().equals("a")){
				System.out.println("please enter an Integer");
				int num = scan2.nextInt();
				first.add(num);
			}
			else if(inp.toLowerCase().equals("c")){

				
				System.out.println("please enter an Integer");
				int num = scan2.nextInt();
				if(first.contains(num)){
					System.out.println(num + " is in the list");
				}
				else{
					System.out.println(num + " is not in the list");
				}
				
			}
			else if(inp.toLowerCase().equals("s")){
				System.out.println(first.size());
			}
			else if(inp.toLowerCase().equals("r")){
				
				System.out.println("please enter an Integer");
				int num = scan2.nextInt();
				first.remove(num);
			}
			else if(inp.toLowerCase().equals("g")){

				System.out.println("please enter an Integer");
				int num = scan2.nextInt();
				System.out.println(first.get(num));
			}
			else if(inp.toLowerCase().equals("str")){
				System.out.println(first.toString());
			}
			else if(inp.toLowerCase().equals("res")){
				first.reset();
				first.resetBack();
			}
			else if(inp.toLowerCase().equals("gn")){
				System.out.println(first.getNext());
			}

			else if(inp.toLowerCase().equals("gp")){
				System.out.println(first.getPrevious());
			}
			else if(inp.toLowerCase().equals("end")){
				x = 1;
			}
			else{
				System.out.println("Please enter a valid input");
			}
			
		}
		
		
		
		
		
	}
}
