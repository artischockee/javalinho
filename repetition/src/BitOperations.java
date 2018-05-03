import java.util.Scanner;

class ExecBitOperations implements Program {
    private final String programName = "Bit Operations (lab-work-##)";
    public String getProgramName() { return programName; }

    private static final Scanner SCANNER = new Scanner(System.in);

    public void execute() throws Exception {
        System.out.print("Timer channel format (0 - 3) > ");
        char c = (char) SCANNER.nextByte();
        System.out.print("Signal form (0 - 3) > ");
        char f = (char) SCANNER.nextByte();
        System.out.print("Reference freq. divide ratio (0 - 4095) > ");
        short d = SCANNER.nextShort();

        BitOperations bitOperations = new BitOperations(c, f, d);
        bitOperations.formTimerFormat();

        // %04X means:
        // 0 - if there is less than four digits - print leading zeroes,
        // 4 - print the number with at least four digits, print spaces otherwise,
        // X - print in hexadecimal format
        System.out.printf("Result: %04X", bitOperations.getTimerFormat());
    }
}

class BitOperations {
    private char c; // timer channel number
    private char f; // signal form
    private short d; // reference freq. divide ratio
    private int timerFormat;

    BitOperations(char c, char f, short d) {
        this.c = c;
        this.f = f;
        this.d = d;
    }

    public int getTimerFormat() {
        return timerFormat;
    }

    public void formTimerFormat() {
        timerFormat = ((int) c & 0x3) << 14;
        timerFormat |= ((int) f & 0x3) << 12;
        timerFormat |= d & 0xFFF;
    }
}
