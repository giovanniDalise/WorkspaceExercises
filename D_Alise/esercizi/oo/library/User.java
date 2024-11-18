package esercizi.oo.library;
public class User{
	public String name;
	public String surname;
	public int age;
	public User(String name, String surname, int age){
		this.name=name;
		this.surname=surname;
		this.age=age;
	}
	public String toString(){
		return name + " - " + surname;
	}
}