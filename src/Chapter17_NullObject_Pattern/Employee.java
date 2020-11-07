package Chapter17_NullObject_Pattern;

import java.util.Date;

/**
 * Nullや0を返すメソッドは返り値をチェックするべきだが、
 * Null Objectパターンを使用すれば、常に有効なオブジェクトを返すことを保証できる
 * 返ってくるオブジェクトは「何もしない」オブジェクトである。
 */
public interface Employee {
    public boolean isTimeToPay(Date payDate);
    public void pay();
    public static final Employee NULL = new Employee() {
        public boolean isTimeToPay(Date payDate) {
            return false;
        }
        public void pay() {}
    };
}
