package Projects;

public class FibNum implements FibInt {

	public int Recursive(int N){

		// if the variable given is 0 or 1 it returns it
		if(N == 0 || N == 1){
		return N;
		}
		
		// if the other conditions are not met it runs a recursive method
		else{
			
			//sets the integer num equal to the recursive method of the given variable - 1 and the recursive method of the given variable -2
		int num = Recursive(N-1) + Recursive(N-2);	
		
		//returns num after all recursion is done
		return num;
		}
	}

	public int NonRecursive(int N){
	
		//sets some initial variables all to 1
		int num = 1;
		int past2 = 1;
		int past1 = 1;
		
		// if the value given is 1 or 0 it returns the variable
		if(N == 1 || N == 0){
			return N;
		}
		
		else{
		
			// runs through the correct number of times until z=N
			for(int z = 3; z<N; z++){
				
				//sets past2 equal to past1
				past2= past1;
				
				//sets past1 to the current num
				past1= num;
				
				//sets num to the sum of past1 and past2
				num = past1 +past2;
			}
			
		//returns num	
		return num;
		}
		
	}
	
	// returns a string that returns the numbers ordinal indicator
	public String end(int N){
		
		// assigns th to the values from 11-13
		if (N >= 11 && N <= 13) {
	        return "th";
	    }
		
		//returns the correct ordinal indicator to each number
	    switch (N % 10) {
	    case 1:
	        return "st";
	    case 2:
	        return "nd";
	    case 3:
	        return "rd";
	    default:
	        return "th";
	    }	
	
	}
	
}
