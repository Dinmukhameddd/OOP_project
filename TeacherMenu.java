package MenuConsole;

import java.io.*;

import MainPackage.*;

public class TeacherMenu extends Menu{
	
	private Teacher t;
	
	String[] variants = {"Add Course File", "Delete Course File", "View All Courses", "View All Courses Files", "View Info About Students",
			              "Put Marks", "View Rate", "View Messages", "Send Messages", "View News", "Exit"};
	
	public TeacherMenu(User u) {
		this.t = (Teacher)u;
	}


	@Override
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
						 System.out.println("Choose a course: ");
						 Course[] c = (Course[]) t.getCourses().toArray(new Course[t.getCourses().size()]);
						 for(int i = 0; i < c.length; i++) {
							 System.out.println((i+1) + " - " + c[i].getCourseName());
						 }
						 st  = br.readLine();
						 ch = Integer.parseInt(st);
						 System.out.println("Write the name of the file: ");
						 String s = br.readLine();
						 
						 CourseFile cf = new CourseFile(s, t, c[ch-1]);
						 
						 if(t.addCourseFile(cf)) System.out.println("Success!");
						 else System.out.println("Such file exist!");
					 }
					 
					 else if(n == 2) {
						 System.out.println("Choose a course: ");
						 Course[] c = (Course[]) t.getCourses().toArray(new Course[t.getCourses().size()]);
						 for(int i = 0; i < c.length; i++) {
							 System.out.println((i+1) + " - " + c[i].getCourseName());
						 }
						 st  = br.readLine();
						 ch = Integer.parseInt(st);
						 
						 System.out.println("Choose file: ");
						 CourseFile[] cfs = (CourseFile[]) t.getCourseFiles(c[ch-1]).toArray(new CourseFile [t.getCourseFiles(c[ch-1]).size()]);
						 for(int i = 0; i < cfs.length; i++) {
							 System.out.println((i+1) + " - " + cfs[i].getNameOfTheFile());
						 }
						 st  = br.readLine();
						 ch = Integer.parseInt(st);
						 
						 if(t.deleteCourseFile(cfs[ch-1])) System.out.println("Success!");
						 else System.out.println("Smth happened!");
					 }
					 
					 else if(n == 3) {
						 for(Course c : t.getAllCourses()) {
							 System.out.println(c.toString());
						 }
					 }
					 else if(n == 4) {
						 System.out.println("Choose a course: ");
						 Course[] c = (Course[]) t.getCourses().toArray(new Course[t.getCourses().size()]);
						 for(int i = 0; i < c.length; i++) {
							 System.out.println((i+1) + " - " + c[i].getCourseName());
						 }
						 st  = br.readLine();
						 ch = Integer.parseInt(st);
						 
						 for(CourseFile cf: t.getCourseFiles(c[ch-1])) {
							 System.out.println(cf.getNameOfTheFile());
						 }
					 }
					 
					 else if(n == 5) {
						 System.out.println("Choose a course: ");
						 Course[] c = (Course[]) t.getCourses().toArray(new Course[t.getCourses().size()]);
						 for(int i = 0; i < c.length; i++) {
							 System.out.println((i+1) + " - " + c[i].getCourseName());
						 }
						 st  = br.readLine();
						 ch = Integer.parseInt(st);
						 for(Student s: t.getStudents(c[ch-1])) {
							 System.out.println(s.toString());
						 }
						 
					 }
					 
					 else if(n == 6) {
						 System.out.println("Choose a course: ");
						 Course[] c = (Course[]) t.getCourses().toArray(new Course[t.getCourses().size()]);
						 for(int i = 0; i < c.length; i++) {
							 System.out.println((i+1) + " - " + c[i].getCourseName());
						 }
						 st  = br.readLine();
						 int chCourse = Integer.parseInt(st);
						 System.out.println("Choose a Student: ");
						 Student[] stud = (Student[])t.getStudents(c[chCourse-1]).toArray(new Student[t.getStudents(c[chCourse-1]).size()]);
						 for(int i = 0; i < stud.length; i++) {
							 System.out.println((i+1) + " - " + stud[i].getSurname() + " " + stud[i].getName());
						 }
						 
						 st  = br.readLine();
						 ch = Integer.parseInt(st);
						 
						 System.out.println("Choose Attestation: ");
						 String at = br.readLine();
						 System.out.println("Put Mark: ");
						 st = br.readLine();
						 int mark = Integer.parseInt(st);
						 t.putMarks(c[chCourse-1], stud[ch-1], at, mark);
					 }
					 
					 else if(n == 7) {
						 System.out.println(t.getRate());
					 }
					 
					 else if(n == 8) {
						 viewMessages(t);
					 }
					 
					 else if(n == 9) {
						 sendMessages(t);
						 
					 }
					 
					 else if(n == 10) {
						 viewNews(t);
					 }
					 else if(n == 11) {
						 check = false;
						 loginSys();
						 while(!loginSys()) {
							 loginSys();
						 }
						 
					 }
					line = br.readLine();
				}
				
				br.close();
		
		} catch(IOException ioe) {
			System.out.println("Can't read!");
		}
		
	}
	
}
