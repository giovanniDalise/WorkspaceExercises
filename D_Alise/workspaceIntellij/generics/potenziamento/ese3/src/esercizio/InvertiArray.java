package esercizio;

public class InvertiArray implements OperationEsecutor {
    public <T> void eseguiOperation(T[] array) {
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            T temp = array[i];
            array[i] = array[length - 1 - i];
            array[length - 1 - i] = temp;
        }
    }
}