package Chapter14_Strategy_Pattern;

// ViewControllerを実装したクラス的な感じ
// 各メソッドは移譲先のクラスが実行する
//
// Strategyパターンにおいては、BubbleSorterの存在を一切知らない
// Templateパターンの場合は、TemplateであるBubbleSorterクラスを継承→依存してしまう
//
// Strategyパターン→BubbleSorter以外のソートでも、IntSortHandleを使用できる
//
// Template Methodパターン: 1つの汎用的いなアルゴリズムだけしか実装の詳細を操作できない
// Strategyパターン: DIPに完全に準拠。たくさんの汎用的なアルゴリズムが実装の詳細を再利用できる
public class IntSortHandle {
    private int[] array = null;
    public void swap(int index) {
        int temp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = temp;
    }
    public void setArray(Object array) {
        this.array = (int[])array;
    }
    public int length() {
        return array.length;
    }
    public boolean outOfOrder(int index) {
        return (array[index] > array[index+1]);
    }
}
