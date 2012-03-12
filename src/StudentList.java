/**
 * <code>StudentList</code> is a doubly linked list with <code>StudentNodes</code>.
 * It has the normal "add", "remove" and "insert" methods. It also has methods for
 * sorting the list such as <code>sortByGPA</code>, <code>sortByLastName</code>.
 * <code>insertByLastName</code> and <code>insertByGPA</code> add <code>Student</code>
 * or <code>StudentNode</code>'s into a sorted list.
 * @author Andrew Dai
 *
 */
public class StudentList {
	
	private StudentNode headNode = null;
	public static final int START = 0;
	
	/**
	 * Constructor that takes a head node.
	 * @param h headNode for the list
	 */
	public StudentList(StudentNode h){
		addStudent(h);
	}
	
	/**
	 * Default constructor
	 * the headnode remains null
	 */
	public StudentList(){
		headNode = null;
	}
	
	/**
	 * Appends a <code>Student</code> to the end of the list.
	 * @param s - <code>Student</code> object
	 */
	public void addStudent(Student s){
		this.addStudent(new StudentNode(s));
	}
	
	/**
	 * Appends a <code>StudentNode</code> to the end of the list.
	 * @param s - <code>StudentNode</code> object
	 */
	public void addStudent(StudentNode s){
		
		if (isEmpty()){
			setHeadNode(s);
			return;
		}
		
		StudentNode currentNode = headNode;
		while(currentNode.getNext() != null){
			currentNode = currentNode.getNext();
		}
		s.setPrevious(currentNode);
		currentNode.setNext(s);
	}
	
	/**
	 * Removes the StudentNode from the list at the index provided and returns it.
	 * @param index of the desired object to be removed
	 * @return the the StudentNode at the <code>index</code>
	 */
	public StudentNode remove(int index){
		if(index == -1){
			return null;
		}
		else if(index == 0){
			StudentNode oldHead = headNode;
			headNode = headNode.getNext();
			return oldHead;
		}
		StudentNode currentNode = getNode(index);
		getNode(index-1).setNext(getNode(index+1));
		getNode(index+1).setPrevious(getNode(index-1));
		currentNode.setNext(null);//returns "nurtured" node aka without next and previous references
		currentNode.setPrevious(null);
		return currentNode;
	}
	
	/**
	 * Removes and returns the first StudentNode whose Student value matches the Student
	 * provided
	 * @param s is the student to be removed from the list.
	 * @return the StudentNode object
	 */
	public StudentNode remove(Student s){
		int target = find(s);
		return remove(target);
	}
	
	/**
	 * Removes and returns the first StudentNode whose Name (<first> <last>) matches the Student
	 * provided
	 * @param s is the student's name who is to be removed from the list.
	 * @return the StudentNode object
	 */
	public StudentNode remove(String name){
		int target = find(name);
		return remove(target);
	}
	
	/**
	 * Finds and returns the index first of the StudentNode which matches the provided Student.
	 * @param s Student
	 * @return index of the student
	 */
	public int find(Student s){
		StudentNode currentNode = headNode;
		for (int i = 0; currentNode.getNext() != null; currentNode = currentNode.getNext()){
			if(s.equals(currentNode)){
				return i;
			}
			currentNode = currentNode.getNext();
			i++;
		}
		return -1;
	}
	
	/**
	 * Finds and returns the index first of the StudentNode whose Student's name matches the provided.
	 * @param s Student
	 * @return index of the student
	 */
	public int find(String name){
		StudentNode currentNode = headNode;
		String cName = currentNode.getValue().getFirstName()
				+ " "
				+ currentNode.getValue().getLastName();
		for (int i = 0; currentNode.getNext() != null; currentNode = currentNode.getNext()){
			if(name.equals(cName)){
				return ++i;
			}
			currentNode = currentNode.getNext();
			cName = currentNode.getValue().getFirstName()
					+ " "
					+ currentNode.getValue().getLastName();
			i++;
		}
		return -1;
	}
	
	/**
	 * Takes a <code>Student</code> object and puts it in a <code>StudentNode</code> ojbect and
	 * delegates to the other <code>insertByLastName(StudentNode)</code>.
	 * @param s - Student to be inserted
	 * @return index of where the Student was inserted
	 */
	public int insertByLastName(Student s){
		return this.insertByLastName(new StudentNode(s));
	}
	
	/**
	 * Takes in a StudentNode and determines where the object should be insert and inserts it 
	 * into the list.
	 * Precondition: the list is already sorted by Last name
	 * @param s the Student or StudentNode that is being inserted.
	 * @return index
	 */
	public int insertByLastName(StudentNode s){
		int i = 0;
		if (isEmpty()){
			setHeadNode(s);
		}
		
		else{
			StudentNode currentNode = headNode;
			String cLast = currentNode.getValue().getLastName(),
					sLast = s.getValue().getLastName();
			
			while((cLast.compareTo(sLast) <= 0)){
				i++;
				if(currentNode.getNext() == null)
					break;
				currentNode = currentNode.getNext();
				cLast = currentNode.getValue().getLastName();
			}
			
			//Moves to first names after comparing last
			if(cLast.equals(sLast)){
				String cFirst = currentNode.getValue().getFirstName(),
						sFirst = s.getValue().getFirstName();
				while(cFirst.compareTo(sFirst) < 0){
					i++;
					if(currentNode.getNext() != null)
						currentNode = currentNode.getNext();
					System.out.println("Win2");
				}
			}
			insertAt(s, i);
		}
		
		return i;
	}
	
	/**
	 * Checks if the List is empty or not by querying the heard node
	 * @return
	 */
	private boolean isEmpty() {
		return (headNode == null);
	}
	
	/**
	 * Sets the headNode of the project to the provided StudentNode.
	 * @param s
	 */
	private void setHeadNode(StudentNode s) {
		headNode = s;
	}
	
	/**
	 * Inserts the Student into the list at the index
	 * @param s - Student to be inserted
	 * @param index - index to insert at
	 */
	public void insertAt(Student s, int index){
		this.insertAt(new StudentNode(s), index);
	}
	
	/**
	 * Inserts the StudentNode into the list at the index
	 * @param s - Student to be inserted
	 * @param index - index to insert at
	 */
	public void insertAt(StudentNode s, int index){
//		System.out.println("Insert " + s + " at " + index);
		if (index == 0){
			s.setNext(headNode);
			headNode.setPrevious(s);
			headNode = s;
			return;
		}
		else if(isValid(index)){
			int i = 0;
			StudentNode currentNode = headNode;
			while(i < index-1){
				i++;
				if (currentNode.getNext() != null)
					currentNode = currentNode.getNext();
				else
					break;
			}
			
			s.setNext(currentNode.getNext());
			currentNode.getNext().setPrevious(s);
			s.setPrevious(currentNode);
			currentNode.setNext(s);
			
			return;
		}
		else if (index == length()){
			addStudent(s);
			return;
		}
	}
	
	/**
	 * Goes through unsorted list and reorders/sorts all the Students by GPA/Average,
	 */
	public void sortByAverage(){
		
		StudentList sorted = new StudentList();
		StudentNode current = headNode;
		for(; current.getNext() != null; current = current.getNext()){
			StudentNode temp = new StudentNode(current.getValue());
			sorted.insertByAverage(temp);
		}
		StudentNode temp = new StudentNode(current.getValue());
		sorted.insertByAverage(temp);
		setHeadNode(sorted.getHeadNode());
	}
	
	/**
	 * Goes through unsorted list and reorders/sorts all the Students by last name
	 */
	public void sortByLastName(){
		StudentList sorted = new StudentList();
		StudentNode current = headNode;
		for(; current.getNext() != null; current = current.getNext()){
			StudentNode temp = new StudentNode(current.getValue());
			sorted.insertByLastName(temp);
		}
		StudentNode temp = new StudentNode(current.getValue());
		sorted.insertByLastName(temp);
		setHeadNode(sorted.getHeadNode());
	}
	
	/**
	 * @returns the headNode of the list
	 */
	private StudentNode getHeadNode() {
		return headNode;
	}
	
	/**
	 * If the grades are the same it moves to comparing alphabetical order
	 * @param s
	 * @return
	 */
	public int insertByAverage(StudentNode s){
		int i = 0;
		if (isEmpty()){
			setHeadNode(s);
		}
		
		else{
			StudentNode currentNode = headNode;
			int cGPA = currentNode.getValue().getGPA();
			int sGPA = s.getValue().getGPA();
			
			while((cGPA >= sGPA)){
				i++;
				if(currentNode.getNext() == null)
					break;
				currentNode = currentNode.getNext();
				cGPA = currentNode.getValue().getGPA();
			}
			
			//Moves to last names after comparing GPA
			if(cGPA == sGPA){
				String cLast = currentNode.getValue().getLastName(),
				sLast = s.getValue().getLastName();
				while((cLast.compareTo(sLast) <= 0)){
					i++;
					if(currentNode.getNext() == null)
						break;
					currentNode = currentNode.getNext();
					cLast = currentNode.getValue().getLastName();
				}
				
				//Moves to first names after comparing last
				if(cLast.equals(sLast)){
					String cFirst = currentNode.getValue().getFirstName(),
							sFirst = s.getValue().getFirstName();
					while(cFirst.compareTo(sFirst) < 0){
						i++;
						if(currentNode.getNext() != null)
							currentNode = currentNode.getNext();
						System.out.println("Win2");
					}
				}
			}
			insertAt(s, i);
		}
		return i;
	}
	
	/**
	 * Checks if the provided index is valid
	 * @param index
	 * @return
	 */
	public boolean isValid(int index) {
		return ((index < length()) && (index >= 0));
	}

	/**
	 * Runs through the list and sets the length of the town. 
	 * @return
	 */
	public int length(){
		if(isEmpty()){
			return 0;
		}
		int length;
		StudentNode currentNode = headNode;
		for (length = 1; currentNode.getNext() != null; currentNode = currentNode.getNext())
			length++;
		return length;
	}
	
	/**
	 * 
	 * @param index
	 * @returns the StudentNode at index on the list
	 */
	public StudentNode getNode(int index){
		
		int i = 0;
		StudentNode currentNode = headNode;
		
		while(currentNode.getNext() != null && i < index){
			currentNode = currentNode.getNext();
			i++;
		}
		
		return currentNode;
	}
	
	public String toString(){
		String s = "";
		StudentNode current = headNode;
		s += current;
		try{
			while (current.getNext() != null){
				s += "\n";
				current = current.getNext();
				s += current;
			}
		}
		catch (NullPointerException e){
			return "List is Empty";
		}
		s += "\n";
		return s;
	}
	
}
