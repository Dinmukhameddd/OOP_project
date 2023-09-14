package MainPackage;


import java.util.*;

public class Librarian extends Employee{
    private HashMap<Integer, Book> books;
    private HashSet<User> BookTakers;
    
    public Librarian() {
    	
    }

    public Librarian(String id, String name, String surname, String password, double salary){
    	super(id, name, surname, password, salary);
        this.books = new HashMap<Integer, Book>();
        this.BookTakers = new HashSet<User>();
    }


    public Book lendBook(int id) {
        Book book = null;
        if (!books.containsKey(id)) return book;
        if (books.containsKey(id)){
            book = books.get(id);
            book.setAvailable();
        }
        return book;
    }
    public List<Book> takeBackBook() {
        List<Book> books1 = new ArrayList<Book>();
        for (Book value: books.values()) {
            books1.add(value);
        }
        return books1;
    }
   

    public void viewBookTakers(User user){
        BookTakers.add(user);
    }
}
