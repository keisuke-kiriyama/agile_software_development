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

    /*
    新たに従業員を追加する場合、従業員登録に必要な情報を全て入力しなければならない。
    また、入力された情報のvalidationが必要になる。
    Commandパターンが、こういった処理を助けてくれる。
    コマンドオブジェクトは、有効性がまだ確認されていないデータの保存場所としての役割を果たし、
    有効性をチェックするためのメソッドと最終的な処理を実行するためのメソッドも実装できる。
     */
    public void Execute() {
        /*
        Templateメソッドパターンにしておくことで、汎用的なアルゴリズムを再利用したまま、
        派生クラスに実装を移譲することができる。
         */
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
