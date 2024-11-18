package esercizi.incapsulamento.biblioteca;

public class BibliotecaMain {
    private Libro[] libri = new Libro[5];
    
    public static void main(String[]args){
        BibliotecaMain biblioteca = new BibliotecaMain();
        
        biblioteca.libri[0] = new Libro ("Manoscritto Trovato a Saragozza","Jan Potocki");
        biblioteca.libri[0].setEditore("Adelphi");
        biblioteca.libri[1] = new Libro ("Alla Ricerca del Tempo Perduto ","Marcel Proust");
        biblioteca.libri[1].setEditore("Mondadori");
        biblioteca.libri[2] = new Libro ("Moby Dick","Herman Melville");
        biblioteca.libri[2].setEditore("Feltrinelli");
        biblioteca.libri[3] = new Libro ("Lo Scarabeo d'oro","Edgar Allan Poe");
        biblioteca.libri[3].setEditore("Einaudi");
        biblioteca.libri[4] = new Libro ("Viaggio al centro della Terra","Jules Verne");
        biblioteca.libri[4].setEditore("Giunti");

        biblioteca.stampaLibri();
    }
    public void stampaLibri() {
        for (int i = 0; i < libri.length; i++) {
            System.out.println("Titolo: " + libri[i].getTitolo());
            System.out.println("Autore: " + libri[i].getAutore());
            System.out.println("Editore: " + libri[i].getEditore());
            System.out.println();
        }
    }
}


