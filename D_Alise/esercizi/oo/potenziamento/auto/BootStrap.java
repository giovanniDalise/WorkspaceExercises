/*Scrivi una classe che rappresenta un'auto, con variabili di istanza come marca, modello, anno di produzione e chilometraggio. 
Implementa un metodo per incrementare il chilometraggio e un metodo per stampare le informazioni dell'auto.
*/
package esercizi.oo.potenziamento.auto;
import esercizi.utility.Tastiera;

public class BootStrap {
    public static void main(String[] args) {

        Car car = setSpecifications();

        System.out.println("Brand: " + car.getBrand());//non posso accedere direttamente all'attributo della classe ma posso farlo tramite il metodo get
        System.out.println("Model: " + car.getModel());
        System.out.println("Production Year: " + car.getProductionYear());
        System.out.println("Kilometers: " + car.getKilometers());

        double newKilometers = Tastiera.chiediDouble("Enter the new kilometers to add:");        
        car.increaseKilometers(newKilometers);

        System.out.println("Increased kilometers: " + car.getKilometers());
    }

    public static Car setSpecifications(){
        String newBrand = Tastiera.chiediStringa("Enter the brand:");
        String newModel = Tastiera.chiediStringa("Enter the model:");
        int newProductionYear = Tastiera.chiediInteroPositivo("Enter the production year:");
        double startKilometers = Tastiera.chiediDouble("Enter the initial kilometers:");

        Car car = new Car(newBrand,newModel,newProductionYear,startKilometers);

        car.setBrand(newBrand);
        car.setModel(newModel);
        car.setProductionYear(newProductionYear);
        car.setKilometers(startKilometers);                

        return car;

    }
}
/*
Il principio di incapsulamento prevede che le variabili private siano accessibili solo tramite i metodi della classe, come i metodi getBrand() e setBrand().
In questo modo, si garantisce una maggiore sicurezza e controllo sull'accesso alle variabili, impedendo l'accesso accidentale o non autorizzato da parte di altre parti del programma.
i metodi set e get sono utilizzati per il principio di incapsulamento, infatti vediamo che in car gli attributi sono tutti privati ed è buona pratica tenarli tali 
e fornire i metodi getter e setter per accedere e modificare gli attributi stessi.
 In questo modo, si garantisce l'incapsulamento degli attributi e si evita di esporre la loro implementazione agli utenti della classe.
 */