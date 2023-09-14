package MenuConsole;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import MainPackage.*;


public class ManagerMenu extends Menu {
	String[] variants = {"Create Course", "View All Students", "View All Teachers", "View Statistical Report", "Add News", "Exit"};
	
	private Manager m;
	
	
	public ManagerMenu(User u)  {
		this.m = (Manager)u;
	}

	@Override
	public void running() throws InvalidPasswordException {
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
					 System.out.println("Write ID of the course");
					 String id = br.readLine();
					 System.out.println("Write name of course");
					 String name = br.readLine();
					 System.out.println("Write credits");
					 String cr = br.readLine();
					 int cred = Integer.parseInt(cr);
					 System.out.println("Write Faculty");
					 String fac = br.readLine();
					 Faculty f = Faculty.valueOf(fac);
					 Course c = new Course(id, name, cred, f);
					 if(DataBase.addCourse(c)) System.out.println("Access!");
					 else System.out.println("Error!");
				 }
				 
				 if(n==2) {
					 for(Student s: DataBase.getAllStudents()) {
						 System.out.println(s.toString());
					 }
				 }
				 
				 if(n==3) {
					 for(Teacher t: DataBase.getAllTeachers()) {
						 System.out.println(t.toString());
					 }
				 }
				 
				 if(n==4) {
					 System.out.println(m.createStatisticalReport());
				 }
				 
				 if(n==5) {
					 System.out.println("Write Title of The News");
					 String title = br.readLine();
					 System.out.println("Write news");
					 String content = br.readLine();
					 
					 if(m.addNews(title, content)) System.out.println("Success!");
					 else System.out.println("Error");
				 }
				 if(n == 6) {
					 check = false;
					 loginSys();
					 while(!loginSys()) {
						 loginSys();
					 }
				 }
			}
			br.close();
		}
		 catch(IOException ioe) {
				System.out.println("Can't read!");
			}
	}
			
		

}
