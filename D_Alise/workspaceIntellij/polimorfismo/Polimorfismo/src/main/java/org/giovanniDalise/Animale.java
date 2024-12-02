package org.giovanniDalise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Classe base
abstract class Animale {
    protected List<String> attivitaPreferite; // Campo ereditabile

    // Aggiunge un'attività preferita
    public void aggiungiAttivita(String attivita) {
        attivitaPreferite.add(attivita); // Si assume che il campo sia già inizializzato
    }

    // Mostra tutte le attività preferite
    public void mostraAttivita() {
        System.out.println("Tipo di lista: " + attivitaPreferite.getClass().getName());
        System.out.println("Attività: " + attivitaPreferite);  // Mostra tutte le attività
    }
}





