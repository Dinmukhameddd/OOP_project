package MainPackage;

import java.util.Vector;

public class Admin extends Employee{
	
	public Admin() {
		
	}
	
	public Admin(String ID, String name, String surname, String password, double salary) {
		super(ID, name, surname, password, salary);
	}
	
	public boolean addUser(User u) {
		if(DataBase.addUser(u)) return true;
		return false;
	}
	
	public boolean deleteUser(User u) {
		if(DataBase.deleteUser(u)) return true;
		return false;
	}
	
	public Vector<User> getUsers() {
		return DataBase.getAllUsers();
	}
	
	public void changePasswordToUser(User u, String oldPassword, String newPassword) throws InvalidPasswordException {
		u.changePassword(oldPassword, newPassword);
		
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	
	
}
