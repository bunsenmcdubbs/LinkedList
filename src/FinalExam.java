
public class FinalExam {

	public static void main(String[] args) {
		StudentList l = new StudentList();
		
		l.insertByLastName(new Student("Thomas","Edgars",89));
		l.insertByLastName(new Student("Jennifer","Smith",86));
		l.insertByLastName(new Student("Harold","Umberton",78));
		l.insertByLastName(new Student("Frank","Martin",60));
		l.insertByLastName(new Student("Jeremy","Andrews",83));
		l.insertByLastName(new Student("Laura","Roberts",93));
		l.insertByLastName(new Student("Adele","Lincoln",85));
		l.insertByLastName(new Student("Peter","Smith",91));
		l.insertByLastName(new Student("Larry","Peterson",72));
		System.out.println("List:\n" + l);
		
		System.out.println("Removing Frank Martin");
		l.remove("Frank Martin");
		System.out.println("List:\n" + l);
		
		System.out.println("Sort By Average");
		l.sortByAverage();
		System.out.println("List:\n" + l);
		
		System.out.println("Sort By Last Name");
		l.sortByLastName();
		System.out.println("List:\n" + l);
		
		System.out.println("\n\nBackwards");
		StudentNode end = null;
		for (StudentNode currentNode = l.getNode(0); currentNode.getNext() != null; currentNode = currentNode.getNext()){
			end = currentNode;
		}
		end = end.getNext();
		StudentNode currentNode = null;
		for (currentNode = end; currentNode.getPrevious() != null; currentNode = currentNode.getPrevious()){
			System.out.println(currentNode);
		}
		System.out.println(currentNode);

	}

}
