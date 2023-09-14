package MainPackage;
import java.util.HashSet;


public class StudentOrganization {
		private HashSet<Student> students = new HashSet <Student>();
		
		private String nameOfOrganization;
		
		private Student headOfOrganization;
		
		public StudentOrganization() {
			
		}
		
		public StudentOrganization(String name, Student head) {
			this.nameOfOrganization = name;
			this.headOfOrganization = head;
		}
		
		public void addMember(Student s) {
			students.add(s);
		}
		
		public Student getHeadOfOrganization() {
			return this.headOfOrganization;
		}
		
		public String getNameOfOrganization() {
			return this.nameOfOrganization;
		}
		
		public HashSet<Student> getStudents() {
			return students;
		}

		@Override
		public String toString() {
			return "StudentOrganization [Name Of Organization = " + nameOfOrganization
					+ ", head Of Organization = " + headOfOrganization + "]";
		}
		
		
		
		
}
