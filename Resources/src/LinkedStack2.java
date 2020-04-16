//----------------------------------------------------------------------
// LinkedStack2.java         by Dale/Joyce/Weems               Chapter 4
//
// Extends LinkedStack with a printReversed method.
//----------------------------------------------------------------------

import ch03.stacks.*;
import support.LLNode;

public class LinkedStack2<T> extends LinkedStack<T> 
{
  private void revPrint(LLNode<T> listRef)
  {
    if (listRef != null)
    {
      revPrint(listRef.getLink());
      System.out.print(" " + listRef.getInfo());  //LaMastra: replaced println with print
    }
  }
  
  public void printReversed()
  {
    revPrint(top);
  }
}
