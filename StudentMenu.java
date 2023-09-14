package MenuConsole;

import java.io.*;

import MainPackage.Admin;
import MainPackage.Course;
import MainPackage.CourseFile;
import MainPackage.DataBase;
import MainPackage.InvalidPasswordException;
import MainPackage.Manager;
import MainPackage.Student;
import MainPackage.StudentOrganization;
import MainPackage.Teacher;
import MainPackage.User;

public class StudentMenu extends Menu{
	
	private Student s;
	
	String[] variants = {"View Courses", "View Course Files", "View Marks", "View Transcript", "View Info About Teachers",
			              "Rate Teachers", "Register Course", "View All Student Organizations", "Create Student Organization",
			              "Join Student Organizations", "View Messages", "Send Messages", "View News", "Exit"};
	
	public StudentMenu(User u) {
		this.s = (Student) u;
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
					 for(Course c: s.getStudentCourses()) {
						 System.out.println(c.getCourseName());
					 }
				 }
				 
				 else if(n == 2) {
					 System.out.println("Choose a course: ");
					 Course[] c = (Course[]) s.getStudentCourses().toArray(new Course[s.getStudentCourses().size()]);
					 for(int i = 0; i < c.length; i++) {
						 System.out.println((i+1) + " - " + c[i].getCourseName());
					 }
					 st  = br.readLine();
					 ch = Integer.parseInt(st);
					 
					 for(CourseFile cf: s.getCourseFiles(c[ch-1])) {
						 System.out.println(cf.toString());
					 }
				 }
				 
				 else if(n == 3) {
					 System.out.println("Choose a course: ");
					 Course[] c = (Course[]) s.getStudentCourses().toArray(new Course[s.getStudentCourses().size()]);
					 for(int i = 0; i < c.length; i++) {
						 System.out.println((i+1) + " - " + c[i].getCourseName());
					 }
					 st  = br.readLine();
					 ch = Integer.parseInt(st);
					 
					 System.out.println("Firts Attestation: " + s.getMarks(c[ch-1]).getMarksFirstAtt() + "\r\n" + "Second Attestation: " +
							 s.getMarks(c[ch-1]).getMarksSecondAtt() + "\r\n" + "Final: " + s.getMarks(c[ch-1]).getMarkFinalExam());
				 }
				 else if(n == 4) {
					 for(String str: s.getTranscript()) {
						 System.out.println(str);
					 }
					 
				 }
				 
				 else if(n == 5) {
					 for(Teacher t: s.getTeachers()) {
						 System.out.println(t.toString());
					 }
				 }
				 
				 else if(n == 6) {
					 System.out.println("Choose a teacher: ");
					 Teacher[] t = (Teacher[]) s.getTeachers().toArray(new Teacher[s.getTeachers().size()]);
					 for(int i = 0; i < t.length; i++) {
						 System.out.println((i+1) + " - " + t[i].getSurname() + " " + t[i].getName());
					 }
					 st  = br.readLine();
					 ch = Integer.parseInt(st);
					 
					 System.out.println("Rate teacher from 0 to 10");
					 st = br.readLine();
					 int rate = Integer.parseInt(st);
					 
					 t[ch-1].getRateFromStudent(rate);
				 }
				 
				 else if(n == 7) {
					 System.out.println("Choose a course: ");
					 Course[] c = (Course[]) DataBase.getAllCourses().toArray(new Course[DataBase.getAllCourses().size()]);
					 for(int i = 0; i < c.length; i++) {
						 System.out.println((i+1) + " - " + c[i].getCourseName());
					 }
					 st  = br.readLine();
					 int chCourse = Integer.parseInt(st);
					 if(s.registerCourse(c[chCourse-1])) System.out.println("Success!");
					 else System.out.println("You can not register on this Course");
				 }
				 
				 else if(n == 8) {
					 for(StudentOrganization so: DataBase.getAllStudOrganizations()) {
						 System.out.println(so.toString());
					 }
				 }
				 else if(n == 9) {
					 System.out.println("Write a name for Organization");
					 
					 st  = br.readLine();
					 
					 if(s.createStudentOrganization(st, s)) System.out.println("Success!");
					 else System.out.println("Such Organization exist!");
				 }
				 
				 else if(n == 10) {
					 System.out.println("Choose a stud Organization: ");
					 StudentOrganization[] so = (StudentOrganization[]) DataBase.getAllStudOrganizations().toArray(new StudentOrganization[DataBase.getAllStudOrganizations().size()]);
					 for(int i = 0; i < so.length; i++) {
						 System.out.println((i+1) + " - " + so[i].getNameOfOrganization());
					 }
					 
					 st  = br.readLine();
					 ch = Integer.parseInt(st);
					 
					 if(s.joinStudentOrganization(so[ch-1])) System.out.println("Success!");
					 else System.out.println("You are already member!");
				 }
				 
				 else if(n == 11) {
					 viewMessages(s);
				 }
				 
				 else if(n == 12) {
					 sendMessages(s);
					 
				 }
				 
				 else if(n == 13) {
					 viewNews(s);
				 }
				 
				 else if(n == 14) {
					 check = false;
					 loginSys();
					 while(!loginSys()) {
						 loginSys();
					 }
				 }
				line = br.readLine();
			}
			// close stream
			br.close();
		} catch(IOException ioe) {
			System.out.println("Can't read!");
		}
		
	}
	
}

