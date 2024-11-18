package test.ide.scritto.vecio;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Piatto> piatti;

    public Menu() {
        this.piatti= new ArrayList<Piatto>();
    }
    public void aggiungiPiatto(Piatto piatto){
        this.piatti.add(piatto);
    }
    public List<Piatto> getMenu(){
        return this.piatti;
    }
}
