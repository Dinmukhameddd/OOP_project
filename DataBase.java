package MainPackage;
import java.util.Vector;

public final class DataBase {
	
	private static Vector<User> allUsers = new Vector<User>();
	private static Vector<Course> allCourses = new Vector<Course>();
	private static Vector<News> allNews = new Vector<News>();
	private static Vector<CourseFile> allCourseFiles = new Vector<CourseFile>();
	private static Vector<StudentOrganization> allStudentOrganizations = new Vector<StudentOrganization>();
	private static Vector<Student> allStudents = new Vector<Student>();
	private static Vector<Teacher> allTeachers = new Vector<Teacher>();
 	
	private static final DataBase DB = new DataBase();
	
	private DataBase() {};
	
	public static DataBase getInstance() {
		return DB;
	}
	
	public static boolean addUser(User u) {
		if(allUsers.contains(u)) return false;
		else {
			allUsers.add(u);
			if(u instanceof Student) {
				allStudents.add((Student)u);
			}
			else if (u instanceof Teacher) {
				allTeachers.add((Teacher)u);
			}
		}
		return true;
	}
	
	public static boolean addCourse(Course c) {
		if(allCourses.contains(c)) return false;
		allCourses.add(c);
		return true;
	}
	
	public static Vector<User> getAllUsers() {
		return allUsers;
	}
	
	public static Vector<Course> getAllCourses(){
		return allCourses;
	}
	
	public static boolean deleteUser(User u) {
		if(allUsers.contains(u)) {
			
			allUsers.remove(u);
			
			if(u instanceof Student) {
				return allStudents.remove(u);
				
			}
			
			else if(u instanceof Teacher) {
				return allTeachers.remove(u);
			}
		
		}
		return false;
	}
	
	public static boolean deleteCourse(Course c) {
		for(Course crs: allCourses) {
			if(crs.getPrereq().contains(c)) {
				crs.deletePrereq(c);
			}
		}
		
		return allCourses.remove(c);
	}
	
	public static Vector<News> getAllNews(){
		return allNews;
	}
	
	public static boolean addNews(News n) {
		if(allNews.contains(n)) return false;
		allNews.add(n);
		return true;
	}
	
	public static Vector<CourseFile> getAllCourseFiles(){
		return allCourseFiles;
	}
	
	public static boolean addCourseFile(CourseFile cf) {
		if(allCourseFiles.contains(cf)) return false;
		allCourseFiles.add(cf);
		return true;
	}
	
	public static boolean deleteCourseFile(CourseFile cf) {
		return allCourseFiles.remove(cf);
	}
	
	public static Vector<StudentOrganization> getAllStudOrganizations() {
		return allStudentOrganizations;
	}
	
	public static boolean addStudOrganization(StudentOrganization so) {
		if(allStudentOrganizations.contains(so)) return false;
		allStudentOrganizations.add(so);
		return true;
		
	}
	
	public static boolean deleteStudOrganization(StudentOrganization so) {
		return allStudentOrganizations.remove(so);
	}
	
	public static Vector<Student> getAllStudents(){
		return allStudents;
	}
	
	public static Vector<Teacher> getAllTeachers(){
		return allTeachers;
	}
	
	
}
