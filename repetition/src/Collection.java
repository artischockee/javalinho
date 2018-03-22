import java.util.Vector;

/// Class Collection is used for storing the programs' executors.

public class Collection {

    private final int initialIndexOfProgram = 1;
    private Vector<IProgram> programs;

    Collection() {
        programs = new Vector<>();

        programs.add(new ExecUselessActions());
        programs.add(new ExecStringsTorture());
        // <- there should be 3rd lab..
        programs.add(new ExecRussianText());
    }

    public void display() {
        int index = initialIndexOfProgram;
        for (IProgram program : programs) {
            System.out.printf("[%d] %s\n", index++, program.getProgramName());
        }
    }

    public void execute(int programIndex) throws Exception
    {
        if (programIndex < initialIndexOfProgram || programIndex > programs.size())
            throw new Exception();

        programs.get(--programIndex).execute();
    }
}
