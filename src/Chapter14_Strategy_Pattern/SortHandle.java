package Chapter14_Strategy_Pattern;

// ViewControllerにイメージが近い
public interface SortHandle {
    public void swap(int index);
    public boolean outOfOrder(int index);
    public int length();
    public void setArray(Object array);
}
