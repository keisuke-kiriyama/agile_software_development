package Chapter19_Payroll_System;

import java.util.HashMap;
import java.util.Map;

/*
各メソッドはstaticで定義されている。
  →PayrollDatabaseのクラスのインスタンスは1つだけであるからグローバルな変数でも良い。
  ※必ずしもグローバルな変数が悪質と言うわけではない。この場合はむしろ理想的な選択。
SingletonパターンやMonostateパターンが使えそうだが、不必要な複雑さが含まれてしまう。
つまり、単純にデータベースのインスタンスをグローバルにすればよく、
Singleton、Monostateのグローバルは不必要な複雑さになってしまう。
 */
public class PayrollDatabase {
    private static Map<Integer, Employee> itsEmployees = new HashMap<Integer, Employee>();

    public static void AddEmployee(int empId, Employee e) {
        itsEmployees.put(empId, e);
    }

    public static Employee GetEmployee(int empId) {
        return itsEmployees.get(empId);
    }

    public static void DeleteEmployee(int empId) {
        itsEmployees.remove(empId);
    }

    public static void Clear() {
        itsEmployees.clear();
    }
}
