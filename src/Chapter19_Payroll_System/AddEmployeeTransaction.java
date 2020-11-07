package Chapter19_Payroll_System;

/**
 * Employeeを追加するトランザクション。
 * Template Methodパターンを応用している。
 */
public abstract class AddEmployeeTransaction implements Transaction {
    // 以下3つのプロパティは従業員のタイプによらず必ず登録する情報
    private int itsEmpId;
    private String itsName;
    private String itsAddress;

    public AddEmployeeTransaction(int empId, String name, String address) {
        itsEmpId = empId;
        itsName = name;
        itsAddress = address;
    }

    public void Execute() {
        PaymentClassifidcation pc = GetClassification();
        PaymentSchedule ps = GetSchedule();
        PaymentMethod pm = new HoldMethod();
        Employee e = new Employee(itsEmpId, itsName, itsAddress);
        e.SetClassification(pc);
        e.SetSchedule(ps);
        e.SetMethod(pm);
        PayrollDatabase.AddEmployee(itsEmpId, e);
    }

    /*
    Template Methodパターン。
    Execute(Commandパターン)内で、この抽象メソッドが実行される。
    この抽象メソッドの実装は派生クラスがもつ。
     */
    abstract PaymentSchedule GetSchedule();
    abstract PaymentClassification GetClassification();
}
