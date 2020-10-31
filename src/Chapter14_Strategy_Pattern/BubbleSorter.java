package Chapter14_Strategy_Pattern;

public class BubbleSorter {
    private int operations = 0;
    private int length = 0;
    private SortHandle itsSortHandel = null;
    public BubbleSorter(SortHandle handle) {
        itsSortHandel = handle;
    }
    public int sort(Object array) {
        itsSortHandel.setArray(array);
        length = itsSortHandel.length();
        operations = 0;
        if (length <= 1)
            return operations;
        for (int nextToLast = length - 2; nextToLast >= 0; nextToLast--)
            for (int index = 0; index <= nextToLast; index++) {
                if (itsSortHandel.outOfOrder(index))
                    itsSortHandel.swap(index);
                operations++;
            }
        return operations;
    }
}
