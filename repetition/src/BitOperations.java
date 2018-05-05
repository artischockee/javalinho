import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

class ExecBitOperations implements Program {
    public String getProgramName() {
        return "Bit Operations (lab-work-##)";
    }
    private static final Scanner SCANNER = new Scanner(System.in);

    private void pack(BitOperations bitOperations) {
        bitOperations.pack();
        // %04X means:
        // 0 - if there is less than four digits - print leading zeroes,
        // 4 - print the number with at least four digits, print spaces otherwise,
        // X - print in hexadecimal format
        System.out.printf("Result: %04X\n", bitOperations.getFormat());
    }

    private void unpack(BitOperations bitOperations) {
        System.out.println("Define new format number:");

        int format = SCANNER.nextInt(BitOperations.HEX_RADIX);
        bitOperations.setFormat(format);
        bitOperations.unpack();

        // show all the values:
        for (BitOperations.PartConstraints pc : bitOperations.getPartConstraints())
            System.out.printf("%s\'s value: %d\n", pc.getName(), pc.getValue());
    }

    private void semiautomaticPart() {
        int partsAmount = 3;
        Vector<BitOperations.PartConstraints> partConstraints = new Vector<>(partsAmount);

        partConstraints.add(new BitOperations.PartConstraints
            ("C", 15, 14, 2)
        );
        partConstraints.add(new BitOperations.PartConstraints
            ("F", 13, 12, 1)
        );
        partConstraints.add(new BitOperations.PartConstraints
            ("D", 11, 0, 4011)
        );

        BitOperations bitOperations = new BitOperations(partConstraints);

        pack(bitOperations);
        unpack(bitOperations);
    }

    private void manualPart() {
        System.out.println("Define amount of parts");
        System.out.print("> ");
        int partsAmount = SCANNER.nextInt();

        Vector<BitOperations.PartConstraints> partConstraints = new Vector<>(partsAmount);

        int index = 1;
        while (partsAmount > 0) {
            System.out.printf("Define name, bounds and value for [%d]:\n", index);
            System.out.println("Name of the part:");
            String name = SCANNER.next();
            System.out.println("Left bound:");
            int leftBound = SCANNER.nextInt();
            System.out.println("Right bound:");
            int rightBound = SCANNER.nextInt();

            BitOperations.PartConstraints partConstr
                    = new BitOperations.PartConstraints(name, leftBound, rightBound);

            System.out.printf("Now define value of the %s (0 - %d):\n",
                    partConstr.getName(), partConstr.getMaximumValue()
            );

            int value;
            do {
                value = SCANNER.nextInt();
            } while(value < 0 || value > partConstr.getMaximumValue());

            partConstr.setValue(value);

            partConstraints.add(partConstr);
            --partsAmount;
            ++index;
        }

        BitOperations bitOperations = new BitOperations(partConstraints);

        pack(bitOperations);
        unpack(bitOperations);
    }

    public void execute() throws Exception {
        System.out.println("Choose manual or semi-automatic mode:");
        System.out.println("1 - Manual");
        System.out.println("2 - Semi-automatic");

        int answer;
        do {
            answer = SCANNER.nextInt();
        } while (answer < 1 || answer > 2);

        switch (answer) {
            case 1:
                manualPart();
                break;
            case 2:
                semiautomaticPart();
                break;
        }
    }
}

class BitOperations {
    static class PartConstraints {
        private final int maximumValue;

        private String name;
        private int upperBound;
        private int lowerBound;
        private int value;
        private int hexMask;

        PartConstraints(String name, int upperBound, int lowerBound) throws IllegalArgumentException {
            if (upperBound > UPPER_BOUND || upperBound < LOWER_BOUND)
                throw new IllegalArgumentException(upperBound + " is out of valid bounds.");
            if (lowerBound > UPPER_BOUND || lowerBound < LOWER_BOUND)
                throw new IllegalArgumentException(lowerBound + " is out of valid bounds.");
            if (upperBound < lowerBound)
                throw new IllegalArgumentException(upperBound + " is lower than " + lowerBound);

            this.name = name;
            this.upperBound = upperBound;
            this.lowerBound = lowerBound;

            maximumValue = (int) Math.pow(BINARY_RADIX, getSize()) - 1;
            hexMask = Hexadecimal.getHexMask(getSize());
        }

        PartConstraints(String name, int upperBound, int lowerBound, int value) throws IllegalArgumentException {
            this(name, upperBound, lowerBound);
            this.value = value;
        }

        int getMaximumValue() {
            return maximumValue;
        }

        String getName() {
            return name;
        }

        int getUpperBound() {
            return upperBound;
        }

        int getLowerBound() {
            return lowerBound;
        }

        int getValue() {
            return value;
        }

        void setValue(int value) {
            this.value = value;
        }

        public int getHexMask() {
            return hexMask;
        }

        int getSize() {
            return upperBound - lowerBound + 1;
        }
    }

    public static final int BINARY_RADIX = 2;
    public static final int HEX_RADIX = 16;
    private static final int UPPER_BOUND = HEX_RADIX - 1;
    private static final int LOWER_BOUND = 0;

    private Vector<PartConstraints> partConstraints;
    private int format;

    BitOperations(Vector<PartConstraints> partConstraints) {
        this.partConstraints = partConstraints;
    }

    Vector<PartConstraints> getPartConstraints() {
        return partConstraints;
    }

    int getFormat() {
        return format;
    }

    void setFormat(int format) {
        this.format = format;
    }

    void pack() {
        for (PartConstraints pc : partConstraints) {
            format |= ((pc.getValue() & pc.getHexMask()) << pc.getLowerBound());
        }
    }

    void unpack() {
        for (PartConstraints pc : partConstraints)
            pc.setValue((format >> pc.getLowerBound()) & pc.getHexMask());
    }
}

final class Hexadecimal {
    private static final Map<Integer, Integer> hexMap = new HashMap<>();

    static {
        hexMap.put(1, 0x1);
        hexMap.put(2, 0x3);
        hexMap.put(3, 0x7);
        hexMap.put(4, 0xF);
        hexMap.put(5, 0x1F);
        hexMap.put(6, 0x3F);
        hexMap.put(7, 0x7F);
        hexMap.put(8, 0xFF);
        hexMap.put(9, 0x1FF);
        hexMap.put(10, 0x3FF);
        hexMap.put(11, 0x7FF);
        hexMap.put(12, 0xFFF);
        hexMap.put(13, 0x1FFF);
        hexMap.put(14, 0x3FFF);
        hexMap.put(15, 0x7FFF);
        hexMap.put(16, 0xFFFF);
    }

    public static int getHexMask(int size) {
        return hexMap.get(size);
    }
}