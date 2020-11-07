package Chapter19_Payroll_System;

/**
 * トランザクションを表現する抽象クラス。
 * Commandパターン。
 */
public interface Transaction {
    void Execute();
}
