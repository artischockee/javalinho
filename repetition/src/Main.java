import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Collection collection = new Collection();
            collection.display();

            System.out.println("Type number of program: ");
            Scanner input = new Scanner(System.in);
            int chosenProgram = input.nextInt();

            collection.execute(chosenProgram);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
