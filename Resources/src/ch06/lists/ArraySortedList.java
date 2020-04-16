//----------------------------------------------------------------------------
// ArraySortedList.java          by Dale/Joyce/Weems                 Chapter 6
//
// Implements the ListInterface using an array. It is kept in increasing order
// as defined by the compareTo method of the added elements. Only Comparable 
// elements may be added to a list.
//
// Null elements are not permitted on a list.
//
// Two constructors are provided: one that creates a list of a default
// original capacity, and one that allows the calling program to specify the 
// original capacity.
//----------------------------------------------------------------------------

package ch06.lists;

public class ArraySortedList<T> extends ArrayUnsortedList<T>
                                implements ListInterface<T>  
{
  public ArraySortedList() 
  {
    super();
  }

  public ArraySortedList(int origCap) 
  {
    super(origCap);
  }

  public void add(T element)
  // Precondition:  element is Comparable.
  //  
  // Adds element to this list.
  {
    T listElement;      
    int location = 0;
 
    if (numElements == list.length)
      enlarge();

    while (location < numElements)
    {
      listElement = (T)list[location];
      if (((Comparable<T>)listElement).compareTo(element) < 0)  // list element < add element
        location++;
      else
        break;   // list element >= add element
    }
    
    for (int index = numElements; index > location; index--)
      list[index] = list[index - 1];

    list[location] = element;
    numElements++;
  }

  public boolean remove (T element)
  // Removes an element e from this list such that e.equals(element)
  // and returns true; if no such element exists, returns false.
  {
    find(element);    
    if (found)
    {
      for (int i = location; i <= numElements - 2; i++)
        list[i] = list[i+1];
      list[numElements - 1] = null;
      numElements--;  
    }
    return found;
  }
  
 // merges two arrays together
public void merge(ArraySortedList<T> otlist){
	  
	//creates a temporary value
	  T temp;
	  
	  //sets len to the number of elements in otlist
	  int len = otlist.numElements;
	  
	  //if the number of elements reaches the list length it makes it bigger
	  if (numElements == list.length){
	      enlarge();
		}
	  
	  //runs for the number of elements in the otlist
	  for(int y = len; y > 0; y--){
		  
		  //sets temp to the value of the otlist starting from last to first
		  temp = otlist.list[y-1];
		  
		  //runs the length of the two lists
		  for(int x = 0; x<= (this.numElements + len);){
			  
			  // sets num equal to the first value of this list then itterates to the last
			  T num = (T)this.list[x];
			  
			  //if num is null then it sets its value to temp and sets x so that it ends teh for loop
			  if (num == null){
				  this.list[x] = temp;
				  x = this.numElements + len + 1;
			  }
			  
			  // compares the two numbers and if temp is less than the value of num then it sets list[x] to temp and temp to the old value of list[x]
			  else if(((Comparable<T>) temp).compareTo(num) < 0){
				  T hold = list[x];
				  list[x] = temp;
				  temp = hold;
				  x++;
			  }  
				  else{
					  x++;
				  }

	  	}
	  }
  }
 
  // prints the array given
  public String print(){
	  
	  // sets answer to "" and x to 0
	  String answer = "";
	  int x = 0;
	  
	  //while the list is not null it runs 
	while(!(this.list[x] == null)){
		// sets answer to list[x] and a space
		answer = answer + list[x] + " ";
		x++;
	}
	
	//returns answer
	return answer;
  }
  
 }