function stampaTabellina() {
  // Ottieni il valore inserito nell'input
  let numero = parseInt(document.getElementById('numero').value);

  // Verifica se il valore inserito è un numero valido
  if (!isNaN(numero)) {
    // Stampa la tabellina nella console del browser
    for (let i = 1; i <= 10; i++) {
      console.log(numero + ' x ' + i + ' = ' + (numero * i));
    }
  } else {
    console.log('Inserisci un numero valido');
  }
}

// Aggiungi l'evento di click al pulsante
document.getElementById('stampaBtn').addEventListener('click', stampaTabellina);

/* document: È l'oggetto globale che rappresenta l'intero documento HTML (la pagina web) e consente di accedere e manipolare gli elementi all'interno di essa.
getElementById('stampaBtn'): È un metodo dell'oggetto document che cerca e restituisce l'elemento del documento con l'ID specificato. In questo caso, sta cercando l'elemento con l'ID "stampaBtn". L'ID "stampaBtn" corrisponde al pulsante "Stampa" nel tuo HTML.
addEventListener('click', function() { ... }): È un metodo che consente di ascoltare gli eventi su un elemento e associare una funzione (callback) da eseguire quando l'evento si verifica. Nel nostro caso, l'evento che stiamo ascoltando è il clic sul pulsante "Stampa". La stringa 'click' specifica l'evento da ascoltare.
function() { ... }: È una funzione anonima (senza nome) che viene passata come callback all'addEventListener. Sarà eseguita quando l'evento specificato si verifica. In questo caso, quando viene cliccato il pulsante "Stampa", la funzione verrà eseguita.
All'interno di questa funzione, puoi inserire il codice che desideri eseguire quando il pulsante viene cliccato. Nel nostro caso, abbiamo il codice che ottiene il valore inserito nell'input, calcola e stampa la tabellina sulla console.*/