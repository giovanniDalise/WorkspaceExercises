package org.giovanniDalise;

import java.util.LinkedList;

// Classe Gatto che utilizza LinkedList
public class Gatto extends Animale {
    public Gatto() {
        attivitaPreferite = new LinkedList<>(); // Inizializzazione diretta
    }
}