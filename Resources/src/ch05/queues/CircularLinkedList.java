package ch05.queues;

//imports the LLnode class
import support.LLNode;

public class CircularLinkedList<T> implements UnboundedQueueInterface<T>
{

  // reference to the rear of this queue
  protected LLNode<T> rear;    
  
  // creates a new linked list with only reference rear
  public CircularLinkedList()
  {
    rear = null;
  }

  // starts the enqueue method and adds an element to the queue
  public void enqueue(T element){ 
	//creates a new node with value of (element)
    LLNode<T> newNode = new LLNode<T>(element);
    
    //if queue is empty this runs
    if (rear == null){
      //sets rear to the new node
      rear = newNode;
      //sets rears link to itself
      rear.setLink(rear);
    }
    //runs if the queue isn't empty
    else{
    // creates a temporary variable to hold the beginning of the queue
    LLNode<T> temp = rear.getLink(); 
    
    // sets the rear's link to new node
    rear.setLink(newNode);
    //sets new nodes link to the beginning
    newNode.setLink(temp);
    //sets rear to new node
    rear = newNode;
    }
    }
    
  //removes elements from the beginning of the queue
  public T dequeue(){
	  // if the queue is empty this runs
    if (isEmpty()){
    	// informs the user that the queue is empty and returns null 
    	System.out.println("Dequeue attempted on empty queue.");
    return null;
    }
    // runs if there are elements in the queue
    else
    {
    	// if rear's link is rear this runs
    	if(rear.getLink() == rear){
    		// creates a variable element and gives it the value of the front variable in the queue
    		T element;
    	      element = rear.getInfo();
    	      
    	      //sets rear to null and returns element
    		rear = null;
    		return element;
    	}
    	// runs if rear is not linked to itself
    	else{
    		// creates a variable element and gives it the value of the front variable in the queue
      T element;
      element = rear.getInfo();
      // creates a temporary variable and sets it to one infront of the beginning 
      LLNode<T> temp = (rear.getLink()).getLink();
      // sets rear's link to the temp variable
      rear.setLink(temp);
      
      // if the link to rear is null then rear is null
      if (rear.getLink() == null)
        rear = null;

      //returns element
      return element;
    	}
    }
  }

  
  //determines if the queue is empty or not
  public boolean isEmpty(){
	  // if rear is null then its empty if not then its false
    if (rear == null) 
      return true;
    else
      return false;
  }
  
  //prints out what's in the queue
  public String Print(){
	  // declares out a string and sets it to nothing
	  String out = "";
	  
	  // while the queue is not empty this runs
	  while (!isEmpty()){
		
		  //sets string out equal to itself plus the front number in the queue then dequeues it
		  out = (out + rear.getLink().getInfo()+" ");
		  dequeue();
	  
	  }

	 //returns out
	  return out;
  }
}
