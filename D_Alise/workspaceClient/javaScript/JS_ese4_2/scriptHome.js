let books = []; // Array per memorizzare i libri

// Aggiungi un listener all'evento 'submit' del form
document.getElementById('bookForm').addEventListener('submit', searchBook);

// Funzione di gestione per la ricerca dei libri
function searchBook(event) {
    event.preventDefault(); // Evita l'invio del modulo

    const searchTerm = document.getElementById('search').value; // Ottieni il termine di ricerca dall'input

    // Chiamata a una funzione che confronta il termine di ricerca con ogni libro
    const matchingBooks = books.filter((book) => equals(book, searchTerm));

    // Puoi fare qualcosa con i libri corrispondenti, ad esempio visualizzarli sulla pagina dei risultati di ricerca
    displayBooks(matchingBooks);
}

// Funzione di confronto per trovare i libri corrispondenti
function equals(book, searchTerm) {
    // Implementa la logica di confronto tra il libro e il termine di ricerca.
    // Ad esempio, puoi confrontare il titolo, l'autore o altre proprietà del libro.
    // Restituisci true se il libro corrisponde al termine di ricerca, altrimenti false.
    const bookTitle = book.title.toLowerCase();
    const bookAuthor = book.author.toLowerCase();
    const search = searchTerm.toLowerCase();
  
    return bookTitle.includes(search) || bookAuthor.includes(search);
}

// Funzione per visualizzare i libri corrispondenti sulla pagina dei risultati di ricerca
function displayBooks(books) {
    const resultsContainer = document.getElementById('resultsContainer');
    resultsContainer.innerHTML = ''; // Pulisci il contenitore dei risultati

    if (books.length === 0) {
        resultsContainer.textContent = 'Nessun libro corrispondente trovato.';
        return;
    }

    // Crea un elemento HTML per ogni libro corrispondente e aggiungilo al contenitore dei risultati
    books.forEach((book) => {
        const bookElement = document.createElement('div');
        bookElement.textContent = book.title + ' - ' + book.author;
        resultsContainer.appendChild(bookElement);
    });
}
