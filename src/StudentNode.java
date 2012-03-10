
public class StudentNode {
	private Student value; 
	private StudentNode next;
	public StudentNode(Student s){
		value = s;
		next = null;
	}
	public StudentNode(Student s, StudentNode next){
		value = s;
		this.next = next;
	}
	public Student getValue(){return value;}
	public StudentNode getNext(){return next;}
	public void setValue(Student s){value = s;}
	public void setNext(StudentNode next){this.next = next;}
	public String toString(){
		return value.toString();
	}
}
