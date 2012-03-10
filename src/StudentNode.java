
public class StudentNode {
	private Student value; 
	private StudentNode next;
	private StudentNode previous;
	public StudentNode(Student s){
		value = s;
		next = null;
		previous = null;
	}
	public Student getValue(){return value;}
	public StudentNode getNext(){return next;}
	public StudentNode getPrevious(){return previous;}
	public void setValue(Student s){value = s;}
	public void setNext(StudentNode next){this.next = next;}
	public void setPrevious(StudentNode previous){this.previous = previous;}
	public String toString(){
		return value.toString();
	}
}
