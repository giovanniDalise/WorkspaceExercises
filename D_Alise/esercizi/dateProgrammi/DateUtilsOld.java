package esercizi.dateProgrammi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.text.DateFormatSymbols;

public class DateUtilsOld {

    // Data corrente
    public static String dataCorrente() {
        Date oggi = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(oggi);
    }
      // Differenza giorni
    public static long differenzaGiorni(String data1Str, String data2Str) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data1;
        Date data2;
        try {
            data1 = formato.parse(data1Str);
            data2 = formato.parse(data2Str);
        } catch (ParseException e) {
            System.out.println("Errore nel parsing delle date");
            return 0;
        }
        long differenza = data2.getTime() - data1.getTime();//restituisce in millisecondi
        return differenza / (1000 * 60 * 60 * 24);
    }

    // Data valida
   public static boolean dataValida(int anno, int mese, int giorno) {
        Calendar cal = new GregorianCalendar();
        cal.setLenient(false);//non indulgente solleva eccezioni in caso di ambiguità posta nei set
        cal.set(Calendar.YEAR, anno);
        cal.set(Calendar.MONTH, mese - 1);
        cal.set(Calendar.DAY_OF_MONTH, giorno);
        try {
            cal.getTime();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Anno bisestile
    public static String annoBisestile(int anno) {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.YEAR, anno);
        if (cal instanceof GregorianCalendar && ((GregorianCalendar)cal).isLeapYear(anno)) {
            //bisogna verificase se calendar è un instanza della classe gregorian calendar dato che solo i 
            //calendari gregorian calendar hanno il metodo isLeapYear
            return anno + " è un anno bisestile.";
        } else {
            return anno + " non è un anno bisestile.";
        }  
    }

    // Giorno della settimana
    public static String giornoSettimana(String dataStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        try {
            data = formatter.parse(dataStr);
        } catch (ParseException e) {
            return "Errore: formato data non valido";
        }
        DateFormatSymbols symbols = new DateFormatSymbols(Locale.getDefault());
        String[] nomiGiorni = symbols.getWeekdays();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int giornoSettimana = cal.get(Calendar.DAY_OF_WEEK);
        if (giornoSettimana == Calendar.SUNDAY) {
            return nomiGiorni[Calendar.SUNDAY];
        } else {
            return nomiGiorni[giornoSettimana].toLowerCase().substring(0, 1).toUpperCase() + nomiGiorni[giornoSettimana].toLowerCase().substring(1);
        }
    }

    public static String differenzaTempo(String data1, String data2) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = format.parse(data1);
            Date date2 = format.parse(data2);
            long differenceInMillis = Math.abs(date1.getTime() - date2.getTime());
            long hours = TimeUnit.MILLISECONDS.toHours(differenceInMillis);
            long minutes = TimeUnit.MILLISECONDS.toMinutes(differenceInMillis) % 60;
            long seconds = TimeUnit.MILLISECONDS.toSeconds(differenceInMillis) % 60;
            return String.format("%d ore, %d minuti, %d secondi", hours, minutes, seconds);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
    
    public static String formattaData(String data) {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = format1.parse(data);
            return format2.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
    
    public static String formattaOraCorrente() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return format.format(cal.getTime());
    }
    
    public static int calcolaDifferenzaEta(String data1, String data2) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date date1 = format.parse(data1);
            Date date2 = format.parse(data2);
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal1.setTime(date1);
            cal2.setTime(date2);
            int ageDifference = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
            if (cal1.get(Calendar.MONTH) < cal2.get(Calendar.MONTH) || 
                    (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) && 
                     cal1.get(Calendar.DAY_OF_MONTH) < cal2.get(Calendar.DAY_OF_MONTH))) {
                ageDifference--;
            }
            return ageDifference;
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public static String dataScadenzaContratto(String dataInizio, int durata) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateInizio = format.parse(dataInizio);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateInizio);
            cal.add(Calendar.MONTH, durata);
            return format.format(cal.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }


    }
