import java.util.Scanner;

class ExecCyrillic implements IProgram {
    private final String programName = "Cyrillic Text (lab-work-03)";
    public String getProgramName() { return programName; }

    public void execute() throws Exception {
        System.out.println("Write your string in Russian:");

        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();

        Cyrillic sentence = new Cyrillic(inputStr);
        sentence.performAction();

        System.out.println("Result:");
        System.out.println(sentence.getSplittedString());
        System.out.println(sentence.getLetterNumbers());
    }

}

final class NumLength {
    public static int getNumberLength(int number) {
        int length = 0;
        do {
            number /= 10;
            length++;
        } while (number != 0);
        return length;
    }
}

final class CyrillicAlphabet {
    private static final int _alphabetLength = 32;
    private static final char[] _alphabet = new char[_alphabetLength];

    static {
        int j = 1;
        for (char i = 'а'; i <= 'я'; i++) {
            _alphabet[j - 1] = i;
            j++;
        }
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
}

class Cyrillic {
    private String _initialString;
    private String _splittedString;
    private String _letterNumbers;

    Cyrillic(String initialString) throws Exception {
        if (initialString.isEmpty())
            throw new Exception("'RussianText' constructor: argument 'initialString' was empty.");

        _initialString = initialString;
        _splittedString = "";
        _letterNumbers = "";
    }

    public String getInitialString() { return _initialString; }
    public String getSplittedString() { return _splittedString; }
    public String getLetterNumbers() { return _letterNumbers; }

    private String divideLetters(String initialString, String divider) throws Exception {
        if (initialString == null || initialString.isEmpty())
            throw new Exception("divideLetters: argument is null or empty");

        return initialString.replaceAll(".", "$0" + divider); // '$0' is a letter definition
    }

    private String appendLetterNumbers() {
        String letterNumbers = "";
        int[] numbers = new int[_initialString.length()];

        for (int i = 0; i < _initialString.length(); i++)
            numbers[i] = CyrillicAlphabet.getLetterPos(Character.toLowerCase(_initialString.charAt(i)));

        for (int number: numbers) {
            // a whitespace is a weak place in this method
            String whitespace = "";
            switch (NumLength.getNumberLength(number)) {
                case 1:
                    whitespace = "  ";
                    break;
                case 2:
                    whitespace = " ";
                    break;
            }

            letterNumbers += Integer.toString(number) + whitespace;
        }

        return letterNumbers;
    }

    public void performAction() throws Exception {
        _splittedString = divideLetters(_initialString, "  ");
        _letterNumbers = appendLetterNumbers();
    }
}