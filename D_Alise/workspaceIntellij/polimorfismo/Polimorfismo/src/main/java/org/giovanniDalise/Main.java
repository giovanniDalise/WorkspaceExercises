package org.giovanniDalise;

import java.util.ArrayList;
import java.util.List;

// Classe principale per testare
    public class Main {
        public static void main(String[] args) {
            // Usa una lista di Animale, trattando tutti gli oggetti allo stesso modo
            List<Animale> animali = new ArrayList<>();
            animali.add(new Cane());
            animali.add(new Gatto());

            // Itera su tutti gli animali e chiama il metodo comune
            for (Animale animale : animali) {
                animale.aggiungiAttivita("Attività generica");
                animale.mostraAttivita();
            }
        }
    }
