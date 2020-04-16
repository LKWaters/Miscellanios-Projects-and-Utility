package ch07.array;

public class ListOverflowException extends RuntimeException {
	public ListOverflowException(){
		super();
	}
	
	public ListOverflowException(String message){
		super(message);
	}
}