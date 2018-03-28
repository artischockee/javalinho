import java.util.Scanner;

final class NumLength {
    public static int getNumberLength(int number) {
        int length = 0;
        while (number != 0) {
            number /= 10;
            length++;
        }
        return length;
    }
}

class ExecCyrillic implements IProgram {
    private final String programName = "Cyrillic Text (lab-work-03)";
    public String getProgramName() { return programName; }

    public void execute() throws Exception {
        System.out.println("Write your string in Russian:");

        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();

        Cyrillic rus = new Cyrillic(inputStr);
        String[] result = rus.performAction();
//        System.out.printf("Result:\n%s", result);
    }
}

class Cyrillic {
    private static final int _alphabetLength = 32;
    private static final char[] _alphabet = new char[_alphabetLength];
    private String _initialString;

    Cyrillic(String initialString) throws Exception {
        if (initialString.isEmpty())
            throw new Exception("'RussianText' constructor: argument 'initialString' was empty.");

        int j = 1;
        for (char i = 'а'; i <= 'я'; i++) {
            _alphabet[j - 1] = i;
            j++;
        }

        _initialString = initialString;
    }

    public static int getLetterPos(char letter) {
        for (int i = 0; i < _alphabet.length; i++) {
            if (letter == _alphabet[i])
                return i + 1;
        }
        return 0;
    }

    public static char getLetter(int position) throws Exception {
        if (position < 1 || position > _alphabetLength)
            throw new Exception();
        return _alphabet[position - 1];
    }

    private String divideLetters(String initialString, String divider) throws Exception {
        if (initialString == null || initialString.isEmpty())
            throw new Exception("divideLetters: argument is null or empty");

        String replacement = "$0" + divider; // '$0' is a letter definition for 'replaceAll' method
        return initialString.replaceAll(".", replacement);
    }

    public String[] performAction() throws Exception {
        String newLetterSpacing = divideLetters(_initialString, "  ");

        int[] num = new int[_initialString.length()];

        for (int i = 0; i < _initialString.length(); i++)
            num[i] = getLetterPos(Character.toLowerCase(_initialString.charAt(i)));

        System.out.println(newLetterSpacing);
        for (int n: num) {
            String whitespace = "";
            switch (NumLength.getNumberLength(n)) {
                case 1:
                    whitespace = "  ";
                    break;
                case 2:
                    whitespace = " ";
                    break;
            }
            System.out.printf("%d%s", n, whitespace);
        }
        System.out.println();

        return new String[] { "d" }; // temp return statement
    }
}