//----------------------------------------------------------------------------
// ArrayRefSortedList.java       by Dale/Joyce/Weems                 Chapter 7
// 
// Implements an array-based sorted linked list of String
//----------------------------------------------------------------------------
 
package ch07.array;
 
import ch06.lists.*;
 
public class ArrayRefSortedStringList implements ListInterface<String>
{
    protected static final int NUL = -1;   // End of list symbol
    protected class AListNode
    {
        private String info;        // The info in a list node
        private int next;           // A link to the next node on the list
    }

    protected AListNode[] nodes;  // Array of AListNode holds the linked list

    protected int list;           // Reference to the first node on the list
    protected int free;           // Reference to the first node on the free list
 
    protected int numElements;    // Number of elements in the list
    protected int currentPos;     // Current position for iteration

    // set by find method
    protected boolean found;      // true if element found, else false
    protected int location;       // node containing element, if found
    protected int previous;       // node preceding location
    public ArrayRefSortedStringList(int maxElements)
       // Instantiates and returns a reference to an empty list object with
       // room for maxElements elements
    {
        nodes = new AListNode[maxElements];
        for (int index = 0; index < maxElements; index++)
            nodes[index] = new AListNode();

        // Link together the free nodes.
        for (int index = 1; index < maxElements; index++)
            nodes[index - 1].next = index;
        nodes[maxElements - 1].next = NUL;
        list = NUL;
        free = 0;
        numElements = 0;
        currentPos = NUL;
    }

    protected int getNode()
    // Returns the index of the next available node from the free list
    // and updates the free list index
    {
        int hold;
        hold = free;
        free = nodes[free].next;
        return hold;
    }

    protected void freeNode(int index)
    // Frees the node at array position index by linking it into the
    //  free list
    {
        nodes[index].next = free;
        free = index;
    }

    public boolean isFull()
    // Determines whether this list is full
    {
        return (free == NUL);
    }

    public boolean remove (String element)
    // Removes an element e from this list such that e.equals(element)
    // and returns true; if no such element exists, returns false
    {
        int hold;              // To remember removed node index
        find(element);
        if (found)
        {
            hold = location;
            if (list == location)
                list = nodes[list].next;   // remove first node
            else
                nodes[previous].next = nodes[location].next;
            freeNode(hold);
            numElements--;
        }
        return found;
    }
    //********************************************************************************************
    // THE FOLLOWING METHODS FROM ListInterface MUST BE IMPLEMENTED FOR THIS CLASS TO WORK(see ex17 Ch7)
    public int size(){ //return -1;  LaMastra implemented 
    // Returns the number of elements on this list.
    	return numElements; 		
    }

    public boolean contains (String element){ //return true; LaMastra implemented - not tested
    // Returns true if this list contains an element e such that
    // e.equals(element); otherwise, returns false.
    	find(element);
    	return found;
    }
    
    public String get(String element){  //return null;   LaMastra implemented - not tested
    // Returns an element e from this list such that e.equals(element);
    // if no such element exists, returns null.
    	find(element);
    	if(found)
    		return nodes[location].info;
    	else
    		return null;
    }
    
    public String toString(){  //return "";    LaMastra implemented
    // Returns a nicely formatted string that represents this list.
    	String toReturn = "";
    	location = list;
    	while (location != NUL){
			toReturn += nodes[location].info + "\n";
			location = nodes[location].next;
    	}
    	return toReturn;
    }
    public void reset(){     //LaMastra implemented - not tested
    // Initializes current position for an iteration through this list,
    // to the first element on this list.
    	currentPos = list;
    }

    public String getNext(){   //return null;    LaMastra implemented - not tested
    // Preconditions: The list is not empty
    //                The list has been reset
    //                The list has not been modified since the most recent reset
    //
    // Returns the element at the current position on this list.
    // If the current position is the last element, then it advances the value
    // of the current position to the first element; otherwise, it advances
    // the value of the current position to the next element.
    	String toReturn = nodes[currentPos].info;
    	if(nodes[currentPos].next == NUL)
    		currentPos=list;
    	else
    		currentPos = nodes[currentPos].next;
    	return toReturn;
    }
    
    // THE FOLLOWING METHOD FROM SortedListInterface MUST BE IMPLEMENTED FOR THIS CLASS TO WORK(see ex17 Ch7)
    public void add(String element){   //LaMastra implemented
    // Adds element to this list. The list remains sorted.
    	if(isFull())
    		throw new ListOverflowException("Attempt to add to a full list");
    	else{
    		// Set up search for insertion point.
    		String listElement;
    		location = list;
    		previous = NUL;
    		
    		// Find insertion point.
    		while (location != NUL){
    			listElement = nodes[location].info;
    			if (listElement.compareTo(element) < 0){  // list element < add element
    				previous = location;
    				location = nodes[location].next;
    			}else
    				break;
    		}
    		
    		// Insert node into list.
    		int newNode = getNode();
    		nodes[newNode].info = element;
    		if (previous == NUL){
    			// Insert at head of list
    			nodes[newNode].next = location;
    			list=newNode;
    		}else{
    			// Insert elsewhere.
    			nodes[newNode].next=location;
    			nodes[previous].next=newNode;
    		}
    		numElements++;
    	}
    }
    
    // ADD THE find METHOD AS WELL (see ex17 Ch7)
    protected void find(String target){  //LaMastra implemented - not tested
    	location = list;
        found = false;

        while (location != NUL) 
        {
        	if (nodes[location].info.equals(target)){ // if they match
        		found = true;
        		return;
        	}else{
        		previous = location;
        		location = nodes[location].next;
        	}
        }
    }
    //*************************************************************************************************
}