package ese1;

import java.util.Comparator;
public class ComparatoreCalorie implements Comparator<Piatto> {
    @Override
    public int compare(Piatto p1, Piatto p2) {
        int calorieP1 = calcolaCaloriePiatto(p1);
        int calorieP2 = calcolaCaloriePiatto(p2);
        return calorieP1 - calorieP2;
    }

    private int calcolaCaloriePiatto(Piatto piatto) {
        int calorieTotali = 0;
        for (Ingrediente ingrediente : piatto.getIngredienti()) {
            calorieTotali += ingrediente.getCalorie();
        }
        return calorieTotali;
    }
}