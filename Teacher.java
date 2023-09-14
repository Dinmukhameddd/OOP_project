package MainPackage;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;

public class Teacher extends Employee{
	private Level level;
	private Faculty faculty;
	private HashMap<Course, Vector<Student>> students = new HashMap<Course,Vector<Student>>();
	private double rating = 0;
	private int cntRate = 0;
	
	
	
	public Teacher (String ID, String name, String surname, String password, double salary, Level lev, Faculty faculty, Vector<Course> courses) {
		super(ID, name, surname, password, salary);
		this.level = lev;
		this.faculty = faculty;
		for(Course c: courses) {
			this.students.put(c, null);
		}
	}
	
	public boolean addCourseFile(CourseFile f) {
		if(DataBase.addCourseFile(f)) return true;
		return false;
	}
	
	public boolean deleteCourseFile(CourseFile f) {
		if(DataBase.deleteCourseFile(f)) return true;
		return false;
	}
	
	
	public Vector<Course> getAllCourses(){
		return DataBase.getAllCourses();
	}
	
	public Set<Course> getCourses(){
		return students.keySet();
	}
	
	public Vector<CourseFile> getCourseFiles(Course c){
		Vector<CourseFile> cf = new Vector<CourseFile>();
		for(CourseFile cff: DataBase.getAllCourseFiles()) {
			if(cff.getCourse().equals(c) && cff.getSender().equals(this)) {
				cf.add(cff);
			}
		}
		return cf;
	}
	
	public Vector<Student> getInfoAboutStudents(Course c){
		return students.get(c);
	}
	
	public void putMarks(Course c, Student s, String attestation, double mark) {
		Mark m = s.getMarks(c);
		if(attestation.equals("First")) {
			m.setFirstAttestation(mark);
		}
		else if(attestation.equals("Second")){
			m.setSecondAttestation(mark);
			
		}
		
		else if(attestation.equals("Final")){
			m.setFinalExam(mark);
		}
		
	}
	
	
	public double getRate() {
		return this.rating/cntRate;
	}
	
	
	public void getRateFromStudent(int rate) {
		cntRate += 1;
		this.rating += rate;
		
	}
	
	public Vector<Student> getStudents(Course c){
		return students.get(c);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(faculty, level, rating, students);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return  faculty == other.faculty && level == other.level
				&& Double.doubleToLongBits(rating) == Double.doubleToLongBits(other.rating)
				&& Objects.equals(students, other.students);
	}

	@Override
	public String toString() {
		return super.toString() + ", level=" + level + ", faculty=" + faculty + ", rating=" + rating;
	}
	
	

	
	
	
	
	
	
	
	
}
