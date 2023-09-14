package MenuConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import MainPackage.*;

public class AdminMenu extends Menu {
	String[] variants = {"Add User", "Delete User", "View All User", "Change Password To User", 
			"View Messages", "Send Messages", "View News", "Exit"};
	
	private Admin a;
	
	public AdminMenu(User u) {
		this.a = (Admin)u;
	}
	
	public void running() throws InvalidPasswordException {
		
		// TODO Auto-generated method stub
		try {
			//br reads from console, pw writes to console (yes, the same as System.out.println), pwFile writes to file
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			boolean check = true;
			String st;
			int ch;
			
			viewMenu(variants);

			while (check) {
				String line = br.readLine();
				int n = Integer.parseInt(line);
				 if(n == 1) {
					 String name, surname, password;
					 String[] types = {"Teacher", "Student", "Librarian", "Manager"};
					 System.out.println("Choose a type of user: ");
					 for(int i = 0; i < types.length; i++) {
						 System.out.println((i+1) + " - " + types[i]);
					 }
					 st  = br.readLine();
					 int chType = Integer.parseInt(st);
					 
					 System.out.println("Write id");
					 String id = br.readLine();
					 
					 System.out.println("Write surname");
					 surname = br.readLine();
					 
					 System.out.println("Write name");
					 name = br.readLine();
					 
					 System.out.println("Write password");
					 password  = br.readLine();
					 
					 if(chType == 1) {
						 System.out.println("Salary: ");
						 double salary = Integer.parseInt(br.readLine());
						 System.out.println("Write Level of teacher");
						 line = br.readLine();
						 Level l = Level.valueOf(line);
						 System.out.println("Write faculty of teacher");
						 line = br.readLine();
						 Faculty fac = Faculty.valueOf(line);
						 
						 System.out.println("Choose courses (Press 'q' to finish with courses)");
						 Course[] c = (Course[]) DataBase.getAllCourses().toArray(new Course[DataBase.getAllCourses().size()]);
						 for(int i = 0; i < c.length; i++) {
							 System.out.println((i+1) + " - " + c[i].getCourseName());
						 }
						 String line1 = br.readLine();
						 Vector<Course> cr = new Vector<Course>();
						 while(!line1.equals("q")) {
							 int m = Integer.parseInt(line1);
							 cr.add(c[m-1]);
							 line1 = br.readLine();
						 }
						 
						 Teacher t = new Teacher(id, name, surname, password, salary, l, fac, cr);
						 if(a.addUser(t)) System.out.println("Success!");
						 else {
							 System.out.println("Such user exists");
						 }
					    }
					 
					 if(chType == 2) {
						 System.out.println("Write Level of Student");
						 line = br.readLine();
						 LevelOfStudy l = LevelOfStudy.valueOf(line);
						 System.out.println("Write faculty of Student");
						 line = br.readLine();
						 Faculty fac = Faculty.valueOf(line);
						 
						 Student stu = new Student(id, name, surname, password, l, fac);	
						 if(a.addUser(stu)) System.out.println("Success!");
						 else System.out.println("Such Student exists");
					 
					 }
					 
					 if(chType == 3) {
						 System.out.println("Salary: ");
						 double salary = Integer.parseInt(br.readLine());
						 Librarian lb = new Librarian(id, name, surname, password, salary);
						 if(a.addUser(lb)) System.out.println("Success!");
						 else {
							 System.out.println("Such librarian exists");
						 }
					 }
					 
					 if(chType == 4) {
						 System.out.println("Salary: ");
						 double salary = Integer.parseInt(br.readLine());
						 Manager mg = new Manager(id, name, surname, password, salary);
						 if(a.addUser(mg)) System.out.println("Success!");
						 else {
							 System.out.println("Such manager exists");
						 }
					 }
				 }
				 
				 if(n==2) {
					 System.out.println("Choose an user: ");
					 User[] u = (User[]) DataBase.getAllUsers().toArray(new User[DataBase.getAllUsers().size()]);
					 
					 for(int i = 0; i < u.length; i++) {
						 System.out.println((i+1) + " - " + u[i].getSurname() + " " + u[i].getName());
					 }
					 
					 ch = Integer.parseInt(br.readLine());
					 
					 if(DataBase.deleteUser(u[ch-1])) System.out.println("Success!");
					 else System.out.println("Can't delete");
				 }
				 
				 if(n == 3) {
					 for(User u : DataBase.getAllUsers()) {
						 System.out.println(u.toString());
					 }
				 }
				 
				 if(n == 4) {
					 System.out.println("Choose an user: ");
					 User[] u = (User[]) DataBase.getAllUsers().toArray(new User[DataBase.getAllUsers().size()]);
					 
					 for(int i = 0; i < u.length; i++) {
						 System.out.println((i+1) + " - " + u[i].getSurname() + " " + u[i].getName());
					 }
					 
					 ch = Integer.parseInt(br.readLine());
					 
					 System.out.println("Write old password");
					 String oldPass = br.readLine();
					 
					 System.out.println("Write new password");
					 String newPass = br.readLine();
					 
					 a.changePasswordToUser(u[ch-1], oldPass, newPass);
					 
				 }
				 
				 
				 if(n == 5) {
					 viewMessages(a);
				 }
				 
				 if(n == 6) {
					 sendMessages(a);
				 }
				 
				 if(n == 7) {
					 viewNews(a);
				 }
				 
				 else if( n == 8) {
					 check = false;
					 loginSys();
					 while(!loginSys()) {
						 loginSys();
					 }
				 }
			}
			
			br.close();
			
		}catch(IOException ioe) {
				System.out.println("Can't read!");
			}
		}

	
}
