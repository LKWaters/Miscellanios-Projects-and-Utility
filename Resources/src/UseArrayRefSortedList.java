import ch06.lists.*;
import ch07.array.*;

public class UseArrayRefSortedList {
	public static void main(String[] args){
	      ListInterface<String> list2 = new ArrayRefSortedStringList(30);
	      list2.add("Wirth");
	      list2.add("Dykstra");
	      list2.add("DePasquale");
	      list2.add("Dahl");
	      list2.add("Nygaard");
	      list2.remove("DePasquale");

	      System.out.println("Sorted ");
	      System.out.println(list2);
	}	      
}
