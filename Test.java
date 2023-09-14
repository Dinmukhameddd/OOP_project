package MainPackage;

import MenuConsole.*;

public class Test {

	public static void main(String[] args) throws InvalidPasswordException {
		// TODO Auto-generated method stub
		Admin a = new Admin("21jnk6", "Damir", "Khan", "21225jk", 25688);
		a.addUser(a);
		AdminMenu m = new AdminMenu(a);
		m.running();
	}

}
