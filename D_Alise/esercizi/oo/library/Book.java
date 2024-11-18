package esercizi.oo.library;
import java.util.Date;

public class Book{
	String author;
	String title;
	String type;
	Date borrowedDate;
	User borrowedUser;
	
	public Book(String author, String title, String type){
		this.author = author;
		this.title = title;
		this.type=type;
	}
	public void rent(User user){
		System.out.println("e' stato richiamato il metodo rent del libro:" + user);
		System.out.println("pre modifica " + this);
		this.borrowedDate = new Date();
		this.borrowedUser = user;
		System.out.println("post rent modifica " + this);
	}
	public String toString(){
		return author + " - " + title + " - " + type + " - " + borrowedUser;
	}
}