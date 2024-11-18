package esercizio;

public class ShiftArray implements OperationEsecutor {
    public <T> void eseguiOperation(T[] array) {
        if (array.length <= 1) {
            return;
        }

        T firstElement = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = firstElement;
    }
}