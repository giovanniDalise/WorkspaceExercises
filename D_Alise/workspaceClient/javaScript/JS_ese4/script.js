// Array per i libri
let books = [];

// Funzione per aggiungere un libro
function addBook(event) {
    event.preventDefault();
    /*Nel contesto specifico di questa funzione, event.preventDefault() viene chiamato per prevenire il comportamento predefinito dell'evento 
    di submit del form. Di solito, l'invio del form provocherebbe il ricaricamento della pagina o l'invio dei dati a un server,ricaricado la pagina cancellerei i libri inseriti.
     Chiamando event.preventDefault(),
     si impedisce questo comportamento predefinito e si consente di gestire l'evento in modo personalizzato*/

    const title = document.getElementById('title-input').value;
    const author = document.getElementById('author-input').value;

    if (title === '' || author === '') { /* se uno dei due campi è vuoto*/
        alert('Inserisci il titolo e l\'autore del libro.');
        return;
    }

    const book = { title, author };
    books.push(book);

    displayBooks();
    clearForm();/*azzera i campi del form in modo che l'utente possa inserire altri libri*/
}

// Funzione per visualizzare i libri
function displayBooks() {
    const bookList = document.getElementById('book-list');
    bookList.innerHTML = '';/*assegna una stringa vuota alla proprietà innerHTML dell'elemento bookList. Questo ha l'effetto di cancellare tutti i contenuti precedenti all'interno di bookList, in modo da poter ricostruire la lista dei libri da zero.*/

    books.forEach(function(book, index) {//l'elemento libro dell'array e il suo indice itereranno fino alla fine degli elementi dell'array.Funzione di callback guarda il .txt*/
        const bookItem = document.createElement('div');/*Questa riga crea un nuovo elemento <div> nel documento HTML e lo assegna alla variabile bookItem. Questo elemento <div> sarà l'elemento che rappresenta il singolo libro nella lista.*/
        bookItem.innerHTML = `
            <span class="book-title">${book.title}</span>
            <span class="book-author">${book.author}</span>
            <button class="remove-button" onclick="removeBook(${index})">Rimuovi</button>
        `;
        bookList.appendChild(bookItem);
        /*span incapsula una parte di testo e vedi .text per dollaro*/
    });
}

// Funzione per rimuovere un libro
function removeBook(index) {
    books.splice(index, 1);
    displayBooks();
    /*Nella prima riga, books.splice(index, 1) viene utilizzato per rimuovere l'elemento corrispondente
     all'indice specificato dall'array books. La funzione splice() modifica direttamente l'array 
     rimuovendo gli elementi desiderati. Nel caso specifico, viene rimosso un solo elemento a partire 
     dall'indice specificato, in modo da rimuovere il libro corrispondente.*/
}
// Funzione per cancellare il contenuto del form
function clearForm() {
    document.getElementById('title-input').value = '';
    document.getElementById('author-input').value = '';
}

// Gestore dell'evento di invio del form
document.getElementById('book-form').addEventListener('submit', addBook);/*primo parametro è quello che si vuole ascoltare e il secondo è quello che si chiama*/

function search(){
   let libroCercato = document.getElementById('cerca-libri').value;
   let risultato = '';

   for(let i = 0; i<books.length;i++){
    if(libroCercato === books[i].title){
        risultato = books[i].title + ' - ' + books[i].author;
    }
   }
   document.getElementById('res').innerHTML = risultato || 'Nessun risultato trovato.';
}