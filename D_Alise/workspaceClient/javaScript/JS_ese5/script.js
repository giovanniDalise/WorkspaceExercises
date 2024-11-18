// Parola da indovinare
const wordToGuess = "javascript";

// Tentativi massimi
const maxGuesses = 6;

// Array di lettere indovinate
let guessedLetters = [];

// Tentativi rimasti
let guessesLeft = maxGuesses;

// Inizializzazione
function initializeGame() {
    guessedLetters = [];
    guessesLeft = maxGuesses;
    displayWord();
    displayGuessesLeft();
    displayLetters();
    displayResult("");
}

// Mostra la parola con le lettere indovinate
function displayWord() {
    const wordDisplay = document.getElementById("word-display");
    let displayedWord = "";
    for (let letter of wordToGuess) {
        if (guessedLetters.includes(letter)) {
            displayedWord += letter + " ";
        } else {
            displayedWord += "_ ";
        }
    }
    wordDisplay.textContent = displayedWord;
}

// Mostra i tentativi rimasti
function displayGuessesLeft() {
    const guessesLeftDisplay = document.getElementById("guesses-left");
    guessesLeftDisplay.textContent = `Tentativi rimasti: ${guessesLeft}`;
}

// Mostra le lettere indovinate
function displayLetters() {
    const lettersDisplay = document.getElementById("letters");
    lettersDisplay.textContent = `Lettere indovinate: ${guessedLetters.join(", ")}`;
}

// Mostra il risultato del gioco
function displayResult(result) {
    const resultDisplay = document.getElementById("result");
    resultDisplay.textContent = result;
}

// Gestore dell'evento di click sulle lettere
function letterClick(letter) {
    if (!guessedLetters.includes(letter)) {
        guessedLetters.push(letter);
        if (!wordToGuess.includes(letter)) {
            guessesLeft--;
        }
        displayWord();
        displayGuessesLeft();
        displayLetters();
        checkGameOver();
    }
}

// Controlla se la parola è stata completamente indovinata
function isWordGuessed() {
    for (let letter of wordToGuess) {
        if (!guessedLetters.includes(letter)) {
            return false;
        }
    }
    return true;
}

// Controlla se il gioco è finito
function checkGameOver() {
    if (guessesLeft === 0) {
        displayResult("Hai perso! Sei stato impiccato.");
        disableLetterButtons();
    } else if (isWordGuessed()) {
        displayResult("Hai vinto! Hai indovinato la parola.");
        disableLetterButtons();
    }
}

// Disabilita i pulsanti delle lettere
function disableLetterButtons() {
    const letterButtons = document.getElementsByClassName("letter-button");
    for (let button of letterButtons) {
        button.disabled = true;
    }
}

// Ricomincia il gioco
function resetGame() {
    initializeGame();
    enableLetterButtons();
}

// Abilita i pulsanti delle lettere
function enableLetterButtons() {
    const letterButtons = document.getElementsByClassName("letter-button");
    for (let button of letterButtons) {
        button.disabled = false;
    }
}

// Inizializza il gioco al caricamento della pagina
window.addEventListener("load", function() {
    initializeGame();
});

// Gestore dell'evento di click sul pulsante Ricomincia
const resetButton = document.getElementById("reset-button");
resetButton.addEventListener("click", resetGame);
