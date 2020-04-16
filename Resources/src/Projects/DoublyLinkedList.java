package Projects;

import support.DLLNode;
// have a setback, getlink, setlink, getback^

public class DoublyLinkedList<T> implements DoublyLinkedListInterface<T>{

	protected int numElements = 0;
	protected boolean found;
	protected DLLNode<T> currentBackPos; 
	protected DLLNode<T> currentPos; 
	protected DLLNode<T> location;
	protected DLLNode<T> temp;
	protected DLLNode<T> list;
	protected DLLNode<T> last;
	
	
	public DoublyLinkedList()
	{
	numElements = 0;
	list = null;
	last = null;
	currentPos = null;
	currentBackPos = null;
	}
	
	public void add(T num){
	
		DLLNode<T> addnode = new DLLNode<T>(num); 
		
		if (list == null){
		     list = addnode;
		     last = list;
		 }
		else{
		    list.setBack(addnode);
		    addnode.setLink(list);
		    list = addnode;
		}
		numElements ++;
	}
	
	public void find(T num){
		 location = list;
		    found = false;

		    while (!(location == null)) 
		    {
		      if (location.getInfo().equals(num))
		      {  
		        found = true;
		        return;
		      }
		      else{
		        temp = location;
		        location = (DLLNode<T>) location.getLink();
		      }
		    }
	}
	
	public int size(){
		return numElements;
	}
	
	public boolean contains(T num){
		find(num);
	    return found;
	}
	
	public boolean remove(T num){    
	    if (contains(num)){
	      if(list == (location)){
	    	  list = (DLLNode<T>) list.getLink();
	      }
	      else{
	    	  temp.setLink(location.getLink());
	      }
		    numElements --;
	    }
	    return found;
	}
	
	public T get(T num){
	    find(num);
	    
		if (found)
	      return location.getInfo();
	    else
	      return null;
	}
	
	public String toString(){
		String listString = "List:\n";
		DLLNode<T> tempNode = list;
	    while(!(tempNode == null)){
	      listString = listString + "  " + tempNode.getInfo();
	      tempNode = (DLLNode<T>) tempNode.getLink();
	    }
	    return listString;
	}
	
	public void reset(){
		currentPos = list;
	}
	
	public T getNext(){
		T next = currentPos.getInfo();
	    if (currentPos.getLink() == null){
	    	currentPos = list;
	    }
	    else{
	    	currentPos = (DLLNode<T>) currentPos.getLink();
	    }
	    	
	    return next;
	}
	
	public void resetBack(){
		currentBackPos = last;
	}
	
	
	public T getPrevious(){
		T prev = currentBackPos.getInfo();
		if (currentBackPos.getBack() == list){
		currentBackPos = last;
		}
		else{
		currentBackPos = currentBackPos.getBack();
		}
		return prev;
	}
	
}
