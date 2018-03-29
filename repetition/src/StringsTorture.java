import java.util.Scanner;

class ExecStringsTorture implements IProgram {
    private final String programName = "Strings Torture (lab-work-02)";
    public String getProgramName() { return programName; }

    public void execute() throws Exception {
        System.out.printf("Write your string:\n> ");

        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();

        StringsTorture tort = new StringsTorture(inputStr);
        String result = tort.performAction();
        System.out.printf("Result:\n%s", result);
    }
}

public class StringsTorture {
    private String initialString;

    StringsTorture(String string) throws Exception {
        if (string.isEmpty())
            throw new Exception("StringsTorture constructor: argument (string:String) was empty.");

        initialString = string;
    }

    public String performAction() {
        String formattedString = initialString;
        formattedString = formattedString.replaceAll(" ", ", ");

        return formattedString;
    }
}
