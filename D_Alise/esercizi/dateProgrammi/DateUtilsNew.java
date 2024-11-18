package esercizi.dateProgrammi;
//import java.time.*; //importo tutte le classe di java.time
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.Year;
import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.time.DateTimeException;

public class DateUtilsNew {
    
    // Metodo per restituire la data odierna
    public static LocalDate dataCorrente() {
        return LocalDate.now();
    }

    // Metodo per calcolare il numero di giorni tra due date inserite dall'utente
    public static long differenzaGiorni(String data1, String data2) {
        LocalDate dataInizio = LocalDate.parse(data1);
        LocalDate dataFine = LocalDate.parse(data2);
        long differenza = ChronoUnit.DAYS.between(dataInizio, dataFine);
        return differenza;
    }

    // Metodo per verificare se una data è valida
    public static boolean dataValida(int anno, int mese, int giorno) {
        try {
            LocalDate.of(anno, mese, giorno);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    // Metodo per verificare se un anno è bisestile
    public static String annoBisestile(int anno) {
        boolean bisestile = Year.of(anno).isLeap();
            if (bisestile) {
                return anno + " è un anno bisestile";
            } else {
                return anno + " non è un anno bisestile";
            }
    }
    // Metodo per calcolare il giorno della settimana di una data specifica inserita dall'utente
    public static String giornoSettimana(String data) {
        LocalDate date = LocalDate.parse(data);
        return date.getDayOfWeek().toString();
    }

    // Metodo per calcolare la differenza tra due date in ore, minuti e secondi
    public static String differenzaTempo(String data1, String data2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(data1, formatter);
        LocalDateTime dateTime2 = LocalDateTime.parse(data2, formatter);
        Duration duration = Duration.between(dateTime1, dateTime2);//come chronounit

        long giorni = duration.toDays(); //differenza di giorni
        duration = duration.minusDays(giorni); //sottrae i giorni dalla differenza
        long ore = duration.toHours();
        duration = duration.minusHours(ore);
        long minuti = duration.toMinutes();
        duration = duration.minusMinutes(minuti);
        long secondi = duration.getSeconds();

        return giorni + " giorni, " + ore + " ore, " + minuti + " minuti e " + secondi + " secondi.";

    }

    // Metodo per convertire una stringa nel formato "dd/MM/yyyy"
    public static String formattaData(String data) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataFormat = LocalDate.parse(data, inputFormatter);
        return dataFormat.format(outputFormatter);
    }

    // Metodo per stampare l'ora attuale in un formato personalizzato, ad esempio "HH:mm:ss"
    public static String formattaOraCorrente() {
        LocalTime oraAttuale = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return oraAttuale.format(formatter);

        /*avendo formattato la data non posso restituire direttamente il tipo LocalTime 
        come ho fatto per LocalDate dato che la proprietà implicita di convertire questi tipi
        in stringhe (dato che lho concatenato ad un altra stringa) avviene solo se il valore
        restituito è di default, avendo formatto la data viene persa questa proprietà)
        */
    }

    // Metodo per calcolare la differenza di età tra due persone in base alla data di nascita inserita dall'utente
    public static String calcolaDifferenzaEta(String dataNascita1, String dataNascita2) {
        LocalDate date1 = LocalDate.parse(dataNascita1);
        LocalDate date2 = LocalDate.parse(dataNascita2);
        long years = Math.abs(ChronoUnit.YEARS.between(date1, date2));
        long months = Math.abs(ChronoUnit.MONTHS.between(date1.plusYears(years), date2));
        long days = Math.abs(ChronoUnit.DAYS.between(date1.plusYears(years).plusMonths(months), date2));
        return years + " anni, " + months + " mesi e " + days + " giorni";

    }

    // Metodo per calcolare la data di scadenza di un contratto a partire dalla data di inizio e dalla durata in mesi inserite dall'utente
    public static String dataScadenzaContratto(String dataInizio, int durataMesi) {
        LocalDate dateInizio = LocalDate.parse(dataInizio, DateTimeFormatter.ISO_DATE);
        LocalDate dateScadenza = dateInizio.plusMonths(durataMesi);
        return dateScadenza.format(DateTimeFormatter.ISO_DATE);
    }
}
    