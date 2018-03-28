import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

class ExecMeinKollektion implements IProgram {
    private final String programName = "My collection (lab-work-05(03))";
    public String getProgramName() { return programName; }

    private void display(Vector<Integer> vector) {
        for (int number: vector)
            System.out.printf("%d ", number);
        System.out.println();
    }

    public void execute() throws Exception {
        Vector<Integer> list = new Vector<>(Arrays.asList(1, 2, 5, -3, -4, 6, -7, 9, -10, 8));

        MeinKollektion mk = new MeinKollektion(list);
        mk.sortNumericList();
        Vector<Integer> sortedList = mk.getNumericList();

        display(sortedList);
    }
}

class MeinKollektion {
    private Vector<Integer> _numericList;

    MeinKollektion(Vector<Integer> numericList) throws Exception {
        if (numericList == null || numericList.isEmpty())
            throw new Exception("'MeinKollektion': 'numericList' argument is null or empty.");

        _numericList = numericList;
    }

    public Vector<Integer> getNumericList() { return _numericList; }

    public void sortNumericList() {
        Collections.sort(_numericList, (a, b) -> a <= 0 ? 1 : b <= 0 ? -1 : 0);
    }
}
