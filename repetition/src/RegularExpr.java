import java.util.regex.Pattern;
import java.util.Scanner;

class ExecRegularExpr implements IProgram {
    private final String programName = "Regular Expression (lab-work-04)";
    public String getProgramName() { return programName; }

    public void execute() throws Exception {
        System.out.println("Write a hexadecimal value of color (example: #FF0000):");

        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();

        String resultLine = RegularExpr.matchesHexColor(inputStr) ?
                "[True] Input string matches the hexadecimal color pattern." :
                "[False] Input string does not match the hexadecimal color pattern.";

        System.out.println(resultLine);
    }
}

final class RegularExpr {
    private static final String _hexColorPattern = "#[a-fA-F_0-9]{6}"; // hash and any of (a-f) letter and (0-9) digit 6 times

    public static boolean matchesHexColor(String initialString) {
        return Pattern.matches(_hexColorPattern, initialString);
    }
}
