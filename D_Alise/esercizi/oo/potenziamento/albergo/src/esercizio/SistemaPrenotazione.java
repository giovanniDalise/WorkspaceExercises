package esercizio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaPrenotazione {
    private List<Camera> camere;  // Lista delle camere dell'hotel

    public SistemaPrenotazione() {
        this.camere = new ArrayList<>();
    }

    public void aggiungiCamera(int numeroCamera,double prezzoPersona,int postiLetto) {
        Camera room = new Camera(numeroCamera, prezzoPersona, postiLetto);
        camere.add(room);
    }

    public void prenotaCamera(int numeroCamera, LocalDate dataArrivo, LocalDate dataPartenza, int numeroOspiti) {
        Camera camera = trovaCamera(numeroCamera);
        if (camera != null) {
            if (camera.isDisponibile(dataArrivo, dataPartenza, numeroOspiti)) {
                camera.prenota(dataArrivo, dataPartenza, numeroOspiti);
                System.out.println("Camera " + numeroCamera + " prenotata con successo.");
            } else {
                System.out.println("Camera " + numeroCamera + " non disponibile per le date specificate.");
            }
        } else {
            System.out.println("Camera " + numeroCamera + " non esiste.");
        }
        calcolaPrezzo(numeroCamera,numeroOspiti);
    }

    public void trovaCamereDisponibili(LocalDate dataArrivo, LocalDate dataPartenza, int numeroOspiti) {
        System.out.println("Camere disponibili per il periodo dal " + dataArrivo + " al " + dataPartenza + " per " + numeroOspiti + " ospiti:");

        for (Camera camera : camere) {
            if (camera.isDisponibile(dataArrivo, dataPartenza, numeroOspiti)) {
                System.out.println("Camera " + camera.getNumeroCamera());
            }
        }
    }

    private Camera trovaCamera(int numeroCamera) {
        for (Camera camera : camere) {
            if (camera.getNumeroCamera() == numeroCamera) {
                return camera;
            }
        }
        return null;
    }
    public void calcolaPrezzo(int numeroCamera, int numeroOspiti){
        double prezzoPersonaNotte = trovaCamera(numeroCamera).getPrezzoPersona();
        double prezzoComplessivo = prezzoPersonaNotte * numeroOspiti;
        System.out.println("Il prezzo complessivo è di "+ prezzoComplessivo + " euro.");
    }
}
