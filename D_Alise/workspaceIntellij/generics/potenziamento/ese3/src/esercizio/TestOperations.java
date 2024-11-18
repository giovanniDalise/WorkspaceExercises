package esercizio;
import java.util.Arrays;

public class TestOperations {
    public static void main(String[] args) {
        OperationEsecutor[] operations = {
                new InvertiArray(),
                new ShiftArray()
        };

        Integer[] array = {1, 2, 3, 4};

        for (OperationEsecutor operation : operations) {
            operation.eseguiOperation(array);
            System.out.println("Array: " + Arrays.toString(array));
        }
    }
}