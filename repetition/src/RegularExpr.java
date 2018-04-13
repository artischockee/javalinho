import java.util.regex.Pattern;
import java.util.Scanner;

class ExecRegularExpr implements Program {
    private final String programName = "Regular Expression (lab-work-04(02))";
    public String getProgramName() { return programName; }

    public void execute() {
        System.out.print("Write a hexadecimal value of color (example: #FF0000, #bf4):\n> ");

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
    private static final String _hexColorPatternShort = "#[a-fA-F_0-9]{3}"; // the same as above but only 3 times (short hex color notation)

    public static boolean matchesHexColor(String initialString) {
        if (initialString == null || initialString.isEmpty())
            throw new IllegalArgumentException("matchesHexColor: initial string is null or empty.");

        return Pattern.matches(_hexColorPattern, initialString)
                || Pattern.matches(_hexColorPatternShort, initialString);
    }
}
