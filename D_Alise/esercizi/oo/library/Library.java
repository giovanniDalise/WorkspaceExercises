package esercizi.oo.library;
public class Library{
	String libraryName;
	String address;
	Book[] libraryBooks;
	
	public static void main(String[] args) throws Exception{
		Library libreriaTorino = new Library();
		libreriaTorino.rentBook(getBook(1), new User("Ciccio","Pasticcio",66));
		Book libroTrovato = libreriaTorino.searchBook(getBook(1));
		System.out.println(libroTrovato);
		if(libroTrovato.borrowedDate!=null){
			System.out.println("Ha funzionato!!! il libro è stato affittato");
		}else{
			System.out.println("Attenzione!!! abbiamo sbagliato qualcosa");
		}
	}
	public Library(){
		this.libraryBooks = initBooks();
	}
	private Book[] initBooks(){//aggiungiLibro
		Book[] result = new Book[3];
		result[0]= getBook(1);
		result[1]= getBook(2);
		result[2]= getBook(3);
		return result;
	}
	
	private static Book getBook(int indice){
		Book book = null;
		switch(indice){
			case 1:
				book = new Book("Tolkien","Lo Hobbit", "Fantasy");
				break;
			case 2:
				book = new Book("J.K.Rowling","Harry Potter - Il calice di fuoco", "Fantasy");
				break;
			case 3: 
				book = new Book("S.King","IT", "Horror");
				break;
		}
		return book;
	}
	
	public void rentBook(Book book, User user) throws Exception{
		Book bookFound = searchBook(book);
		if(book!=null){
			// chiamare il metodo rent(user)
			bookFound.rent(user);
			System.out.println("operazione riuscita");
		}else{
			throw new Exception("libro non trovato");
		}
	}
	public Book searchBook(Book book){
		Book result = null;
		int i=0;
		while(i< libraryBooks.length && result==null){
			if(
				libraryBooks[i].author.equals(book.author) &&
				libraryBooks[i].title.equals(book.title) &&
				libraryBooks[i].type.equals(book.type)
			){
				result = libraryBooks[i];
			}
			i++;
		}
		return result;
	}
}