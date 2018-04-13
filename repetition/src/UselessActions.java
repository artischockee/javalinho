import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ExecUselessActions implements Program {
    private final String programName = "Useless Actions (lab-work-01)";
    public String getProgramName() { return programName; }

    public void execute() {
        UselessActions areComing = new UselessActions(8);

        areComing.foreachOperator("foreach");
        areComing.whileOperator();
        areComing.doWhileOperator();
        areComing.ifelseOperator();
        areComing.switchOperator();
    }
}

public class UselessActions {
    private final Random rand = new Random();
    private int[] _array;

    UselessActions(int arraySize) {
        if (arraySize <= 0)
            throw new IllegalArgumentException();

        _array = new int[arraySize];

        for (int i = 0; i < _array.length; ++i)
            _array[i] = rand.nextInt(300);

        System.out.printf("A new array with %d random integers has been created.\n", arraySize);
    }

    public int[] getArray() { return _array; }

    // Prints all the numbers in the array
    public void foreachOperator(String command) {
        String consoleMessage = command.equals("foreach") ? "Foreach Operator" : "Content of the array";
        System.out.println("# " + consoleMessage + ":");

        for (int number : _array)
            System.out.printf("%d ", number);
        System.out.println("\n");
    }

    // Makes some mathematical actions with the array's elements
    public void whileOperator() {
        System.out.println("# While Operator:");
        int i = _array.length / 2;
        while (i > 0) {
            _array[i] = (i + 2) * 7;
            --i;
        }

        foreachOperator("");
    }

    // Makes some mathematical actions with the array's elements
    public void doWhileOperator() {
        System.out.println("# Do-while Operator:");
        int i = 0;
        int lastElement = _array[_array.length - 1];
        do {
            _array[i] = lastElement + 3 * i;
            ++i;
        } while (i < _array.length);

        foreachOperator("");
    }

    // Splits the array into two separate List containers for even and odd numbers
    public void ifelseOperator() {
        System.out.println("# If-Else Operator:");
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

        System.out.println("\n");
    }

    // Takes one random number from the existing array and
    public void switchOperator() {
        System.out.println("# Switch Operator:");
        int randomNumber = _array[rand.nextInt(_array.length)];
        System.out.printf("Random number: %d\n", randomNumber);

        int parity = randomNumber % 2;
        String message = parity == 0 ?
                "A random number is even number." :
                "A random number is odd number.";

        System.out.println(message);
    }
}
