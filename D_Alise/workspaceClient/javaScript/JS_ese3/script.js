function appendToDisplay(value) {
    document.getElementById('display').value += value;
    /*visualizziamo il valore attuale più il precedente dato che vengono considerate come delle stringhe 
    ad esempio digitando 7 poi + e poi 10 vedro 7 + 10*/
}

function calculate() {
    let displayValue = document.getElementById('display').value;/* valore(value) di input corrente dell'elemento con id display*/
    let result = eval(displayValue);/* La funzione eval() viene utilizzata per valutare l'espressione contenuta nella stringa displayValue. eval() interpreta la stringa come codice JavaScript e restituisce il risultato dell'esecuzione dell'espressione*/
    document.getElementById('display').value = result;/* aggiornando poi il campo di input visualizzato visualizzeremo la variabile result ossia il risultato*/
}

function clearDisplay() {
    document.getElementById('display').value = '';
}
