package MainPackage;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;

public class Student extends User{
	private LevelOfStudy levelOfStudy;
	private Faculty faculty;
	private HashMap<Course, Mark> marks = new HashMap<Course, Mark>();
	private int creditsOfStudent = 0;
	private HashMap<Course, Mark> passedCourses = new HashMap<Course, Mark>();
	
	
	public Student(){
		
	}
	
	public Student(String ID, String name, String surname, String password, LevelOfStudy levelOfStudy, Faculty faculty) {
		super(ID, name, surname, password);
		this.levelOfStudy = levelOfStudy;
		this.faculty = faculty;
	}
	
	public LevelOfStudy getLevelOfStudy() {
		return this.levelOfStudy;
	}
	
	public void setLevelOfStudy(LevelOfStudy l) {
		this.levelOfStudy = l;
	}
	
	public Faculty getFaculty() {
		return this.faculty;
	}
	
	public Set<Course> getStudentCourses(){
		return marks.keySet();
	}
	
	public Vector<CourseFile> getCourseFiles(Course course) {
		Vector<CourseFile> cf = new Vector<CourseFile>();
		for(CourseFile x: DataBase.getAllCourseFiles()) {
			if(x.getCourse() == course) {
				cf.add(x);
			}
		}
		
		return cf;
	}
	
	public Mark getMarks(Course course) {
		
		return marks.get(course);
	}
	
	public Vector<Teacher> getTeachers () {
		Vector<Teacher> info = new Vector<Teacher>();
		for(Teacher t : DataBase.getAllTeachers()) {
			for(Course c: getStudentCourses()) {
				if(t.getCourses().contains(c) && t.getStudents(c).contains(this)) {
					info.add(t);
				}
			}
		}
		
		return info;
	}
	
	public Vector<String> getTranscript() {
		Vector<String> v = new Vector<String>();
		for(Course c: passedCourses.keySet()) {
			v.add(c.getCourseName()+ ":" + "\r\n" + passedCourses.get(c).toString());
		}
		
		for(Course c: marks.keySet()) {
			v.add(c.getCourseName()+ ":" + "\r\n" + passedCourses.get(c).toString());
		}
		
		return v;
	}
	
	
	
	public double getGpa() {
		double totalNum = 0;
		for(Course c: getStudentCourses()) {
			totalNum += marks.get(c).getNumberMark();
		}
		
		return totalNum/21;
	}
	
	public boolean registerCourse(Course c) {
		
		if(c.getFaculty() != this.faculty) return false;

		if(this.creditsOfStudent > 21) return false;
		
		for(Course crs: c.getPrereq()) {
			if(!passedCourses.containsKey(crs)) return false;
		}
		
		return true;
	}
	
	
	public boolean createStudentOrganization(String s, Student st) {
			StudentOrganization so = new StudentOrganization(s, this);
			if(DataBase.getAllStudOrganizations().contains(so)) return false;
			DataBase.addStudOrganization(so);
			return true;
		
	}

	
	public boolean joinStudentOrganization(StudentOrganization so) {
		if(so.getStudents().contains(this)) {
			return false;
		}
		so.addMember(this);
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(creditsOfStudent, faculty, levelOfStudy);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return creditsOfStudent == other.creditsOfStudent && faculty == other.faculty
				&& levelOfStudy == other.levelOfStudy && Objects.equals(marks, other.marks);
	}

	@Override
	public String toString() {
		return super.toString() + ", levelOfStudy=" + levelOfStudy + ", faculty=" + faculty + ", " + "creditsOfStudent=" + creditsOfStudent+"]";
	}
	
	
	
	
	
	
	
	
		
	
	
}
