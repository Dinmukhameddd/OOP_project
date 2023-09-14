package MainPackage;

import java.util.Vector;

public class Manager extends Employee{
	
	public Manager(String id, String name, String surname, String password, double salary) {
		super(id, name, surname, password, salary);
	}
	
	public boolean createCourse(String courseId, String courseName, int credits, Faculty faculty) {
		 Course c = new Course(courseId, courseName, credits, faculty);
		 if(DataBase.addCourse(c)) return true;
		 else return  false;
	}
	
	public Vector<Student> getAllStudents() {
		return DataBase.getAllStudents();
	}
	
	public Vector<Teacher> getAllTeachers() {
		return DataBase.getAllTeachers();
	}
	
	public String createStatisticalReport() {
		Vector<Student> vb = new Vector<Student>(1);
		Vector<Student> vm = new Vector<Student>(1);
		Vector<Student> vp = new Vector<Student>(1);
		Vector<Double> gpa = new Vector<Double>(1);
		double mid = 0;
		double cnt = 0;
		
		for(Student s: DataBase.getAllStudents()) {
			if(s.getLevelOfStudy() == LevelOfStudy.BACHELOR) {
				vb.add(s);
			} else if(s.getLevelOfStudy() == LevelOfStudy.MASTER) {
				vm.add(s);
			} else if(s.getLevelOfStudy() == LevelOfStudy.PHD) {
				vp.add(s);
			}
			gpa.add(s.getGpa());
		}
		
		int b;
		int m;
		int p;
		
		b = vb.size();
		m = vm.size();
		p = vp.size();
		
		String s = null;
		s += "Bachelor: " + b + "\r\n" + "Master: " + m + "\r\n" + "PhD: " + "\r\n";
		
		
		
		for(double g: gpa) {
			cnt += g;
		}
		
		mid = cnt / gpa.size();
		s+= "Average gpa: " + mid;
		
		return s;
	}

	
	public boolean addNews(String title, String content) {
		
		if(DataBase.addNews(new News(title, content))) return true;
		else return false;
	}
	
	
}
