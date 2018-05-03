import java.util.Arrays;
import java.util.Vector;

// This class is used for storing the programs' executors

final class Collection {
    private static final int INIT_PROGRAM_INDEX = 1;
    private static final Vector<Program> PROGRAMS;

    static {
        PROGRAMS = new Vector<>(Arrays.asList(
            new ExecUselessActions(),
            new ExecStringsTorture(),
            new ExecRussianText(),
            new ExecRegularExpr(),
            new ExecMyCollection(),
            new ExecBitOperations()
        ));
    }

    static final int LOWER_BOUND = INIT_PROGRAM_INDEX; // just for better semantics
    static final int UPPER_BOUND = PROGRAMS.size();

    // 'private' used to escape an initializing of this pseudo-static class
    private Collection() {}

    static void display() {
        int index = INIT_PROGRAM_INDEX;

        for (Program program : PROGRAMS)
            System.out.printf("[%d] %s\n", index++, program.getProgramName());
    }

    static void execute(int programIndex) throws Exception {
        if (programIndex < INIT_PROGRAM_INDEX || programIndex > PROGRAMS.size())
            throw new Exception();

        PROGRAMS.elementAt(--programIndex).execute();
    }
}
