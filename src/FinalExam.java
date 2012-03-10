
public class FinalExam {

	public static void main(String[] args) {
		StudentList l = new StudentList();
		
//		System.out.println("1Thomas Edgars\n");
		l.insertByLastName(new Student("Thomas","Edgars",89));
		
//		System.out.println("2Jennifer Smith\n");
		l.insertByLastName(new Student("Jennifer","Smith",86));
		
//		System.out.println("3Harold Umberton\n");
		l.insertByLastName(new Student("Harold","Umberton",78));
		
//		System.out.println("4Frank Martin\n");
		l.insertByLastName(new Student("Frank","Martin",60));
		
//		System.out.println("5Jeremy Andrews\n");
		l.insertByLastName(new Student("Jeremy","Andrews",83));
		
//		System.out.println("6Laura Roberts\n");
		l.insertAt(new Student("Laura","Roberts",93), 3);
		
//		System.out.println("7Adele Lincoln\n");
		l.insertByLastName(new Student("Adele","Lincoln",85));
		
//		System.out.println("8Peter Smith\n");
		l.insertByLastName(new Student("Peter","Smith",91));
		
//		System.out.println("9Larry Peterson\n");
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
