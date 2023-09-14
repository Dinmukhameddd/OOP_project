package MainPackage;



import java.util.*;

public abstract class User implements Comparable<User>{
    private String id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private Vector <String> messages;

    public User(){}
    public User (String id, String name, String surname, String password){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.username = name.substring(0, 1).toLowerCase() + "_" + surname.toLowerCase();
    }
    @Override
    public int compareTo(User other){
        int result = surname.compareTo(other.surname);
        if (result == 0) return name.compareTo(other.name);
        return result;
    }

    public void setPassword(String password) { this.password = password; }

    public void changePassword(String oldPassword, String newPassword) throws InvalidPasswordException{
        if (!password.equals(oldPassword)) {
            if (newPassword.equals(oldPassword)) {
                throw new InvalidPasswordException("Your entered new password is the same as actual.");
            } else this.setPassword(newPassword);
        }
    }
  
    public void sendMessage(String message, User toUser){
    	
    }
    public Vector<String> getMessages(){
        return messages;
    }
    public void getMessagesFromOthers(String message, User fromUser){
        messages.add(message + "\r\n" + "From: " + fromUser.username);
       
    }

    public static User login(String username, String password){
        for(User u: DataBase.getAllUsers()) {
        	if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
        		return u;
        	}
        }
         return null;
    }

    public void borrowBooks(Librarian title, Book idB){
        title.lendBook(idB.getIdBook());
    }

    public void returnBook(Librarian title){
        title.takeBackBook();
    }

    public Vector<News> getNews(){
        return DataBase.getAllNews();
    }

    public String getId() { return id;}
    public String getName() { return name;}
    public String getSurname() { return surname;}
    
    public String getUsername() {return this.username;};

    public String getPassword() { return password;}

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null ) return false;
        User user_1 = (User) o;
        return Objects.equals(id, user_1.id) && Objects.equals(name, user_1.name) && Objects.equals(surname, user_1.surname)
                && Objects.equals(username, user_1.username) && Objects.equals(password, user_1.password);
    }

    public int hashCode(){
        return Objects.hash(id, name, surname, username, password);
    }
	@Override
	public String toString() {
		return "Id = " + id + ", name=" + name + ", surname=" + surname + ", username=" + username;
	}
    
    
}
