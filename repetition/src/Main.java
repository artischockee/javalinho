import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static int scanValidNumber() {
        int number;

        do {
            System.out.print("> ");
            number = SCANNER.nextInt();
        } while (number < Collection.LOWER_BOUND || number > Collection.UPPER_BOUND);

        return number;
    }

    public static void main(String[] args) {
        try {
            Collection.display();
            System.out.println("Select a program by its number:");
            int chosenProgram = scanValidNumber();
            Collection.execute(chosenProgram);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
