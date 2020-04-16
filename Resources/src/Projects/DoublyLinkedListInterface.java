package Projects;

public interface DoublyLinkedListInterface<T> {

	public void add(T num);
	
	public void find(T num);
	
	public int size();
	
	public boolean contains(T num);
	
	public boolean remove(T num);
	
	public T get(T num);
	
	public String toString();
	
	public void reset();
	
	public T getNext();
	
	public void resetBack();
	
	public T getPrevious();
	
}
