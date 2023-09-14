package MainPackage;


import java.util.Objects;

public class CourseFile {
	private String nameOfTheFile;
	private Teacher sender;
	private Course course;
	
	
	public CourseFile(String nameOfTheFile, Teacher sender, Course course) {
		this.nameOfTheFile = nameOfTheFile;
		this.sender = sender;
		this.course = course;
	}
	
	public String getNameOfTheFile() {
		return nameOfTheFile;
	}
	
	public Teacher getSender() {
		return sender;
	}
	
	public Course getCourse() {
		return course;
	}
	
	void setChangeNameOfTheFile(String newName) {
		this.nameOfTheFile = newName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, nameOfTheFile);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseFile other = (CourseFile) obj;
		return Objects.equals(course, other.course) && Objects.equals(nameOfTheFile, other.nameOfTheFile);
	}

	@Override
	public String toString() {
		return "CourseFile [The File name = " + nameOfTheFile + ", course = " + course + "]";
	}
	
	
}

