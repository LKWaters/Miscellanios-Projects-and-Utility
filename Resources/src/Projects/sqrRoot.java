package Projects;

public class sqrRoot {

	//creates a new method that takes in three doubles and finds the answer recursively
	double Recur (double number, double approx, double tol){
		
		// if the approximation squared is within + or - the tolerance then return the approximation
		if(Math.abs(approx * approx - number) <= tol){
			return approx;
		}
		
		// if its not within the tolerance then return Recur with the same info except approximation is now ((approx^2+number)/(2approx))
		else {
			return Recur(number, (approx*approx + number)/(2 * approx), tol);
		}
	}
	
	//creates a method that takes three doubles and finds an answer iteratively
	double NonRecur (double number, double approx, double tol){
		
		//while the approximation squared is within + or - the tolerance then this will continue to run
		while(!(Math.abs(approx * approx - number) <= tol)){
		
			//if the approx value is too low, raises approx value by tol^2
			if (approx * approx - number < tol){
				approx = approx + (tol*tol);
			}
			//if the approx value is too high, lowers approx value by tol^2
			else{
				approx = approx - (tol*tol);
			}
		}
		
		//returns approx
		return approx;
	}
}
