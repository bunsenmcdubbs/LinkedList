
public class StudentList {
	
	private StudentNode headNode = null;
	//private int length;//TODO stop failing
	public static final int END = -1;
	public static final int START = 0;
	
	//Working
	public StudentList(StudentNode h){
		addStudent(h);
	}
	
	//Working
	public StudentList(){
		headNode = null;
//		length = 0;
	}
	
	//Working
	public void addStudent(Student s){
		this.addStudent(new StudentNode(s));
	}
	
	//Working
	public void addStudent(StudentNode s){
//		length++;
		
		if (isEmpty()){
			setHeadNode(s);
			return;
		}
		
		StudentNode currentNode = headNode;
		while(currentNode.getNext() != null){
			currentNode = currentNode.getNext();
		}
		
		currentNode.setNext(s);
	}
	
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
		currentNode.setNext(null);//returns "nurtured" node aka without next reference
		
//		length--;
		return currentNode;
	}
	
	public StudentNode remove(Student s){
		int target = find(s);
		return remove(target);
	}
	
	public StudentNode remove(String name){
		int target = find(name);
		return remove(target);
	}
	
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
	
	//Working
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
	
	public int insertByLastName(Student s){
		return this.insertByLastName(new StudentNode(s));
	}
	
	//Working
	public int insertByLastName(StudentNode s){
		int i = 0;
		if (isEmpty()){
			setHeadNode(s);
			System.out.println("empty");
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
//			System.out.println(i);
			insertAt(s, i);
		}
		
//		length++;
		return i;
	}
	
	//work
	private boolean isEmpty() {
		return (headNode == null);
	}
	
	//work
	private void setHeadNode(StudentNode s) {
		headNode = s;
	}

	//working
	public void insertAt(Student s, int index){
		this.insertAt(new StudentNode(s), index);
	}
	
	//working NEXT
	public void insertAt(StudentNode s, int index){
//		System.out.println("Insert " + s + " at " + index);
//		System.out.println(this);
//		System.out.println(isValid(index));
		if (index == 0){
			s.setNext(headNode);
			headNode = s;
			return;
		}
		else if(isValid(index)){
			int i = 0;
			StudentNode currentNode = headNode;
			while((i < index-1)){
				i++;
				if (currentNode.getNext() != null)
					currentNode = currentNode.getNext();
				else
					break;
			}
			
			s.setNext(currentNode.getNext());
			currentNode.setNext(s);
//			length++;
			
			return;
		}
		else if (index == length()){
			addStudent(s);
			return;
		}
	}
	
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
	
	private StudentNode getHeadNode() {
		return headNode;
	}

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
				//System.out.println("move to next");
			}
			
			//Moves to first names after comparing last
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
//		length++;
		return i;
	}
	
	public boolean isValid(int index) {
		//checkLength();
//		System.out.println("Length: " + length());
		return ((index < length()) && (index >= 0));
	}

	//Working
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
	
//	private int checkLength(){
//		int i = 0;
//		StudentNode currentNode = headNode;
//		while(currentNode.getNext() != null){
//			currentNode = currentNode.getNext();
//			i++;
//		}
//		length = i;
//		
//		return length;
//	}
	
	//Working
	public StudentNode getNode(int index){
		
		int i = 0;
		StudentNode currentNode = headNode;
		
		while(currentNode.getNext() != null && i < index){
			currentNode = currentNode.getNext();
			i++;
		}
		
		return currentNode;
	}
	
	//Working
	public StudentIterator addIterator(){
		return new StudentIterator(headNode);
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
