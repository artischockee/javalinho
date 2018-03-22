import java.util.Arrays;
import java.util.Scanner;

class ExecRussianText implements IProgram {
    private final String programName = "Russian Text (lab-work-01(04))";
    public String getProgramName() { return programName; }

    public void execute() throws Exception {
        System.out.println("Write your string in Russian:");

        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();

        RussianText rus = new RussianText(inputStr);
        String[] result = rus.performAction();
//        System.out.printf("Result:\n%s", result);
    }
}

class RussianText {
    private String initialString;

    RussianText(String string) throws Exception {
        if (string.isEmpty())
            throw new Exception("StringsTorture constructor: argument (string:String) was empty.");

        initialString = string;
    }

    public String[] performAction() {
        String letterSpacing = initialString;
        letterSpacing = letterSpacing.replaceAll(".", "$0  ");

        for (int i = 'а'; i <= 'я'; i++) {
            System.out.printf("%d - %c", i - 1071);
        }

        System.out.println(letterSpacing);
        return new String[] { "d" };
    }
}