
public class FinalExam {

	public static void main(String[] args) {
		StudentList l = new StudentList();
		
		System.out.println("\n1Thomas Edgars");
		l.insertByLastName(new Student("Thomas","Edgars",89));
		
		System.out.println("\n2Jennifer Smith");
		l.insertByLastName(new Student("Jennifer","Smith",86));
		
		System.out.println("\n3Harold Umberton");
		l.insertByLastName(new Student("Harold","Umberton",78));
		
		System.out.println("\n4Frank Martin");
		l.insertByLastName(new Student("Frank","Martin",60));
		
		System.out.println("\n5Jeremy Andrews");
		l.insertByLastName(new Student("Jeremy","Andrews",83));
		
		System.out.println("\n6Laura Roberts");
		l.insertAt(new Student("Laura","Roberts",93), 3);
		
		System.out.println("\n7Adele Lincoln");
		l.insertByLastName(new Student("Adele","Lincoln",85));
		
		System.out.println("\n8Peter Smith");
		l.insertByLastName(new Student("Peter","Smith",91));
		
		System.out.println("\n9Larry Peterson");
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
	}

}
