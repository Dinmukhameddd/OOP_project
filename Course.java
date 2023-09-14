package MainPackage;

import java.util.Objects;
import java.util.Vector;

public class Course implements Comparable <Course> {
	private String courseID;
	private String courseName;
	private int credits;
	private Faculty faculty;
	private Vector<Course> prereq = new Vector<Course>();
	
	public Course(String courseID, String courseName, int credits, Faculty faculty) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.credits = credits;
		this.faculty = faculty;
	}
	
	public String getCourseId() {
		return courseID;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public Vector<Course> getPrereq() {
		return prereq;
	}
	public boolean addPrereq(Course c) {
		if(prereq.contains(c)) return false;
		prereq.add(c);
		return true;
	}
	
	public boolean deletePrereq(Course c) {
		if(!prereq.contains(c)) return false;
		prereq.remove(c);
		return true;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}
	
	public int getCredits() {
		return this.credits;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(courseID, other.courseID) && Objects.equals(courseName, other.courseName)
				&& credits == other.credits && Objects.equals(prereq, other.prereq);
	}
	
	public int compareTo(Course c) {
		if(this.credits > c.credits) {
			return 1;
		} else if(this.credits < c.credits) {
			return -1;
		} 
		
		return 0;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + courseID + ", course_name=" + courseName + ", faculty = " + faculty +", credits=" + credits + " ]";
	}
	
	
}
