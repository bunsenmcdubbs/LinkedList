import java.util.ListIterator;
import java.util.NoSuchElementException;


public class StudentIterator{
	
	private StudentNode next = null;
	private StudentNode previous = null;
	private int place = 0;
	
	public StudentIterator(StudentNode head){
		next = head;
	}
	
	public boolean hasNext(){
		return (next.getNext() != null);
	}
	
	public StudentNode next(){
		if(!hasNext())
			throw new NoSuchElementException();
		previous = next;
		next = next.getNext();
		place++;
		System.out.println("next");
		return next;
	}
	
	public int getPlace(){
		return place;
	}
	
	public void goTo(int i){
		while((getPlace() < i) && !hasNext()){
			next();
		}
	}

	public boolean hasPrevious() {return false;}

	public StudentNode getPrevious() {return previous;}

	public int previousIndex() {return -1;}
}
