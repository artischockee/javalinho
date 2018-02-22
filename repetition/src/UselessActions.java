import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UselessActions {

    private Random rand = new Random();
    private int[] _array;

    UselessActions(int arraySize) {
        if (arraySize <= 0)
            throw new IllegalArgumentException();

        _array = new int[arraySize];

        for (int i = 0; i < _array.length; ++i)
            _array[i] = rand.nextInt(300);

        System.out.printf("A new array with %d random integers has been created.\n", arraySize);
    }

    // Imitates the foreachOperator()
    private void print() {
        System.out.println("Content of the array:");
        for (int number : _array) {
            System.out.printf("%d ", number);
        }
        System.out.println("\n\n");
    }

    // Prints all the numbers in the array
    private void foreachOperator() {
        System.out.println("\nForeach Operator");
        for (int number : _array) {
            System.out.printf("%d ", number);
        }
        System.out.println("\n\n");
    }

    // Makes some mathematical actions with the array's elements
    private void whileOperator() {
        System.out.println("While Operator");
        int i = _array.length / 2;
        while (i > 0) {
            _array[i] = (i + 2) * 7;
            --i;
        }

        print();
    }

    private void doWhileOperator() {
        System.out.println("Do-while Operator");
        int i = 0;
        int lastElement = _array[_array.length - 1];
        do {
            _array[i] = lastElement + i;
            ++i;
        } while (i < _array.length);

        print();
    }

    private void ifelseOperator() {
        System.out.println("If-Else Operator");
        List<Integer> evensContainer = new ArrayList<>();
        List<Integer> oddsContainer = new ArrayList<>();

        for (int number: _array) {
            if (number % 2 == 0)
                evensContainer.add(number);
            else
                oddsContainer.add(number);
        }

        System.out.println("Evens container:");
        for (int evenNumber: evensContainer)
            System.out.printf("%d ", evenNumber);
        System.out.println("\nOdds container:");
        for (int oddNumber: oddsContainer)
            System.out.printf("%d ", oddNumber);

        System.out.println("\n\n");
    }

    private void switchOperator() {
        System.out.println("Switch Operator");
        int randomNumber = _array[rand.nextInt(_array.length)];
        System.out.printf("Random number: %d\n", randomNumber);
        randomNumber %= 2;
        switch (randomNumber) {
            case 0:
                System.out.println("A random number is even number");
                break;
            case 1:
                System.out.println("A random number is odd number");
                break;
        }
    }

    public void perform() {
        foreachOperator();
        whileOperator();
        doWhileOperator();
        ifelseOperator();
        switchOperator();
    }
}
