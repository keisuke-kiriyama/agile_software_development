package Chapter16_Monostate_Pattern;

/**
 * 同じクラスの2つのインスタンスがあたかも1つの様に振舞う
 * 片方のインスタンスの変数xをある値に設定しても、もう一方のインスタンスの変数xからその値を読み出すことができる
 *
 * Singletonパターン: オブジェクトが1つだけしか存在しない構造になっていなければならない
 * Monostateパターン: 構造に対して制約を与えるのではなく、複数のオブジェクトが同じ振る舞いをする様にしている
 */
public class Monostate {
    private static int itsX = 0;
    public Monostate () {}
    public void setX(int x) {
        itsX = x;
    }
    public int getX() {
        return itsX;
    }
}
