package MenuConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import MainPackage.*;

public abstract class Menu {
	String[] variants = {};
	
	public Menu() {
		
	}
	
	public void viewMessages(User u) {
		for(String str: u.getMessages()) {
			 System.out.println(str);
		 }
	}
	
	public boolean log(User u) throws InvalidPasswordException {
		 if(u instanceof Teacher) {
				TeacherMenu tm = new TeacherMenu(u);
				tm.running();
				return true;
			}
			else if(u instanceof Student) {
				StudentMenu sm = new StudentMenu(u);
				sm.running();
				return true;
			}
			
			else if(u instanceof Admin) {
				AdminMenu am = new AdminMenu(u);
				am.running();
				return true;
			}
			
			else if (u instanceof Manager){
				ManagerMenu mm = new ManagerMenu(u);
				mm.running();
				return true;
			}
			else {
				System.out.println("Error!");
				return false;
			}
	}

    public boolean loginSys() throws IOException, InvalidPasswordException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("Login: ");
		String login = br.readLine();
		System.out.println("Password: ");
		String passwordString = br.readLine();
     	if(User.login(login, passwordString) != null) {
     		if(log(User.login(login, passwordString))) return true;;
     	}
     	return true;
 
    }
    
	
	public void sendMessages(User u) throws IOException {
		System.out.println("Choose an user: ");
		 User[] us = (User[]) DataBase.getAllUsers().toArray(new User[DataBase.getAllUsers().size()]);
		 for(int i = 0; i < us.length; i++) {
			 System.out.println((i+1) + " - " + us[i].getSurname() + " " + us[i].getName() + " " + us[i].getUsername());
		 }
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String st  = br.readLine();
		 int ch = Integer.parseInt(st);
		 
		 System.out.println("Text a message: ");
		 st  = br.readLine();
		 
		 us[ch-1].getMessagesFromOthers(st, u);
	}
	
	public void viewNews(User u) {
		for(News n: u.getNews()) {
			 System.out.println(n.toString());
		 }
	}
	
	
	public abstract void running() throws InvalidPasswordException;
	
	public void viewMenu(String[] variants) {
		System.out.println("Choose one of folowing options: ");
		for(int i = 0; i < variants.length; i++)
			System.out.println((i + 1) + " - " + variants[i]);
	}

}
