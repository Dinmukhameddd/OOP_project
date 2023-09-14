package MainPackage;


import java.util.Date;

public class Book {
    private int idBook;
    private String title;
    private String author;
    private Date publishedDate;
    private int quantity;
    private boolean available;

    public Book(){}
    public Book(int idBook, String title, String author, Date publishedDate, int quantity){
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.quantity = quantity;
        this.available = true;
    }

    public int getIdBook(){ return idBook; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public Date getPublishedDate() { return publishedDate; }
    public int getQuantity() { return quantity; }

    public void setIdBook(int idBook) { this.idBook = idBook; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void setAvailable() {
        this.available = false;
    }

    public String isBookAvaible(){
        return this.available ? "yes" : "no";
    }
    public String toString(){
        return "Book title - " + getTitle() + ", author - " +getAuthor() + ", published date: " + getPublishedDate() + ", quantity:" + getQuantity();
    }

}
