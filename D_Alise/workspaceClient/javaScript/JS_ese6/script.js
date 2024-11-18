document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('view-books-button').addEventListener('click', getBooks);
    document.getElementById('book-form').addEventListener('submit', inserisci);
    document.getElementById('cerca').addEventListener('click', search);
    document.getElementById('elimina').addEventListener('click', elimina);
    document.getElementById('modifica').addEventListener('click', modifica);
  
    function getBooks() {
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState === 4 && this.status === 200) {
            updateUI(xhttp.responseText);
            }
        };
        xhttp.open("GET", "http://localhost:3003/libri", true);
        xhttp.send();
    }
  
    function updateUI(responseText) {
        const sezioneLibri = document.getElementById('libri');
        sezioneLibri.innerHTML = responseText;
    }
  
    function inserisci(event) {
        event.preventDefault();
  
        let titolo = document.getElementById("title-input").value;
        let autore = document.getElementById("author-input").value;
        let editore = document.getElementById("edithor-input").value;

        let libro = {
            titolo: titolo,
            autore: autore,
            editore: editore
        };
  
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState === 4) {
                if (this.status === 201) {
                    alert("Libro inserito con successo");
                } else {
                    alert("Si è verificato un errore durante l'inserimento del libro");
                }
            }
        };
        xhttp.open("POST", "http://localhost:3003/libri", true);
        xhttp.setRequestHeader("Authorization", "luca");
        xhttp.send(JSON.stringify(libro));
    }
    function search() {
        let id = 1; // ID specifico per la ricerca
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState === 4) {
                if (this.status === 200) {
                    // Libro trovato
                    updateUI(xhttp.responseText);
                    alert("Libro trovato!");
                } else {
                    // Libro non trovato
                    alert("Libro non trovato.");
                }
            }
        };
        xhttp.open("GET", "http://localhost:3003/libri/" + id, true);
        xhttp.send();
    }
    function elimina() {
        let id = 1; // ID del libro da eliminare
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState === 4) {
                if (this.status === 204) {
                    alert("Libro eliminato con successo!");
                    // Aggiorna l'interfaccia utente o effettua altre operazioni dopo l'eliminazione
                    getBooks(); // Esempio: richiama la funzione per aggiornare l'elenco dei libri
                } else {
                    alert("Si è verificato un errore durante l'eliminazione del libro.");
                }
            }
        };
        xhttp.open("DELETE", "http://localhost:3003/libri/" + id, true);
        xhttp.setRequestHeader("Authorization", "luca"); // Esempio di impostazione di un'intestazione
        xhttp.send();
    }
    function modifica() {
        let id = 1; // ID del libro da modificare
        let titolo = document.getElementById("title-input").value;
        let autore = document.getElementById("author-input").value;
        let editore = document.getElementById("edithor-input").value;

        let libro = {
            titolo: titolo,
            autore: autore,
            editore: editore
        };
    
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState === 4) {
                if (this.status === 200) {
                    alert("Libro modificato con successo!");
                    // Aggiorna l'interfaccia utente o effettua altre operazioni dopo la modifica
                    getBooks(); // Esempio: richiama la funzione per aggiornare l'elenco dei libri
                } else {
                    alert("Si è verificato un errore durante la modifica del libro.");
                }
            }
        };
        xhttp.open("PUT", "http://localhost:3003/libri/" + id, true);
        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.setRequestHeader("Authorization", "luca"); // Esempio di impostazione di un'intestazione
        xhttp.send(JSON.stringify(libro));
    }       
});
    