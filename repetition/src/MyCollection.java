import java.util.Random;
import java.util.Vector;

class ExecMyCollection implements Program {
    private final String programName = "My collection (lab-work-05(03))";
    public String getProgramName() { return programName; }

    private final int _vectorSize = 48;
    private final int _lowerBound = -50;
    private final int _upperBound = 50;

    private void display(Vector<Integer> vector) {
        for (int number: vector)
            System.out.printf("%d ", number);
        System.out.println();
    }

    private Vector<Integer> createVector(int size) {
        Vector<Integer> vector = new Vector<>();
        Random random = new Random();

        // random generates numbers between the lower and the upper bounds
        for (int i = 0; i < size; ++i)
            vector.add(random.nextInt(_upperBound + 1 - _lowerBound) + _lowerBound);

        return vector;
    }

    public void execute() throws Exception {
        Vector<Integer> list = createVector(_vectorSize);

        System.out.println("You have the next array:");
        display(list);

        MyCollection mc = new MyCollection(list);
        mc.sortNumericList();
        Vector<Integer> sortedList = mc.getNumericList();

        System.out.println("The array after the sorting:");
        display(sortedList);
    }
}

class MyCollection {
    private Vector<Integer> _numericList;

    MyCollection(Vector<Integer> numericList) throws Exception {
        if (numericList == null || numericList.isEmpty())
            throw new Exception("'MyCollection': 'numericList' argument is null or empty.");

        _numericList = numericList;
    }

    public Vector<Integer> getNumericList() { return _numericList; }

    // Every positive element goes into the start (head)
    // and negative elements go into the end (tail)
    // of the _numericList. The elements are not sorted in default order.
    // Example:
    // Initial array: -5 10 12 -4 -7 18 -1 1
    //  Result array: 10 12 18 1 -5 -4 -7 -1
    public void sortNumericList() {
        int listSize = _numericList.size();
        if (listSize <= 1) {
            System.out.printf("'sortNumericList': there is nothing to sort (array size is %d).\n", listSize);
            return;
        }

        _numericList.sort((a, b) ->
            a >= 0 && b < 0 ? -1 :
            a < 0 && b < 0 ? 0 :
            a < 0 ? 1 : 0);
    }
}
